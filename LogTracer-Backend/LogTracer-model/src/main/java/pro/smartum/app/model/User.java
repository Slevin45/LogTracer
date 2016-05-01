package pro.smartum.app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by eldar.s on 22.04.2016.
 */
@Entity
@Table(name = "USERS")
public class User extends Identifier {

    @Column(name = "CREATETIMESTAMP")
    private Date createTimestamp;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column( name = "NAME")
    private String name;

    private List<Token> tokens;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
