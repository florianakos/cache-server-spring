package com.flrnks.vtcache.dto.url.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UrlReport {
    
    private String fileScanId;
    private String permaLink;
    private Integer positives;
    private String resource;
    private Integer responseCode;
    private String scanDate;
    private String scanId;
    private Map<String, UrlScan> scans;
    private Integer total;
    private String url;
    private String verboseMsg;

    @JsonProperty("filescan_id")
    @DynamoDBAttribute(attributeName = "filescan_id")
    public String getFileScanId() { return fileScanId; }
    public void setFileScanId(String fileScanId) { this.fileScanId = fileScanId; }

    @JsonProperty("permalink")
    @DynamoDBAttribute(attributeName = "permalink")
    public String getPermaLink() { return permaLink; }
    public void setPermaLink(String permaLink) { this.permaLink = permaLink; }

    @JsonProperty("positives")
    @DynamoDBAttribute(attributeName = "positives")
    public Integer getPositives() { return positives; }
    public void setPositives(Integer positives) { this.positives = positives; }

    @JsonProperty("resource")
    @DynamoDBAttribute(attributeName = "resource")
    public String getResource() { return resource; }
    public void setResource(String resource) { this.resource = resource; }

    @JsonProperty("response_code")
    @DynamoDBAttribute(attributeName = "response_code")
    public Integer getResponseCode() { return responseCode; }
    public void setResponseCode(Integer responseCode) { this.responseCode = responseCode; }

    @JsonProperty("scan_date")
    @DynamoDBAttribute(attributeName = "scan_date")
    public String getScanDate() { return scanDate; }
    public void setScanDate(String scanDate) { this.scanDate = scanDate; }

    @JsonProperty("scan_id")
    @DynamoDBAttribute(attributeName = "scan_id")
    public String getScanId() { return scanId; }
    public void setScanId(String scanId) { this.scanId = scanId; }
    
    @JsonProperty("scans")
    @DynamoDBAttribute(attributeName = "scans")
    public Map<String, UrlScan> getScans() { return scans; }
    public void setScans(Map<String, UrlScan> urlScans) { this.scans = urlScans; }

    @JsonProperty("total")
    @DynamoDBAttribute(attributeName = "total")
    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    @JsonProperty("url")
    @DynamoDBAttribute(attributeName = "url")
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @JsonProperty("verbose_msg")
    @DynamoDBAttribute(attributeName = "verbose_msg")
    public String getVerboseMsg() { return verboseMsg; }
    public void setVerboseMsg(String verboseMsg) { this.verboseMsg = verboseMsg; }
}
