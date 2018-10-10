FROM java:8
COPY target/*.jar /var/www/java
MKDIR /var/www/java/lib
COPY target/lib/* /var/www/java/lib
WORKDIR /var/www/java
CMD java -jar templebase-service-1.0-SNAPSHOT.jar