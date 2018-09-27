package org.wfq.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching(proxyTargetClass = true)
public class EhCacheConfiguration extends CachingConfigurerSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(EhCacheConfiguration.class);

	private final static String EhACHE_NAME_CACHE_DEMO = "cache_demo";

	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		LOGGER.info("CacheConfiguration.ehCacheManagerFactoryBean()");
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
		cacheManagerFactoryBean.setShared(true);
		cacheManagerFactoryBean.setCacheManagerName("ehCacheManagerFactoryBean");
		return cacheManagerFactoryBean;
	}

	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		LOGGER.info("CacheConfiguration.ehCacheCacheManager()");
		EhCacheManagerFactoryBean bean = ehCacheManagerFactoryBean();
		EhCacheCacheManager manager = new EhCacheCacheManager(bean.getObject());
		return manager.getCacheManager();
	}

	@Bean
	public EhCacheFactoryBean ehCacheFactoryBean() {
		EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
		ehCacheFactoryBean.setCacheManager(ehCacheManager());
		return ehCacheFactoryBean;
	}

	@Override
	@Bean
	public KeyGenerator keyGenerator() {
		return new MyKeyGenerator();
	}

	@Bean(name="cacheDemo")
	public EhcacheClient dictionaryTimeEhcache() {
		return new EhcacheClient(ehCacheManager().getCache(EhACHE_NAME_CACHE_DEMO));
	}

}
