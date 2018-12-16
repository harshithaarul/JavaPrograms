
class Point {
	private double dx;
	private double dy;
	
	public Point (double x, double y) {
		dx = x;
		dy = y;
	}
	public double getX() {
		return dx;
	}
	public double getY() {
		return dy;
	}

	public double getDistance(Point point) {
		double distance = 0;
		double xTot = Math.pow((point.getX()-this.getX()), 2);
		double yTot = Math.pow((point.getY()-this.getY()), 2);
		distance = Math.sqrt(xTot+yTot);
		return distance;
	}
}
