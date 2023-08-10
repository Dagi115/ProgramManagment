public class Plot {

	private int PlotX = 0;
	private int PlotY = 0;
	private int PlotW = 0;
	private int PlotD = 0;

	public Plot() {
		this.PlotW = 1;
		this.PlotD = 1;
	}

	public Plot(int X, int Y, int W, int D) {
		this.PlotX = X;
		this.PlotY = Y;
		this.PlotW = W;
		this.PlotD = D;
	}

	public int getX() {
		return this.PlotX;
	}

	public int getY() {
		return this.PlotY;
	}

	public int getWidth() {
		return this.PlotW;
	}

	public int getDepth() {
		return this.PlotD;
	}

	public void setX(int X) {
		this.PlotX = X;
	}

	public void setY(int Y) {
		this.PlotY = Y;
	}

	public void setWidth(int W) {
		this.PlotW = W;
	}

	public void setDepth(int D) {
		this.PlotD = D;
	}

	public boolean overlaps(Plot P) {

		int result = 0;
		int p1x1 = this.getX();
		int p2x1 = P.getX();
		int p1x2 = this.getX() + this.getWidth();
		int p1y1 = this.getY();
		int p2y1 = P.getY();
		int p1y2 = this.getY() + this.getDepth();

		if (p1x1 >= p2x1 || p2x1 <= p1x2) {
			result = 1;
		}
		if (p1y1 >= p2y1 || p2y1 <= p1y2) {
			result = 1;
		}

		return result == 0 ? false : true;
	}

	public boolean encompasses(Plot P) {

		int result = 0;
		int p1x1 = this.getX();
		int p2x1 = P.getX();
		int p1x2 = this.getX() + this.getWidth();
		int p1y1 = this.getY();
		int p2y1 = P.getY();
		int p1y2 = this.getY() + this.getDepth();

		if (p1x1 + this.getWidth() > p2x1) {
			result = 1;
		}
		if (p1y1 + this.getDepth() > p2y1) {
			result = 1;
		}
		if (p1x1 >= p2x1 || p2x1 <= p1x2) {
			result = 1;
		}
		if (p1y1 >= p2y1 || p2y1 <= p1y2) {
			result = 1;
		}

		System.out.println("Encompasses: this.X" + p1x1 + " P.X " + p2x1);

		return result == 0 ? false : true;
	}

	public String toString() {

		String r = "";

		r += "(X, Y): (" + this.getX() + ", " + this.getY() + ")";
		r += "\n" + "Width: " + this.getWidth();
		r += "\n" + "Depth:" + this.getDepth();

		return r;
	}
}