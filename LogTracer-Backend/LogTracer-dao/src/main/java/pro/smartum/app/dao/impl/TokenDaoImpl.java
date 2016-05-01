package pro.smartum.app.dao.impl;

import org.springframework.stereotype.Repository;
import pro.smartum.app.dao.BaseDao;
import pro.smartum.app.dao.TokenDao;
import pro.smartum.app.model.Application;
import pro.smartum.app.model.Token;
import pro.smartum.app.model.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by eldar.s on 27.04.2016.
 */
@Repository
public class TokenDaoImpl extends BaseDao<Token> implements TokenDao{

    public TokenDaoImpl(){
        setClazz(Token.class );
    }

    public User getUserByToken(String token) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Token> criteria = builder.createQuery(Token.class);
        Root<Token> from = criteria.from(Token.class);
        criteria.select(from).where(builder.equal(from.get("token"), token));
        TypedQuery<Token> query = entityManager.createQuery(criteria);
        List<Token> results = query.getResultList();
        if(results.isEmpty())
            return null;
        return results.get(0).getUser();
    }
}
