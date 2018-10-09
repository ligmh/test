package 线程同步算法;

public class Algorithm_1 extends MutualExclusionAlgorithm {

	private volatile int turn;

	private int count = 0;

	public Algorithm_1() {
		turn = TURN_0;
	}

	public void enteringCriticalSection(int t) {
		while (turn != t)
			Thread.yield();
	}

	public void leavingCriticalSection(int t) {
		turn = 1 - t;
	}

	public void criticalSection(int t) {
		// simulate the critical section
		System.out.println(t + "," + count++);
	}

	public void nonCriticalSection(int t) {
		// simulate the non-critical section
	}

}
