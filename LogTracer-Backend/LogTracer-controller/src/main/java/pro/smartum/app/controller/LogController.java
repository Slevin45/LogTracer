package pro.smartum.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.smartum.app.business.LogService;
import pro.smartum.app.dto.response.LogsResponseBean;
import pro.smartum.app.model.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 16.04.16
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/logs")
public class LogController {
    private static final String APP_ID = "appId";
    private static final String MESSAGE = "message";
    private static final String START_TIMESTAMP = "sDate";
    private static final String END_TIMESTAMP = "eDate";
    private static final String NUMBER = "number";
    private static final String COUNT = "count";

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/{appId}", method = RequestMethod.GET)
    public ResponseEntity<LogsResponseBean> getLogs(@PathVariable(APP_ID) String appId, @RequestParam(START_TIMESTAMP) Long startTimestamp,
                                                    @RequestParam(END_TIMESTAMP) Long endTimestamp, @RequestParam(MESSAGE) String message, @RequestParam(NUMBER) Integer number,
                                                    @RequestParam(required = false, value = COUNT) Integer count) {
        return new ResponseEntity<>(logService.getLogs(appId, message, startTimestamp, endTimestamp, number, count), HttpStatus.OK);
    }


}
