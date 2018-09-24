# Building and Testing spring boot project

This document describes how to set up your development environment to build and test SpringBoot Web Project.
It also explains the basic mechanics of using `SpringBoot`, `RESTful API`, and `UnitTest`.

* [Prerequisite Extension](#prerequisite-Extension)
* [RESTful API Mechanic](#RESTful API Mechanic)
* [Config JPA Dependency](#config-jpa-dependency)
* [Build commands](#build-commands)
* [Running Tests Locally](#running-tests-locally)
* [Formatting](#clang-format)

See the [contribution guidelines](https://github.com/ng-bootstrap/ng-bootstrap/blob/master/CONTRIBUTING.md)
if you'd like to contribute to ng-bootstrap.

## Prerequisite Extension

Before you can build and test springboot project, you must install and configure the
following extensions on your development machine:
  Language Support for Java  - Microsoft
  Debugger for Java  - Microsoft
  Java Test Runner  - Microsoft
  Java Extension Pack   - Microsoft
  Maven for Java -Microsoft
  SpringInitializr - Microsoft
 
You can use these two extensions(SpringInitializr or Maven for Java) to create SpringBoot project.

##RESTful API Mechanic
Restful本身不是一项什么高深的技术，而只是一种编程风格，或者说是一种设计风格。
 接口URL         HTTP方法  接口说明
 /article	     POST	  保存文章
 /article/{id}	 GET	  查询文章列表
 /article/{id}	 DELETE	  删除文章
 /article/{id}	 PUT	  更新文章信息

 RESTful API代码和之前SpringMVC代码的区别在于：
　　（1）我们使用的是@RestController这个注解，而不是@Controller，不过这个注解同样不是Spring boot提供的，而是Spring MVC4中的提供的注解，表示一个支持Restful的控制器。
　　（2）这个类中有三个URL映射是相同的，即都是/article/{id}，这在@Controller标识的类中是不允许出现的。这里的可以通过method来进行区分，produces的作用是表示返回结果的类型是JSON。
　　（3）@PathVariable这个注解，也是Spring MVC提供的，其作用是表示该变量的值是从访问路径中获取。
　　所以看来看去，这个代码还是跟Spring boot没太多的关系，Spring boot也仅仅是提供自动配置的功能，这也是Spring boot用起来很舒服的一个很重要的原因，因为它的侵入性非常非常小，你基本感觉不到它的存在。

##config jpa dependency
add these configure to pom.xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

##config Gson dependency
  <dependency>
     <groupId>com.google.code.gson</groupId>
     <artifactId>gson</artifactId>
     <version>2.3.1</version>
  </dependency>

  
##Spring Boot实战：数据库操作
通过JdbcTemplate来访问数据库-JDBCTemplate就是Spring对JDBC的封装,通俗点说就是Spring对jdbc的封装的模板
某些特定的查询或者批量插入数据库，可以采用该方式进行读写数据库

通过JPA方式实现数据库操作
Repository 引入的两种方式：继承和使用注解
继承方法：
public interface PersonRepository extends Repository<Persion,Integer>
{
  Persion getByLastName(String lastName);

}

使用注解方法：
@RepositoryDefination(domainClass=Persion.class,idClass=Integer.class)
public interface PersonRepository extends Repository<Persion,Integer>
{
  Persion getByLastName(String lastName);

}
继承 Repository<Employee,Integer>可以使用@RepositoryDefinition注解
那 PagingAndSortingRepository、CrudRepository接口的继承却没有对应的注解

##读取application.properties 配置文件的两种常用方法
- value注解:
@Value("${jdbc.user}")
    private String user;  
      
    @Value("${jdbc.password}") 
    private String password; 

---------------------

- Bean中自动装配
@Autowired
class Student{
    private Environment env;
 
    public void speak() {
        System.out.println("=========>" + env.getProperty("aaa"));
 
    }
}
