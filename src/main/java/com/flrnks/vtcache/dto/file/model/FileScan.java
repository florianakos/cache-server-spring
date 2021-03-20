package com.flrnks.vtcache.dto.file.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
public class FileScan {
    
    private String detected;
    private String result;
    private String version;
    private String update;

    @JsonProperty("detected")
    @DynamoDBAttribute(attributeName = "detected")
    public String getDetected() { return detected; }
    public void setDetected(String detected) { this.detected = detected; }

    @JsonProperty("result")
    @DynamoDBAttribute(attributeName = "result")
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    @JsonProperty("version")
    @DynamoDBAttribute(attributeName = "version")
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    @JsonProperty("update")
    @DynamoDBAttribute(attributeName = "update")
    public String getUpdate() { return update; }
    public void setUpdate(String update) { this.update = update; }

}
