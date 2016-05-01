package pro.smartum.app.dto.response;

import pro.smartum.app.dto.LogDto;

import java.util.List;

/**
 * Created by eldar.s on 26.04.2016.
 */
public class LogsResponseBean extends BaseResponseBean {
    private List<LogDto> logs;

    public List<LogDto> getLogs() {
        return logs;
    }

    public void setLogs(List<LogDto> logs) {
        this.logs = logs;
    }
}
