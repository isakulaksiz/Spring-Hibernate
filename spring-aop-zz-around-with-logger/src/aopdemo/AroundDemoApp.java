package aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
													new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneSerive = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		System.out.println("\nMain program: AroundDemoApp");
		
		System.out.println("Calling getFortune()");
		
		String data = theFortuneSerive.getFortune();
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("\nFinished");
		
		
		// close the context
		context.close();
	}

}
