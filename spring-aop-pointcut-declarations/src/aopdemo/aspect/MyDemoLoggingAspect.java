package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related devices for logging
	
	// let's start with an @Before advice
	
	
	@Pointcut("execution(* aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n----> Executing @Before advice on method");
	}
	
	@Before("forDAOPackage()")
	public void performApiAnalytics() {
		System.out.println("\n----> perform Api Analytics");
	}
	
	
}
