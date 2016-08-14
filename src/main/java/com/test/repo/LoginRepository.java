package com.test.repo;
import com.test.domain.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RooJpaRepository(domainType = Login.class)
public interface LoginRepository {

    @Query(value = "SELECT DISTINCT DATE(login_time) AS login_dates FROM login ORDER BY login_dates", nativeQuery = true)
    @Transactional(readOnly = true)
    List<Date> getAllUniqueDates();

    @Query(value = "SELECT user_name FROM login WHERE login_time BETWEEN ?1 AND ?2 ORDER BY user_name", nativeQuery = true)
    @Transactional(readOnly = true)
    List<String> getUsersBetweenDates(Date startDate, Date endDate);
}
