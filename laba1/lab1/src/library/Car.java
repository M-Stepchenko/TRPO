package library;

public class Car extends Transport {
	
	public String brand;
	public String model;
	
	private Engine engine;
	private Driver driver;
	
	public Car (String b, String m, int w){
		super(w);
		brand = b;
		model = m;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}