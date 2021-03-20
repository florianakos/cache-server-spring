package com.flrnks.vtcache.dto.ipaddress.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IpResolution {

    private String last_resolved;
    private String hostname;

    @JsonProperty("last_resolved")
    @DynamoDBAttribute(attributeName = "last_resolved")
    public String getLastResolved() {
        return last_resolved;
    }
    public void setLastResolved(String last_resolved) { this.last_resolved = last_resolved; }

    @JsonProperty("hostname")
    @DynamoDBAttribute(attributeName = "hostname")
    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) { this.hostname = hostname; }
}
