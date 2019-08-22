package aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;

public class AfterReturningMainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
													new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccount =theAccountDAO.findAccounts();
		
		// display the accounts
		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("--------");
		
		System.out.println(theAccount);
		System.err.println("\n");
		
		// close the context
		context.close();
	}

}
