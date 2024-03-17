package helper_methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		File input = new File("./src/resources/Stardew Valley All Colors.txt");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		File output = new File("./src/resources/Stardew Valley Unique Colors.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(output, false));
		Map<String, Integer> flossColors = new HashMap<String, Integer>();
		File input2 = new File("./src/resources/Richard Owned Colors.txt");
		BufferedReader reader2 = new BufferedReader(new FileReader(input2));
		Map<String, Integer> ownedColors = new HashMap<String, Integer>();
		
		// Finding out unique strings
		try {
		    String line;
		    while((line = reader.readLine()) != null) {
	    		// Skip commented lines
		    	if(line.length() == 0 || line.substring(0, 2).equals("//")) {
		    		continue;
		    	}
		    	
		    	List<String> flossList = Arrays.asList(line.split(","));
		    	for(String floss : flossList) {
		    		floss = floss.trim();
		    		
		    		if(flossColors.containsKey(floss)) {
		    			flossColors.put(floss, flossColors.get(floss) + 1);
		    		} else {
		    			flossColors.put(floss, 1);
		    		}
		    	}
		    }
		    reader.close();

		    while((line = reader2.readLine()) != null) {
	    		// Skip commented lines
		    	if(line.length() == 0 || line.substring(0, 2).equals("//")) {
		    		continue;
		    	}
		    	
		    	List<String> flossList = Arrays.asList(line.split(","));
		    	for(String floss : flossList) {
		    		floss = floss.trim();

		    		if(ownedColors.containsKey(floss)) {
		    			ownedColors.put(floss, ownedColors.get(floss) + 1);
		    		} else {
		    			ownedColors.put(floss, 1);
		    		}
		    	}
		    }
		    reader2.close();
		    	
		} catch (Exception e) {
			reader.close();
			reader2.close();
			writer.close();
			throw e;
		}
		
		for(String name : flossColors.keySet()) {
			if(!ownedColors.containsKey(name)) {
			    System.out.println("New floss color " + name + " needs to be purchased!");
			    writer.append(name + "     " + flossColors.get(name) + '\n');
			} else {
				System.out.println("We already own the color " + name);
			}
		}
		writer.close();
		
		
		// Hannah Testing
		hexColor exampleHex = new hexColor("#ABCDEF");
		
		System.out.println(exampleHex.getHex());
		System.out.println(exampleHex.getRGB());
		System.out.println(exampleHex.getRed());
		System.out.println(exampleHex.getGreen());
		System.out.println(exampleHex.getBlue());
		
		//DMCColor pls = new DMCColor("white","#000000","1");
		// System.out.println(pls.toString());
	}

}
