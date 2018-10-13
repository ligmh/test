package 生产者消费者问题;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {
	private static final int BUFFER_SIZE = 2;
	private Semaphore mutex;
	private Semaphore empty;
	private Semaphore full;
	private int in, out;
	private Object[] buffer;

	public BoundedBuffer() {
		// buffer is initially empty
		in = 0;
		out = 0;
		buffer = new Object[BUFFER_SIZE];
		mutex = new Semaphore(1);
		empty = new Semaphore(BUFFER_SIZE);
		full = new Semaphore(0);
	}

	public void enter(Object item) throws InterruptedException {
		empty.acquire();
		mutex.acquire();

		// add an item to the buffer
		buffer[in] = item;
		in = (in + 1) % BUFFER_SIZE;
		System.out.println("The " + item + " has just been put into the library!");

		mutex.release();
		full.release();
	}

	public Object remove() throws InterruptedException {
		full.acquire();
		mutex.acquire();

		// remove an item from the buffer
		Object item = buffer[out];
		out = (out + 1) % BUFFER_SIZE;
		System.out.println("The " + item + " has just been fectched out!");

		mutex.release();
		empty.release();

		return item;
	}

}
