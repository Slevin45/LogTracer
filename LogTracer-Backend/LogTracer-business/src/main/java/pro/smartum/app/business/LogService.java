package pro.smartum.app.business;

import pro.smartum.app.dto.request.CreateLogRequestBean;
import pro.smartum.app.dto.response.LogsResponseBean;

/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 16.04.16
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public interface LogService {

    LogsResponseBean getLogs(String appId, String message, Long startTimestamp, Long endTimestamp, Integer number, Integer count);

    void createLog(CreateLogRequestBean bean, String appId);

}
