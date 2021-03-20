package com.flrnks.vtcache.dto.ipaddress.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Sample {

    private String date;
    private Integer positives;
    private Integer total;
    private String sha256;

    @JsonProperty("date")
    @DynamoDBAttribute(attributeName = "date")
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    @JsonProperty("positives")
    @DynamoDBAttribute(attributeName = "positives")
    public Integer getPositives() { return positives; }
    public void setPositives(Integer positives) { this.positives = positives; }

    @JsonProperty("total")
    @DynamoDBAttribute(attributeName = "total")
    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    @JsonProperty("sha256")
    @DynamoDBAttribute(attributeName = "sha256")
    public String getSha256() { return sha256; }
    public void setSha256(String sha256) { this.sha256 = sha256; }
}
