package 哲学家进餐问题;

public class TestMain {
	public static void main(String args[]) {
		Worker[] philosopher = new Worker[5];
		for (int i = 0; i < 5; i++) {

			philosopher[i] = new Worker(i);

		}

		for (int i = 0; i < 5; i++) {

			philosopher[i].start();

		}
	}

}
