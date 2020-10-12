package zmijewska.p.currencysubscription.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zmijewska.p.currencysubscription.dao.entity.Subscriber;

@Repository
public interface SubscriberRepo extends CrudRepository<Subscriber, Long> {


}
