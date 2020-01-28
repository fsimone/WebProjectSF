package com.fsimone.hibernate;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.Bean;


/*
With the release of Hibernate 5.2 the SessionFactory extends the EntityManagerFactoryinterface. This leads to the SessionFactory also being an EntityManagerFactory.
In previous hibernate releases this wasn’t the case.
The easy solution is to downgrade the hibernate version to a version < 5.2 as there is no solution for Spring 5.0 (there will be in Spring 5.1).
Or probably even better don’t use the plain SessionFactory and let Spring Boot autoconfigure the EntityManagerFactory (done by default if hibernate is detected) and use that instead of plain Hibernate.
The solution is:
I added a exclude = HibernateJpaAutoConfiguration.classproperty to @SpringBootApplicationannotation.
*/
//@SpringBootApplication
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class Main extends SpringBootServletInitializer {

	private static ApplicationContext context;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		try {
		  ApplicationContext c = new ClassPathXmlApplicationContext("hibernate5Configuration.xml");
	      context = c;
		} catch (Exception e) {
	    	e.printStackTrace();
		}
		return application.sources(Main.class);
	}

	@Bean
    public static ApplicationContext propertyApplicationConfig() {
        return new ApplicationConfig().setApplicationContext(context);
    }

//	public static void main(String[] args) {
//		  SpringApplication.run(Main.class, args);
//	}


}
