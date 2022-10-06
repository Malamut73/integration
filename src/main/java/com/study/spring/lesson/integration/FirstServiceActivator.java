package com.study.spring.lesson.integration;

import com.study.spring.lesson.domain.News;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FirstServiceActivator {

    @ServiceActivator(inputChannel = "channel")
    public void listenChannel(@Payload String payload, @Headers Map<String, Object> headers) {
        System.out.println("********************");
        headers.forEach((k, v) -> System.out.println(k + " -> " + v));
        System.out.println("Payload -> " + payload);
        System.out.println("********************");
    }

    @ServiceActivator(inputChannel = "newsChannel")
    public void listenNewsChannel(@Payload News payload, @Headers Map<String,Object> headers){
        System.out.println("********** NEWS **********");
        headers.forEach((k,v) -> System.out.println(k + " -> " + v));
        System.out.println("Payload -> " + payload);
        System.out.println("********** NEWS **********");
    }

}

