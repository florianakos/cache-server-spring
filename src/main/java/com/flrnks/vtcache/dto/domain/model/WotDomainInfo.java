package com.flrnks.vtcache.dto.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WotDomainInfo {

    private String childSafety;
    private String privacy;
    private String trustworthiness;
    private String vendorReliability;

    @JsonProperty("Child safety")
    @DynamoDBAttribute(attributeName = "Child safety")
    public String getChildSafety() { return childSafety; }
    public void setChildSafety(String childSafety) { this.childSafety = childSafety; }

    @JsonProperty("Privacy")
    @DynamoDBAttribute(attributeName = "Privacy")
    public String getPrivacy() { return privacy; }
    public void setPrivacy(String privacy) { this.privacy = privacy; }

    @JsonProperty("Trustworthiness")
    @DynamoDBAttribute(attributeName = "Trustworthiness")
    public String getTrustworthiness() { return trustworthiness; }
    public void setTrustworthiness(String trustworthiness) { this.trustworthiness = trustworthiness; }

    @JsonProperty("Vendor reliability")
    @DynamoDBAttribute(attributeName = "Vendor reliability")
    public String getVendorReliability() { return vendorReliability; }
    public void setVendorReliability(String vendorReliability) { this.vendorReliability = vendorReliability; }
}
