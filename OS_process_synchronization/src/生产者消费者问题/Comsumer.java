package ����������������;

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
//				System.out.println("��ǰ�ó�������ƷΪ��" + count + "����Ʒ:" + merchandise);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
