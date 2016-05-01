package pro.smartum.app.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.smartum.app.business.LogService;
import pro.smartum.app.business.security.SecurityContextHolder;
import pro.smartum.app.business.utils.ConvertedList;
import pro.smartum.app.dao.impl.ApplicationDaoImpl;
import pro.smartum.app.dao.impl.LogDaoImpl;
import pro.smartum.app.dao.impl.UserDaoImpl;
import pro.smartum.app.dto.request.CreateLogRequestBean;
import pro.smartum.app.dto.response.LogsResponseBean;
import pro.smartum.app.exception.AppNotExistsException;
import pro.smartum.app.exception.IncorrectUserException;
import pro.smartum.app.model.Log;

import javax.transaction.Transactional;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 16.04.16
 * Time: 22:41
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDaoImpl logDao;
    @Autowired
    private ApplicationDaoImpl appDao;
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public LogsResponseBean getLogs(String appId, String message, Long startTimestamp, Long endTimestamp, Integer number, Integer count) {
        if (appDao.findById(appId) == null) {
            throw new AppNotExistsException();
        }
        if (appDao.getUsersAppByAppId(SecurityContextHolder.getInstance().getUserId(), appId) == null) {
            throw new IncorrectUserException();
        }
        LogsResponseBean bean = new LogsResponseBean();
        bean.setLogs(new ConvertedList<>(logDao.getLogsById(appId, message, startTimestamp, endTimestamp, number, count)));
        return bean;
    }

    @Override
    public void createLog(CreateLogRequestBean bean, String appId) {
        if (appDao.findById(appId) == null) {
            throw new AppNotExistsException();
        }
        Log log = new Log();
        log.setMessage(bean.getMessage());
        log.setTag(bean.getTag());
        log.setException(bean.getException());
        log.setCreateTimestamp(new Date());
        log.setAppId(appId);
        logDao.persist(log);
    }

}
