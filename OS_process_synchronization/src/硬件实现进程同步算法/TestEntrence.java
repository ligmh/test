package 硬件实现进程同步算法;

public class TestEntrence {
	public static void main(String[] args) {
		HardwareData lock = new HardwareData(false);

		int count = 0;
		while (count <= 1) {
			while (HardwareSolution.testAndSet(lock))
				Thread.yield(); // do nothing

			// now in critical section code
			System.out.println("这个是test-and-set方法：" + count++);
			lock.set(false);

			// out of critical section
		}

		HardwareData key = new HardwareData(true);

		while (count <= 10) {
			key.set(true);
			do {
				HardwareSolution.swap(lock, key);
			} while (key.get() == true);
			// now in critical section code
			System.out.println("这个是swap方法：" + count++);
			lock.set(false);
			// out of critical section
		}

	}
}
