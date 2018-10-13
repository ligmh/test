package 读者写者问题;

public class Reader extends Thread {
	private Database server;
	private int who;

	public Reader(Database db, int who) {
		server = db;
		this.who = who;
	}

	public void run() {
		int c;
		while (true) {
			try {
				c = server.startRead(who);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// now reading the database

			try {
				c = server.endRead(who);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
