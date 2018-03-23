/**
 * ���ֵ���ģʽ�У�
 * 			һ�㲻����ʹ������ʽ������ʹ�ö���ʽ����ȷҪ��̬���أ�Lazy loading��ʱʹ�õǼ�
 * 			�Ǽ�ʽ�ڲ���̬�ࣻ����漰�����л���������ö�ٵ���ģʽ�������������Ҫ���ʹ��˫��������ģʽ
 */

package SingletonPattern;

public class DemoSingleton {

	public static void main(String[] args) {
		//����ʹ��SingleObject�Ĺ��캯��
		SingleObject object=SingleObject.getInstance();
		object.showMessage();
		//�̰߳�ȫ������ʽ����ģʽ
		SingletonIdler1 idler=SingletonIdler1.getInstance();
		idler.showMessage();
		//������ȫ����ģʽ
		UnidlerSingleton1_2 unidler=UnidlerSingleton1_2.getInstance();
		unidler.showMessage();
		//�Ǽ�ʽ/��̬�ڲ���
		LoginSingleton1_3 login=LoginSingleton1_3.getInstance();
		login.showMessage();
		//ö��ʵ��������ģʽ
		EnumSingleton1_1 sEnum=EnumSingleton1_1.INSTANCE;
		sEnum.showMessage();
		//˫����/˫��У����
		DCLSinglecton1_4 instance=DCLSinglecton1_4.getInstance();
		instance.showMessage();
	}

}
