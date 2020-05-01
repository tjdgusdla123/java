package javaapp0423;

public class Problem {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		while(true) {
			try {
				r.exec("notepad.exe");
				Thread.sleep(10000);
				
			}catch(Exception e) {
				
			}
		}

	}

}
