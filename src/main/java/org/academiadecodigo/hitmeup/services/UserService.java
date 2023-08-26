package org.academiadecodigo.hitmeup.services;

import org.academiadecodigo.hitmeup.exceptions.*;
import org.academiadecodigo.hitmeup.persistence.model.Hitman;



import java.util.List;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface UserService {

    /**
     * Gets the customer with the given id
     *
     * @param id the customer id
     * @return the customer
     */
    Hitman get(Integer id);



    Hitman save(Hitman hitman);

    /**
     * Deletes the customer
     *
     * @param id the customer id
     * @throws UserNotFoundException
     */
    void delete(Integer id) throws UserNotFoundException;

    /**
     * Gets a list of the customers
     *
     * @return the customers list
     */
    List<Hitman> list();


}
