package pro.smartum.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.smartum.app.business.ApplicationService;
import pro.smartum.app.dto.request.CreateApplicationRequestBean;
import pro.smartum.app.dto.response.ApplicationResponseBean;
import pro.smartum.app.dto.response.ApplicationsResponseBean;

/**
 * Created by eldar.s on 25.04.2016.
 */
@RestController
@RequestMapping(value = "/application")
public class AplicationController {
    private static final String NUMBER = "number";
    private static final String COUNT = "count";

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ApplicationResponseBean> createApplication(@RequestBody CreateApplicationRequestBean bean) {
        return new ResponseEntity<>(applicationService.createApplication(bean), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ApplicationsResponseBean> getApps(@RequestParam(NUMBER) Integer number,
                                                            @RequestParam(required = false, value = COUNT) Integer count) {
        return new ResponseEntity<>(applicationService.getApps(number, count), HttpStatus.OK);
    }
}
