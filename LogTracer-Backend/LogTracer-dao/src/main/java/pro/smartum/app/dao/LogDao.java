package pro.smartum.app.dao;

import pro.smartum.app.model.Log;

import java.util.List;

/**
 * Created by eldar.s on 27.04.2016.
 */
public interface LogDao {
    List<Log> getLogsById(String appId, String message, Long startTimestamp, Long endTimestamp, Integer number, Integer count);
}
