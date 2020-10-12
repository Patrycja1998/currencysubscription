package zmijewska.p.currencysubscription.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zmijewska.p.currencysubscription.dao.entity.EmailNotification;
import zmijewska.p.currencysubscription.manager.EmailManager;
import java.util.logging.Logger;


@RestController
@RequestMapping("email/notification")
@Slf4j
public class EmailController {

    private final static Logger log = Logger.getLogger(EmailController.class.getName());


    @Autowired
    private EmailManager emailManager;


    @PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
    public String sendEmail(@RequestBody EmailNotification emailNotification) {
        try {

            log.info("Sending Simple Text Email....");
            emailManager.sendTextEmail(emailNotification);

            return "Email Sent!";
        } catch (Exception ex) {
            return "Error in sending email: " + ex;
        }
    }


}