import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Main {

	public static void main(String[] args) {
		//teste
		Product productA;
		productA = new Product();
		Locale.setDefault(Locale.US);
		
		System.out.println("Enter product data:");
		System.out.println("Name:");
		Scanner sc = new Scanner(System.in);
		productA.productName = sc.next();
		System.out.println("Price:");
		productA.productPrice = sc.nextDouble();
		System.out.println("Quantity in stock:");
		productA.productQty = sc.nextInt();
		
		
		System.out.println("Product data: " + productA.productName + " | $" + productA.productPrice + " | " + productA.productQty + " | " + "Total: " + productA.totalValor());
		
		System.out.println("Enter the number of product to be added to stock: ");
		int add = sc.nextInt();
		productA.addQty(add);
		
		System.out.println("Product data: " + productA.productName + " | $" + productA.productPrice + " | " + productA.productQty + " | " + "Total: " + productA.totalValor());
		
		System.out.println("Enter the number of product to be removed to stock: ");
		int rmv = sc.nextInt();
		productA.rmvQty(rmv);
		
		sc.close();
		
		System.out.println(productA.toString());
		
	}

}
