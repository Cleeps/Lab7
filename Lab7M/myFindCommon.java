package Lab7;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;

/**Find common popular foods among countries
 * 
 * @author abigail pitcairn
 * @version 6 novemeber 2023
 */

public class myFindCommon implements IFindCommon {

    /**Input a TreeMap with the country’s name as the key, and the values shown as TreeSet holding the popular foods in that country.
     The second input is a list of countries. The return value is the list of food that is popular among
     all the (second) input countries. If there is no common food among all of them, the method
     returns the food popular in the majority of countries
     @input countryFoodSet - the total countries and their popular foods to search
     @input countries - the list of countries to find common foods among
     @return a list of the common foods found among the input countries, within the universal set, countryFoodSet
     */
    public List<String> getCommonFood(TreeMap<String, TreeSet<String>> countryFoodSet, List<String> countries) {
        List<String> commonFoods = new List<String>();
        TreeMap<String,int> tempMap = new TreeMap<String,int>();

        //add all the foods as keys to a temporary TreeMap with values for their frequency
        //(how many times they occur, or how many countries they are popular foods in)
        for (String food : countryFoodSet) {
            if (!tempMap.containsKey(food))
                tempMap.put(food, 1);
            else
                tempMap.put(food, tempMap.get(food)+1);
        }

        //add the common popular foods to the final return list
        for (String food : tempMap) {
            //if the frequency of the food is the same as the size of the list of coutries,
            //the food was found in every country; add to return list "commonFoods"
            if (tempMap.get(food) == countries.count)
                commonFoods.add(food);
            //if no foods were found in every country (the last if statement did not execute),
            //cycle through the food frequencies until we add the next most frequent food(s)
            if (commonFoods.count == 0)
                while (commonFoods.count == 0)
                    for (int i = countries.count; i > 0; --i)
                        if (tempMap.get(food) >= i)
                            commonFoods.add(food);
        }

        return commonFoods;
    }

}