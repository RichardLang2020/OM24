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
		BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));
		Map<String, Integer> flossColors = new HashMap<String, Integer>();
		
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
		} catch (Exception e) {
			reader.close();
			writer.close();
			throw e;
		}
		
		for(String name : flossColors.keySet()) {
		    System.out.println(name + "     " + flossColors.get(name));
		    writer.append(name + "     " + flossColors.get(name) + '\n');
		}
		writer.close();
	}

}
