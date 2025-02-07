package com.ricardo.hosoku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HosokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(HosokuApplication.class, args);
		System.out.println("App started .... ");
		TcpServer.start();
	}

}
