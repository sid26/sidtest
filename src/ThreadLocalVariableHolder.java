/*import java.util.concurrent.*;
import java.util.*;
import java.io.*;
class Accessor implements Runnable 
  {
   private final int id;
  
   public Accessor(int idn) 
     { 
      id = idn; 
	 }
  
   public void run() 
     {
      while(!Thread.currentThread().isInterrupted()) 
       {
        System.out.println("before increment ");
        ThreadLocalVariableHolder.increment();
        System.out.println("after increment ");
        System.out.println(this);
        Thread.yield();
       }
     }
  
   public String toString() 
     {
	  return "#" + id + ": " +
      ThreadLocalVariableHolder.get();
     }
  }

public class ThreadLocalVariableHolder 
  {
   private static ThreadLocal<Integer> value = 
		   new ThreadLocal<Integer>() 
		    {
             private Random rand = new Random(47);
             protected synchronized Integer initialValue() 
               {
    	        System.out.println("inside thread local variable holder");
    	        Scanner in = new Scanner(System.in);
    	        int num = in.nextInt();
                return rand.nextInt(10000);
               }
            };
 
   public static void increment() 
     {
	  System.out.println("increment "+value.get());  
      value.set(value.get() + 1);
     }
  
   public static int get() 
     {
	  return value.get();
	 } 
  
   public static void main(String[] args) throws Exception 
     {
      ExecutorService exec = Executors.newCachedThreadPool();
      for(int i = 0; i < 5; i++)
       exec.execute(new Accessor(i));
      TimeUnit.SECONDS.sleep(3);  // Run for a while
      exec.shutdownNow();         // All Accessors will quit
     }
  }*/