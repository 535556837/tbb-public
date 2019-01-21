package com.zyt.cxfq.common.aspect;
import javax.servlet.http.HttpSession;

import com.zyt.cxfq.plugin.page.BootPage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class TestAnnotationAspect {

    @Autowired
    private HttpSession session;
    
	@Pointcut("execution(* com.casit.service.*.*.*(..))")
	private void pointCutMethod() {
	}
	@Before("execution(* com.casit.service.*.*.*(..))")     
    public void before(JoinPoint call) {    
		
		String className = call.getTarget().getClass().getName();     
        String methodName = call.getSignature().getName(); 

        if(session!=null){
        	System.out.println("userid:"+session.getAttribute("userid"));
        	
        }
        
        System.out.println("【注解-前置通知】:" + className + "类的"      
                + methodName + "方法开始了"); 
        for(Object o: call.getArgs()){
      
        	if(o instanceof BootPage<?>){
        		System.out.println("有分页参数了");
        		
        	}
        }
	}
	//声明后置通知
	@AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	public void doAfterReturning(String result) {
		//System.out.println("后置通知");
		//System.out.println("---" + result + "---");
	}

	//声明例外通知
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		//System.out.println("例外通知");
		//System.out.println(e.getMessage());
	}

	//声明最终通知
	@After("pointCutMethod()")
	public void doAfter() {
		//System.out.println("最终通知");
	}

	//声明环绕通知
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		//System.out.println("进入方法---环绕通知");
		Object o = pjp.proceed();
		//System.out.println("退出方法---环绕通知");
		return o;
	}
}