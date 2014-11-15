package testyield;

public class TestYield {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Productor productor = new Productor();
		Thread consumidor = new Consumidor();

		productor.start();
		consumidor.start();
	}

}

class Productor extends Thread {
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("Ping ");
			Thread.yield(); //pasa el control a otro hilo
		}
	}
}

class Consumidor extends Thread {

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("Pong ");
			Thread.yield();
		}
	}

}
