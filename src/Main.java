import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String code;
   Scanner scanner =new Scanner(System.in);
   
   System.out.print("entrer ton code");
   code=scanner.nextLine();
   if(!code.matches("^CPT-\\d{5}$")) 
	   throw new IllegalArgumentException("code compte invalide");
   System.out.printf("votre code est %S",code);
	}

}
