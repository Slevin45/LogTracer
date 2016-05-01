package pro.smartum.app.business.utils;

import pro.smartum.app.dto.ApplicationDto;
import pro.smartum.app.dto.BaseDto;
import pro.smartum.app.dto.LogDto;
import pro.smartum.app.model.Application;
import pro.smartum.app.model.Identifier;
import pro.smartum.app.model.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by eldar.s on 25.04.2016.
 */
public class ConvertUtil {

    public static <T extends BaseDto, R extends Object> List<T> convert(Collection<R> list) {
        if (list == null) {
            return null;
        }
        List<T> result = new ArrayList<>();
        for (R entity : list) {
            result.add((T) convert(entity));
        }
        return result;
    }

    private static <T , R extends Object> T convert(R identifier) {
        if (identifier == null)
            return null;
        if (identifier instanceof Application) {
            return (T) convert((Application) identifier);
        }
        else if (identifier instanceof Log) {
            return (T) convert((Log) identifier);
        } else {
            throw new UnsupportedOperationException(
                    "Method is not found: convert(" + identifier.getClass().getName() + ")");
        }
    }

    public static ApplicationDto convert(Application application) {
        ApplicationDto applicationDto = new ApplicationDto();
        applicationDto.setName(application.getName());
        applicationDto.setCreateTimestamp(application.getCreateTimestamp());
        applicationDto.setAppId(application.getAppId());
        return applicationDto;
    }

    public static LogDto convert(Log log) {
        LogDto logDto = new LogDto();
        logDto.setAppId(log.getAppId());
        logDto.setCreateTimestamp(log.getCreateTimestamp());
        logDto.setException(log.getException());
        logDto.setMessage(log.getMessage());
        logDto.setTag(log.getTag());
        return logDto;
    }
}
