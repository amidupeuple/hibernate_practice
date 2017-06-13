package pesiykot.dao.criteria;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by dpivovar on 26.05.2017.
 */
@Component
public class CriteriaDao {

    @PersistenceContext
    private EntityManager em;

    /*public List<PdConfiguration> getEntities() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PdConfiguration> query = cb.createQuery(PdConfiguration.class);
        Root<PdConfiguration> root = query.from(PdConfiguration.class);
        Path<String> path = root.get("name");
        query.where(cb.like(path, "%RoutingInfo"));
        //query.select(root);
        return em.createQuery(query).getResultList();
    }*/
}
