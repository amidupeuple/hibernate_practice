package pesiykot.dao;

import org.springframework.stereotype.Repository;
import pesiykot.entity.Person;
import pesiykot.entity.PersonProjection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by dpivovar on 13.06.2017.
 */
@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager em;

    public Person getPersonById(long id) {
        return em.find(Person.class, id);
    }

    public void saveNewPerson(Person p) {
        em.persist(p);
    }

    @SuppressWarnings("JpaQlInspection")
    public PersonProjection getPersonProjectionById(long id) {
        TypedQuery<PersonProjection> query = em.createQuery("select new pesiykot.entity.PersonProjection(person.firstName, person.secondName) " +
                "from Person person where person.id = :id", PersonProjection.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


}
