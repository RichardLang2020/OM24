package helper_methods;

public record DMCColor(String name, hexColor hexItem, String DMCNum) {
	
	public DMCColor(String n, String h, String DMC) {
		this(n, new hexColor(h), DMC);
	}
	
	@Override
	public String toString() {
		return "DMCColor [DMCNum = " + DMCNum + ", name=" + name + ", hexCode=" + hexItem.getHex() + "]";
	}
	
}
