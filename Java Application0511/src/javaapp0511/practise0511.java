package javaapp0511;

public class practise0511 {

	public static void main(String[] args) {
		int mathscor =90;
		int engscor= 70;
		int korscor= 100;
		int totalscor= korscor+engscor+mathscor;
		System.out.println(totalscor);
		double avgscor = totalscor/3.0;
		System.out.println(avgscor);
		
		int gamescor = 150;
		int lastscor1 = gamescor++;
	
		System.out.println(lastscor1);

		
		int lastscor2 = gamescor--;
		System.out.println(lastscor2);
		
		int number =5;
		int  i = 10;
		boolean value =((number=number*10)>45)||((i=i-5)<10);
		System.out.println(value);
		System.out.println(number);
		System.out.println(i);
		
		int fatherage =50;
		int maotherage =51;
		char ch;
		ch =(fatherage>maotherage)? 'T':'F';
		System.out.println(ch);
		
		int num2 =10;
		boolean isEVen;
		isEVen =(num2 %2)==0?true:false;
		System.out.println(isEVen);
		
	
			
			
		}
		
	}


