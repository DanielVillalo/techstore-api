package cl.techstore.api;

import oracle.security.pki.OraclePKIProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.Security;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        Security.addProvider(new OraclePKIProvider());
        SpringApplication.run(ApiApplication.class, args);
    }
}