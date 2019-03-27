package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class TimeAspect {
	  	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)&&execution(public * com.example.demo..*.*(..))  ")
	    public Object method(ProceedingJoinPoint pjp) throws Throwable {

	        System.out.println("=====Aspect处理=======");
	        Object[] args = pjp.getArgs();
	        for (Object arg : args) {
	            System.out.println("参数为:" + arg);
	        }

	        long start = System.currentTimeMillis();

	        Object object = pjp.proceed();

	        System.out.println(pjp.getSignature().getName()+"方法耗时:"+ (System.currentTimeMillis() - start)+"ms");

	        return object;
	    }
}
