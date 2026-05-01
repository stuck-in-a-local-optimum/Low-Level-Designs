package LLD.lldproblems.pubsub.entities;

import LLD.lldproblems.pubsub.observer.Subscriber;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

public class Topic {
    private final String name;
    private final ExecutorService deliveryExecutor;
    private Set<Subscriber> subscribers;

    public Topic(String name, ExecutorService deliveryExecutor) {
        this.name = name;
        this.deliveryExecutor = deliveryExecutor;
        this.subscribers = new CopyOnWriteArraySet<>();
    }

    public void broadCast(Message message){
        for(Subscriber subscriber : this.subscribers){
            deliveryExecutor.submit( () -> {

                try {
                    subscriber.onMessage(message);
                } catch (Exception e){
                    System.err.println("Error deliverying message to subcriber: "+ subscriber.getId() +
                            "Exception: " + e.getMessage());

                }

            });
        }
    }

    public void addSubscriber(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    public String getName() {
        return name;
    }

    public ExecutorService getDeliveryExecutor() {
        return deliveryExecutor;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
