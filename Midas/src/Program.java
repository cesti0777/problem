import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result;
		String first = sc.nextLine();
		int count = Integer.parseInt(first.split(" ")[0]);
		int distance = Integer.parseInt(first.split(" ")[1]);
		int[] array = new int[count];
		for (int i = 0; i < count; i++) {
			array[i] = Integer.parseInt(sc.nextLine());
		}
		double temp = (double) (count - 1) / (distance - 1);
		int temp2 = (int) Math.floor(temp);
		result = array[temp2] - array[0];
		System.out.println(result);
	}

}
