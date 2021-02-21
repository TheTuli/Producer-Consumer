package ProducerConsumerTests;

import java.util.ArrayList;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(new ArrayList(), 10);
        int limit = 50000;

        Thread producer = new Thread(new Producer(buffer, limit));
        Thread consumer = new Thread(new Consumer(buffer, limit));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}