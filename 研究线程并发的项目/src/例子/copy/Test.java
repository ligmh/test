package 例子.copy;

public class Test {
	private static int inc = 0;

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 1000; j++)
						inc = inc + 1;
				};
			}.start();
		}

		while (Thread.activeCount() > 1) // 保证前面的线程都执行完
			Thread.yield();
		System.out.println(inc);
	}
}
