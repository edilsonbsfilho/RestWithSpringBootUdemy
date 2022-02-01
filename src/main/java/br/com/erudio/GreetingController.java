package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Edilson
 *
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Alguém") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/greeting/{name}")
	public Greeting greetingByName(@RequestParam(value = "name", defaultValue = "Alguém") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
