package com.iteam.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocieteRestController {

    @Value("${xParam}")
    private int xParam;

    @GetMapping("/myConfig")
    public Map<String, Object> myConfig() {
        Map<String, Object> params = new HashMap<>();
        params.put("xParam", xParam);
        params.put("threadName",
                Thread.currentThread().getName());
        return params;
    }

}
