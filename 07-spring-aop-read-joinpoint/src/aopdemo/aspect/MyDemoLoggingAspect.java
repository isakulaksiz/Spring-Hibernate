package aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related devices for logging
	
	// let's start with an @Before advice
	
	
	@Before("aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n----> Executing @Before advice on method");
		
		// display the message signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+methodSig);
		
		// display the message arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: "+theAccount.getName());
				System.out.println("account name: "+theAccount.getLevel());

				
				
			}
			
		}
		
		
	}

}
