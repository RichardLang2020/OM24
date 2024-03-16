package helper_methods;

public record DMCColor(String name, String hexCode, String DMCNum) {
	
	@Override
	public String toString() {
		return "DMCColor [DMCNum = " + DMCNum + ", name=" + name + ", hexCode=" + hexCode + "]";
	}
	
}
