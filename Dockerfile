FROM maven:3.5-jdk-8-alpine
WORKDIR /app

COPY  . /app
RUN mvn clean install -DskipTests

EXPOSE 8090
# ADD target/todos-user-service.jar todos-user-service.jar
#CMD ["tail","-f","/dev/null"]
CMD [ \
"java","-jar", \
"-Dspring.datasource.password=PASSWORD", \
"-Ddatasource.hostname=","-Dhibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect", \
"-Ddatasource.hostname=172.25.0.2", \
"-Ddatasource.db=todosdb", \
"target/todos-user-service.jar" \
]