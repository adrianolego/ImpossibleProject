package com.e_commerce.sms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsService {

    Logger logger = LoggerFactory.getLogger(SmsService.class);

    public void sendEmail(Long oderId) {
        logger.info("Sending email for oderId=" + oderId);
    }
}
