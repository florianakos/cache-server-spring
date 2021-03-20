package com.flrnks.vtcache.dto.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WebutationDomainInfo {
    
    private String adultContent;
    private Integer safetyScore;
    private String verdict;

    @JsonProperty("Adult content")
    @DynamoDBAttribute(attributeName = "Adult content")
    public String getAdultContent() { return adultContent; }
    public void setAdultContent(String adultContent) { this.adultContent = adultContent; }

    @JsonProperty("Safety score")
    @DynamoDBAttribute(attributeName = "Safety score")
    public Integer getSafetyScore() { return safetyScore; }
    public void setSafetyScore(Integer safetyScore) { this.safetyScore = safetyScore; }

    @JsonProperty("Verdict")
    @DynamoDBAttribute(attributeName = "Verdict")
    public String getVerdict() { return verdict; }
    public void setVerdict(String verdict) { this.verdict = verdict; }
}
