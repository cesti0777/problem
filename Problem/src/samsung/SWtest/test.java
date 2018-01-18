package samsung.SWtest;

public class test {

	public static void main(String[] args) {
		String txt1 = "가나다라" ;
		String txt2 = "테스sdf트" ;
		String txt3 = "가격은 29,000원 입니다" ;

		// contains를 이용한 방법(true, false 반환)
		if(txt1.contains("나다"))
		    System.out.println("문자열 있음!");
		else
		    System.out.println("문자열 없음!");
		         
		         
		// matches를 이용한 방법
		if(txt2.matches("테스.*.트"))
		    System.out.println("문자열 있음!");
		else
		    System.out.println("문자열 없음!");
	}
}
