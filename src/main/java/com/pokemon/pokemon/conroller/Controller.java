package com.pokemon.pokemon.conroller;

import com.pokemon.pokemon.model.Response;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(value = "/pokemon")
public class Controller {

    @CrossOrigin
    @GetMapping(value = "/probability")
    public Response getProbability() {
        Response resp = new Response();
        Random rand = new Random();
        int randomNum = rand.nextInt(2);
        System.out.println(randomNum);
        resp.setDescription("random menentukan bilangan genap, hasil: "+rand);
        if(randomNum == 0) resp.setValue(true);
        else resp.setValue(false);
        return resp;
    }

    @CrossOrigin
    @GetMapping(value = "/isPrimeNumber")
    public Response isPrimeNumber() {
        Response resp = new Response();
        Random rand = new Random();
        int num = rand.nextInt(20 - 1 + 1) + 1;
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            resp.setDescription(num + " is a prime number");
            resp.setValue(true);
        } else {
            resp.setDescription(num + " is not a prime number");
            resp.setValue(false);
        }
        return resp;
    }

    @CrossOrigin
    @GetMapping(value = "/fibonacci")
    public Integer isPrimeNumber(@RequestParam(value = "current") Integer current,
                                 @RequestParam(value = "last") Integer last) {
        System.out.println(current);
        System.out.println(last);
        if(current == 0 && last == 0) current = 1;
        if(last < 0) last = 0;
        return current + last;
    }
}
