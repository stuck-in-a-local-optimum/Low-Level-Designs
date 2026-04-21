package LLD.lldproblems.misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ReentrantLockExample.TicketBooking ticketBooking = new ReentrantLockExample.TicketBooking();

        //Thread pool (better than manually creating threads)
        ExecutorService executor = Executors.newFixedThreadPool(5);

        //simulating 10 users trying to book seats (10 tasks)
        for(int i = 1; i <= 10; i++){
            String user = "User-" + i;

            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " handling " + user);
                ticketBooking.bookSeat(user);
            });
        }
        executor.shutdown();
    }
}
