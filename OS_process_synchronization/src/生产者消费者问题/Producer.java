package ����������������;

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
				// ����Ĵ��벻����������дŶ��Ҳ���ǲ����������ӡ�ó��������ǷŽ�ȥ�Ķ�����ʲô����Ϊ���ﲻ�Ǵ�ӡ�����Ķ������߰���ģ���Ϊ���������߳��ǿ��Բ����Ĵ�ӡ�ģ������Ϊʲô�������߰����ԭ����
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
