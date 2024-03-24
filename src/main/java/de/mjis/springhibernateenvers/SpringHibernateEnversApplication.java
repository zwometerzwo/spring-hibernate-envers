package de.mjis.springhibernateenvers;

import de.mjis.springhibernateenvers.adapter.out.persistence.UserJpaEntity;
import de.mjis.springhibernateenvers.adapter.out.persistence.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHibernateEnversApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateEnversApplication.class, args);

		System.out.println("Application started");
	}

	private void makeDatabaseWork() {

	}
}
