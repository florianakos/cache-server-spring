package com.flrnks.vtcache.dao;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.flrnks.vtcache.dto.domain.VtDomainReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DomainReportDao {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public DomainReportDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public VtDomainReport load(String domain) {
        return dynamoDBMapper.load(VtDomainReport.class, domain);
    }

    public VtDomainReport save(VtDomainReport domainReport) {
        dynamoDBMapper.save(domainReport);
        return domainReport;
    }
    
}
