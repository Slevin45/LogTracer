package pro.smartum.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
;import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 17.04.16
 * Time: 0:07
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "LOGS")
public class Log extends Identifier {

    @Column(name = "APP_ID")
    private String appId;

    @Column(name = "TAG")
    private String tag;

    @Column(name = "CREATETIMESTAMP")
    private Date createTimestamp;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "EXCEPTION")
    private String exception;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
