package Lab7;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public interface ISimilarCountries {
    // The return value is a TreeMap that has a country name “A” as the key
    // and the value is the list of country names that have the highest similarity with the country “A”
    public TreeMap<String, List<String>> getSimilarCountries(TreeMap<String, TreeSet<String>> countryFoodSet); 
}
