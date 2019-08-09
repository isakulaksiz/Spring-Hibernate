package deneme;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	public static void main(String[] args) {
		
		//load the Spring configuration file.
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrive bean Spring container.
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		
		//close context.
		context.close();
		
	}
}
