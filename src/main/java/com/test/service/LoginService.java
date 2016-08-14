package com.test.service;
import org.springframework.roo.addon.layers.service.RooService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RooService(domainTypes = { com.test.domain.Login.class })
public interface LoginService {

    /**
     * Get all unique dates
     * @return List of dates
     */
    List<Date> getAllUniqueDates();

    /**
     * Get users with login_time between the given dates
     * @param startDate
     * @param endDate
     * @return List of user_names
     */
    List<String> getUsersBetweenDates(String startDate, String endDate);

    /**
     * Get Map of users and count value that has login_time between the given dates
     * @param start
     * @param end
     * @return Map of users and count value
     */
    Map<String, Integer>  getUsersCountBetweenDates(String start, String end);
}
