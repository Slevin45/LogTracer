package pro.smartum.app.business;

import pro.smartum.app.dto.request.CreateApplicationRequestBean;
import pro.smartum.app.dto.response.ApplicationResponseBean;
import pro.smartum.app.dto.response.ApplicationsResponseBean;

/**
 * Created by eldar.s on 25.04.2016.
 */
public interface ApplicationService {
    ApplicationResponseBean createApplication(CreateApplicationRequestBean bean);

    ApplicationsResponseBean getApps(Integer number, Integer count);
}
