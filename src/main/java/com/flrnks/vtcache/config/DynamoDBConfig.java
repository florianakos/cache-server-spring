package com.flrnks.vtcache.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint:#{null}}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.access-key-id:#{null}}")
    private String awsAccessKeyId;

    @Value("${amazon.aws.secret-key:#{null}}")
    private String awsSecretKey;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDBClientBuilder client = AmazonDynamoDBClientBuilder.standard();

        if (amazonDynamoDBEndpoint != null) {
            EndpointConfiguration conf = new EndpointConfiguration(amazonDynamoDBEndpoint, Regions.EU_WEST_1.toString());
            client.withEndpointConfiguration(conf);
        } else {
            client.withRegion(Regions.EU_WEST_1);
        }
        if (awsAccessKeyId != null && awsSecretKey != null) {
            client.withCredentials(
                    new AWSStaticCredentialsProvider(
                            new BasicAWSCredentials(awsAccessKeyId, awsSecretKey)
                    )
            );
        }
        
        return new DynamoDBMapper(client.build(), DynamoDBMapperConfig.DEFAULT);
    }
}
