# --- COMPILE IMAGE --- #
FROM maven:3-openjdk-11 as mvn
RUN mkdir -p /usr/src/project
COPY . /usr/src/project
WORKDIR /usr/src/project
RUN mvn clean package -DskipTests

# --- PRODUCTION IMAGE --- @
FROM adoptopenjdk/openjdk11:alpine-jre
ARG  USERNAME
RUN  addgroup -S appgroup && adduser -D -u 1000 ${USERNAME} -G appgroup
USER ${USERNAME}
WORKDIR /home/${USERNAME}/project
COPY --from=mvn /usr/src/project/target/cache-server-spring-*-SNAPSHOT.jar ./service.jar
CMD exec java -jar service.jar
