package com.flrnks.vtcache.dto.ipaddress;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flrnks.vtcache.dto.ipaddress.model.IpAddressReport;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@DynamoDBTable(tableName = "VTCacheIPAddresses")
public class VtIpAddressReport {

    public String queryValue;
    public Integer timestamp;
    public Integer ttl;
    public IpAddressReport ipAddressReport;

    public VtIpAddressReport(String queryValue, Integer timestamp, Integer ttl, IpAddressReport ipAddressReport) {
        this.queryValue = queryValue;
        this.timestamp = timestamp;
        this.ttl = ttl;
        this.ipAddressReport = ipAddressReport;
    }

    @JsonProperty("query_value")
    @DynamoDBHashKey(attributeName = "query_value")
    public String getQueryValue() { return queryValue; }
    public void setQueryValue(String query_value) { this.queryValue = query_value; }

    @DynamoDBAttribute(attributeName = "timestamp")
    public Integer getTimestamp() { return timestamp; }
    public void setTimestamp(Integer timestamp) { this.timestamp = timestamp; }

    @DynamoDBAttribute(attributeName = "ttl")
    public Integer getTtl() { return ttl; }
    public void setTtl(Integer ttl) { this.ttl = ttl; }

    @JsonProperty("vt_data")
    @DynamoDBAttribute(attributeName = "vt_data")
    public IpAddressReport getIpAddressReport() { return ipAddressReport; }
    public void setIpAddressReport(IpAddressReport ipAddressReport) { this.ipAddressReport = ipAddressReport; }
}
