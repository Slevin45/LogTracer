package pro.smartum.app.dao;

import pro.smartum.app.model.User;

/**
 * Created by eldar.s on 27.04.2016.
 */
public interface TokenDao {
    User getUserByToken(String token);
}
