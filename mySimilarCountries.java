import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class mySimilarCountries implements ISimilarCountries{

	@Override
	public TreeMap<String, List<String>> getSimilarCountries(TreeMap<String, TreeSet<String>> countryFoodSet) {
		
		TreeMap<String, List<String>> similarCountries = new TreeMap<String, List<String>>();
		
		for(Map.Entry<String, TreeSet<String>> entry : countryFoodSet.entrySet()){
			similarCountries.put(entry.getKey(), new ArrayList<String>());
			int highestSimilar = 0;
			String highestSimilarCountry;
			int sameFood = 0;
			
			for(Map.Entry<String, TreeSet<String>> entry2 : countryFoodSet.entrySet()) {
				sameFood = 0;
				
				if(entry2.getKey() == entry.getKey()) {
					continue;
				}
				
				//iterate through 
				
				if(highestSimilar < sameFood) {
					highestSimilar = sameFood;
				}
			}
		}
		
		return similarCountries;
	}

}
