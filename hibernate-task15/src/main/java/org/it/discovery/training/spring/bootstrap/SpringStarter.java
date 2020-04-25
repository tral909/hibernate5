package org.it.discovery.training.spring.bootstrap;

import org.it.discovery.training.hibernate.repository.BookRepository;
import org.it.discovery.training.spring.config.PersistenceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStarter {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(
				PersistenceConfig.class)) {
			BookRepository bookRepository = context.getBean(BookRepository.class);
			// book operations		
		}
	}

}
