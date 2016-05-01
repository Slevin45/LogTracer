package pro.smartum.app.business.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.smartum.app.business.ApplicationService;
import pro.smartum.app.business.security.SecurityContextHolder;
import pro.smartum.app.business.utils.ConvertUtil;
import pro.smartum.app.business.utils.ConvertedList;
import pro.smartum.app.dao.impl.ApplicationDaoImpl;
import pro.smartum.app.dao.impl.TokenDaoImpl;
import pro.smartum.app.dao.impl.UserDaoImpl;
import pro.smartum.app.dto.request.CreateApplicationRequestBean;
import pro.smartum.app.dto.response.ApplicationResponseBean;
import pro.smartum.app.dto.response.ApplicationsResponseBean;
import pro.smartum.app.exception.AppAlreadyExistsException;
import pro.smartum.app.model.Application;
import pro.smartum.app.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by eldar.s on 25.04.2016.
 */
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationDaoImpl applicationDao;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private TokenDaoImpl tokenDao;

    @Override
    public ApplicationResponseBean createApplication(CreateApplicationRequestBean bean) {
        if (applicationDao.getUsersAppByAppName(SecurityContextHolder.getInstance().getUserId(), bean.getName()) != null) {
            throw new AppAlreadyExistsException();
        }
        Application application = new Application();
        application.setName(bean.getName());
        application.setCreateTimestamp(new Date());
        application.setAppId(DigestUtils.md5Hex((bean.getName() + System.currentTimeMillis()).getBytes()));
        application.setUserId(SecurityContextHolder.getInstance().getUserId());
        applicationDao.persist(application);
        ApplicationResponseBean responseBean = new ApplicationResponseBean();
        responseBean.setApplication(ConvertUtil.convert(application));
        return responseBean;
    }

    @Override
    public ApplicationsResponseBean getApps(Integer number, Integer count) {
        ApplicationsResponseBean bean = new ApplicationsResponseBean();
        List<Application> applicationList = applicationDao.getAppsByUserId(SecurityContextHolder.getInstance().getUserId(), number, count);
        bean.setApplications(new ConvertedList<>(applicationList));
        return bean;
    }
}
