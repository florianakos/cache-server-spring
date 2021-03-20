package com.flrnks.vtcache.controller;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.flrnks.vtcache.dto.ipaddress.VtIpAddressReport;
import com.flrnks.vtcache.dao.IpAddressReportDao;
import com.flrnks.vtcache.dto.ipaddress.model.IpAddressReport;
import com.flrnks.vtcache.service.VirusTotalService;
import com.flrnks.vtcache.util.EmptyResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.flrnks.vtcache.util.Utils.isNullOrBlank;


@RestController 
@RequestMapping("/ip-address")
public class IPAddressController {

     Logger logger = LogManager.getLogger(IPAddressController.class);

     @Value("${virustotal.cache.ttl-seconds:240}")
     private int TTL;
    
     @Autowired
     private IpAddressReportDao ipAddressReportDao;
     
     @Autowired
     private VirusTotalService vt;

    @RequestMapping(value = "/report", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<List<Object>> getIpAddressReport(@RequestBody String body) {
        try {
            List<String> ipList = Stream.of(body.split("\n"))
                    .filter(t -> !isNullOrBlank(t)).distinct().collect(Collectors.toList());
            List<Object> response = new ArrayList<>();

            ipList.forEach(IP -> {
                VtIpAddressReport cached = ipAddressReportDao.load(IP);
                if (cached != null) {
                    response.add(cached);
                    logger.debug(String.format("Loaded IP Report for %s from DynamoDB cache ...", IP));
                } else {
                    IpAddressReport vtReport = vt.ipAddressReport(IP);
                    if (vtReport != null && vtReport.getResponseCode() == 1) {
                        int NOW = (int) Instant.now().getEpochSecond();
                        response.add(ipAddressReportDao.save(new VtIpAddressReport(IP, NOW, NOW + TTL, vtReport)));
                        logger.debug(String.format("Fetched IP Report for %s from VT API ...", IP));
                    } else {
                        response.add(new EmptyResponse(IP, "empty response or rate limit exceeded"));
                        logger.debug(String.format("empty response or rate limit exceeded while checking [%s]", IP));
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
