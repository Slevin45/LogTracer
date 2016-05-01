package pro.smartum.app.controller;

import org.springframework.web.bind.annotation.*;
import pro.smartum.app.business.LogService;
import pro.smartum.app.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pro.smartum.app.business.UserService;
import pro.smartum.app.dto.request.CreateLogRequestBean;
import pro.smartum.app.dto.request.LoginRequestBean;
import pro.smartum.app.dto.request.RegistrationRequestBean;

/**
 * Created by eldar.s on 22.04.2016.
 */
@RestController
@RequestMapping(value = "/anon")
public class AnonController {

    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/register", method = RequestMethod.POST) // works
    public ResponseEntity<Object> registerUser(@RequestBody RegistrationRequestBean bean) {
        return new ResponseEntity<>(userService.registerUser(bean), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST) // works
    public ResponseEntity<Object> loginUser(@RequestBody LoginRequestBean bean) {
        return new ResponseEntity<>(userService.loginUser(bean), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/log", method = RequestMethod.POST)
    public ResponseEntity<String> createLog(@RequestHeader(value="appId") String appId, @RequestBody CreateLogRequestBean bean) {
        logService.createLog(bean, appId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
