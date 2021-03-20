package com.flrnks.vtcache.dto.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flrnks.vtcache.dto.ipaddress.model.Sample;
import com.flrnks.vtcache.dto.ipaddress.model.URL;

import java.util.List;

@DynamoDBDocument
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DomainReport {
    
    private String alexaDomainInfo;
    private Integer alexaRank;
    private String bitDefenderCategory;
    private String bitDefenderDomainInfo;
    private String comodoValkyrieVerdictCategory;
    private String forcepointThreatSeekerCategory;
    private WotDomainInfo wotDomainInfo;
    private WebutationDomainInfo webutationDomainInfo;

    private List<URL> detectedUrls;
    private List<Sample> detectedDownloadedSamples;
    private List<Sample> detectedReferrerSamples;
    private List<Sample> detectedCommunicatingSamples;
    
    private List<String> domainSiblings;
    private List<String> pcaps;
    private List<DomainResolution> resolutions;
    private Integer responseCode;
    private String sophosCategory;
    private List<String> subDomains;
    
    private List<Object> undetectedUrls; // does not adhere to URL schema
    private List<Sample> undetectedDownloadedSamples;
    private List<Sample> undetectedReferrerSamples;
    private List<Sample> undetectedCommunicatingSamples;
    private String verboseMsg;
    private String whoIs;
    private Integer whoIsTimestamp;

    @JsonProperty("Alexa domain info")
    @DynamoDBAttribute(attributeName = "Alexa domain info")
    public String getAlexaDomainInfo() { return alexaDomainInfo; }
    public void setAlexaDomainInfo(String alexaDomainInfo) { this.alexaDomainInfo = alexaDomainInfo; }

    @JsonProperty("Alexa rank")
    @DynamoDBAttribute(attributeName = "Alexa rank")
    public Integer getAlexaRank() { return alexaRank; }
    public void setAlexaRank(Integer alexaRank) { this.alexaRank = alexaRank; }

    @JsonProperty("BitDefender category")
    @DynamoDBAttribute(attributeName = "BitDefender category")
    public String getBitDefenderCategory() { return bitDefenderCategory; }
    public void setBitDefenderCategory(String bitDefenderCategory) { this.bitDefenderCategory = bitDefenderCategory; }

    @JsonProperty("BitDefender domain info")
    @DynamoDBAttribute(attributeName = "BitDefender domain info")
    public String getBitDefenderDomainInfo() { return bitDefenderDomainInfo; }
    public void setBitDefenderDomainInfo(String bitDefenderDomainInfo) { this.bitDefenderDomainInfo = bitDefenderDomainInfo; }

    @JsonProperty("Comodo Valkyrie Verdict category")
    @DynamoDBAttribute(attributeName = "Comodo Valkyrie Verdict category")
    public String getComodoValkyrieVerdictCategory() { return comodoValkyrieVerdictCategory; }
    public void setComodoValkyrieVerdictCategory(String comodoValkyrieVerdictCategory) { this.comodoValkyrieVerdictCategory = comodoValkyrieVerdictCategory; }

    @JsonProperty("Forcepoint ThreatSeeker category")
    @DynamoDBAttribute(attributeName = "Forcepoint ThreatSeeker category")
    public String getForcepointThreatSeekerCategory() { return forcepointThreatSeekerCategory; }
    public void setForcepointThreatSeekerCategory(String forcepointThreatSeekerCategory) { this.forcepointThreatSeekerCategory = forcepointThreatSeekerCategory; }

    @JsonProperty("WOT domain info")
    @DynamoDBAttribute(attributeName = "WOT domain info")
    public WotDomainInfo getWotDomainInfo() { return wotDomainInfo; }
    public void setWotDomainInfo(WotDomainInfo wotDomainInfo) { this.wotDomainInfo = wotDomainInfo; }

    @JsonProperty("Webutation domain info")
    @DynamoDBAttribute(attributeName = "Webutation domain info")
    public WebutationDomainInfo getWebutationDomainInfo() { return webutationDomainInfo; }
    public void setWebutationDomainInfo(WebutationDomainInfo webutationDomainInfo) { this.webutationDomainInfo = webutationDomainInfo; }

    @JsonProperty("detected_urls")
    @DynamoDBAttribute(attributeName = "detected_urls")
    public List<URL> getDetectedUrls() { return detectedUrls; }
    public void setDetectedUrls(List<URL> detectedUrls) { this.detectedUrls = detectedUrls; }

    @JsonProperty("detected_downloaded_samples")
    @DynamoDBAttribute(attributeName = "detected_downloaded_samples")
    public List<Sample> getDetectedDownloadedSamples() { return detectedDownloadedSamples; }
    public void setDetectedDownloadedSamples(List<Sample> detectedDownloadedSamples) { this.detectedDownloadedSamples = detectedDownloadedSamples; }

    @JsonProperty("detected_referrer_samples")
    @DynamoDBAttribute(attributeName = "detected_referrer_samples")
    public List<Sample> getDetectedReferrerSamples() { return detectedReferrerSamples; }
    public void setDetectedReferrerSamples(List<Sample> detectedReferrerSamples) { this.detectedReferrerSamples = detectedReferrerSamples; }

    @JsonProperty("detected_communicating_samples")
    @DynamoDBAttribute(attributeName = "detected_communicating_samples")
    public List<Sample> getDetectedCommunicatingSamples() { return detectedCommunicatingSamples; }
    public void setDetectedCommunicatingSamples(List<Sample> detectedCommunicatingSamples) { this.detectedCommunicatingSamples = detectedCommunicatingSamples; }

    @JsonProperty("domain_siblings")
    @DynamoDBAttribute(attributeName = "domain_siblings")
    public List<String> getDomainSiblings() { return domainSiblings; }
    public void setDomainSiblings(List<String> domainSiblings) { this.domainSiblings = domainSiblings; }

    @JsonProperty("pcaps")
    @DynamoDBAttribute(attributeName = "pcaps")
    public List<String> getPcaps() { return pcaps; }
    public void setPcaps(List<String> pcaps) { this.pcaps = pcaps; }

    @JsonProperty("resolutions")
    @DynamoDBAttribute(attributeName = "resolutions")
    public List<DomainResolution> getResolutions() { return resolutions; }
    public void setResolutions(List<DomainResolution> resolutions) { this.resolutions = resolutions; }

    @JsonProperty("response_code")
    @DynamoDBAttribute(attributeName = "response_code")
    public Integer getResponseCode() { return responseCode; }
    public void setResponseCode(Integer responseCode) { this.responseCode = responseCode; }

    @JsonProperty("sophos category")
    @DynamoDBAttribute(attributeName = "sophos category")
    public String getSophosCategory() { return sophosCategory; }
    public void setSophosCategory(String sophosCategory) { this.sophosCategory = sophosCategory; }

    @JsonProperty("subdomains")
    @DynamoDBAttribute(attributeName = "subdomains")
    public List<String> getSubDomains() { return subDomains; }
    public void setSubDomains(List<String> subDomains) { this.subDomains = subDomains; }

    @JsonProperty("undetected_urls")
    @DynamoDBAttribute(attributeName = "undetected_urls")
    @DynamoDBTypeConvertedJson
    public List<Object> getUndetectedUrls() { return undetectedUrls; }
    public void setUndetectedUrls(List<Object> undetectedUrls) { this.undetectedUrls = undetectedUrls; }

    @JsonProperty("undetected_downloaded_samples")
    @DynamoDBAttribute(attributeName = "undetected_downloaded_samples")
    public List<Sample> getUndetectedDownloadedSamples() { return undetectedDownloadedSamples; }
    public void setUndetectedDownloadedSamples(List<Sample> undetectedDownloadedSamples) { this.undetectedDownloadedSamples = undetectedDownloadedSamples; }

    @JsonProperty("undetected_referrer_samples")
    @DynamoDBAttribute(attributeName = "undetected_referrer_samples")
    public List<Sample> getUndetectedReferrerSamples() { return undetectedReferrerSamples; }
    public void setUndetectedReferrerSamples(List<Sample> undetectedReferrerSamples) { this.undetectedReferrerSamples = undetectedReferrerSamples; }

    @JsonProperty("undetected_communicating_samples")
    @DynamoDBAttribute(attributeName = "undetected_communicating_samples")
    public List<Sample> getUndetectedCommunicatingSamples() { return undetectedCommunicatingSamples; }
    public void setUndetectedCommunicatingSamples(List<Sample> undetectedCommunicatingSamples) { this.undetectedCommunicatingSamples = undetectedCommunicatingSamples; }

    @JsonProperty("verbose_msg")
    @DynamoDBAttribute(attributeName = "verbose_msg")
    public String getVerboseMsg() { return verboseMsg; }
    public void setVerboseMsg(String verboseMsg) { this.verboseMsg = verboseMsg; }

    @JsonProperty("whois")
    @DynamoDBAttribute(attributeName = "whois")
    public String getWhoIs() { return whoIs; }
    public void setWhoIs(String whoIs) { this.whoIs = whoIs; }

    @JsonProperty("whois_timestamp")
    @DynamoDBAttribute(attributeName = "whois_timestamp")
    public Integer getWhoIsTimestamp() { return whoIsTimestamp; }
    public void setWhoIsTimestamp(Integer whoIsTimestamp) { this.whoIsTimestamp = whoIsTimestamp; }
}
