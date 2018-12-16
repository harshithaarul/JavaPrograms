
class Triangle extends Shape{
	private Point first;
	private Point second;
	private Point third;

	public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
		first = firstPoint;
		second = secondPoint;
		third = thirdPoint;
	}
	public Point getFirstPoint(){
		return first;
	}
	public Point getSecondPoint(){
		return second;
	}
	public Point getThirdPoint(){
		return third;
	}

	public double getArea() {
		double tArea; 
		double a = first.getDistance(getSecondPoint());
		double b = second.getDistance(getThirdPoint());
		double c = third.getDistance(getFirstPoint());
		double s = 0.5*(a+b+c);
		double underSqrt = (s*(s-a)*(s-b)*(s-c));
		tArea = Math.sqrt(underSqrt);
		return tArea;
	}


	public double getPerimeter() {
		double tPerimeter;
		double a = first.getDistance(getSecondPoint());
		double b = second.getDistance(getThirdPoint());
		double c = third.getDistance(getFirstPoint());
		tPerimeter = a+b+c;
		return tPerimeter;
	}

}
