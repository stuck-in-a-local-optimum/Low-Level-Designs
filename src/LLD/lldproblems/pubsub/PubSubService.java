package LLD.lldproblems.pubsub;

import LLD.lldproblems.cricinfo.enums.PlayerRole;
import LLD.lldproblems.pubsub.entities.Message;
import LLD.lldproblems.pubsub.entities.Topic;
import LLD.lldproblems.pubsub.observer.Subscriber;
import LLD.lldproblems.taskmanager.enums.TaskPriority;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PubSubService {
    private static PubSubService INSTANCE;
    private Map<String, Topic> topicRegistry;
    private final ExecutorService deliveryExecutor;

    private PubSubService() {
        this.topicRegistry = new ConcurrentHashMap<>();

//        newCachedThreadPool
//        Creates threads on demand
//        Reuses idle threads if available
//        Kills idle threads after ~60 seconds
//        NO upper limit on thread count
        this.deliveryExecutor = Executors.newCachedThreadPool();
    }

    public static PubSubService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PubSubService();
        }
        return INSTANCE;

    }

    public void createTopic(String topicName){
        Topic topic = new Topic(topicName, this.deliveryExecutor);
        this.topicRegistry.putIfAbsent(topicName, topic);
        System.out.println("Topic " + topicName + " created");


    }
    public void subscribe(String topicName, Subscriber subscriber){
        Topic topic = this.topicRegistry.get(topicName);
        if(topic == null){
            throw new IllegalArgumentException("Topic not found with name: "+ topicName);
        }
        topic.addSubscriber(subscriber);
        System.out.println("Subscriber '" + subscriber.getId() + "' subscribed to topic: " + topicName);
    }
    public void unsubscribe(String topicName, Subscriber subscriber){
        Topic topic = this.topicRegistry.get(topicName);
        topic.removeSubscriber(subscriber);
        System.out.println("Subscriber '" + subscriber.getId() + "' unsubscribed from topic: " + topicName);
    }
    public void publish(String topicName, Message message){
        Topic topic = this.topicRegistry.get(topicName);
        if(topic == null){
            throw new IllegalArgumentException("Topic not found with name: "+ topicName);
        }
        topic.broadCast(message);
    }

    public void shutdown(){
//        Problem if we don’t shut it down:
//        App keeps running even after work is done
//        Memory leaks
//        Hanging processes
//        In real systems → resource exhaustion

        System.out.println("PubSubService shutting down...");
        this.deliveryExecutor.shutdown(); // no new tasks allowed, Already submitted tasks will continue

        try {
            // wait a reasonable time for existing tasks to complete
            if(!deliveryExecutor.awaitTermination(60, TimeUnit.SECONDS)){
                deliveryExecutor.shutdownNow(); //Stop everything immediately

            }
        } catch (InterruptedException e) {
            deliveryExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("PubSubService shutdown complete.");
    }
}
