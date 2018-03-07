package com.apress.spring;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSimpleApplication implements CommandLineRunner, ApplicationRunner{
	private static final Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
	
	public static void main(String[] args) throws IOException {
		
		
		System.out.println("##################\n ["+args.toString()+"]["+args.length+"]");
		
		// 옵션 개수 검사. 옵션 없으면 에러 메시지 출력하고 종료
	    if (args.length == 0) {
	      System.err.println("옵션을 입력하세요");
	      System.exit(1);
	    }


	    // 옵션 개수 출력
	    System.out.println("모두 " + args.length + "개의 옵션을 입력하셨군요.");

	    System.out.println(); // 줄바꿈


	    // 모든 옵션 하나씩 화면에 출력
	    for (int i = 0; i < args.length; i++)
	      System.out.format("args[%d] : %s%n", i, args[i]);
		
		//Version 11 and 12.
		SpringApplication.run(SpringBootSimpleApplication.class, args);
		
	}
	

	//Version 11. ApplicationRunner implementation
	@Bean
	String info(){
		return "문자열 입니다.";
	}
	
	@Autowired
	String info;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("## > ApplicationRunner 구현체...");
		log.info("Accessing the Info bean: " + info);
		args.getNonOptionArgs().forEach(file -> log.info(file));
	}
	@Override
	public void run(String... args) throws Exception {
		log.info("## > CommandLineRunner 구현체...");
		log.info("Accessing the Info bean: " + info);
		for(String arg:args)
			log.info(arg);
	}
	
	
}

