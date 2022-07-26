
public class Prompt2 {
	public static void execute() {
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 2: Write a program to create two threads (unsynched)\n");
		EvenPrinterThread evenThread = new EvenPrinterThread();
		OddPrinterThread oddThread = new OddPrinterThread();
		Thread thread2 = new Thread(evenThread);
		Thread thread1 = new Thread(oddThread);
		thread1.start();
		thread2.start();
		while(thread1.isAlive() || thread2.isAlive()) {}
		System.out.println();
	}
}

class EvenPrinterThread implements Runnable{
	public void run() {
		for(int i = 1; i <= 50; i++) {
			if(i%2==0) {
				System.out.printf("E: %d\n", i);
			}
		}
	}
}
class OddPrinterThread implements Runnable{
	public void run() {
		for(int i = 1; i <= 50; i++) {
			if(i%2==1) {
				System.out.printf("O: %d\n", i);
			}
		}
	}
}