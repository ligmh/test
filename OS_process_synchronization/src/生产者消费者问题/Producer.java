package 生产者消费者问题;

public class Producer extends Thread {

	private BoundedBuffer bf = new BoundedBuffer();
	private int count = 0;
	private int i = 0;
	private int produceAmount;

	public Producer(BoundedBuffer TheBf, int amount) {
		bf = TheBf;
		produceAmount = amount;
	}

	public void run() {
		while (count < produceAmount) {
			try {
				bf.enter(i);
				count++;
				// System.out.println("The " + count + "th merchandise " + i + " have just been
				// put into the library!");
				// 上面的代码不可以再这里写哦，也就是不能在这里打印拿出来或者是放进去的东西是什么，因为这里不是打印出来的东西乱七八糟的，因为这里两个线程是可以并发的打印的，这就是为什么它会乱七八糟的原因了
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
