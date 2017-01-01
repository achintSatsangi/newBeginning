package org.vs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vs.dao.PlainTextMailDao;

@Service
public class SendMailService {

    public final PlainTextMailDao plainTextMailDao;

    @Autowired
    public SendMailService(PlainTextMailDao plainTextMailDao) {
        this.plainTextMailDao = plainTextMailDao;
    }


    public void sendmail(String name, String mail, String message) {
        plainTextMailDao.sendMail("anaamDeveloper@gmail.com", "anaam211213@gmail.com","achint.satsangi@gmail.com","Message from anaamOffical", prepareBody(name, mail, message));
    }

    private String prepareBody(String name,String  mail,String  message) {
        return "<name>" + name + "</name>" +
                "<mail>" + name + "</mail>" +
                "<message>" + name + "</message>";
    }
}
