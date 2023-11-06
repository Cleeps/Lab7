package Lab7;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.TreeSet;

// File reader class, takes in a CSV and formats it into a TreeMap
public class myFileReader implements IFileReader{
	
	// Takes in a CSV filepath and reads the values into a TreeMap of countries with a
	// TreeSet of foods as its values
	public TreeMap<String, TreeSet<String>> readFileToTreeMap(String filePath)
	{
		// Initialize variables
		BufferedReader reader;
		TreeMap<String, TreeSet<String>> foodTree = new TreeMap<String, TreeSet<String>>();
		String line = "";
		
		try {	
			reader = new BufferedReader(new FileReader(filePath)); // Create a new reader
			
			while ((line = reader.readLine()) != null) // While the reader has lines to read
			{
				String[] split = line.split(","); // Split the collection
				foodTree.put(split[0], new TreeSet<String>()); // Create a new value for the tree
			
				// For as many elements are left, loop through and add elements to treeset
				for(int i = 1; i < split.length; i++)
				{
					foodTree.get(split[0]).add(split[i]);
				}
			}	
			
			reader.close(); // Close the reader upon completion
		} catch (Exception e) { 
			e.printStackTrace(); // Catch and print exceptions
		}

		return foodTree; // Return the food tree when finished reading the file
	}
}
