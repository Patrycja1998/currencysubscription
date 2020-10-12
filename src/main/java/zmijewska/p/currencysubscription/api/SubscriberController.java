package zmijewska.p.currencysubscription.api;


import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zmijewska.p.currencysubscription.Subscription;
import zmijewska.p.currencysubscription.dao.entity.EmailNotification;
import zmijewska.p.currencysubscription.dao.entity.Subscriber;
import zmijewska.p.currencysubscription.manager.SubscriberManager;

import java.time.LocalDate;


@Controller
public class SubscriberController  {



    private Subscription subscription;
    private SubscriberManager subscriberManager;
    private EmailController emailController;



    @Autowired
    public SubscriberController(SubscriberManager subscriberManager, Subscription subscription, EmailController emailController) {
        this.subscriberManager = subscriberManager;
        this.subscription = subscription;
        this.emailController = emailController;

    }




    @GetMapping("/subscriber")
    public String getSubscriber(Model model) {
//
        model.addAttribute("newSubscriber", new Subscriber());
        return "subscriber";
    }



    @RequestMapping(value = "/add-subscriber", method = RequestMethod.POST)
    public String addSubscriber(@RequestParam(value = "name") String name, @RequestParam(value = "mail") String mail ,
                                @RequestParam(value = "frequency") String frequency,
                                @RequestParam(value = "baseCurrency") String baseCurrency,
                                Model model) throws JSONException {

        Subscriber subscriber = new Subscriber(name,mail,frequency,baseCurrency);
        System.out.println(subscriber);
        subscriberManager.save(subscriber);
        subscription.Connection(baseCurrency);
        emailController.sendEmail(new EmailNotification(mail,"Currency " + LocalDate.now().toString() + ": ", subscription.Connection(baseCurrency) ));
        return "redirect:/subscriber";
    }



}
