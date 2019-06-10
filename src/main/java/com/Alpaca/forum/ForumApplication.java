package com.Alpaca.forum;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication(/*exclude = SecurityAutoConfiguration.class*/)
public class ForumApplication {
	
	
//	public static final SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//	public static final SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	

	public static void main(String[] args) {
		
	
		
		SpringApplication.run(ForumApplication.class, args);
	}

}
