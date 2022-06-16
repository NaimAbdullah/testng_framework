package testng_learning;

import org.testng.annotations.Test;
import scripts.Base;
import utilities.Waiter;

public class _07A_Parallel extends Base {

    @Test(priority = 1)
    public void testA1(){
        Waiter.pause(10);
        System.out.println("This is testA1");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 2)
    public void testA2(){
        Waiter.pause(15);
        System.out.println("This is testA2");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 3)
    public void testA3(){
        Waiter.pause(20);
        System.out.println("This is testA3");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

}
