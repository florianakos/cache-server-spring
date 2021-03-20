package com.flrnks.vtcache.dto.ipaddress.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class URL {
    
    private String url;
    private Integer positives;
    private Integer total;
    private String scan_date;

    @JsonProperty("url")
    @DynamoDBAttribute(attributeName = "url")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("positives")
    @DynamoDBAttribute(attributeName = "positives")    
    public Integer getPositives() {
        return positives;
    }
    public void setPositives(Integer positives) {
        this.positives = positives;
    }

    @JsonProperty("total")
    @DynamoDBAttribute(attributeName = "total")
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("scan_date")
    @DynamoDBAttribute(attributeName = "scan_date")
    public String getScanDate() {
        return scan_date;
    }
    public void setScanDate(String scan_date) {
        this.scan_date = scan_date;
    }
}
