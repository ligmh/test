package 硬件实现进程同步算法;

public class HardwareSolution {
	// 下面是testandset实现的方法
	public static boolean testAndSet(HardwareData target) {
		HardwareData temp = new HardwareData(target.get());

		target.set(true);

		return temp.get();
	}

	// 下面是swap方式实现的模拟
	public static void swap(HardwareData a, HardwareData b) {
		HardwareData temp = new HardwareData(a.get());
		a.set(b.get());
		b.set(temp.get());
	}

}