package org.chintanu.service_rest_jenkins.controller;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonController {

    Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getUrl")
    public ResponseEntity<String> getUrl() {

        log.info("Inside getUrl()");
        String url = environment.getProperty("SERVICE_URL");
        System.out.println(url);
        return ResponseEntity.ok(url);
    }

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser() {

        log.info("Inside getUser()");
        return ResponseEntity.ok("User 2");
    }

    @GetMapping("/getAnotherUser")
    public ResponseEntity<String> getAnotherUser() {

        log.info("Inside getAnotherUser()");
        return ResponseEntity.ok("Another User");
    }

    @GetMapping("/getResp")
    public ResponseEntity<String> getResp() {

        log.info("Inside getResp()");
        String url = environment.getProperty("SERVICE_URL");
        url = url + "/getUser";

        return restTemplate.getForEntity(url, String.class);
    }
}
