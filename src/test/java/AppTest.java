import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pesiykot.dao.CommunityDAO;
import pesiykot.dao.PersonDao;
import pesiykot.dao.criteria.CriteriaDao;
import pesiykot.entity.Community;
import pesiykot.entity.Person;
import pesiykot.entity.PersonProjection;
import pesiykot.main.AppConfig;
import pesiykot.service.PersonService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpivovar on 25.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private CommunityDAO communityDAO;

    @Autowired
    private PersonService personService;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void get_person() {
        Person p = personDao.getPersonById(1);
        Assert.assertNotNull(p);
    }

    @Test
    public void get_pojo_projection() {
        PersonProjection persProj = personDao.getPersonProjectionById(1);
        Assert.assertEquals("John Zorro", persProj.getFullName());
    }

    @Test
    @Transactional
    public void get_communities_from_person() {
        Person p = personDao.getPersonById(1);
        Assert.assertEquals(2, p.getCommunityList().size());

    }

    @Test
    @Transactional
    public void create_new_person_and_ensure_that_it_saved_correctly() {
        int initNumberOfBikers = 0;

        Community bikersCommunity = communityDAO.getCommunityByName("Bikers");
        initNumberOfBikers = bikersCommunity.getPersonList().size();
        Community hooligansCommunity = communityDAO.getCommunityByName("Football hooligans");
        ArrayList<Community> coms = new ArrayList<Community>();
        coms.add(bikersCommunity);
        coms.add(hooligansCommunity);

        Person p = new Person();
        p.setSecondName("Lamar");
        p.setFirstName("Kendrick");
        p.setHeight(170);
        p.setWeight(65.5);

        personService.createNewPerson(p, coms);

        Community c = communityDAO.getCommunityByName("Bikers");
        Assert.assertEquals(initNumberOfBikers + 1, c.getPersonList().size());
    }

    @Test
    public void check_after_insert() {
        Community c = communityDAO.getCommunityByName("Bikers");
        Assert.assertNotNull(c);
    }

    @Test
    public void get_community() {
        Community c = communityDAO.getCommunityByName("Bikers");
        Assert.assertNotNull(c);
    }

}
