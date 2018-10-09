package 线程同步算法;

public class Algorithm_3 extends MutualExclusionAlgorithm {

	public static int count = 0;

	private volatile int turn;
	private volatile boolean[] flag = new boolean[2];

	public Algorithm_3() {
		flag[0] = false;
		flag[1] = false;
		turn = TURN_0;
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
		turn = other;

		while ((flag[other] == true) && (turn == other))
			Thread.yield();
	}

	public void leavingCriticalSection(int t) {

		flag[t] = false;
	}

	public void criticalSection(int t) {
		// simulate the critical section
		System.out.println(t + "," + count++);
	}

}
