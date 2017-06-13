package pesiykot.dao;

import org.springframework.stereotype.Repository;
import pesiykot.entity.Community;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by dpivovar on 13.06.2017.
 */
@Repository
public class CommunityDAO {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("JpaQlInspection")
    public Community getCommunityByName(String name) {
        TypedQuery<Community> query = em.createQuery("select com from Community com where com.name = :name", Community.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
