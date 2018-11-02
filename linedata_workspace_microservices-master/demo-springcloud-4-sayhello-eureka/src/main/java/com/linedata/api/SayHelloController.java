package com.linedata.api;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linedata.MySayhelloApplication;

@RestController
public class SayHelloController {
	private static Logger log = LoggerFactory.getLogger(MySayhelloApplication.class);

	@Value("${server.port}")
	private Integer port;

	@RequestMapping(value = "/greeting")
	public String greet() {
		log.info("Access /greeting");

		List<String> greetings = Arrays.asList("Bonjour", "Asslama", "Hello");
		Random rand = new Random();

		int randomNum = rand.nextInt(greetings.size());
		return greetings.get(randomNum)+ "- From Port: "+port.toString();
	}

	@RequestMapping(value = "/")
	public String home() {
		log.info("Access /");
		return "Hi!"+ "- From Port: "+port.toString();
	}


}
