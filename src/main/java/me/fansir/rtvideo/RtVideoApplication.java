package me.fansir.rtvideo;

import me.fansir.rtvideo.dao.UserDao;
import me.fansir.rtvideo.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RtVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RtVideoApplication.class, args);
	}

}
