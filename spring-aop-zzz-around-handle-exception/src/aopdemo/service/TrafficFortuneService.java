package aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	// simulate a delay
	public String getFortune() {

		try {
			
			TimeUnit.SECONDS.sleep(6);	
			
		}catch(InterruptedException e) {
			
			e.printStackTrace();
		}
	
		// return a fortune
		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		
		
		return getFortune();
	}
}
