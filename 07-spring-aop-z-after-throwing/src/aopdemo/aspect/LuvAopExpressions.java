package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	@Pointcut("execution(* aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNoGetterSetter() {}
	
}
