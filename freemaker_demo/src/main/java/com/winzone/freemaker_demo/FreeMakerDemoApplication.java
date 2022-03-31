package com.winzone.freemaker_demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class FreeMakerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeMakerDemoApplication.class, args);
    }

    @Autowired
    private Configuration configuration;

    @Bean
    public CommandLineRunner sendMail() {
        return args -> {
            Template mailTemplate = configuration.getTemplate("create_user.html");
            Map<String, String> params = new HashMap<>();
            params.put("fullName", "Java 07");
            params.put("email", "java07@gmail.com");
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, params);
            System.out.println(content);
        };
    }

}
