package com.carvalhodelucas.magalums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Agendamento de tarefas
public class MagalumsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagalumsApplication.class, args);
	}

}
