package com.flrnks.vtcache.dto.url;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flrnks.vtcache.dto.url.model.UrlReport;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@DynamoDBTable(tableName = "VTCacheURLs")
public class VtUrlReport {

    public String queryValue;
    public Integer timestamp;
    public Integer ttl;
    public UrlReport urlReport;

    public VtUrlReport(String queryValue, Integer timestamp, Integer ttl, UrlReport urlReport) {
        this.queryValue = queryValue;
        this.timestamp = timestamp;
        this.ttl = ttl;
        this.urlReport = urlReport;
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
    public UrlReport getUrlReport() { return urlReport; }
    public void setUrlReport(UrlReport urlReport) { this.urlReport = urlReport; }
}
