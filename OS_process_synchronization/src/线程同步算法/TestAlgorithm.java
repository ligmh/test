package �߳�ͬ���㷨;

public class TestAlgorithm {
	public static void main(String args[]) {

		MutualExclusionAlgorithm alg = new Algorithm_1();

		Worker first = new Worker("Runner 0", 0, alg);
		Worker second = new Worker("Runner 1", 1, alg);

		first.start();
		second.start();
	}
}
