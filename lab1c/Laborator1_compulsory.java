package lab1c;

public class Laborator1_compulsory {
	
	  public static void main(String args[]) {
		  System.out.println("hello world");
		  String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "Javascript", "PHP", "Swift", "Java"};
	  int n = (int) (Math.random() * 1_000_000);
	  int n1 = (n*3 + Integer.parseInt("10101",2) + Integer.parseInt("FF",16))*6;  
	    
	  int n2=0,n3=0;
	  while(n1!=0) {
		  n2 = n2 + n1%10;
		  n1=n1/10;
	  }
	  while(n2%100 != 0) {
		  n3 = n3 + n2%10;
		  n2=n2/10;
	  }
	  System.out.println("Willy-nilly, this semester I will learn " + languages[n3] );
	  }

	}

