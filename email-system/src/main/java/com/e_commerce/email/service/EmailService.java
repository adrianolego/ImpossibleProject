package com.e_commerce.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void sendEmail(Long oderId) {
        logger.info("Sending email for oderId=" + oderId);

    }
}
