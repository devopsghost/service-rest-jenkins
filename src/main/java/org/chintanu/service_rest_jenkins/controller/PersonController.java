package org.chintanu.service_rest_jenkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonController {

    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getUrl")
    public ResponseEntity<String> getUrl() {

        String url = environment.getProperty("SERVICE_URL");
        System.out.println(url);
        return ResponseEntity.ok(url);
    }

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser() {

        return ResponseEntity.ok("User 2");
    }

    @GetMapping("/getResp")
    public ResponseEntity<String> getResp() {

        String url = environment.getProperty("SERVICE_URL");
        url = url + "/getUser";

        return restTemplate.getForEntity(url, String.class);
    }
}
