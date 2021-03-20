package com.flrnks.vtcache.dao;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.flrnks.vtcache.dto.ipaddress.VtIpAddressReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IpAddressReportDao {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public IpAddressReportDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public VtIpAddressReport load(String ipAddress) {
        return dynamoDBMapper.load(VtIpAddressReport.class, ipAddress);
    }

    public VtIpAddressReport save(VtIpAddressReport ipAddressReport) {
        dynamoDBMapper.save(ipAddressReport);
        return ipAddressReport;
    }
    
}
