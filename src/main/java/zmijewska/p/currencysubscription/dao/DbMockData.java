package zmijewska.p.currencysubscription.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import zmijewska.p.currencysubscription.dao.entity.Subscriber;
import zmijewska.p.currencysubscription.manager.SubscriberManager;


@Component
public class DbMockData {
    private SubscriberManager subscriberManager;


    @Autowired
    public DbMockData(SubscriberManager subscriberManager) {
        this.subscriberManager = subscriberManager;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill() {

        Subscriber subscriber1 = new Subscriber ("Ewa","ewa@wp.pl","ffff","ff");
        Subscriber subscriber2 = new Subscriber ("Marta","marta@wp.pl","eee","ff");

        subscriberManager.save(subscriber1);
        subscriberManager.save(subscriber2);



    }
}


