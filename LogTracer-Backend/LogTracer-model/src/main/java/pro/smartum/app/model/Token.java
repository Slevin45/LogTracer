package pro.smartum.app.model;

import javax.persistence.*;

/**
 * Created by eldar.s on 22.04.2016.
 */
@Entity
@Table(name = "TOKEN")
public class Token extends Identifier {

    private User user;

    @Column(name = "TOKEN")
    private String token;


    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="USERID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
