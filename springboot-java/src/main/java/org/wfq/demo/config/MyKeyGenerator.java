package org.wfq.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("myKeyGenerator")
public class MyKeyGenerator implements KeyGenerator {
	public static final Logger LOGGER = LoggerFactory.getLogger(MyKeyGenerator.class);

	public static final int NO_PARAM_KEY = 0;

	public static final int KEY_ERROR = 53;

	@Override
	public Object generate(Object target, Method method, Object... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(target.getClass().getName()+"|||");
		sb.append(method.getName()+"|||");
		for (Object obj : params) {
			String str = "-1";
			if (obj != null) {
				try {
					str =obj.toString();
				} catch (Exception e) {

				}
			}
			sb.append(str+"|||");
		}
		return sb.toString();
	}

}
