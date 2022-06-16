package testng_learning;

import org.testng.annotations.Test;
import scripts.Base;
import utilities.Waiter;

public class _07B_Parallel extends Base {

    @Test(priority = 1)
    public void testB1(){
        Waiter.pause(10);
        System.out.println("This is testB1");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 2)
    public void testB2(){
        Waiter.pause(15);
        System.out.println("This is testB2");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 3)
    public void testB3(){
        Waiter.pause(20);
        System.out.println("This is testB3");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

}
