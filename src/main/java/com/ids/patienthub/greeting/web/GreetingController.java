package com.ids.patienthub.greeting.web;

import com.ids.patienthub.greeting.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

//    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
        return Greeting.builder()
                .id(counter.incrementAndGet())
//                .content(String.format(template, name))
//                .content("Hello, " + name + "!")
                .content(new StringBuilder(3).append("Hello, ").append(name).append("!").toString())
                .build();
    }
}
/*
GET /apis : récuperer une liste ou un seul élement
GET /apis/{id} : récuperer seul élement

GET /greeting?name=Zouhir&birth=xx&
POST /apis : la création d'un nouvel elt
PUT /apis/{id} : la mise a jour d un elt
PATCH /apis/{id} : la mise a jour partielle d un elt
DELETE /apis/{id} : la suppression d'un elt

 */
