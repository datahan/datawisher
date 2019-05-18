package com.datawisher.common.aop;

import com.datawisher.common.annotation.LoggerCut;
import com.datawisher.common.base.utils.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
* @Title: LoggerAdvice.java
* @Package com.ezhiyang.paysys.aop
* @Description: log切入
* @author gangchen.chen
* @date 2019/1/23 09:53
* @version V1.0
*/
@Aspect
@Service
@Slf4j
public class LoggerAdvice {

	@Before("within(com.datawisher..*) && @annotation(logCut)")
	public void addBeforeLogger(JoinPoint joinPoint, LoggerCut logCut) {
		if(log.isInfoEnabled()){
			log.info("执行 {} 方法开始, 传参：{}", logCut.value(), JSONUtils.object2Json(joinPoint.getArgs()));
			log.info("方法路径：{}", joinPoint.getSignature());
		}
	}
	
	@AfterReturning(value = "within(com.datawisher..*) && @annotation(logCut)",returning = "result")
	public void addAfterReturningLogger(JoinPoint joinPoint, LoggerCut logCut,Object result) {
		if(log.isInfoEnabled()){
			log.info("执行 {} 方法结束, 返回值：{}", logCut.value(), JSONUtils.object2Json(result));
		}
	}
	
	@AfterThrowing(pointcut = "within(com.datawisher..*) && @annotation(logCut)", throwing = "ex")
	public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerCut logCut, Exception ex) {
		if(log.isInfoEnabled()){
			log.error("执行 {} 方法异常", logCut.value(), ex);
		}
	}

	@SuppressWarnings("unused")
	private String parseParams(Object[] params) {
		if (null == params || params.length <= 0 || params.length >1024) {
			return "";
		}
		StringBuffer param = new StringBuffer("传入参数：");
		for (Object obj : params) {

			param.append(obj).append("  ");
		}
		return param.toString();
	}

}
