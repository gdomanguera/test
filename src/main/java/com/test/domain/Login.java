package com.test.domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Login {

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(name = "login_time")
    private Date loginTime;

    /**
     */
    @Column(name = "user_name")
    private String userName;

    /**
     */
    private String attribute1;

    /**
     */
    private String attribute2;

    /**
     */
    private String attribute3;

    /**
     */
    private String attribute4;

}
