package com.flrnks.vtcache.dto.url.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
public class UrlScan {

    private String detected;
    private String result;
    private String detail;

    @JsonProperty("detail")
    @DynamoDBAttribute(attributeName = "detail")
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    @JsonProperty("detected")
    @DynamoDBAttribute(attributeName = "detected")
    public String getDetected() { return detected; }
    public void setDetected(String detected) { this.detected = detected; }

    @JsonProperty("result")
    @DynamoDBAttribute(attributeName = "result")
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
