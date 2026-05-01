package LLD.lldproblems.pubsub.observer;

import LLD.lldproblems.pubsub.entities.Message;

public class NewsSubscriber implements Subscriber {
    private final String id;

    public NewsSubscriber(String id) {
        this.id = id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Subscriber: " + this.id + " recieved [NEWS] : message: " + message);

    }

    @Override
    public String getId() {
        return this.id;
    }
}
