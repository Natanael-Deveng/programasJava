import java.util.Locale;
import java.util.Scanner;
import entities.Retangulo;

public class application {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Retangulo retanguloA;
		retanguloA = new Retangulo();		
		
		System.out.print("Enter rectangle width: ");
		Scanner sc = new Scanner(System.in);
		retanguloA.width = sc.nextDouble();
		System.out.print("Enter rectangle height: ");
		retanguloA.height = sc.nextDouble();
		
		sc.close();

		System.out.print(retanguloA);		
	}

}
