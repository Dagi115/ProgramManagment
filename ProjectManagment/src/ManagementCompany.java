public class ManagementCompany {

	private int MAX_PROPERTY = 5;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;

	private String Name = "";
	private String TaxID = "";
	private double ManagementFee = 0.00;
	private Plot ManagementPlot;
	private Property Properties[] = new Property[MAX_PROPERTY];
	private int currentPropertyIndex = -1;

	public ManagementCompany() {
		this.ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}

	public ManagementCompany(String n, String tax, double fee) {
		this.Name = n;
		this.TaxID = tax;
		this.ManagementFee = fee;
		this.ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}

	public ManagementCompany(String n, String tax, double fee, int x, int y, int w, int d) {
		this.Name = n;
		this.TaxID = tax;
		this.ManagementFee = fee;
		this.ManagementPlot = new Plot(x, y, w, d);
	}

	public int getMAX_PROPERTY() {
		return this.MAX_PROPERTY;
	}

	public Plot getPlot() {
		return this.ManagementPlot;
	}

	public String getName() {
		return this.Name;
	}

	public double totalRent() {

		double total = 0;
		for (int i = 0; i < this.Properties.length; i++) {
			if (this.Properties[i] == null) {
				continue;
			}
			Property p = this.Properties[i];
			total += p.getRentAmount();
		}

		return (this.Properties.length > 0 ? total : 0.00);
	}

	public String maxRentPropInfo() {

		double highest = 0;
		String stringified = "";

		for (int i = 0; i < this.Properties.length; i++) {

			Property p = this.Properties[i];

			if (p == null) {
				continue;
			}
			if (p.getRentAmount() > highest) {
				highest = p.getRentAmount();
				stringified = p.toString();
			}
		}

		return (highest > 0 ? stringified : "");
	}

	public String toString() {

		String r = "";

		r += "List of properties for " + this.getName() + ", TaxID: " + this.TaxID;

		for (int i = 0; i < this.Properties.length; i++) {
			if (this.Properties[i] == null) {
				continue;
			}

			r += "\n" + this.Properties[i].toString();
		}

		r += "\ntotal management Fee: " + (this.totalRent() * (this.ManagementFee * 0.01));

		return r;
	}

	public int addProperty(Property P) {

		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;

		if (newIndex >= this.MAX_PROPERTY) {
			return -1;
		}

		this.Properties[newIndex] = new Property(P);

		currentPropertyIndex = newIndex;
		return newIndex;
	}

	public int addProperty(String n, String c, double r, String o) {
		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;

		if (newIndex >= this.MAX_PROPERTY) {
			return -1;
		}

		this.Properties[newIndex] = new Property(n, c, r, o);

		currentPropertyIndex = newIndex;
		return newIndex;
	}

	public int addProperty(String n, String c, double r, String o, int x, int y, int w, int d) {

		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		Plot tempPlot = new Plot(x, y, w, d);

		if (newIndex >= this.MAX_PROPERTY) {
			return -1;
		}
		if (this.ManagementPlot.encompasses(tempPlot) == false) {
			return -3;
		}
		if (index >= 0) {
			for (int i = 0; i < this.Properties.length; i++) {
				if (this.Properties[i] == null) {
					continue;
				}
				if (this.Properties[i].getPlot().overlaps(tempPlot) == true) {
					return -4;
				}
			}
		}

		this.Properties[newIndex] = new Property(n, c, r, o, x, y, w, d);

		currentPropertyIndex = newIndex;
		return newIndex;
	}
}