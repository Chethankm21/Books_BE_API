# Use Ubuntu as base image
FROM ubuntu:latest

# Install necessary packages (Tomcat, MySQL, Java 8)
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    wget \
    mysql-server \
    openjdk-8-jdk \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Download and install Tomcat
RUN wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.100/bin/apache-tomcat-8.5.100.tar.gz && \
    tar -xzvf apache-tomcat-8.5.100.tar.gz -C /opt/ && \
    mv /opt/apache-tomcat-8.5.100 /opt/tomcat && \
    rm apache-tomcat-8.5.100.tar.gz

# Copy test.war to webapps
COPY target/bookstore-spring-boot-demo-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/

# Copy init.sql to container
COPY init.sql /init.sql

# Start MySQL service
RUN service mysql start && \
    mysql -uroot -e "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Welcome'; FLUSH PRIVILEGES;" && \
    mysql -uroot -pWelcome< /init.sql && \
    service mysql stop

# Expose Tomcat port
EXPOSE 8080

# Start MySQL and Tomcat
CMD service mysql start && /opt/tomcat/bin/catalina.sh run
