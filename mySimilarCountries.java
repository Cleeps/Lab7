package lab7m;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Finds country for each country which has the most similar popular foods
 * @author Aidan Bell
 * @version 11/06/2023
 */
public class mySimilarCountries implements ISimilarCountries{
	/**
	 * @param countryFoodSet TreeMap with countries as key and TreeSet of popular foods as values
	 * @return TreeMap with countries as key and most similar popular foods country as values
	 */
	@Override
	public TreeMap<String, List<String>> getSimilarCountries(TreeMap<String, TreeSet<String>> countryFoodSet) {
		
		TreeMap<String, List<String>> similarCountries = new TreeMap<String, List<String>>();
		
		//Iterate through each entry of TreeMap
		for(Map.Entry<String, TreeSet<String>> entry : countryFoodSet.entrySet()){
			int highestSimilar = 0;
			String highestSimilarCountry = "none";
			int sameFood = 0;
			
			//Iterate through each entry of TreeSet
			for(Map.Entry<String, TreeSet<String>> entry2 : countryFoodSet.entrySet()) {
				sameFood = 0;
				
				//Don't check a country with itself
				if(entry2.getKey() == entry.getKey()) {
					continue;
				}
				
				//Add the food shared between both sets to sameFood
				TreeSet<String> entry2copy = entry2.getValue();
				entry2copy.retainAll(entry.getValue());
				sameFood += entry2copy.size();
				
				//If previous highest is less than current, current = new highest
				if(highestSimilar < sameFood) {
					highestSimilar = sameFood;
					highestSimilarCountry = entry2.getKey();
				}
			}
			//Update similarCountries with Country: Array of most similar
			ArrayList<String> similar = new ArrayList<String>();
			similar.add(highestSimilarCountry);
			similarCountries.put(entry.getKey(), similar);
		}
		
		return similarCountries;
	}

}
