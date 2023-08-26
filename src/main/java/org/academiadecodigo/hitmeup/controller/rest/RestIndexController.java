package org.academiadecodigo.hitmeup.controller.rest;

import org.academiadecodigo.hitmeup.persistence.model.Hitman;
import org.academiadecodigo.hitmeup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST controller responsible for retrieving the API description
 */
@RestController
@RequestMapping("/api")
public class RestIndexController {

    UserService userService;
    List<Hitman> hitmanList = new ArrayList();
    /**
     * Retrieves the API name and version
     *
     * @return the response
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    @ResponseBody
    protected Hitman showVersion() {

        Hitman hitman = new Hitman();
        hitman.setUsername("EasyKiller");
        hitman.setAlias("The Murderer");
        hitman.setPassword("qazqaz");
        hitman.setEmail("mail@gmail.com");


        Hitman hitman2 = new Hitman();
        hitman.setUsername("Knifer");
        hitman.setAlias("The KNIFERERER");
        hitman.setPassword("qwerty123");
        hitman.setEmail("mail@gmail.com");

        hitmanList.add(hitman);
        hitmanList.add(hitman2);


        return hitman;

    }

    private static class ApiVersion {

        private String name;
        private String version;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
