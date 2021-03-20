# cache-server-spring
A Java / Spring Boot server that uses AWS DynamoDB to cache API responses 

To test it, just run the below command via docker compose:

```
docker-compose up --build --abort-on-container-exit
```

I've also included some historically useful scripts in `/bin` which are now kinda obsolete thansk to the docker-compose file.