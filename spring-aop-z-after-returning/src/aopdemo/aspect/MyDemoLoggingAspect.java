package aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	
	//------
	
	// add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(
					pointcut="execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=========>>> Executing @AfterReturning on method: "+method);
		
		// print out the results of the method call
		System.out.println("\n=========>>> result is: "+result);

		
		// let's post-peocess the data ... let's modify it
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=========>>> result is: "+result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
	
		// loop through accounts
		
		for(Account tempAccount : result) {
		
		// get uppercase version of name
		String theUpperName = tempAccount.getName().toUpperCase();
		
		// update the name on the account
		tempAccount.setName(theUpperName);
		}
	}




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
