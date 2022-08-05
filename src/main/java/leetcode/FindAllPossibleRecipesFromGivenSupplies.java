package leetcode;

import java.util.*;

/*
* Time: O(V + E)
* Space: O(V + E)
* */

public class FindAllPossibleRecipesFromGivenSupplies {
    Map<String, List<String>> recipesToIngredients = new HashMap<>();
    Set<String> suppliesSet = new HashSet<>();
    Set<String> visited = new HashSet<>();
    Set<String> result = new HashSet<>();
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        for (int i=0; i < recipes.length; i++) {
            recipesToIngredients.put(recipes[i], ingredients.get(i));
        }
        for (String s : supplies) suppliesSet.add(s);

        for(String recipe: recipes) {
            dfs(recipe);
        }
        return new ArrayList<>(result);
    }

    private boolean dfs(String recipe) {
        for (String ingredient : recipesToIngredients.get(recipe)) {
            // this ingredient won't impede this recipe, so we can ignore it
            if (suppliesSet.contains(ingredient)) continue;
            // we look for the ingredient's recipe
            if (!recipesToIngredients.containsKey(ingredient)) return false;
            // we try to create the ingredient
            if (!visited.contains(ingredient)) {
                visited.add(ingredient);
                if (!dfs(ingredient)) return false;
            }
            // If the ingredient is not in the result, we could not create it, so we cannot create the current
            // recipe either
            if (!result.contains(ingredient)) return false;
        }
        result.add(recipe);
        return true;
    }
}
