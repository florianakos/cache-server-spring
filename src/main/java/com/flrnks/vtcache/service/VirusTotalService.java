package com.flrnks.vtcache.service;

import com.flrnks.vtcache.dto.domain.model.DomainReport;
import com.flrnks.vtcache.dto.file.model.FileReport;
import com.flrnks.vtcache.dto.ipaddress.model.IpAddressReport;
import com.flrnks.vtcache.dto.url.model.UrlReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class VirusTotalService {

    Logger logger = LogManager.getLogger(VirusTotalService.class);

    @Value("${virustotal.api.endpoint}")
    private String base;

    @NonNull
    @Value("${virustotal.api.key:#{null}}")
    private String apiKey;
    
    private final RestTemplate restTemplate = new RestTemplate();

    public IpAddressReport ipAddressReport(String IP) {
        
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(base + "/ip-address/report").queryParam("apikey", apiKey).queryParam("ip", IP);

        ResponseEntity<IpAddressReport> response = restTemplate.getForEntity(builder.toUriString(), IpAddressReport.class);
        if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            logger.info("VT API Rate Limit Reached!");
            return null;
        }
        return response.getBody();
    }

    public DomainReport domainReport(String domain) {
        
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(base + "/domain/report").queryParam("apikey", apiKey).queryParam("domain", domain);

        ResponseEntity<DomainReport> response = restTemplate.getForEntity(builder.toUriString(), DomainReport.class);
        if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            logger.info("VT API Rate Limit Reached!");
            return null;
        }
        return response.getBody();
    }

    public UrlReport urlReport(String url) {
        
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(base + "/url/report").queryParam("apikey", apiKey).queryParam("resource", url);

        ResponseEntity<UrlReport> response = restTemplate.getForEntity(builder.toUriString(), UrlReport.class);
        if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            logger.info("VT API Rate Limit Reached!");
            return null;
        }
        return response.getBody();
    }

    public FileReport fileReport(String fileHash) {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(base + "/file/report").queryParam("apikey", apiKey).queryParam("resource", fileHash);

        ResponseEntity<FileReport> response = restTemplate.getForEntity(builder.toUriString(), FileReport.class);
        if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            logger.info("VT API Rate Limit Reached!");
            return null;
        }
        return response.getBody();
    }
}
