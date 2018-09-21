//package org.wfq.demo.config;
//
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Autowired
//    private Environment environment;
//
//    @Bean(name = "firstlyDruidDataSource")
//    @Primary
//    public DataSource druidDataSource() throws Exception {
//        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "druid.");
//        Map<String, Object> properties = propertyResolver.getSubProperties("jdbc.");
//        return DruidDataSourceFactory.createDataSource(properties);
//    }
//
//    @Bean(name = "secondaryDruidDataSource")
//    public DataSource secondaryDruidDataSource() throws Exception {
//        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "druid.");
//        Map<String, Object> properties = propertyResolver.getSubProperties("secondary.");
//        return DruidDataSourceFactory.createDataSource(properties);
//    }
//
//}
