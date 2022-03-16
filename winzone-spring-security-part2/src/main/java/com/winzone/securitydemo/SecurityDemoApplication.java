package com.winzone.securitydemo;

import com.winzone.securitydemo.entity.Account;
import com.winzone.securitydemo.enums.Role;
import com.winzone.securitydemo.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
@SpringBootApplication
@Slf4j
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Check if not exist a default client, add new one
     */
    @Bean
    public CommandLineRunner initDefaultOAuthClient() {
        return args -> {
            Optional<Account> adminOpt = accountRepository.findByAccount("admin");
            // Create a default admin account
            if (adminOpt.isEmpty()) {
                Account admin = Account.builder()
                        .account("admin")
                        .password(passwordEncoder.encode("123456"))
                        .authority(Role.ADMIN)
                        .build();

                Account user = Account.builder()
                        .account("user")
                        .password(passwordEncoder.encode("123456"))
                        .authority(Role.USER)
                        .build();
                accountRepository.saveAll(Arrays.asList(admin, user));

                log.info("Create success 2 demo accounts with information user/123456 and admin/123456");
            }
        };
    }
}
