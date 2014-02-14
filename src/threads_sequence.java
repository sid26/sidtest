import java.util.*;
import java.util.concurrent.*;

class th implements Runnable
  {
   private int l[]={1,0,0},i=0,c=0;
   public void run()
     {
	  i=ThreadLocalVariableHolder.get();
	  System.out.println("sdfsfsdfs  "+i);
	  while(!Thread.currentThread().isInterrupted()) 
       {
		//Scanner in = new Scanner(System.in);
	    //int num = in.nextInt();
	    if(l[i]==1)
         {
      	  l[i]=0;
      	  c++;
          System.out.print(" numbers  "+c);
          System.out.println("   thread  "+i);
          //ThreadLocalVariableHolder.increment();
          i++;
          // System.out.println(" after numbers  "+i);
	      if(i==3)
	       i=0;
	      l[i]=1;
	     }
	   }
     }
  }

class ThreadLocalVariableHolder 
  {
   private static int a=0;
   private static ThreadLocal<Integer> value =
	    new ThreadLocal<Integer>() 
	     {
	      //private Random rand = new Random(47);
	      protected synchronized Integer initialValue() 
	       {
	        return a++;
	       }
	     };
   public static void increment() 
     {
	  value.set(value.get() + 1);
	 }
   public static int get() 
     {
	  return value.get();
	 }
  }
	  
public class threads_sequence 
  {
   public static void main(String[] args) throws Exception 
     {
	   ExecutorService exec = Executors.newCachedThreadPool();
	   for(int i = 0; i < 3; i++)
	    exec.execute(new th());
	   TimeUnit.SECONDS.sleep(1);  // Run for a while
	   exec.shutdownNow(); 
     }
  }
