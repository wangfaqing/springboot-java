package org.wfq.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.wfq.demo.common.annotation.Ds;
import org.wfq.demo.config.DynamicDataSourceContextHolder;


/**
 * 多数据源处理
 * 
 * @author ruoyi
 */
@Aspect
@Order(1)
@Component
public class DsAspect {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(public * org.wfq.demo.dao..*.*(..)) || execution(public * org.wfq.demo.methodLog.dao.*.*(..))")
	public void dsPointCut(){

	}

	@Around("dsPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object target = point.getTarget();
		Ds dataSource = AnnotationUtils.findAnnotation(target.getClass(),Ds.class);
		if (dataSource != null) {
			DynamicDataSourceContextHolder.setDateSoureType(dataSource.value().name());
		}
		try {
			return point.proceed();
		} finally {
			// 销毁数据源 在执行方法之后
			DynamicDataSourceContextHolder.clearDateSoureType();
		}
	}
}
