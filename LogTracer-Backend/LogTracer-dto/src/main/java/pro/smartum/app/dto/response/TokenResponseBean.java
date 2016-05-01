package pro.smartum.app.dto.response;

/**
 * Created by eldar.s on 26.04.2016.
 */
public class TokenResponseBean extends BaseResponseBean {

    private String token;

    public TokenResponseBean() {
    }

    public TokenResponseBean(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
