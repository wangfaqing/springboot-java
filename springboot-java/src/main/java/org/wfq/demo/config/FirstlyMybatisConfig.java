//package org.wfq.demo.config;
//
//import com.github.pagehelper.PageHelper;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@MapperScan(basePackages = "org.wfq.demo.dao.firstly", sqlSessionFactoryRef  = "firstlySqlSessionFactory")
//public class FirstlyMybatisConfig {
//
//    @Resource(name = "firstlyDruidDataSource")
//    private DataSource firstlyDruidDataSource;
//
//    @Bean(name = "firstlySqlSessionFactory")
//    @Primary
//    public SqlSessionFactory sqlSessionFactory(
//            @Value("${mybatis.customer.xmlLocations}")String xmlLocations,
//            @Value("${mybatis.customer.entityAliases}")String entityAliases) {
//        return createSqlSessionFactory(xmlLocations, entityAliases, firstlyDruidDataSource);
//    }
//
//    @Bean(name = "firstlySqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstlySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean(name = "firstlyManager")
//    @Primary
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(firstlyDruidDataSource);
//    }
//
//    /**
//     * @ClassName: BaseMybatisConfig
//     * @Description: 配置SqlSessionFactory
//     * @Params:
//     * @Date 2017/12/1 14:31
//     */
//    protected SqlSessionFactory createSqlSessionFactory (String xmlLocations, String entityAliases, DataSource dataSource) {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setTypeAliasesPackage(entityAliases);
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum", "true");
//        properties.setProperty("rowBoundsWithCount", "true");
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "pageNum=pageHelperStart;pageSize=pageHelperRows;count=countSql");
//        pageHelper.setProperties(properties);
//        //添加插件
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        try {
//            sqlSessionFactoryBean.setMapperLocations(resolver.getResources(xmlLocations));  // 配置*mapper.xml
//            return sqlSessionFactoryBean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//}
