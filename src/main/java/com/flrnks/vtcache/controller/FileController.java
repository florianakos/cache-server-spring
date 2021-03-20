package com.flrnks.vtcache.controller;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.flrnks.vtcache.dao.FileReportDao;
import com.flrnks.vtcache.dto.file.VtFileReport;
import com.flrnks.vtcache.dto.file.model.FileReport;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.flrnks.vtcache.util.Utils.isNullOrBlank;

@RestController 
@RequestMapping("/file")
public class FileController {

     Logger logger = LogManager.getLogger(FileController.class);

     @Value("${virustotal.cache.ttl-seconds:240}")
     private int TTL;
    
     @Autowired
     private FileReportDao fileReportDao;
     
     @Autowired
     private VirusTotalService vt;

    

    @RequestMapping(value = "/report", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<List<Object>> getFileReport(@RequestBody String body) {
        try {
            List<String> hashList = Stream.of(body.split("\n"))
                    .filter(t -> !isNullOrBlank(t)).distinct().collect(Collectors.toList());
            List<Object> response = new ArrayList<>();

            hashList.forEach(fileHash -> {
                VtFileReport cached = fileReportDao.load(fileHash);
                if (cached != null) {
                    response.add(cached);
                    logger.debug(String.format("Loaded Domain Report for %s from DynamoDB cache ...", fileHash));
                } else {
                    FileReport fileReport = vt.fileReport(fileHash);
                    if (fileReport != null && fileReport.getResponseCode() == 1) {
                        int NOW = (int) Instant.now().getEpochSecond();
                        response.add(fileReportDao.save(new VtFileReport(fileHash, NOW, NOW + TTL, fileReport)));
                        logger.debug(String.format("Fetched Domain Report for %s from VT API ...", fileHash));
                    } else {
                        response.add(new EmptyResponse(fileHash, "empty response or rate limit exceeded"));
                        logger.debug(String.format("empty response or rate limit exceeded while checking [%s]", fileHash));
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
