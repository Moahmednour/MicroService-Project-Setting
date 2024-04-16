package com.iteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.iteam.Entity.Societe;
import com.iteam.Repository.SocieteRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.iteam.Repository")
@EntityScan(basePackages = { "com.iteam.Entity" })
public class ServicesocieteApplication implements CommandLineRunner {
	@Autowired
	SocieteRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ServicesocieteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Societe(null, "A", 100));
		repo.save(new Societe(null, "B", 200));
		repo.save(new Societe(null, "C", 300));
	}
}
