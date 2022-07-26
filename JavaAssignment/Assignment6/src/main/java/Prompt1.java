
public class Prompt1{

	public static void execute() {
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 1: Write a program for printing 1 to 50 from a thread\n");
		PrinterThread runThread = new PrinterThread();
		Thread thread = new Thread(runThread);
		thread.start();
		while(thread.isAlive()) {}
		System.out.println();
	}

}

class PrinterThread implements Runnable{
	public void run() {
		for(int i = 1; i <= 50; i++) {
			if((i-1)%10==0) {
				System.out.printf("\n%d ", i);
			}
			else {
				System.out.printf("%d ", i);
			}
		}
	}
}