package com.test.service;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginServiceImpl implements LoginService {

    private static final Logger LOG = Logger.getLogger(LoginServiceImpl.class);
    private static final String DATE_FORMAT = "yyyyMMdd";

    @Override
    public List<Date> getAllUniqueDates() {
        return loginRepository.getAllUniqueDates();
    }

    @Override
    public List<String> getUsersBetweenDates(String start, String end) {
        LOG.info(String.format("getUsersBetweenDates() start: %s end: %s", start, end));
        Date startDate = parseToDate(start);
        Date endDate = parseToDate(end);

        return loginRepository.getUsersBetweenDates(startDate, endDate);
    }

    @Override
    public Map<String, Integer> getUsersCountBetweenDates(String start, String end) {
        LOG.info(String.format("getUsersCountBetweenDates() start: %s end: %s", start, end));
        Date startDate = parseToDate(start);
        Date endDate = parseToDate(end);

        List<String> users = loginRepository.getUsersBetweenDates(startDate, endDate);

        return countPerUsers(users);
    }

    /**
     * Count per Users
     * @param users
     * @return Map<String, Integer> with user_name as key and the count as the value
     */
    private Map<String, Integer> countPerUsers(List<String> users) {
        Map<String, Integer> userCountMap = new HashMap<String, Integer>();

        for (String user : users) {
            int count = userCountMap.containsKey(user) ? userCountMap.get(user) : 0;
            userCountMap.put(user, count + 1);
        }

        return userCountMap;
    }

    /**
     * Parse string to date
     * @param strDate
     * @return Date
     */
    private Date parseToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date();
        try {
            date = formatter.parse(strDate);
        } catch (Exception e) {
            LOG.warn("Error parsing date string: " + strDate);
            LOG.warn("Setting date to: " + date);
        }
        return date;
    }
}
