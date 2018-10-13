package 哲学家进餐问题;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {
	private static Semaphore[] chopStick = new Semaphore[5];
	private int i;

	private static int countEating = 0;
	private static int countThinking = 0;

	public Worker(int who) {
		i = who;
		for (int j = 0; j < 5; j++) {
			chopStick[j] = new Semaphore(1);
		}
	}

	public void run() {
		while (true) {

			if ((i % 2) == 1) {
				try {
					chopStick[i].acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					chopStick[(i + 1) % 5].acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// eat for a while
				System.out.println(i + " is eating!");

				chopStick[i].release();
				chopStick[(i + 1) % 5].release();

				// think for a while
				System.out.println(i + " is thinking!");

			} else {
				try {
					chopStick[(i + 1) % 5].acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					chopStick[i].acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// eat for a while
				System.out.println(i + " is eating!");

				chopStick[i].release();
				chopStick[(i + 1) % 5].release();

				// think for a while
				System.out.println(i + " is thinking!");

			}

		}
	}

}
