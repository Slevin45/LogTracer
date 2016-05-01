package pro.smartum.app.dto;

import java.util.Date;

/**
 * Created by eldar.s on 25.04.2016.
 */
public class ApplicationDto extends BaseDto  {
    private String appId;
    private String name;
    private Date createTimestamp;

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

    public String getAppId() {

        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
