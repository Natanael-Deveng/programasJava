package entities;

public class Product {
	public String productName;
	public double productPrice;
	public int productQty;
	
	public double totalValor() {
		double total = productPrice * productQty;
		return total;
	}
	
	public void addQty(int addQty) {
		productQty += addQty;
	}
	
	public void rmvQty(int rmvQty) {
		productQty -= rmvQty;
	}
	
	public String toString() {
		return  "Product data: "
				+ productName
				+ " | $"
				+ productPrice
				+ " | "
				+ productQty
				+ " | Total: "
				+ totalValor();
	}

}
