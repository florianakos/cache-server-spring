package com.flrnks.vtcache.dto.file.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FileReport {
    
    private String scanId;
    private String md5;
    private String sha1;
    private String sha256;
    private String resource;
    private Integer responseCode;
    private String scanDate;
    private String permaLink;
    private String verboseMsg;
    private Integer total;
    private Integer positives;
    private Map<String, FileScan> scans;

    @JsonProperty("scan_id")
    @DynamoDBAttribute(attributeName = "scan_id")
    public String getScanId() { return scanId; }
    public void setScanId(String scanId) { this.scanId = scanId; }

    @JsonProperty("md5")
    @DynamoDBAttribute(attributeName = "md5")
    public String getMd5() { return md5; }
    public void setMd5(String md5) { this.md5 = md5; }

    @JsonProperty("sha1")
    @DynamoDBAttribute(attributeName = "sha1")
    public String getSha1() { return sha1; }
    public void setSha1(String sha1) { this.sha1 = sha1; }

    @JsonProperty("sha256")
    @DynamoDBAttribute(attributeName = "sha256")
    public String getSha256() { return sha256; }
    public void setSha256(String sha256) { this.sha256 = sha256; }

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

    @JsonProperty("permalink")
    @DynamoDBAttribute(attributeName = "permalink")
    public String getPermaLink() { return permaLink; }
    public void setPermaLink(String permaLink) { this.permaLink = permaLink; }

    @JsonProperty("verbose_msg")
    @DynamoDBAttribute(attributeName = "verbose_msg")
    public String getVerboseMsg() { return verboseMsg; }
    public void setVerboseMsg(String verboseMsg) { this.verboseMsg = verboseMsg; }

    @JsonProperty("total")
    @DynamoDBAttribute(attributeName = "total")
    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    @JsonProperty("positives")
    @DynamoDBAttribute(attributeName = "positives")
    public Integer getPositives() { return positives; }
    public void setPositives(Integer positives) { this.positives = positives; }

    @JsonProperty("scans")
    @DynamoDBAttribute(attributeName = "scans")
    public Map<String, FileScan> getFileScans() { return scans; }
    public void setFileScans(Map<String, FileScan> scans) { this.scans = scans; }
}
