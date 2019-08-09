package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {

	@Before("aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n----> perform Api Analytics");
	}
	
}
