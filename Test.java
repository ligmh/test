package 研究线程并发的项目;

public class Test {
	//随便弄一下
	public int inc = 0;
	int x;
	x=1;

	public void increase() {
		inc++;
	}

	public static void main(String[] args) {
		final Test test = new Test();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 1000; j++)
						test.increase();
				};
			}.start();
		}

		while (Thread.activeCount() > 1) // 保证前面的线程都执行完
			Thread.yield();
		System.out.println(test.inc);
	}
}
