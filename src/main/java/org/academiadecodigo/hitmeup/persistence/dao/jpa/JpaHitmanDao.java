package org.academiadecodigo.hitmeup.persistence.dao.jpa;

import org.academiadecodigo.hitmeup.persistence.dao.HitmanDao;
import org.academiadecodigo.hitmeup.persistence.model.Hitman;

import org.springframework.stereotype.Repository;

@Repository
public class JpaHitmanDao extends GenericJpaDao<Hitman> implements HitmanDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaHitmanDao() {
        super(Hitman.class);
    }
}
