package com.logos.fu.jenkinsdevlopdemo;

import com.cdancy.jenkins.rest.JenkinsClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JenkinsDevlopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDevlopDemoApplication.class, args);
    }


    @Bean
    public JenkinsClient jenkinsClient() {
        return JenkinsClient.builder().credentials("shiwei:123456").endPoint("http://127.0.0.1:8080").build();
    }
}
