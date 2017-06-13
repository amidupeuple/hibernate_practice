package pesiykot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pesiykot.dao.CommunityDAO;
import pesiykot.dao.PersonDao;
import pesiykot.entity.Community;
import pesiykot.entity.Person;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dpivovar on 13.06.2017.
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public void createNewPerson(Person person, List<Community> communities) {
        for (Community c: communities) {
            c.getPersonList().add(person);
        }
        personDao.saveNewPerson(person);
    }
}
