package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class LRUCacheTests {

    @Test
    public void lru_cache() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);

        Assertions.assertThat(lruCache.get(1)).isEqualTo(1);

        lruCache.put(3,3);

        Assertions.assertThat(lruCache.get(2)).isEqualTo(-1);

        lruCache.put(4,4);

        Assertions.assertThat(lruCache.get(1)).isEqualTo(-1);
        Assertions.assertThat(lruCache.get(3)).isEqualTo(3);
        Assertions.assertThat(lruCache.get(4)).isEqualTo(4);
    }

    @Test
    public void lru_cache_2() {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.put(1,1);
        lruCache.put(2,2);

        Assertions.assertThat(lruCache.get(1)).isEqualTo(1);

        lruCache.put(3,3);

        Assertions.assertThat(lruCache.get(2)).isEqualTo(-1);
    }
}
