package semaphore�ź���ʵ�ֵ�ͬ���㷨;

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
				sem.acquire();// ��������൱����P������

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// in critical section

			System.out.println("��ǰ�ǵ�" + currentThreadId + "��thread��ִ��,���ڵ�countΪ��" + count++);
			sem.release();// ��������൱����V����

			// out of critical section
		}
	}

}
