package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class FindAllPossibleRecipesFromGivenSuppliesTests {
    @Test
    public void test() {
        FindAllPossibleRecipesFromGivenSupplies fa = new FindAllPossibleRecipesFromGivenSupplies();

        String[] recipes = {"bread"};
        List<List<String>> ingredients = List.of(List.of("yeast","flour"));
        String[] supplies = {"yeast","flour","corn"};
        List<String> res = List.of("bread");

        Assertions.assertThat(fa.findAllRecipes(recipes, ingredients, supplies)).isEqualTo(res);
    }
}
