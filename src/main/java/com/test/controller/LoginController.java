package com.test.controller;
import com.test.domain.Login;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RooWebScaffold(path = "test", formBackingObject = Login.class)
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/dates", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Date> dates() {
        return loginService.getAllUniqueDates();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<String> users(@RequestParam(required = false) String start,
                              @RequestParam(required = false) String end) {
        LOG.debug("start: " + start);
        LOG.debug("end: " + end);
        return loginService.getUsersBetweenDates(start, end);
    }

    @RequestMapping(value = "/logins", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Map<String, Integer> logins(@RequestParam(required = false) String start,
                                       @RequestParam(required = false) String end) {
        LOG.debug("start: " + start);
        LOG.debug("end: " + end);
        return loginService.getUsersCountBetweenDates(start, end);
    }
}
