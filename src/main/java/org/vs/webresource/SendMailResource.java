package org.vs.webresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vs.service.SendMailService;

@RestController
public class SendMailResource {

    public final SendMailService sendMailService;

    @Autowired
    public SendMailResource(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }

    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public ResponseEntity sendMail(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
        try {
            System.out.println(name + ", " + email + ", " + message);
            sendMailService.sendmail(name, email, message);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
