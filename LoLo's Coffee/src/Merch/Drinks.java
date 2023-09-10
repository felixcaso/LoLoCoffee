package Merch;

import java.util.*;


public class Drinks {
	private final double ADD_SYRUP = .50;
	private final double NON_DAIRY = .75;
	
	private double price;
	private String drink;
	private String[] syrup;
	private String milk;
	private char size;

	
	public enum Espresso {
		Single, Double, Triple, Quad,
		Latte, Matcha, Caramel_Macchiato,
		Flat_White, Cortado, DChai
	}
	
	public enum Teas {
		Black, Green, White, Mint
	}
	
	public enum Syrups {
		Vanilla, Caramel, Mocha, WhiteMocha
	}
	
	public enum Milks {
		Whole, Lowfat, Oat, Almond, Half
	}
	
	
	//Constructors for Espresso drinks
	public Drinks(Espresso drink, double price){
		this.price = price;
		this.milk = "Whole";
		this.syrup = new String[10];
		this.drink = String.valueOf(drink);
		this.size = 'M';
	}
	
	public Drinks(Espresso drink, double price, Milks milk ){
		this.price = price;
		this.milk = String.valueOf(milk);
		this.syrup = new String[10];
		this.drink = String.valueOf(drink);
		this.size = 'M';
	}
	
	public Drinks(Espresso drink, double price, String[] syrup){
		this.price = price;
		this.milk = "Whole";
		this.syrup = syrup;
		this.drink = String.valueOf(drink);
		this.size = 'M';
	}
	
	public Drinks(Espresso drink, double price, Milks milk, String[] syrup){
		this.price = price;
		this.milk = String.valueOf(milk);
		this.syrup = syrup;
		this.drink = String.valueOf(drink);
		this.size = 'M';
	}
	
	
	//Constructors for Tea drinks
	public Drinks(Teas drink, double price){
		this.price = price;
		this.milk = "";
		this.syrup = new String[10];
		this.drink = String.valueOf(drink);
		this.size = 'M';
	}
	
	public Drinks(Teas drink, double price, Milks milk){
		this.price = price;
		this.milk = String.valueOf(milk);
		this.syrup = new String[10];
		this.drink = String.valueOf(drink);
		this.size = 'M';
	}
	
	public Drinks(Teas drink, double price, String[] syrup){
		this.price = price;
		this.milk = "";
		this.syrup = syrup;
		this.drink = String.valueOf(drink);
		this.size = 'M';
	}
	
	public Drinks(Teas drink, double price, Milks milk, String[] syrup){
		this.price = price;
		this.milk = String.valueOf(milk);
		this.syrup = syrup;
		this.drink = String.valueOf(drink);
		this.size = 'M';
	}
	
	
	// set & get drink
	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	public String getDrink() {
		return this.drink;
	}
	
	// set & get price
	public void setprice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		
		if (syrup.length > 1) 
			this.price += ADD_SYRUP;
		
		if(milk.equals("Oat") || milk.equals("Almond"))
			this.price += NON_DAIRY;
		
		
		return this.price;
	}
	
	// set & get size
	public void setSize(char size) {
		this.size = size;
	}
		
	public char getSize() {
		return this.size;
	}
	
	// set & get milk
	public void setMilk(String milk) {
		this.milk = milk;
	}
	
	public String getMilk() {
		return milk;
	}
	
	// set & get syrup
	public void setSyrups(String[] syrup) {
		this.syrup = syrup;
	}
	
	public void moreSyrup(String syrup) {
		if(this.syrup.length < 10)
			this.syrup[this.syrup.length] = syrup;
	}
	
	public String[] getSyrups() {
		return syrup;
	}
	
	
	public String toString() {
		return drink;
		
	}

}
