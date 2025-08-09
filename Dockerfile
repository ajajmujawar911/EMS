FROM maven:sapmachine

WORKDIR /app

COPY . .

RUN ["mvn","clean"]

CMD ["mvn","spring-boot:run"]

EXPOSE 80
