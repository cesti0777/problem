package samsung.SWtest;

public class test {

	public static void main(String[] args) {
		String txt1 = "�����ٶ�" ;
		String txt2 = "�׽�sdfƮ" ;
		String txt3 = "������ 29,000�� �Դϴ�" ;

		// contains�� �̿��� ���(true, false ��ȯ)
		if(txt1.contains("����"))
		    System.out.println("���ڿ� ����!");
		else
		    System.out.println("���ڿ� ����!");
		         
		         
		// matches�� �̿��� ���
		if(txt2.matches("�׽�.*.Ʈ"))
		    System.out.println("���ڿ� ����!");
		else
		    System.out.println("���ڿ� ����!");
	}
}
