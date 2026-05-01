package LLD.lldproblems.pubsub.entities;

import java.time.Instant;

public class Message {
    //immutable class
    private final String payload;
    private final Instant timestamp;

    public Message(String payload) {
        this.payload = payload;
        this.timestamp = Instant.now();
    }

    public String getPayload(){
        return this.payload;
    }

    @Override
    public String toString(){
        return "Message{" + " payload = "+ payload + '\'' + '}';
    }
}
