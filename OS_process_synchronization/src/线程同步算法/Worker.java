package 线程同步算法;

public class Worker extends Thread {
	private String name;
	private int id;
	private MutualExclusionAlgorithm shared;

	public Worker(String n, int i, MutualExclusionAlgorithm s) {
		name = n;
		id = i;
		shared = s;
	}

	public void run() {
		while (true) {
			shared.enteringCriticalSection(id);
			// in critical section code

			shared.criticalSection(id);

			shared.leavingCriticalSection(id);
			// out of critical section code

		}
	}
}
