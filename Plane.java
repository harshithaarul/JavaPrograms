class Plane {
	private Shape[] s;
	private Shape[] temp;
	private int count;
	private Point p;
	
	public Plane() {
		s = new Shape[count];
		temp = new Shape[100];
		
	}
	public Shape[] getShape() {
		s = temp;
		return s;

	}
	public void addShape(Shape shape) {
		temp[count] = shape;
		count++;
	}
	public double getSumOfAreas() {
		double sum = 0;
		for (int i = 0; i <count; i++) {
			sum+=temp[i].getArea();
		}
		return sum;

	}
	public double getSumOfPerimeters() {
		double sum = 0;
		for (int i = 0; i <count; i++) {
			sum+=temp[i].getPerimeter();
		}
		return sum;

	}
	public Point getCenterOfPointOfSymmetries() {	
		double x = 0;
//		double xcount = 0;
//		double ycount = 0;
		int counter = 0;
		double y = 0;
		boolean isNull = false;
		if (count == 0) {
			isNull = true;
			return null;
		}
		for (int i = 0; i < count; i++) {
			if (temp[i] instanceof Symmetric) {
				x+= ((Symmetric) temp[i]).getPointOfSymmetry().getX();
				y+=((Symmetric) temp[i]).getPointOfSymmetry().getY();
				counter++;
//				if (temp[i] instanceof Circle) {
//					Circle circ = (Circle) temp[i];
//					p = circ.getPointOfSymmetry();
//					x+=p.getX();
//					xcount++;
//					y+=p.getY();
//					ycount++;
//				}else if(temp[i] instanceof Square) {
//					Square sqr = (Square) temp[i];
//					p = sqr.getPointOfSymmetry();
//					x+=p.getX();
//					xcount++;
//					y+=p.getY();
//					ycount++;
//				}else if (temp[i] instanceof EquilateralTriangle) {
//					EquilateralTriangle trngl = (EquilateralTriangle) temp[i];
//					p = trngl.getPointOfSymmetry();
//					x+=p.getX();
//					xcount++;
//					y+=p.getY();
//					ycount++;
//				}
			}else if (!(temp[i] instanceof Symmetric) && i == count-1){
				isNull = true;
			} 
		}
		p = new Point(x/counter, y/counter);
		if (isNull == true) {
			return null;
		}else {
			return p;
		}
	}

}
