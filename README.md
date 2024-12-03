
**CONFIG CLIENT :** 

Client that connects to a Spring Cloud Config server to fetch the application configuration.

Steps to create Config Client:

* Add the spring-cloud-sarter-config[Config Client] dependency in your pom file.
  
    ```
    <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId>
		</dependency>
    ```
* In the application.yml file we need to add spring.config.import proprty in the file to let application know from where it will fetch the properties
  ```
  spring.application.name: interviewprep  
  spring.config.import: optional:configserver:http://localhost:8888  # URL of your Config Server
  ```


**Important Notes**
- **Optional Prefix:** The prefix optional: means that if the Config Server is not available, the application will not fail to start. Removing this prefix will cause the application to fail if it cannot connect to the Config Server.
- **Default Context and Profile Handling:** The Spring Cloud Config Client automatically attempts to load properties based on the application name and active profiles. Ensure that you have a corresponding properties file on the Config Server named after your application (e.g., your-application-name.properties).
- **Testing Configuration:** Make sure your Spring Cloud Config Server is running and accessible at the specified URI (e.g., http://localhost:8888). You can test this by accessing:
  
   ```
   http://localhost:8888/interviewprep/default
   ```
