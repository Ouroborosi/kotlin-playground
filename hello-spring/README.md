Hello-Spring
==========
The project is using Kotlin to demonstrate a Spring Hello World application and also using the Gradle Kotlin DSL to build this project.

## Database
The application would need a database to persist and retrieve the sample data. 
For this project I'm choosing to use [_Vagrant_](https://www.vagrantup.com/) to create a PostgreSQL database. 
But, feel free to choose any way you like to create a database.
Here's the Vagrant box this project is using: [centos-7-postgres-10](https://app.vagrantup.com/sohoffice/boxes/centos-7-postgres-10)

## Build

#### Plugins
```kotlin
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
```

- **_kotlin-spring_**
([EN](https://kotlinlang.org/docs/reference/compiler-plugins.html#spring-support) | [中文](http://www.liying-cn.net/kotlin/docs/reference/compiler-plugins.html#spring-%E6%94%AF%E6%8C%81)): 
When you use Spring, you don't need all the classes to be open, 
but only classes annotated with specific annotations like @Configuration or @Service. 
The kotlin-spring is a wrapper on top of _all-open_ ([EN](https://kotlinlang.org/docs/reference/compiler-plugins.html#all-open-compiler-plugin) | [中文](http://www.liying-cn.net/kotlin/docs/reference/compiler-plugins.html#all-open-%E7%BC%96%E8%AF%91%E5%99%A8%E6%8F%92%E4%BB%B6)), 
and it behaves exactly the same way. <br>
default supports annotations:
    - @Component
    - @Async
    - @Transactional
    - @Cacheable
    - @SpringBootTest
    - @Configuration
    - @Controller
    - @RestController
    - @Service
    - @Repository

- **_kotlin-jpa_** ([EN](https://kotlinlang.org/docs/reference/compiler-plugins.html#jpa-support) | [中文](http://www.liying-cn.net/kotlin/docs/reference/compiler-plugins.html#jpa-%E6%94%AF%E6%8C%81)): 
_kotlin-jpa_ is a wrapped on top of _no-arg_. 
The plugin specifies JPA's annotations automatically. 
The _no-arg_ ([EN](https://kotlinlang.org/docs/reference/compiler-plugins.html#no-arg-compiler-plugin) | [中文](http://www.liying-cn.net/kotlin/docs/reference/compiler-plugins.html#no-arg-%E7%BC%96%E8%AF%91%E5%99%A8%E6%8F%92%E4%BB%B6)) is a plugin helps to generate a default constructor for classes. 
The generated constructor is synthetic so it can’t be directly called from Java or Kotlin. This allows the Java Persistence API (JPA) to instantiate a class although it doesn't have the zero-parameter constructor from Kotlin or Java point of view. <br>
default supports annotations:
    - @Entity
    - @Embeddable
    - @MappedSuperclass
    
## Run

#### Start up
```sbtshell
gradlew bootRun
```

#### Hello World
**/helloworld**
```sbtshell
curl -X GET http://localhost:8080/helloworld
```
**Response**

Hello,World!

#### Find by last name
**/hello?lastName=_$lastName_**
```sbtshell
curl -X GET http://localhost:8080/hello?lastName=Chen
```
**Response**

```json
{
    "People last name is Chen": [{
        "id": 1,
        "firstName": "Jason",
        "lastName": "Chen",
        "gender": "Male",
        "age": 28,
        "gmtCreated": "2019-11-25T05:44:57.307+0000",
        "gmtModified": "2019-11-25T05:44:57.307+0000"
    }, {
        "id": 3,
        "firstName": "Corey",
        "lastName": "Chen",
        "gender": "Female",
        "age": 20,
        "gmtCreated": "2019-11-25T05:44:57.307+0000",
        "gmtModified": "2019-11-25T05:44:57.307+0000"
    }]
}
```
