package entities;

public class Triangle {
	public double a;
	public double b;
	public double c;
	
	public double areaTriangulo () {
		double p = (a + b + c)/2;
		double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return area;
	}

}
