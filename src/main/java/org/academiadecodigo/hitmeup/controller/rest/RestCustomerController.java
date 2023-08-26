package org.academiadecodigo.hitmeup.controller.rest;


import org.academiadecodigo.hitmeup.persistence.model.Hitman;


import org.academiadecodigo.hitmeup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RestCustomerController {

    private UserService userService;



    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Hitman> showCustomer(@PathVariable Integer id) {


        Hitman hitman2 = new Hitman();
        hitman2.setUsername("Knifer");
        hitman2.setAlias("The KNIFERERERERERER");
        hitman2.setPassword("qwerty123");
        hitman2.setEmail("mail@gmail.com");

        userService.save(hitman2);

        return new ResponseEntity<>(hitman2,HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/add"})
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Hitman hitman, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {


        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.save(hitman);

        return new ResponseEntity<>(hitman, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ResponseEntity<List<Hitman>> sendList() {


       List<Hitman> hitmanList = userService.list();


        return new ResponseEntity<List<Hitman>>(hitmanList,HttpStatus.OK);
    }




}
