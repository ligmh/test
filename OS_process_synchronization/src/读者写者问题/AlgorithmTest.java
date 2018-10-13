package 读者写者问题;

public class AlgorithmTest {
	public static void main(String args[]) {
		Database db = new Database();
		int WriterNumber = 2;
		int ReaderNumver = 5;
		Reader[] rd = new Reader[ReaderNumver];
		Writer[] wt = new Writer[WriterNumber];

		for (int i = 0; i < ReaderNumver; i++) {
			rd[i] = new Reader(db, i);
		}
		for (int i = 0; i < WriterNumber; i++) {
			wt[i] = new Writer(db, i);
		}

		for (int i = 0; i < ReaderNumver; i++) {
			rd[i].start();
		}
		for (int i = 0; i < WriterNumber; i++) {
			wt[i].start();
		}
	}
}
