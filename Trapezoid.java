
class Trapezoid extends Shape{
	private Point topLeft;
	private Point bottomLeft;
	private double top;
	private double bottom;
	
	public Trapezoid(Point topLeftPoint, Point bottomLeftPoint, double topSide, double bottomSide) {
		topLeft = topLeftPoint;
		bottomLeft = bottomLeftPoint;
		top = topSide;
		bottom = bottomSide;
	}
	public Point getTopLeftPoint() {
		return topLeft;
	}
	public Point getBottomLeftPoint() {
		return bottomLeft;
	}
	public double getTopSide() {
		return top;
	}
	public double getBottomSide() {
		return bottom;
	}

	public double getArea() {
		double trapArea = 0.5*(top+bottom)*(Math.abs(topLeft.getY()-bottomLeft.getY())); 
		return trapArea;
	}

	public double getPerimeter() {
		double bottomRightX = bottomLeft.getX()+ bottom;
		double bottomRightY = bottomLeft.getY();
		double topRightX = topLeft.getX()+ top;
		double topRightY = topLeft.getY();
		double distance = 0;
		double xTot = Math.pow(topRightX-bottomRightX, 2);
		double yTot = Math.pow(topRightY - bottomRightY, 2);
		distance = Math.sqrt(xTot+yTot);
		double trapPerimeter = bottom + top + (topLeft.getDistance(bottomLeft)) +(distance);
		return trapPerimeter;
	}
}
