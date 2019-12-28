package Dec24;

public class DemoStatic {

	static int a,b,c;
	static double x,y,z;
	
	public static void mul()
	{
		a=10;
		b=20;
		c=a*b;
		System.out.println(c);
	}
	public static void div()
	{
		x=10.5;
		y=5.2;
		z=x*y;
		System.out.println(z);
	}
	public static void main(String[] args) {
		DemoStatic.mul();
		DemoStatic.div();
	}

}
