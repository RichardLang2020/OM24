package helper_methods;

public class hexColor{
	int intRed;
	int intBlue; 
	int intGreen;
	String strCode;
	
	public hexColor(int R, int G, int B) {		
		intRed = R;
		intBlue = B;
		intGreen = G;
		
		//Validate arguments to be within colorspace
		if (intRed > 255 || intGreen > 255 || intBlue > 255) { 
			throw new IllegalArgumentException("RGB values must be less than 256");
		}
			
		//Create string representation of hexcode
		strCode = String.format("#%02x%02x%02x", intRed,intGreen,intBlue);
	}

	public String getHex() {
			return strCode;
	}
	
	public String getRGB() {
		return (Integer.toString(intRed) + ", " + Integer.toString(intGreen) + ", " + Integer.toString(intBlue));
	}
	
	public int getRed() {
		return intRed;
	}
	
	public int getGreen() {
		return intGreen;
	}
	
	public int getBlue() {
		return intBlue;
	}
}
