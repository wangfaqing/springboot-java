//package org.wfq.demo.config;
//
//import tk.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import java.util.Properties;
//
//@Configuration
//@AutoConfigureAfter({FirstlyMybatisConfig.class,SecondaryMybatisConfig.class})
//public class MybatisMapperScannerConfig {
//
//    @Bean(name = "firstlyScannerConfigurer")
//    @Primary
//    public MapperScannerConfigurer petScannerConfigurer() {
//        return createMapperScannerConfigure("firstlySqlSessionFactory", "org.wfq.demo.dao.firstly");
//    }
//
//    @Bean(name = "secondScannerConfigurer")
//    public MapperScannerConfigurer secondScannerConfigurer() {
//        return createMapperScannerConfigure("secondSqlSessionFactory", "org.wfq.demo.dao.secondary");
//    }
//
//    private MapperScannerConfigurer createMapperScannerConfigure(String SqlSessionFactoryBeanName, String basePackage) {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName(SqlSessionFactoryBeanName);
//        mapperScannerConfigurer.setBasePackage(basePackage);
//        Properties properties = new Properties();
//        properties.setProperty("notEmpty", "false");
//        properties.setProperty("IDENTITY", "MYSQL");
//        properties.setProperty("mappers", "org.wfq.demo.common.util.MyMapper");
//        mapperScannerConfigurer.setProperties(properties);
//        return mapperScannerConfigurer;
//    }
//
//}
