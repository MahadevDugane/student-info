package com.example.studentInfo.controller;

import com.example.studentInfo.service.InformationService;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/forecast")
public class InformationController {

    InformationService service;
    public InformationController(InformationService service){
        this.service=service;
    }
    @GetMapping("/weather")
    public String getWeatherInfo() throws URISyntaxException, ExecutionException, InterruptedException {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(()->{
            RestTemplate template = new RestTemplate();
            URI uri = null;
            try {
                uri = new URI("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m");
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            Object ob= template.exchange(uri, HttpMethod.GET,null,Object.class);

            service.getWeatherInfo();
            service.getWeatherInfo1();

            return ob.toString();
        });
        return future.get().toString();

    }

}
