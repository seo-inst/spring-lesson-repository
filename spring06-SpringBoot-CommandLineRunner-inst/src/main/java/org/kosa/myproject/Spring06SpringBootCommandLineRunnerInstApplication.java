package org.kosa.myproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring06SpringBootCommandLineRunnerInstApplication implements CommandLineRunner{
	public static void main(String[] args) {
		System.out.println("SpringBoot App 시작");
		SpringApplication.run(Spring06SpringBootCommandLineRunnerInstApplication.class, args);
		System.out.println("SpringBoot App 종료");
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner 실행!");
	}
}






