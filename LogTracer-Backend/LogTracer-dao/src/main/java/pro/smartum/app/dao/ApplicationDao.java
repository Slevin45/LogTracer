package pro.smartum.app.dao;

import pro.smartum.app.model.Application;

import java.util.List;

/**
 * Created by eldar.s on 27.04.2016.
 */
public interface ApplicationDao {
    List<Application> getAppsByUserId(int userId, Integer number, Integer count);
    Application getUsersAppByAppName(int userId, String appName);
    Application getUsersAppByAppId(int userId, String appId);
}
