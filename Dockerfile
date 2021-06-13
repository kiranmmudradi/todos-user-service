FROM maven:3.5-jdk-8-alpine
WORKDIR /app

COPY  . /app
RUN mvn clean install -DskipTests

EXPOSE 8090
# ADD target/todos-user-service.jar todos-user-service.jar
#CMD ["tail","-f","/dev/null"]
CMD [ \
"java","-jar", \
"-Dhibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect", \
"-Ddatasource.hostname=todosdb.c1j8neznq1ig.ap-south-1.rds.amazonaws.com", \
"-Ddatasource.db=todosdb", \
"-Ddatasource.username=root", \
"-Ddatasource.password=password", \
"target/todos-user-service.jar" \
]