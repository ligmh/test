package 生产者消费者问题;

public class AlgorithmTest {
	public static void main(String args[]) {
		BoundedBuffer bf = new BoundedBuffer();

		Producer pd = new Producer(bf, 10000);
		Comsumer cs = new Comsumer(bf, 10000);

		pd.start();
		cs.start();
	}

}
