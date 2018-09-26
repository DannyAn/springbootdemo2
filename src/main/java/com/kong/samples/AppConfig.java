package com.kong.samples;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
 并用于构建bean定义，初始化Spring容器。
 */
@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;

    /**
     * (1)、@Bean注解在返回实例的方法上，如果未通过@Bean指定bean的名称，则默认与标注的方法名相同；
     * (2)、@Bean注解默认作用域为单例singleton作用域，可通过@Scope(“prototype”)设置为原型作用域；
     * (3)、既然@Bean的作用是注册bean对象，那么完全可以
     *      使用@Component、@Controller、@Service、@Ripository等注解注册bean，
     *      当然需要配置@ComponentScan注解进行自动扫描。
     *  //@Bean使用方法
     *  // @Bean注解注册bean,同时可以指定初始化和销毁方法
     *  // @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
     *  @ConfigurationProperties: 加上ConfigurationProperties注解后,
     *     就会注入在application.properties中server开头的属性
     *  原理：寻找工厂方法上是否有@ConfigurationProperties 注解,如果存在的话,
     *     则调用postProcessBeforeInitialization进行处理.对应的是@Bean的方式.
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
    DataSource realDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .build();
        return dataSource;
    }

    /**
     * 在spring容器中，如果同一个类型有多个实例，但我们需要注入一个的时候，我们必须采取措施
     * @Primary的意思是在众多相同的bean中，优先使用用@Primary注解的bean.
     * @return
     */
    @Bean
    @Primary
    DataSource dataSource() {
        return new DataSourceSpy(realDataSource());
    }
}