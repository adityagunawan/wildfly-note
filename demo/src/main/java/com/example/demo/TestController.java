package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/")
    public Map<String, String> getApiTest() {
        Map<String, String> map = new HashMap<>();
        map.put("error", "null");
        map.put("message", "success");
        logger.info("success to access controller on server! :)");
        return map;
    }
}
