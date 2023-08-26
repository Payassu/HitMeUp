package org.academiadecodigo.hitmeup.services;

import org.academiadecodigo.hitmeup.exceptions.*;
import org.academiadecodigo.hitmeup.persistence.dao.HitmanDao;
import org.academiadecodigo.hitmeup.persistence.model.Hitman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private HitmanDao hitmanDao;



    @Autowired
    public void setCustomerDao(HitmanDao hitmanDao) {
        this.hitmanDao = hitmanDao;
    }




    @Override
    public Hitman get(Integer id) {
        return hitmanDao.findById(id);
    }



    @Transactional
    @Override
    public Hitman save(Hitman hitman) {
        return hitmanDao.saveOrUpdate(hitman);
    }

    /**
     * @see UserService#delete(Integer)
     */
    @Transactional
    @Override
    public void delete(Integer id) throws UserNotFoundException {

        Hitman hitman = Optional.ofNullable(hitmanDao.findById(id))
                .orElseThrow(UserNotFoundException::new);

        hitmanDao.delete(id);
    }

    /**
     * @see UserService#list()
     */
    @Override
    public List<Hitman> list() {
        return hitmanDao.findAll();
    }


}

