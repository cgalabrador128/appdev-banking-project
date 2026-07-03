package io.github.unawarespecs.bankdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "io.github.unawarespecs.bankapp",
        "io.github.unawarespecs.bankdb"
})
@EntityScan("io.github.unawarespecs.bankapp.entity")
@EnableJpaRepositories("io.github.unawarespecs.bankapp.repo")
public class BankdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankdbApplication.class, args);
    }

}
