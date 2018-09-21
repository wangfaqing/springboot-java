package org.wfq.demo.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.wfq.demo.common.constants.DataSourceType;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {
	public static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSourceConfig.class);

	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.master")
	public DataSource masterDataSource(){
		DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
		dataSource.setName("masterDataSource");
		return dataSource;
	}

	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.slave")
	public DataSource slaveDataSource(){
		DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
		dataSource.setName("slaveDataSource");
		return dataSource;
	}

	/**
	 * 
	 * dataSource:多数据源配置时在此处添加即可
	 * @author <a href="mailto:wulei@zhexinit.com" >吴磊</a>
	 * @param masterDataSource
	 * @return
	 */
	@Bean(name = "dynamicDataSource")
	@Primary
	public DynamicDataSource dataSource(DataSource masterDataSource , DataSource slaveDataSource) {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DataSourceType.MASTER_DATASOURCE.name(), masterDataSource);
		targetDataSources.put(DataSourceType.SLAVE_DATASOURCE.name(), slaveDataSource);
		return new DynamicDataSource(masterDataSource, targetDataSources);
	}
}
