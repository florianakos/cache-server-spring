package com.flrnks.vtcache.dto.file;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flrnks.vtcache.dto.file.model.FileReport;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@DynamoDBTable(tableName = "VTCacheFiles")
public class VtFileReport {

    public String queryValue;
    public Integer timestamp;
    public Integer ttl;
    public FileReport fileReport;

    public VtFileReport(String queryValue, Integer timestamp, Integer ttl, FileReport fileReport) {
        this.queryValue = queryValue;
        this.timestamp = timestamp;
        this.ttl = ttl;
        this.fileReport = fileReport;
    }

    @JsonProperty("query_value")
    @DynamoDBHashKey(attributeName = "query_value")
    public String getQueryValue() { return queryValue; }
    public void setQueryValue(String queryValue) { this.queryValue = queryValue; }

    @DynamoDBAttribute(attributeName = "timestamp")
    public Integer getTimestamp() { return timestamp; }
    public void setTimestamp(Integer timestamp) { this.timestamp = timestamp; }

    @DynamoDBAttribute(attributeName = "ttl")
    public Integer getTtl() { return ttl; }
    public void setTtl(Integer ttl) { this.ttl = ttl; }

    @JsonProperty("vt_data")
    @DynamoDBAttribute(attributeName = "vt_data")
    public FileReport getFileReport() { return fileReport; }
    public void setFileReport(FileReport fileReport) { this.fileReport = fileReport; }
}
