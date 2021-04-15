package cn.wntime.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class RbacJpaApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RbacJpaApplication.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }

}
