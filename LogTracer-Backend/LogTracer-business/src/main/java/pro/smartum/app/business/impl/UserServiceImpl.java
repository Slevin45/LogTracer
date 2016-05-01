package pro.smartum.app.business.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pro.smartum.app.dao.impl.TokenDaoImpl;
import pro.smartum.app.dao.impl.UserDaoImpl;
import pro.smartum.app.dto.request.LoginRequestBean;
import pro.smartum.app.dto.request.RegistrationRequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.smartum.app.business.UserService;
import pro.smartum.app.dto.response.TokenResponseBean;
import pro.smartum.app.model.Token;
import pro.smartum.app.model.User;
import pro.smartum.app.exception.*;

import java.util.Date;

/**
 * Created by eldar.s on 22.04.2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private TokenDaoImpl tokenDao;

    @Override
    public TokenResponseBean loginUser(LoginRequestBean bean) {
        User user = userDao.getUserByLoginAndPassword(bean.getLogin(), bean.getPassword());
        if (user == null) {
            throw new UserNotExistsException();
        }
        return new TokenResponseBean(createToken(user));
    }

    @Override
    public TokenResponseBean registerUser(RegistrationRequestBean bean) {
        if (userDao.getUserByLogin(bean.getLogin()) != null) {
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setName(bean.getName());
        user.setLogin(bean.getLogin());
        user.setPassword(bean.getPassword());
        user.setCreateTimestamp(new Date());
        userDao.persist(user);
        return new TokenResponseBean(createToken(user));
    }

    @Override
    public User getUserByToken(String token) {
        User user = tokenDao.getUserByToken(token);
        if (user == null) {
            return null;
        }
        return user;
    }

    private String createToken(User user) {
        String tokenData = DigestUtils.md5Hex((user.getLogin() + System.currentTimeMillis()).getBytes());
        Token token = new Token();
        token.setToken(tokenData);
        token.setUser(user);
        tokenDao.persist(token);
        return tokenData;

    }
}
