package pesiykot.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pesiykot.dao.PersonDao;
import pesiykot.entity.Person;
import pesiykot.entity.PersonProjection;

/**
 * Created by dpivovar on 25.05.2017.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonDao personDao = context.getBean(PersonDao.class);

        Person pers = personDao.getPersonById(1);
        System.out.println("Person fetched: " + pers.getFullName());

        PersonProjection persProj = personDao.getPersonProjectionById(1);
        System.out.println("Person fetched: " + persProj.getFullName());
    }
}
