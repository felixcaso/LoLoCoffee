package Merch;

public class Food {
	
	//Attributes
	
	private final double toasted = .25;
	private String plate;
	private boolean warmed;
	private double price;
	private String[] addons;
	
	//COnstructors
	public Food() {
		this.plate = "";
		this.warmed = false;
		this.price = 0.0;
		this.addons = new String[10];
	}
	
	public Food(String plate, boolean warmed, double price) {
		this.plate = plate;
		this.warmed = warmed;
		this.price = price;
		this.addons = new String[10];
	}
	
	//Set and get plate
	public void setPlate(String plate) {
		this.plate=plate;
	}
	public String getPlate() {
		return this.plate;
	}
	
	//set and get warmed
	public void setWarmed(boolean warmed) {
		this.warmed = warmed;
	}
	
	public boolean getWarmed() {
		return this.warmed;
	}
	
	//set and get price
	public void setPrice( double price) {
		this.price = price;
	}
		
	public double getPrice() {
		
		return this.price;
	}
	
	//set and get addOns
	public void setAddOns(String[] addons) {
		this.addons = addons;
	}
			
	public double getAddOns() {
		return this.price;
	}
	
	public void addExtra(String extra) {
		
		if(this.addons.length < 10)
			this.addons[this.addons.length] = extra;
	}
	
	
	
	
	

}
