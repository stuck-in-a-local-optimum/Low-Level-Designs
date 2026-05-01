package LLD.lldproblems.pubsub.observer;

import LLD.lldproblems.pubsub.entities.Message;

public interface Subscriber {

    void onMessage(Message message);

     String getId();
}
