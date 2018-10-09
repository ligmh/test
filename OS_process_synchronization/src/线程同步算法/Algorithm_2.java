package 线程同步算法;

public class Algorithm_2 extends MutualExclusion {
	private volatile boolean[] flag = new boolean[2];

	private int count = 0;

	public Algorithm_2() {
		flag[0] = false;
		flag[1] = false;
	}

	public void enteringCriticalSection(int t) {
		if (t == 1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int other = 1 - t;
		flag[t] = true;
		while (flag[other] == true)
			Thread.yield();
	}

	public void leavingCriticalSection(int t) {
		flag[t] = false;
	}

	public void criticalSection(int t) {
		// simulate the critical section
		System.out.println(t + "," + count++);
	}

	public void nonCriticalSection(int t) {
		// simulate the non-critical section
	}

}
