
class Circle extends Shape implements Symmetric{
	private Point middle;
	private double r;
	
	public Circle(Point center, double radius) {
		middle = center;
		r = radius;
	}
	public Point getCenter() {
		return middle;
	}
	public double getRadius() {
		return r;
	}
	
	public double getArea() {
		double area = Math.PI*Math.pow(r, 2);
		return area;
	}

	
	public double getPerimeter() {
		double perimeter = Math.PI*r*2;
		return perimeter;
	}
	@Override
	public Point getPointOfSymmetry() {
		return middle;
	}


}
