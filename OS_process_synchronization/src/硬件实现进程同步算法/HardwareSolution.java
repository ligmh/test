package Ӳ��ʵ�ֽ���ͬ���㷨;

public class HardwareSolution {
	// ������testandsetʵ�ֵķ���
	public static boolean testAndSet(HardwareData target) {
		HardwareData temp = new HardwareData(target.get());

		target.set(true);

		return temp.get();
	}

	// ������swap��ʽʵ�ֵ�ģ��
	public static void swap(HardwareData a, HardwareData b) {
		HardwareData temp = new HardwareData(a.get());
		a.set(b.get());
		b.set(temp.get());
	}

}