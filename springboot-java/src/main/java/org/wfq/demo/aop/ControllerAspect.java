package org.wfq.demo.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.wfq.demo.common.exception.CommonException;
import org.wfq.demo.common.util.ResponseUtil;
import org.wfq.demo.common.util.ResultEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class ControllerAspect {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(public * org.wfq.demo.controller..*.*(..))")
	private void controllerAspect() {
	}
	
//	@Before(value = "controllerAspect()")
//	public void beforeController(ProceedingJoinPoint joinPoint) {
//		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = requestAttributes.getRequest();
//		String methodName = joinPoint.getSignature().toShortString();
//		long beginTime = System.currentTimeMillis();
//	}
	

	@Around(value = "controllerAspect()")
	public Object methodBefore(ProceedingJoinPoint joinPoint) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String methodName = joinPoint.getSignature().toShortString();
		long beginTime = System.currentTimeMillis();
		// 打印请求内容
		log.info("===============请求内容 start ===============");
		log.info("请求IP:" + request.getRemoteAddr().toString());
		log.info("请求地址:" + request.getRequestURL().toString());
		log.info("请求方式:" + request.getMethod());
		log.info("请求类方法:" + joinPoint.getSignature());
		log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));

		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable throwable) {
			if (throwable instanceof CommonException) {
				log.warn("异常捕获:", throwable);
				return ResponseUtil.fail((CommonException) throwable);
			} else {
				log.error("异常捕获:", throwable);
			}
			return ResponseUtil.fail(ResultEnum.systemError);
		}
		long endTime = System.currentTimeMillis();
		log.info("耗时：" + (endTime - beginTime));
		log.info("返回结果:" + JSON.toJSONString(result));
		log.info("===============请求结束 end ===============");
		return result;
	}

}
