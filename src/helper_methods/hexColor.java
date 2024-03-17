package helper_methods;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
			throw new IllegalArgumentException("hexColor: RGB values must be less than 256");
		}
			
		//Create string representation of hexcode
		strCode = String.format("#%02x%02x%02x", intRed,intGreen,intBlue);
	}
	
	public hexColor (String code) {
		//Validate hex code input argument
		if (!containsHexs(code)) {
			throw new IllegalArgumentException("hexColor: Invalid hex code input");
		}
		
		strCode = code;
		
		intRed = Integer.valueOf(strCode.substring(1,3),16);
		intGreen = Integer.valueOf(strCode.substring(3,5),16);
		intBlue = Integer.valueOf(strCode.substring(5,7),16);
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
	
	private boolean containsHexs(String toExamine) {
	    //Pattern pattern = Pattern.compile("^#(?:[0-9A-F]{3}){1,2}$"); //this regex should work for length 3 or length 6 if we need that later
		Pattern p = Pattern.compile("^#[A-F0-9]{6}$");		
	    Matcher m = p.matcher(toExamine);	    
	    return m.matches();
	}
}
