package springboot.demo.mycoolappspringboot.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	// add expose "/" that return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is "+LocalDateTime.now();
	}
	
	// add expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "Run a hard 5k!";
	}
	
	// add expose a new endponint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day!";
	}
}
