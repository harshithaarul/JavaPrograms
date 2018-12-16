
class Rectangle extends Shape{
	private Point LeftPoint;
	private double dLength;
	private double dWidth;

	public Rectangle(Point topLeftPoint, double length, double width) {
		LeftPoint = topLeftPoint;
		dLength = length;
		dWidth = width;
	}
	public Point getTopLeftPoint() {
		return LeftPoint;	
	}
	public double getLength() {
		return dLength;
	}
//	public void setLength (double length) {
//		dLength = length;
//	}
	public double getWidth() {
		return dWidth;
	}

	public double getArea() {
		double rArea = dLength*dWidth;
		return rArea;
	}

	public double getPerimeter() {
		double rPerimeter = (2*dLength) +(2*dWidth);
		return rPerimeter;
	}
}
