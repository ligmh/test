package 读者写者问题;

public class Writer extends Thread {
	private Database server;
	private int who;

	public Writer(Database db, int who) {
		server = db;
		this.who = who;
	}

	public void run() {
		while (true) {
			try {
				server.startWrite();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(who + " Writing starts!");
			System.out.println(who + " Writing ends!");
			// now writing the database
			server.endWrite();
		}
	}

}
