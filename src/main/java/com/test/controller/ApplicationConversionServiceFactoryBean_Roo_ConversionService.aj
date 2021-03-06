// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.test.controller;

import com.test.controller.ApplicationConversionServiceFactoryBean;
import com.test.domain.Login;
import com.test.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    @Autowired
    LoginService ApplicationConversionServiceFactoryBean.loginService;
    
    public Converter<Login, String> ApplicationConversionServiceFactoryBean.getLoginToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.test.domain.Login, java.lang.String>() {
            public String convert(Login login) {
                return new StringBuilder().append(login.getLoginTime()).append(' ').append(login.getUserName()).append(' ').append(login.getAttribute1()).append(' ').append(login.getAttribute2()).toString();
            }
        };
    }
    
    public Converter<Long, Login> ApplicationConversionServiceFactoryBean.getIdToLoginConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.test.domain.Login>() {
            public com.test.domain.Login convert(java.lang.Long id) {
                return loginService.findLogin(id);
            }
        };
    }
    
    public Converter<String, Login> ApplicationConversionServiceFactoryBean.getStringToLoginConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.test.domain.Login>() {
            public com.test.domain.Login convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Login.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getLoginToStringConverter());
        registry.addConverter(getIdToLoginConverter());
        registry.addConverter(getStringToLoginConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
