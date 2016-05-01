package pro.smartum.app.dao.impl;

import org.springframework.stereotype.Repository;
import pro.smartum.app.dao.BaseDao;
import pro.smartum.app.dao.LogDao;
import pro.smartum.app.model.Log;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

/**
 * Created by eldar.s on 27.04.2016.
 */
@Repository
public class LogDaoImpl extends BaseDao<Log> implements LogDao {

    private static final int PAGE_SIZE_10 = 10;

    public LogDaoImpl(){
        setClazz(Log.class );
    }
    public List<Log> getLogsById(String appId, String message, Long startTimestamp, Long endTimestamp, Integer number, Integer count) {
        CriteriaBuilder builder  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Log> criteria = builder.createQuery(Log.class);
        Root<Log> logRoot = criteria.from(Log.class);
        Date startDate = new Date(startTimestamp);
        Date endDate = new Date(endTimestamp);
        criteria.select(logRoot);
        criteria.where(
                builder.equal(logRoot.get("message"), message),
                builder.equal(logRoot.get("appId"), appId),
                builder.between(logRoot.get("createTimestamp"), startDate, endDate)

        );
        TypedQuery<Log> query = entityManager.createQuery(criteria);
        query.setFirstResult(number);
        query.setMaxResults(count == null ? PAGE_SIZE_10 : count);
        List<Log> results = query.getResultList();
        if(results.isEmpty())
            return null;
        return results;
    }
}
