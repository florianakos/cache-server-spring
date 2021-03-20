package com.flrnks.vtcache.dto.ipaddress.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IpAddressReport {
    
    private Integer asn;
    private String country;
    private Integer responseCode;
    private String asOwner;
    private String verboseMsg;
    private List<URL> detectedUrls;
    private List<Object> undetectedUrls; // does not adhere to URL schema
    private List<Sample> detectedDownloadedSamples;
    private List<Sample> undetectedDownloadedSamples;
    private List<Sample> detectedReferrerSamples;
    private List<Sample> undetectedReferrerSamples;
    private List<Sample> detectedCommunicatingSamples;
    private List<Sample> undetectedCommunicatingSamples;
    private List<IpResolution> ipResolutions;

    @JsonProperty("asn")
    @DynamoDBAttribute(attributeName = "asn")
    public Integer getAsn() { return asn; }
    public void setAsn(Integer asn) { this.asn = asn; }

    @JsonProperty("country")
    @DynamoDBAttribute(attributeName = "country")
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @JsonProperty("response_code")
    @DynamoDBAttribute(attributeName = "response_code")
    public Integer getResponseCode() { return responseCode; }
    public void setResponseCode(Integer response_code) { this.responseCode = response_code; }

    @JsonProperty("as_owner")
    @DynamoDBAttribute(attributeName = "as_owner")
    public String getAsOwner() { return asOwner; }
    public void setAsOwner(String as_owner) { this.asOwner = as_owner; }

    @JsonProperty("verbose_msg")
    @DynamoDBAttribute(attributeName = "verbose_msg")
    public String getVerboseMsg() { return verboseMsg; }
    public void setVerboseMsg(String verbose_msg) { this.verboseMsg = verbose_msg; }

    @JsonProperty("detected_urls")
    @DynamoDBAttribute(attributeName = "detected_urls")
    public List<URL> getDetectedUrls() { return detectedUrls; }
    public void setDetectedUrls(List<URL> detected_urls) { this.detectedUrls = detected_urls; }
    
    @JsonProperty("undetected_urls")
    @DynamoDBAttribute(attributeName = "undetected_urls")
    @DynamoDBTypeConvertedJson
    public List<Object> getUndetectedUrls() { return undetectedUrls; }
    public void setUndetectedUrls(List<Object> undetected_urls) { this.undetectedUrls = undetected_urls; }

    @JsonProperty("detected_downloaded_samples")
    @DynamoDBAttribute(attributeName = "detected_downloaded_samples")
    public List<Sample> getDetectedDownloadedSamples() { return detectedDownloadedSamples; }
    public void setDetectedDownloadedSamples(List<Sample> detectedDownloadedSamples) { this.detectedDownloadedSamples = detectedDownloadedSamples; }

    @JsonProperty("undetected_downloaded_samples")
    @DynamoDBAttribute(attributeName = "undetected_downloaded_samples")
    public List<Sample> getUndetectedDownloadedSamples() { return undetectedDownloadedSamples; }
    public void setUndetectedDownloadedSamples(List<Sample> undetectedDownloadedSamples) { this.undetectedDownloadedSamples = undetectedDownloadedSamples; }

    @JsonProperty("detected_referrer_samples")
    @DynamoDBAttribute(attributeName = "detected_referrer_samples")
    public List<Sample> getDetectedReferrerSamples() { return detectedReferrerSamples; }
    public void setDetectedReferrerSamples(List<Sample> detectedReferrerSamples) { this.detectedReferrerSamples = detectedReferrerSamples; }

    @JsonProperty("undetected_referrer_samples")
    @DynamoDBAttribute(attributeName = "undetected_referrer_samples")
    public List<Sample> getUndetectedReferrerSamples() { return undetectedReferrerSamples; }
    public void setUndetectedReferrerSamples(List<Sample> undetectedReferrerSamples) { this.undetectedReferrerSamples = undetectedReferrerSamples; }

    @JsonProperty("detected_communicating_samples")
    @DynamoDBAttribute(attributeName = "detected_communicating_samples")
    public List<Sample> getDetectedCommunicatingSamples() { return detectedCommunicatingSamples; }
    public void setDetectedCommunicatingSamples(List<Sample> detectedCommunicatingSamples) { this.detectedCommunicatingSamples = detectedCommunicatingSamples; }

    @JsonProperty("undetected_communicating_samples")
    @DynamoDBAttribute(attributeName = "undetected_communicating_samples")
    public List<Sample> getUndetectedCommunicatingSamples() { return undetectedCommunicatingSamples; }
    public void setUndetectedCommunicatingSamples(List<Sample> undetectedCommunicatingSamples) { this.undetectedCommunicatingSamples = undetectedCommunicatingSamples; }

    @JsonProperty("resolutions")
    @DynamoDBAttribute(attributeName = "resolutions")
    public List<IpResolution> getResolutions() { return ipResolutions; }
    public void setResolutions(List<IpResolution> ipResolutions) { this.ipResolutions = ipResolutions; }
}
