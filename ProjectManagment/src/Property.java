/*
 * Class: CMSC203 
 * Instructor:
 * Description: A property management company manages individual properties they will build to rent, and charges them a management fee as the percentages of the monthly rental amount. The properties cannot overlap each other, and each property must be within the limits of the management company’s plot.  Write an application that lets the user create a management company and add the properties managed by the company to its list. Assume the maximum number of properties handled by the company is 5.  
 * Due: MM/DD/YYYY
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dagmawi Kebede
*/
public class Property {

	private String Name = "";
	private String City = "";
	private String Owner = "";
	private double RentAmount = 0;
	private Plot Plot;

	public Property() {
		this.Plot = new Plot();
	}

	public Property(String N, String C, double R, String O) {
		this.Name = N;
		this.City = C;
		this.RentAmount = R;
		this.Owner = O;
		this.Plot = new Plot();
	}

	public Property(String N, String C, double R, String O, int X, int Y, int W, int D) {
		this.Name = N;
		this.City = C;
		this.RentAmount = R;
		this.Owner = O;
		this.Plot = new Plot(X, Y, W, D);
	}

	public Property(Property P) {
		this.Name = P.getPropertyName();
		this.City = P.getCity();
		this.RentAmount = P.getRentAmount();
		this.Owner = P.getOwner();
		this.Plot = P.getPlot();
	}

	public String getCity() {
		return this.City;
	}

	public String getOwner() {
		return this.Owner;
	}

	public Plot getPlot() {
		return this.Plot;
	}

	public String getPropertyName() {
		return this.Name;
	}

	public double getRentAmount() {
		return this.RentAmount;
	}

	public void setCity(String S) {
		this.City = S;
	}

	public void setOwner(String O) {
		this.Owner = O;
	}

	public void setPropertyName(String N) {
		this.Name = N;
	}

	public void setRentAmount(double R) {
		this.RentAmount = R;
	}

	public String toString() {

		String r = "";

		r += "Property Name: " + this.getPropertyName();
		r += "\n" + "Located in " + this.getCity();
		r += "\n" + "Belonging to: " + this.getOwner();
		r += "\n" + "Rent Amount: " + this.getRentAmount();
		r += " ";

		return r;
	}
}