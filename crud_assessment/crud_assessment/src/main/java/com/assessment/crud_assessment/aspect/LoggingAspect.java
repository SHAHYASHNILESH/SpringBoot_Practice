package com.assessment.crud_assessment.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//	Pointcut designators(execution,within,@within(used for classes),@annotation(used for functions),target,@target)
//	@Before("execution(* com.assessment.crud_assessment.service.EmployeeService.addEmployee(..))")
//	@After("execution(* com.assessment.crud_assessment.service.EmployeeService.*(..))")
//	public void log() {
//
//		System.out.println("Aspect Log called.....");
//
//	}

//	Named Pointcut
//	@Pointcut("execution(* com.assessment.crud_assessment.service.EmployeeService.*(..))")
//	@Pointcut("within(com.assessment.crud_assessment.service.EmployeeService)")
//	@Pointcut("@within(org.springframework.stereotype.Service)")
//	@Pointcut("@target(org.springframework.stereotype.Service)")
//	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	@Pointcut("within(com.assessment.crud_assessment.service.EmployeeService) && @within(org.springframework.stereotype.Service)")
	private void anyOldTransaction() {
	}

	@Around("anyOldTransaction()")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("Aspect Log called.....");
		Object result = joinPoint.proceed();
		System.out.println("Aspect Log after called......");

		return result;

	}
}
