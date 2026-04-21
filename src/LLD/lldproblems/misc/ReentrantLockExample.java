package LLD.lldproblems.misc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {


    public static class TicketBooking{
        private final ReentrantLock lock = new ReentrantLock();
        private int seats = 5;

        public void bookSeat(String user){
            if(lock.tryLock()) {
                try {
                    System.out.println(user + " acquired lock");
                    if (seats > 0) {
                        System.out.println(user + " is booking a seat");

                        //following could be real work (payment processing, DB call, etc)
                        try {
                            Thread.sleep(500); // simulate work

                        } catch (InterruptedException e){
                                Thread.currentThread().interrupt();
                        }

                        seats--;
                        System.out.println(user + " successfully booked, remaining: "+ seats);
                    } else {
                        System.out.println("tried but no seats left");
                    }
                } finally {
                    System.out.println(user + " releasing lock");
                    lock.unlock();
                }
            } else {
                System.out.println(user + " couldn't acquire lock, try again later");
            }

        }
    }
}
