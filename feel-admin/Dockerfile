FROM java:8
EXPOSE 10086

VOLUME /tmp
ADD feel-admin.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
