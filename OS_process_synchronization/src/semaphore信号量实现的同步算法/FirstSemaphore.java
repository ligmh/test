package semaphore信号量实现的同步算法;

import java.util.concurrent.Semaphore;

public class FirstSemaphore {


	public static void main(String args[]) {

		Semaphore sem = new Semaphore(1);
		Worker[] bees = new Worker[5];

		for (int i = 0; i < 5; i++)
			bees[i] = new Worker(sem, i);

		for (int i = 0; i < 5; i++)
			bees[i].start();
	}
}
