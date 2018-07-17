mvn clean package

scp -i ~/UnitNetwork.pem ./target/SmallApp.war ubuntu@18.222.192.98:~/apache-tomcat-9.0.8/webapps

scp -i ~/aliyun.pem ./target/SmallApp.war root@120.78.154.6:~/apache-tomcat-9.0.8/webapps

mvn clean