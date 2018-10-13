package 生产者消费者问题;

public class Comsumer extends Thread {
	private BoundedBuffer bf = new BoundedBuffer();
	private int count = 0;
	private Object merchandise;
	private int comsumeAmount;

	public Comsumer(BoundedBuffer theBf, int amount) {
		bf = theBf;
		comsumeAmount = amount;

	}

	public void run() {
		while (count < comsumeAmount) {
			try {
				merchandise = bf.remove();
				count++;
//				System.out.println("当前拿出来的商品为第" + count + "件商品:" + merchandise);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
