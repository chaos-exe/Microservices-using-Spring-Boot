**Technical Stack:**

- JAVA Version 17
- Spring Boot version 3.0.2
- Postman Version 10.10.6
- IntelliJ IDE Community Edition 2022.3.2
- Spring Cloud Version 2022.0.1
- Build Tool 
  

**Introduction:**

In this project we have created a spring boot microservice using maven. Here we have created two microservices namely Department and User services that are linked through RestApi. User services are dependent on department service through RestTemplate. Then we have created a service registry using eureka server. Where all the running microservices are visible on the eureka dashboard available on [http://localhost:8761/](http://localhost:8761/). All the get and post requests are monitored in the postman. Then circuit breaker is implemented through resilience4j for both department and user service to handle all the breaks in the code.

**Introduction to Spring Framework**

Spring Framework is a Java platform that provides comprehensive infrastructure support for developing Java applications. Spring handles the infrastructure so you can focus on your application.

Spring enables you to build applications from "plain old Java objects" (POJOs) and to apply enterprise services non-invasively to POJOs. This capability applies to the Java SE programming model and to full and partial Java EE.

Examples of how you, as an application developer, can use the Spring platform advantage:

- Make a Java method execute in a database transaction without having to deal with transaction APIs.
- Make a local Java method a remote procedure without having to deal with remote APIs.
- Make a local Java method a management operation without having to deal with JMX APIs.
- Make a local Java method a message handler without having to deal with JMS APIs.

**Overview of Spring Microservices**

Spring Microservices is a framework for building microservices using the Spring Boot and Spring Cloud projects. Microservices are an architectural approach that involves breaking an application down into small, independent services that can be deployed and scaled independently. Spring Microservices provides a set of tools and patterns for building and managing microservices that work together to form a larger system.

**Some of the key features of Spring Microservices include:**

- Service discovery and registration: Services can register themselves with a service registry, allowing other services to discover and communicate with them.
- Load balancing: Requests can be load balanced across multiple instances of a service.
- Circuit breaking: Services can detect when a downstream service is unavailable and respond gracefully.
- Distributed configuration: Configuration can be managed across multiple services using a central configuration server.
- Tracing and monitoring: Requests can be traced across multiple services, and metrics can be collected and monitored.
- Spring Microservices is built on top of the Spring Boot and Spring Cloud projects, which provide a rich set of features for building microservices. Spring Boot provides a simple and lightweight way to build standalone Spring applications, while Spring Cloud provides a set of tools and patterns for building microservices.

**Eureka Server**

Eureka Server is a service registry that is used to register and discover microservices in a Spring Microservices system. It provides a central location for services to register themselves and for other services to discover them. Eureka Server uses a peer-to-peer architecture, where multiple instances of the service registry can be run in a cluster, providing redundancy and fault tolerance.

When a service starts up, it registers itself with the Eureka Server. It provides information about its hostname, IP address, and the port on which it is listening. Other services can then discover the service by querying the Eureka Server for its hostname.

**Eureka Server provides a number of features for managing services, including:**

- **Service registration:** Services can register themselves with the Eureka Server on startup, and unregister themselves when they shut down.
- **Service discovery:** Services can discover other services by querying the Eureka Server for their hostname.
- **Health checks:** Eureka Server can periodically check the health of registered services to ensure they are still running.
- **Load balancing:** Eureka Server can provide a list of available instances of a service to a client, allowing the client to load balance requests across multiple instances.

**API Gateway for microservices**

API Gateway is a design pattern that acts as a single entry point for all client requests to the microservices architecture. It provides an interface for clients to access multiple microservices without having to know their individual endpoints. Spring Boot provides support for building API Gateways using the Spring Cloud Gateway project.

To create an API Gateway in Spring Boot, you can follow these steps:

**1. Add the Spring Cloud Gateway dependency to your project:**
```XML
<dependency>
 <groupId>org.springframework.cloud</groupId>
 <artifactId>spring-cloud-starter-gateway</artifactId>
 </dependency>
```
**2. Configure your API routes in the application.yml or application.properties file:**
```YML
spring:
cloud:
gateway:
routes:
 - id: service1
url: http://localhost:8081
predicates:
 - Path=/service1/\*\*
 - id: service2
url: http://localhost:8082
predicates:
 - Path=/service2/\*\*
```
**3. Create a Spring Boot application class and annotate it with @EnableGateway:**
```java
@SpringBootApplication
@EnableGateway
public class ApiGatewayApplication {
public static void main(String[] args) {
 SpringApplication._run_(ApiGatewayApplication.class, args);
}
 }
```
**4. Run your API Gateway application** and test the endpoints using the configured routes.

This is a simple example of how to create an API Gateway in Spring Boot using Spring Cloud Gateway. You can customize your gateway by adding filters and configuring load balancing and circuit breaking for your microservices.

**Dependency Injection**

Dependency Injection is a pattern used in software development to allow objects to be created with their dependencies supplied from outside. It allows for loose coupling between objects, making it easier to modify and test code.

In Spring, Dependency Injection is implemented through the use of Inversion of Control (IoC) containers. The container is responsible for creating and managing objects, and injecting their dependencies. Objects are created as beans, which can be configured with various properties and dependencies.

**There are three main types of Dependency Injection in Spring:**

**Constructor Injection:** Dependencies are supplied through the constructor of the bean.

**Setter Injection:** Dependencies are supplied through setter methods on the bean.

**Field Injection:** Dependencies are supplied directly to fields on the bean.

Spring also supports a number of other features related to Dependency Injection, such as:

**Autowiring:** Dependencies can be automatically wired by type or name.

**Qualifiers:** Multiple beans of the same type can be distinguished using qualifiers.

**Profiles:** Beans can be created and configured based on different profiles, allowing for different configurations in different environments.

Overall, Spring's Dependency Injection framework provides a powerful and flexible way to manage object dependencies, making it easier to write maintainable and testable code.

**Overview of Resilience4j**

Resilience4j is a fault tolerance library for Java that provides a set of resilience patterns to help developers build more resilient applications. It is designed to work with the Spring framework and provides integrations for Spring Boot, Spring Cloud, and other Spring projects.

Resilience4j is built on top of the ReactiveX framework and provides support for reactive programming. It provides a number of resilience patterns, including circuit breaking, rate limiting, retry, and bulkheading. These patterns can be used to help applications recover from failures, prevent cascading failures, and reduce the impact of failures on users.

One of the key features of Resilience4j is its configurability. Each resilience pattern can be configured with various properties, such as the number of retries or the timeout period. This allows developers to fine-tune the behavior of the patterns to match the specific needs of their application.

Resilience4j also provides a set of monitoring and metrics features to help developers understand how their application is performing. It integrates with popular monitoring tools like Prometheus and Grafana, and provides metrics on things like the number of failures, the number of successful requests, and the response time of requests.

**Integration with Spring**

Resilience4j integrates with Spring through a number of Spring projects, including Spring Boot and Spring Cloud. Spring Boot provides auto-configuration for Resilience4j, making it easy to get started with the library. Spring Cloud provides additional features for building resilient microservices, including service discovery and load balancing.

In Spring Boot, Resilience4j can be configured using properties in the application.yml or application.properties file. For example, the following configuration sets up a circuit breaker with a 60-second timeout:

application.yaml
```YML
resilience4j.circuitbreaker.configs:
myCircuitBreaker:
slidingWindowSize: 100
permittedNumberOfCallsInHalfOpenState: 5
waitDurationInOpenState: 60000
```
Once configured, Resilience4j can be used in a number of ways within Spring applications. For example, the @CircuitBreaker annotation can be used to annotate a method that should be wrapped with a circuit breaker:
```JAVA
@CircuitBreaker(name = "myCircuitBreaker")
public String myMethod() {
// ...
}
```
Overall, Resilience4j provides a powerful set of resilience patterns for building more resilient applications. Its integrations with Spring make it easy to use within Spring applications, and its configurability and monitoring features make it a great choice for production applications.

**Overview of Postman:**

Postman is a popular API testing tool that allows developers to design, test, and document APIs. It provides a user-friendly interface for making HTTP requests, as well as a comprehensive set of tools for testing and analyzing API responses.

Here are some of the key features of Postman:

- API Request Builder: Postman makes it easy to build HTTP requests, including RESTful API requests, by providing a user-friendly interface for defining the request method, URL, headers, and request body.
- Collection Management: Postman allows you to group related requests into collections for better organization and easier testing. You can also share collections with other developers and team members.
- Test Automation: Postman supports automated testing through the use of test scripts, which are written in JavaScript. These scripts can be used to validate API responses and ensure that the API is working as expected.
- Response Viewer: Postman provides a response viewer that makes it easy to inspect the response from an API request. You can view the response body, headers, and status code, as well as analyze response times and performance metrics.
- Environment Variables: Postman allows you to define environment variables, which can be used to parameterize requests and responses. This makes it easy to test different scenarios without having to manually change request parameters.
- API Documentation: Postman provides tools for documenting your API, including generating API documentation and creating interactive API documentation that allows developers to test the API directly from the documentation.
- Collaboration: Postman allows multiple developers to collaborate on API development and testing. You can share collections, test results, and documentation with other team members.

Overall, Postman is a powerful tool for API development and testing, offering a comprehensive set of features that make it easy to design, test, and document APIs. Its user-friendly interface and support for automation make it a popular choice for developers and development teams around the world.

**Project Architecture:**

![](RackMultipart20230221-1-i170d4_html_d3d736e718df6d04.png)

**Project Microservices:**

As mentioned in the introduction we have created 4 microservices.

- As mentioned in the introduction we have created 4 microservices.
- Department-Service running on Port 9001
- User-Service running on Port 9002
- Service-Registry (Eureka Server) running on Port 8761
- Cloud Gateway (RESTful APIs) running on Port 9191

![](RackMultipart20230221-1-i170d4_html_cd8d6a0b0a2594d4.png)

_Figure 1 : cloud-geteway project structure_

**Project Structure:**

![](RackMultipart20230221-1-i170d4_html_e5985e585ccacfc7.png)

_Figure 2:department-service project structure_

![](RackMultipart20230221-1-i170d4_html_248c3e2e6f8976bf.png)

_Figure 3: service-registry project structure_

 ![](RackMultipart20230221-1-i170d4_html_fe9d6e3b930a6577.png)

_Figure 4: user-service project structure_

**Dependencies used in the project:**

- Lombok
- H2 database
- Eureka Discovery Client
- Eureka Server
- Spring Web
- Spring Data JPA

**Flow Chart:**

![](RackMultipart20230221-1-i170d4_html_77e9ac367a04d2dc.png)


 

**What is the use of API Gateway?**

API Gateway is a service that allows developers to create, publish, and manage APIs for their applications. The primary use of an API Gateway is to act as a single point of entry for multiple back-end services or microservices, and to provide features such as security, caching, load balancing, and rate limiting. Here are some of the key use cases of an API Gateway:

Routing and load balancing: API Gateway can route incoming requests to multiple backend services or instances, allowing you to scale your application as needed and distribute load across multiple instances.

Security: API Gateway can help secure your API by enforcing authentication and authorization, and by blocking requests that don't meet certain criteria.

Caching: API Gateway can cache responses from back-end services, reducing the load on your servers and improving performance for your users

Monitoring and analytics: API Gateway can provide detailed metrics and logs that help you understand how your API is being used, which can inform decisions about how to optimize and improve your application.

Protocol translation: API Gateway can also act as a translation layer, allowing you to expose your API over multiple protocols, such as HTTP, Web Sockets, or MQTT.

**Endpoint vs URL vs Base URL :**

An endpoint, a URL, and a base URL are all related to web development and the use of APIs (Application Programming Interfaces) to access web-based services.

An endpoint refers to a specific location or URL on a web server that can be accessed by an API. An endpoint defines a specific set of operations that can be performed on the server, and it typically represents a single resource or collection of resources. For example, an endpoint might represent a specific customer record in a customer database or a specific product in an online store.

A URL (Uniform Resource Locator) is a specific address that identifies a web page or other online resource. A URL typically includes several components, such as the protocol (e.g. http or https), the domain name or IP address of the server, and a specific path to the resource on the server. For example, the URL for the Google homepage is https://www.google.com.

A base URL is a common starting point for a set of related endpoints. It is the common root URL for a set of related resources that are part of a web-based API. When making API calls, developers can use a base URL to identify the root of the API and then append specific endpoint paths to it to access specific resources. For example, a base URL for a customer database might be https://api.example.com/customers, and specific endpoints might be accessed by appending the endpoint path to the base URL, such as https://api.example.com/customers/1234 to access a specific customer record.

In summary, an endpoint is a specific location or URL on a web server that can be accessed by an API, a URL is a specific address that identifies a web page or online resource, and a base URL is a common starting point for a set of related endpoints in a web-based API.

**Query params vs JSON body**

Query parameters and JSON bodies are both commonly used in web applications to pass information between a client and a server. Here are some differences and use cases for each:

| **Query Parameters** | **JSON Body** |
| --- | --- |
| Query parameters are part of the URL and are visible in the address bar of a web browser. They are typically used to pass simple values such as search terms, filters, or pagination options. | JSON bodies are part of the request payload and are not visible in the address bar of a web browser. They are typically used to pass more complex or structured data such as user input or API requests. |
| Query parameters are limited in size and complexity, so they are best suited for simple data structures. | JSON bodies can contain larger and more complex data structures than query parameters, making them more versatile. |
| Query parameters can be cached by the browser, making them faster to retrieve and reducing server load. | JSON bodies can be harder to cache than query parameters, making them slower to retrieve and potentially increasing server load. |
| Query parameters can be bookmarked or shared with others, making them useful for creating shareable links. | JSON bodies are more secure than query parameters because they are not visible in the URL, which can prevent sensitive information from being exposed. |

In summary, query parameters are best suited for passing simple values and are useful for creating shareable links, while JSON bodies are better suited for passing complex data structures and are more secure.

**API management through Postman:**

![](RackMultipart20230221-1-i170d4_html_3b3e22ac4c57e9b4.png)

_Figure 5:Sending post request to department microservice through department gateway_

**Description** : Sending POST request to department micro service through API gateway

**url** – http://localhost:9191/

**End point** - /departments/{id}

id={1,2,3,…,n}

**Request** – JSON body
```JSON
{

    "departmentName": "CSE",

    "departmentAddress": "KOLKATA",

    "departmentCode": "CSE-1365"

}
```

**Response** -JSON body
```JSON
{

"departmentId": "1"

    "departmentName": "CSE",

    "departmentAddress": "KOLKATA",

    "departmentCode": "CSE-1365"

}
```

**Method**  – POST

![](RackMultipart20230221-1-i170d4_html_6c86f35fa95fd044.png)

_Figure 6:Sending get request to department microservice through API Gateway_

**Description** : Sending GET request to department micro service through API gateway

**url** – http://localhost:9191/

**End point** - /departments/{id}

id={1,2,3,…,n}

**Request** – /departments/1

**Response** -JSON body

```JSON
{

    "departmentId": "1"

    "departmentName": "CSE",

    "departmentAddress": "KOLKATA",

    "departmentCode": "CSE-1365"

}
```
**Method**  – GET

![](RackMultipart20230221-1-i170d4_html_1c5d599aa7672066.png)

_Figure 7:Sending post request to user microservice through API gateway_

**Description** : Sending POST request to user micro service through API gateway

**url** – http://localhost:9191/

**End point** - /departments/{id}

id={1,2,3,…,n}

**Request** – JSON
```JAVA
{

"firstName": "Ankan",

    "lastName": "Das",

    "email": "ankandas11@gmail.com",

    "departmentId": "1"

}
```
**Response** -JSON body

```JAVA
{

    "userId": 1,

    "firstName": "Ankan",

    "lastName": "Das",

    "email": "ankandas11@gmail.com",

    "departmentId": "1"

}
```
**Method**  – POST

![](RackMultipart20230221-1-i170d4_html_ff4e7d8680e60ae8.png)

_Figure 8:Sending get request to user microservice through API gateway_

**Description** : Sending GET request to user micro service through API gateway

**url** – http://localhost:9191/

**End point** - /users/{id}

id={1,2,3,…,n}

**Request** – JSON
```JAVA
{

"user"

"firstName": "Ankan",

    "lastName": "Das",

    "email": "ankandas11@gmail.com",

    "departmentId": "1"

}```

**Response** -JSON body

```JSON
{

    "user": {

    "firstName": "Ankan",

    "lastName": "Das",

    "email": "ankandas11@gmail.com",

    "departmentId": "1"

},

    "department": {

    "departmentId": "1"

    "departmentName": "CSE",

    "departmentAddress": "KOLKATA",

    "departmentCode": "CSE-1365"

}
```
**Method**  – GET

**After Terminating the department service:**

![](RackMultipart20230221-1-i170d4_html_cadce6617816d606.png)

_Figure 9: After terminating department service circuit breaker beaker is calling the Fallback method for department microservice_

Description: After terminating department service circuit breaker beaker is calling the Fallback method for department microservice

Url: http://localhost:9191/

End point: /departments/{id}

Id = {1,2,3,…n}

Request: /departments/1

Response: Error Message

   "Department Service is taking longer than expected. Please Try again later"

Method: GET

![](RackMultipart20230221-1-i170d4_html_c0a04fa58f987da8.png) **No White Label Error:**

Here We can see that After Department Service is stopped , We are able to detect it using Resilience4j

**How @GeneratedValue(strategy = GenerationType.**_ **AUTO** _**) is working?**

@Id
 @GeneratedValue(strategy = GenerationType._AUTO_)
private Long departmentId;

First of all, using annotations as our configure method is just a convenient method instead of coping the endless XML configuration file.

The @Idannotation is inherited from javax.persistence.Id，indicating the member field below is the primary key of current entity. Hence your Hibernate and spring framework as well as you can do some reflect works based on this annotation.

The @GeneratedValue annotation is to configure the way of increment of the specified column(field). For example when using Mysql, you may specify auto\_increment in the definition of table to make it self-incremental, and then use

@GeneratedValue(strategy = GenerationType.IDENTITY)

in the Java code to denote that you also acknowledged to use this database server side strategy. Also, you may change the value in this annotation to fit different requirements.

### 1. Define Sequence in database

For instance, Oracle has to use sequence as increment method, say we create a sequence in Oracle:

create sequence oracle\_seq;

### 2. Refer the database sequence

Now that we have the sequence in database, but we need to establish the relation between Java and DB, by using @SequenceGenerator:

@SequenceGenerator(name="seq",sequenceName="oracle\_seq")

sequenceName is the real name of a sequence in Oracle, name is what you want to call it in Java. You need to specify sequenceName if it is different from name, otherwise just use name. I usually ignore sequenceName to save my time.

### 3. Use sequence in Java

Finally, it is time to make use this sequence in Java. Just add[@GeneratedValue](http://docs.oracle.com/javaee/6/api/javax/persistence/SequenceGenerator.html):

@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")

The generator field refers to which sequence generator you want to use. Notice it is not the real sequence name in DB, but the name you specified in name field of SequenceGenerator.

### 4. Complete

So the complete version should be like this:
```JAVA
@Entity
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class Department {

@Id
 @GeneratedValue(strategy = GenerationType._AUTO_)
private Long departmentId;
 private String departmentName;
 private String departmentAddress;
 private String departmentCode;

}
```
