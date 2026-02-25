#Use official maven image to build the app
From maven:3.9.6-eclipse-temurin-21 As build

WoORKDIR /app
COPY pom.xml
COPY src ./src

RUN mvn clean package -DskipTests

#Use smaller JDK image to run the app
From eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]