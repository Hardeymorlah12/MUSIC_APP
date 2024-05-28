package com.Hardeymorlah.Music_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
@EnableCaching
public class MusicAppApplication{

	public static void main(String[] args) {
		SpringApplication.run(MusicAppApplication.class, args);
	}

}
