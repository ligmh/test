package 线程同步算法;

public abstract class MutualExclusion {

	public void criticalSection(int t) {
		// simulate the critical section
	}

	public void nonCriticalSection(int t) {
		// simulate the non-critical section
	}

	public abstract void enteringCriticalSection(int t);

	public abstract void leavingCriticalSection(int t);

	public static final int TURN_0 = 0;
	public static final int TURN_1 = 1;

}
