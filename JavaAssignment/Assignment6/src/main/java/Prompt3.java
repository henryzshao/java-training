
public class Prompt3 {
	public static void execute() {
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 3: Write a program for synchronization example\n");
		
		Timer timer = new Timer(29);
		System.out.println("New Timer: 30");
		
		CountThread thread1 = new CountThread("Countdown Thread 1", timer);
		CountThread thread2 = new CountThread("Countdown Thread 2", timer);
		CountThread thread3 = new CountThread("Countdown Thread 3", timer);
		
		thread1.start();
		thread2.start();
		thread3.start();

	}
}

class CountThread implements Runnable{
	private Thread thread;
	private Timer timer;
	private String name;
	
	public CountThread(String name, Timer timer) {
		this.name = name;
		this.timer = timer;
	}
	
	public void run() {
		synchronized(timer) {
			timer.countdownBy10(); //synchronized
		}
		//timer.countdown(); //unsynchronized
		System.out.printf("%s is exiting\n", name);
		
	}
	
	public void start () {
	      System.out.println("Starting " +  name );
	      if (thread == null) {
	    	 thread = new Thread (this, name);
	    	 thread.start ();
	      }
	   }	
}


class Timer {
	private int time;
	
	public Timer(int time) {
		this.time = time;
	}
	
	public void countdownBy10() {
		int i = 10;
		while(time > 0 && i > 0) {
			System.out.printf("Remaining time: %d by %s\n", --time, Thread.currentThread().getName());
			i--;
		}
	}
}