package LLD.lldproblems.pubsub.observer;

import LLD.lldproblems.pubsub.entities.Message;

import java.util.UUID;

public class AlertSubscriber implements Subscriber {
    private final String id;

    public AlertSubscriber(String id) {
        this.id =id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Subscriber: " + this.id + " recieved [ALERT] : message: " + message);

    }

    @Override
    public String getId() {
        return this.id;
    }
}
