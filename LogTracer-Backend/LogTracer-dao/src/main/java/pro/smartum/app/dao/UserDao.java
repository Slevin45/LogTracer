package pro.smartum.app.dao;

import pro.smartum.app.model.User;

/**
 * Created by eldar.s on 27.04.2016.
 */
public interface UserDao {
    User getUserByLoginAndPassword(String login, String password);
    User getUserByLogin(String login);
}
