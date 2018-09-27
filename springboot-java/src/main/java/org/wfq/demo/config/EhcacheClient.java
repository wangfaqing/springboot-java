package org.wfq.demo.config;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.util.StringUtils;

import java.util.concurrent.Callable;

public class EhcacheClient implements Cache {

	private static final Logger LOGGER = LoggerFactory.getLogger(EhcacheClient.class);

	private String name;

	private net.sf.ehcache.Ehcache ehCache;

	public EhcacheClient(Ehcache ehCache) {
		this.ehCache = ehCache;
		this.name = ehCache.getName();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Object getNativeCache() {
		return this;
	}

	@Override
	public ValueWrapper get(Object key) {
		Element value = ehCache.get(key);
		LOGGER.debug("Cache L1 (ehcache) :{" + name + "}{" + key + "}={" + value + "}");
		if (value != null) {
			return (value != null ? new SimpleValueWrapper(value.getObjectValue()) : null);
		}
		return null;
	}

	@Override
	public <T> T get(Object key, Callable<T> valueLoader) {
		ValueWrapper cachedValue = this.get(key);
		if (cachedValue != null) {
			return (T) cachedValue.get();
		}
		T newCallValue = null;
		try {
			newCallValue = valueLoader.call();
		} catch (Exception e) {
			LOGGER.error("Any error msg that u want to write", e);
		}
		if (newCallValue != null) {
			put(key, newCallValue);
		}
		return newCallValue;
	}

	@Override
	public <T> T get(Object key, Class<T> type) {
		if (StringUtils.isEmpty(key) || null == type) {
			return null;
		} else {
			final Class<T> finalType = type;
			final Object object = this.get(key);
			if (finalType != null && finalType.isInstance(object) && null != object) {
				return (T) object;
			} else {
				return null;
			}
		}
	}

	@Override
	public void put(Object key, Object value) {
		ehCache.put(new Element(key, value));
	}

	@Override
	public void evict(Object key) {
		ehCache.remove(key);
	}

	@Override
	public void clear() {
		ehCache.removeAll();
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
			return null;
		} else {
			this.put(key, value);
		}
		return new SimpleValueWrapper(value);
	}

	/**
	 * 获取缓存中的值
	 * @author <a href="mailto:wangfaqing@zhexinit.com" >王法清</a>
	 * @param key
	 * @return
	 */
	public Object getValue(Object key) {
		return get(key).get();
	}

}