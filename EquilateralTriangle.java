
class EquilateralTriangle extends Triangle implements Symmetric {
	private Point top;
	private double s;

	
	public EquilateralTriangle(Point topPoint, double side) {//figure out formula again
		super(topPoint,new Point((topPoint.getX()- (side/2)),topPoint.getY()- (((Math.sqrt(3))/2)*side)),new Point(topPoint.getX()+ (side/2),topPoint.getY()- (((Math.sqrt(3))/2)*side) )); //since we are defining the other methods after calling the super, wouldn't it return null
		top = topPoint;
		s = side;
	}
	public Point getTopPoint() {
		return top;
	}
	public double getSide() {
		return s;
	}

	@Override
	public Point getPointOfSymmetry() {
		double x = top.getX();
		double y = ((3*top.getY()-((Math.sqrt(3)))*s))/3;
		Point middle = new Point (x, y);
		return middle;
	}
}
