package pro.smartum.app.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by eldar.s on 22.04.2016.
 */
@Entity
@Table(name = "APPLICATION")
public class Application {

    @Id
    private String appId;

    @Column(name = "USERID")
    private Integer userId;

    @Column(name = "NAME")
    private String name;

    private Date createTimestamp;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
