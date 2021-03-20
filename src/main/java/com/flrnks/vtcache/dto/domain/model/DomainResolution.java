package com.flrnks.vtcache.dto.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DomainResolution {

    private String lastResolved;
    private String ipAddress;

    @JsonProperty("last_resolved")
    @DynamoDBAttribute(attributeName = "last_resolved")
    public String getLastResolved() {
        return lastResolved;
    }
    public void setLastResolved(String lastResolved) { this.lastResolved = lastResolved; }

    @JsonProperty("ip_address")
    @DynamoDBAttribute(attributeName = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
}
