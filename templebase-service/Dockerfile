FROM frolvlad/alpine-oraclejdk8
EXPOSE 8060 

COPY target/*.jar /home
MKDIR /home/lib
COPY target/lib/* /home/lib
WORKDIR /home
CMD java -Dserver.port=8060 -jar templebase-service-1.0-SNAPSHOT.jar
