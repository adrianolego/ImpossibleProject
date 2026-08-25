# ImpossibleProject

The idea is have a project where I'm gonna create a sell system, since de architecture to a big usage to that system. Let's follow a comum evolution from a software, starting simple and it will grow to add more complexity. This will allow implementations, refactoring, migration, problems and so on.

Bellow will be documentaded each step, each evolution will be described here to understand since the start to the current point, the decisions, the problems and the solutions, it will generate real scenarios for achitecture, implementation, frameworks, vunerability, security, monitoring, etc.

Soon the next steps:

- Choose an big system to replay
- Choose the architecture to implement with java and springboot
- Figure out how to test the implementation (maybe with performance tests)
- Grow the requirements like more users, more concurency, more complexity

The projet was generate in the spring initializer 'https://start.spring.io/' with dependencies:

- Docker Compose Support
- Spring Web
- HTTP Client
- Testcontainers
- Java 26

The first idea is to create an e-commerce with some APIs, database, divided in some layers to separete business, data and presentation documented with swagger. At this point the software need to provide a backend to save and return produts bought. This will be the first funcionality. Just one module till here.

It was installed java using sdkman

- sdk install java 26.0.2-amzn


The first version should be like below in the picture:

![System_v1.jpg](assets/System_v1.jpg?t=1787621856520)

So, let's implement the endpoint to receive the purchase order and other 2 projects to send email and sms, so far we are gonna use the same database. When de system grows up we are gonna to separate the databases in order find a way to migrate data. Till here we need to create more 2 modules at the same project like a monolith used to be created.
