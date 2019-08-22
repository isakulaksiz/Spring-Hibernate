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
	
	// create pointcut for getter methods
	@Pointcut("execution(* aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void forDAOPackageNoGetterSetter() {}
	
	
	@Before("forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n----> Executing @Before advice on method");
	}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n----> perform Api Analytics");
	}
	
	
}
