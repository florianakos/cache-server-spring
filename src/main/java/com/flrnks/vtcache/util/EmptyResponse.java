package com.flrnks.vtcache.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

public class EmptyResponse {
    
    private Integer timestamp;
    private String queryValue;
    private String errorMsg;

    public EmptyResponse(String queryValue, String errorMsg) {
        this.timestamp = (int) Instant.now().getEpochSecond();
        this.queryValue = queryValue;
        this.errorMsg = errorMsg;
    }

    @JsonProperty("timestamp")
    public Integer getTimestamp() { return timestamp; }
    public void setTimestamp(Integer timestamp) { this.timestamp = timestamp; }

    @JsonProperty("query_value")
    public String getQueryValie() { return queryValue; }
    public void setQueryValie(String queryValue) { this.queryValue = queryValue; }

    @JsonProperty("error_msg")
    public String getErrorMsg() { return errorMsg; }
    public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
}
