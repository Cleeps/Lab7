package Lab7;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public interface IFindCommon {
    // For the list of input countries, find the list of common food among all the input countries
    // If there is no common food in all the countries, find the one with the highest popularity
    public List<String> getCommonFood(TreeMap<String, TreeSet<String>> countryFoodSet, List<String>countries); 

}
