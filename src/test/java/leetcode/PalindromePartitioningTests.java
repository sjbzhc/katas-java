package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PalindromePartitioningTests {
    @Test
    public void palindrome_partitioning() {
        PalindromePartitioning pp = new PalindromePartitioning();

        List<List<String>> list = pp.partition("aab");

        Assertions.assertThat(list.size()).isEqualTo(2);
    }
}
