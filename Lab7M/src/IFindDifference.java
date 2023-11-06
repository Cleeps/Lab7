package Lab7;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public interface IFindDifference {
    // This method will return the list of foods that are popular in majority of the countries in countries1 
    // and not popular in the majority of the countries in countries2
    public List<String> getDifferentFood(TreeMap<String, TreeSet<String>> countryFoodSet, List<String>countries1, List<String>countries2); 
}
