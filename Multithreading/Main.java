class Main implements Runnable {
	private Thread t;
	private String threadName;
	private int z = 0;

	Main( String name) {
		threadName = name;
	}

	public void run() {
		try {
			for(int i = 4; i > 0; i--) {
				// Let the thread sleep for a while.
				Thread.sleep(50);
				if (threadName.equals("a")) {
					z++;
					System.out.println(z);
				} else if (threadName.equals("b")) {
					z += 10;
					System.out.println(z);
				}
			}
		} catch (InterruptedException e) {
		}
	}

	public void start () {
		if (t == null) {
			t = new Thread (this, threadName);
			t.start ();
		}
	}
}

