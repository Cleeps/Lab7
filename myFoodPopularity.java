import java.util.TreeMap;
import java.util.TreeSet;
import java.util.List;
public class myFoodPopularity implements IFoodPopularity{
  //Return list of foods popular in the majority of countries in countries1 and not popular in the majority of countries in countries2
  public TreeSet<String>  getFoodPopularity(TreeMap<String, TreeSet<String>> countryFoodSet, List<String>countries1, List<String>countries2)){
        TreeMap<String, Integer> popularFoods = new TreeMap<>();
        TreeMap<String, Integer> unpopularFoods = new TreeMap<>();
        TreeSet<String> finalList = new TreeSet<>();
  //Loop through each countries popular foods
  //If a food is popular enough in countries1 we will add it to final TreeSet
  //If a food is unpopular in countries2 we will add it to the final TreeSet
        for(String country: countries1) {
           for(String food:countryFoodSet.get(country)) {
               if(!popularFoods.containsKey(food)) {
                   popularFoods.put(food, 0);
               }
               if(popularFoods.containsKey(food)){
                  popularFoods.replace(food, popularFoods.get(food)+1);
            }        
            }
            }
        for(String country: countries2) {
            for(String food:countryFoodSet.get(country)) {
                if(!unpopularFoods.containsKey(food)) {
                    unpopularFoods.put(food, 0);
                }
                if(unpopularFoods.containsKey(food)){
                   unpopularFoods.replace(food, popularFoods.get(food)+1);
            }        
            }
            }
    //Find if food is popular in majority
    //I am just using if greater than 50% or less than 50% of countries have food
    int majority1 = countries1.size() / 2;
    int majority2 = countries2.size() / 2;
         
    for(String food: popularFoods.keySet()) {   
        if(popularFoods.get(food) > majority1) {
            finalList.add(food);
        }
    }
    for(String food: unpopularFoods.keySet()) {   
        if(unpopularFoods.get(food) < majority2) {
            finalList.add(food);
        }
    }
    
    return finalList;
    } 
}
