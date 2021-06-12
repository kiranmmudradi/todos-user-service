FROM openjdk:8
EXPOSE 8090
ADD target/todos-user-service.jar todos-user-service.jar
CMD ["tail","-f","/dev/null"]
#ENTRYPOINT ["java","-jar","/todos-user-service.jar","-Ddatasource.hostname="]