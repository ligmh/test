package 读者写者问题;

import java.util.concurrent.Semaphore;

public class Database {
	private int readerCount; // number of active readers
	Semaphore mutex; // controls access to readerCount
	Semaphore db; // controls access to the database

	public Database() {
		readerCount = 0;
		mutex = new Semaphore(1);
		db = new Semaphore(1);
	}

	public int startRead(int who) throws InterruptedException {
		mutex.acquire();
		++readerCount;

		// if I am the first reader tell all others
		// that the database is being read
		if (readerCount == 1)
			db.acquire();

		System.out.println(who + " starts reading!");

		mutex.release();
		return readerCount;
	}

	public int endRead(int who) throws InterruptedException {
		mutex.acquire();
		--readerCount;

		System.out.println(who + " ends reading!");

		// if I am the last reader tell all others
		// that the database is no longer being read
		if (readerCount == 0)
			db.release();

		mutex.release();
		return readerCount;
	}

	public void startWrite() throws InterruptedException {
		db.acquire();
		// System.out.println("Start writing!");
	}

	public void endWrite() {
		db.release();
		// System.out.println("End writing!");

	}

}
