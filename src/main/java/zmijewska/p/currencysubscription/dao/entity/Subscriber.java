package zmijewska.p.currencysubscription.dao.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String mail;
    private String frequency;
    private String baseCurrency;

    public Subscriber() {
    }


    public Subscriber(String name, String mail, String frequency, String baseCurrency) {
        this.name = name;
        this.mail = mail;
        this.frequency = frequency;
        this.baseCurrency = baseCurrency;
    }

    public Subscriber(long id,String name, String mail, String frequency, String baseCurrency) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.frequency = frequency;
        this.baseCurrency = baseCurrency;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", frequency='" + frequency + '\'' +
                ", baseCurrency='" + baseCurrency + '\'' +
                '}';
    }
}