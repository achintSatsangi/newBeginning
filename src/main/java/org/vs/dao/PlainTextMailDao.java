package org.vs.dao;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;


@Component
public class PlainTextMailDao {
    private MailSender mailSender;
    private static final Logger LOG = LoggerFactory.getLogger(PlainTextMailDao.class);

    @Autowired
    public PlainTextMailDao(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String fromEmail, String toEmail, String ccEmail, String subject, String body) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        if(StringUtils.isNotEmpty(ccEmail)) {
            message.setCc(ccEmail);
        }
        message.setSubject(subject);
        message.setText(body);
        try {
            mailSender.send(message);
            System.out.println("Mail sent");
        }
        catch (MailException e) {
            e.printStackTrace();
            System.out.println("Mail failed");
            throw e;
        }
    }
}
