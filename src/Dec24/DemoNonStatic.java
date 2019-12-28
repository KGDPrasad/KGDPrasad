package Dec24;

public class DemoNonStatic {

	int a,b,c;
	double x,y,z;

	public void add()
	{
		a=200;
		b=25;
		c=a+b;
		System.out.println(c);
	}
	public void floating()
	{
		x=50;
		y=4;
		z=x*y;
		System.out.println(z);
	}
	public static void main()
	{
		DemoNonStatic d=new DemoNonStatic();
		d.add();
		d.floating();
	}
}
