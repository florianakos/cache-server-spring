package com.flrnks.vtcache.dao;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.flrnks.vtcache.dto.file.VtFileReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileReportDao {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public FileReportDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public VtFileReport load(String domain) {
        return dynamoDBMapper.load(VtFileReport.class, domain);
    }

    public VtFileReport save(VtFileReport domainReport) {
        dynamoDBMapper.save(domainReport);
        return domainReport;
    }
    
}
