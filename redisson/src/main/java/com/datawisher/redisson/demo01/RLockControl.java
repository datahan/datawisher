package com.datawisher.redisson.demo01;

import com.datawisher.redisson.demo01.domain.vo.PaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


@Aspect
@Component
@Slf4j
public class RLockControl {

  @Autowired
  private DistributedRedisLock redisLock;

  @Before("within(com.datawisher..*) && @annotation(lockCut)")
  public void addBeforeTryLock(JoinPoint joinPoint, LockCut lockCut) {
    log.info("获取锁开始");
    Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
    Parameter[] parameters = method.getParameters();
    for (Parameter parameter : parameters) {
      AnnotatedType annotatedType = parameter.getAnnotatedType();
      if (annotatedType.equals(LockId.class)) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }
    }

    System.out.println("===");
  }

  @AfterReturning(value = "within(com.datawisher..*) && @annotation(lockCut)",returning = "result")
  public void addAfterReturningReleaseLock(JoinPoint joinPoint, LockCut lockCut, Object result) {
    log.info("释放锁开始");
  }

  @AfterThrowing(pointcut = "within(com.datawisher..*) && @annotation(lockCut)", throwing = "ex")
  public void addAfterThrowingReleaseLock(JoinPoint joinPoint, LockCut lockCut, Exception ex) {

  }

}
