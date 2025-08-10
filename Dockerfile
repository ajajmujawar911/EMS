FROM maven:sapmachine

WORKDIR /app

COPY . .

RUN mvn clean package 

CMD ["java", "-jar", "target/ems-1.0.0.jar"]


