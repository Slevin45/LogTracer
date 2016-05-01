package pro.smartum.app.dto.response;

import pro.smartum.app.dto.ApplicationDto;

/**
 * Created by eldar.s on 25.04.2016.
 */
public class ApplicationResponseBean {
    private ApplicationDto application;

    public ApplicationDto getApplicationDto() {
        return application;
    }

    public void setApplication(ApplicationDto applicationDto) {
        this.application = applicationDto;
    }
}
