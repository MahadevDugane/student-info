package com.example.studentInfo.service;

import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

@Service
public class InformationService {
    @Async
    public CompletableFuture<String> getWeatherInfo(){
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            System.out.println("inside 1st weather info");
            Thread.sleep(1000);
            uri = new URI("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object ob= template.exchange(uri, HttpMethod.GET,null,Object.class);
        System.out.println(" weather info end");
        return CompletableFuture.completedFuture(ob.toString());
    }
    @Async
    public CompletableFuture<String> getWeatherInfo1(){
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            System.out.println("inside 2nd weather info");
            Thread.sleep(500);
            uri = new URI("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object ob= template.exchange(uri, HttpMethod.GET,null,Object.class);
        System.out.println(" weather1 info end");
        return CompletableFuture.completedFuture(ob.toString());
    }
}
