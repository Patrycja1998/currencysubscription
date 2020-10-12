package zmijewska.p.currencysubscription.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zmijewska.p.currencysubscription.dao.SubscriberRepo;
import zmijewska.p.currencysubscription.dao.entity.Subscriber;


import java.util.Optional;


    @Service
    public class SubscriberManager {

        private SubscriberRepo subscriberRepo;

        @Autowired
        public SubscriberManager(SubscriberRepo subscriberRepo) {
            this.subscriberRepo = subscriberRepo;
        }

        public Optional<Subscriber> findById(Long id) {
            return subscriberRepo.findById(id);
        }


        public Iterable<Subscriber> findAll() {
            return subscriberRepo.findAll();
        }


        public Subscriber save(Subscriber subscriber) {
            return subscriberRepo.save(subscriber);
        }

    }

