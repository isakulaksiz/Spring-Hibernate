package aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
													new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneSerive = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		myLogger.info("\nMain program: AroundDemoApp");
		
		myLogger.info("Calling getFortune()");
		
		String data = theFortuneSerive.getFortune();
		
		myLogger.info("\nMy fortune is: "+data);
		
		myLogger.info("\nFinished");
		
		
		// close the context
		context.close();
	}

}
