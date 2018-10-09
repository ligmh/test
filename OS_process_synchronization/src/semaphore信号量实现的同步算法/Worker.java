package semaphore信号量实现的同步算法;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {

	private Semaphore sem;

	private int currentThreadId;

	private static int count = 0;

	public Worker(Semaphore s, int thread_id) {
		sem = s;
		currentThreadId = thread_id;
	}

	public void run() {
		while (true) {
			try {
				sem.acquire();// 这个函数相当于是P操作吧

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// in critical section

			System.out.println("当前是第" + currentThreadId + "个thread在执行,现在的count为：" + count++);
			sem.release();// 这个函数相当于是V操作

			// out of critical section
		}
	}

}
