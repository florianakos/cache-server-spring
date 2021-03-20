package com.flrnks.vtcache.controller;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.flrnks.vtcache.dao.UrlReportDao;
import com.flrnks.vtcache.dto.url.VtUrlReport;
import com.flrnks.vtcache.dto.url.model.UrlReport;
import com.flrnks.vtcache.service.VirusTotalService;
import com.flrnks.vtcache.util.EmptyResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.flrnks.vtcache.util.Utils.isNullOrBlank;


@RestController 
@RequestMapping("/url")
public class UrlController {

     Logger logger = LogManager.getLogger(UrlController.class);

     @Value("${virustotal.cache.ttl-seconds:240}")
     private int TTL;
    
     @Autowired
     private UrlReportDao urlReportDao;
     
     @Autowired
     private VirusTotalService vt;

    @RequestMapping(value = "/report", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<List<Object>> getUrlReport(@RequestBody String body) {
        try {
            List<String> urlList = Stream.of(body.split("\n"))
                    .filter(t -> !isNullOrBlank(t)).distinct().collect(Collectors.toList());
            List<Object> response = new ArrayList<>();

            urlList.forEach(URL -> {
                VtUrlReport cached = urlReportDao.load(URL);
                if (cached != null) {
                    response.add(cached);
                    logger.debug(String.format("Loaded URL Report for %s from DynamoDB cache ...", URL));
                } else {
                    UrlReport vtReport = vt.urlReport(URL);
                    if (vtReport != null && vtReport.getResponseCode() == 1) {
                        int NOW = (int) Instant.now().getEpochSecond();
                        response.add(urlReportDao.save(new VtUrlReport(URL, NOW, NOW + TTL, vtReport)));
                        logger.debug(String.format("Fetched URL Report for %s from VT API ...", URL));
                    } else {
                        response.add(new EmptyResponse(URL, "empty response or rate limit exceeded"));
                        logger.debug(String.format("empty response or rate limit exceeded while checking [%s]", URL));
                    }
                    
                }
            });
            
            HttpStatus status = HttpStatus.OK;
            if ((response.size() == 1 && response.get(0).getClass() == EmptyResponse.class) || (response.size() == 0)) {
                status = HttpStatus.NOT_FOUND;
            }
            return ResponseEntity.status(status).body(response);
            
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(),
                    e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
