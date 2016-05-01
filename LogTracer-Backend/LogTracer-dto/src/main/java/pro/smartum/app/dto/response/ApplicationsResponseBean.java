package pro.smartum.app.dto.response;

import pro.smartum.app.dto.ApplicationDto;

import java.util.List;

/**
 * Created by eldar.s on 26.04.2016.
 */
public class ApplicationsResponseBean extends BaseResponseBean {
    private List<ApplicationDto> applications;

    public List<ApplicationDto> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationDto> applications) {
        this.applications = applications;
    }
}
