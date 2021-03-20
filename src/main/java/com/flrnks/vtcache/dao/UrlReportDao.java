package com.flrnks.vtcache.dao;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.flrnks.vtcache.dto.url.VtUrlReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UrlReportDao {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UrlReportDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public VtUrlReport load(String url) {
        return dynamoDBMapper.load(VtUrlReport.class, url);
    }

    public VtUrlReport save(VtUrlReport urlReport) {
        dynamoDBMapper.save(urlReport);
        return urlReport;
    }
    
}
