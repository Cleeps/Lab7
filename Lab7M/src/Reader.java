package program7;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class contains a file reader intended to be able to read data from a CSV and parse the 
 * information into instances of a Sales Record class
 * @author Colby Cormier
 */
public class Reader 
{	
	// Field that holds the name for the given CSV file to read from
	String fileName;
	
	/**
	 * Reader constructor, takes in a file name
	 * @param fName The name of a specified CSV file
	 */
	public Reader(String fName) 
	{
		fileName = fName;
	}
	
	/**
	 * This method reads a CSV file and stores the data into a map of car makes, with a sub map of dates and sale records
	 * @return dateMap A map of car makes, with a sub map of dates and sale records
	 */
	public Map<String, myAVL> ReadFile(){	
		String line = ""; // Create an empty line which can be used to stored read lines
		Map<String, myAVL> dateMap = new TreeMap<>();
		
		try {
			// Create a new reader to open the file	
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			 
			line = reader.readLine(); // Skip the first line of formatting
			
			// While the file has not been completely read, create sale records
			while ((line = reader.readLine()) != null) {
				PutSaleRecord(line, dateMap);
			}
			
			reader.close(); // Close the reader
			return dateMap; // Return the array	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null; // Return null in the event of an exception
	}
	
	/**
	 * This record creates sale records, and handles the building and assigning of sale records into the date map
	 * @param line The current line being processed from the CSV file
	 * @param dateMap A map of car makes, with a sub map of dates and sale records
	 */
	protected static void PutSaleRecord(String line, Map<String, myAVL> dateMap){
		String[] splitString = line.split(","); // Split the current line
		String[] dateString = splitString[0].split("-"); // Split the date information
		
		SaleRecord record = CreateRecord(dateString, splitString); // Create a new record
		
		//If there is no map for a given car make, create one 
		if(!dateMap.containsKey(record.carMake)){
			dateMap.put(record.carMake, new myAVL(null, 10));
			myAVL temp = dateMap.get(record.carMake);
			temp.root = temp.add(null, record);
		}
		else
		{
			// Get a reference to the map for the current car make
			myAVL temp = dateMap.get(record.carMake);
			temp.add(temp.root, record); // Add the entry to the list for the date
			//temp.Rebalance(temp.root, record.date);
		}
	}
	
	/**
	 * This method takes in processed data related to sale records and creates an instance of a sale record
	 * @param dateString A split string containing date information
	 * @param splitString A split string containing sale record data
	 * @return SaleRecord A new instance of a sale record storing the given data
	 */
	protected static SaleRecord CreateRecord(String[] dateString, String[] splitString)
	{
		// Create a new sale record based on the given data
		return new SaleRecord(Integer.parseInt(dateString[0]), 
	                          Integer.parseInt(dateString[1]), 
	                          Integer.parseInt(dateString[2]), 
							  splitString[1], splitString[2], splitString[3], 
							  splitString[4], splitString[5], splitString[6], 
							  splitString[7], splitString[8]);
	}
}