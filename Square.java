
class Square extends Rectangle implements Symmetric {
	private Point topLeft;
	private double s;
	
	public Square(Point topLeftPoint, double side) {
		super(topLeftPoint, side,side);
		topLeft = topLeftPoint;
		s= side;
	}
	public double getSide() {
		return s;
	}
	@Override
	public Point getPointOfSymmetry() {
		double x= (topLeft.getX()+ (s/2));
		double y = (topLeft.getY()-(s/2));
		Point symmetry = new Point(x, y);
		return symmetry;
	}

}
