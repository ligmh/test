package 线程同步算法;

public class TestAlgorithm {
	public static void main(String args[]) {

		MutualExclusion alg = new Algorithm_3();

		Worker first = new Worker("Runner 0", 0, alg);
		Worker second = new Worker("Runner 1", 1, alg);

		first.start();
		second.start();
	}
}
