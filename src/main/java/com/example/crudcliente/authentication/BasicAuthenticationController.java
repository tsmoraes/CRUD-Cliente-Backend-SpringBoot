package com.example.crudcliente.authentication;

/**
 * @author Thiago da Silva Moraes
 */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins={ "http://localhost:3000", "*" })
@RestController
public class BasicAuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {
        return new AuthenticationBean("Você esta autenticado!");
    }   
}