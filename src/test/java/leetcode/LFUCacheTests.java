package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LFUCacheTests {
    @Test
    public void lfu_cache() {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2,2);

        Assertions.assertThat(lfu.get(1)).isEqualTo(1);
    }
}
