package 硬件实现进程同步算法;

public class HardwareData {
	public HardwareData(boolean v) {
		data = v;
	}

	public boolean get() {
		return data;
	}

	public void set(boolean v) {
		data = v;
	}

	private boolean data;
}
