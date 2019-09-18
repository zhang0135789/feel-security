FROM java:8
EXPOSE 10088

VOLUME /tmp
ADD feel-api.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
