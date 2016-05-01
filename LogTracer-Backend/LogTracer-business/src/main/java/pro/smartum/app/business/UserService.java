package pro.smartum.app.business;

import pro.smartum.app.dto.request.LoginRequestBean;
import pro.smartum.app.dto.request.RegistrationRequestBean;
import pro.smartum.app.dto.response.TokenResponseBean;
import pro.smartum.app.model.User;

/**
 * Created by eldar.s on 22.04.2016.
 */
public interface UserService {

    TokenResponseBean loginUser(LoginRequestBean bean);

    TokenResponseBean registerUser(RegistrationRequestBean bean);

    User getUserByToken(String token);

}
