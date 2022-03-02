package ecommerce.com;

public class Product {
	

	private int id;
	private String laptopName; 
	private String color; 
	private String weight; 
	private String model;
	private String screensize;
	
	public Product() {
		
	}
	
	public Product(String screensize, String laptopName, String color, String weight, String model) {
		super();
		this.screensize = screensize;
		this.laptopName = laptopName;
		this.color = color;
		this.weight = weight;
		this.model = model;
	
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getScreensize() {
		return screensize;
	}

	public void setScreensize(String screensize) {
		this.screensize = screensize;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
	
}