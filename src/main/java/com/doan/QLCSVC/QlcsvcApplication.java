package com.doan.QLCSVC;

import com.doan.QLCSVC.config.SwaggerConfiguration;
import com.doan.QLCSVC.model.Role;
import com.doan.QLCSVC.model.User;
import com.doan.QLCSVC.service.FileDBServiceImpl;
import com.doan.QLCSVC.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;

@SpringBootApplication
@AllArgsConstructor
@Import(SwaggerConfiguration.class)
public class QlcsvcApplication implements CommandLineRunner{
	private final PasswordEncoder passwordEncoder;
	@Resource
	FileDBServiceImpl fileDBService;

	public static void main(String[] args) {
		SpringApplication.run(QlcsvcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		fileDBService.init();

	}
}
