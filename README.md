# Test app
- just a test app that contains login information
- this project is built using spring-roo

# Requirements
- maven 3
- java 1.7
- postgres

# Configuration
## database
src/main/resources/META-INF/spring/database.properties
- database.username=XXX
- database.password=XXX
 
# Run app
- mvn clean install -Pinit-db jetty:run
