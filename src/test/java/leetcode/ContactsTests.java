package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class ContactsTests {
    @Test
    public void test() {
        Contacts ct = new Contacts();
        List<List<String>> queries = List.of(List.of("add", "hack"), List.of("add", "hackerrank"), List.of("find", "hac"), List.of("find", "hak"));

        Assertions.assertThat(ct.contacts(queries)).isEqualTo(List.of(2, 0));
    }
}
