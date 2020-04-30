package test0430;

public class TestStar {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i = i + 1) {
			if (i < 3) {
				for (int j = 0; j < i; j = j + 1) {
					System.out.print(" ");
				}
				for (int j = 0; j < 3 - i; j = j + 1) {
					System.out.print("*");
				}

			} else {
				for (int j = 0; j < 4 - i; j = j + 1) {
					System.out.print(" ");
				}
				for(int j =0; j<i-1;j=j+1) {
					System.out.print("*");
					
				}
			}
              System.out.print("\n");
		}

	}
}
