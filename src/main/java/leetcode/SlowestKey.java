package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SlowestKey {

    class Keypress {
        int duration;
        char character;
    }
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int prev = 0;
        List<Keypress> list = new ArrayList<>();

        for (int i=0; i<releaseTimes.length; i++) {
            Keypress k = new Keypress();
            k.character = keysPressed.charAt(i);
            k.duration = releaseTimes[i] - prev;
            prev = releaseTimes[i];
            list.add(k);
        }

        Collections.sort(list, (a, b) -> b.duration - a.duration);

        int duration = list.get(0).duration;
        List<Keypress> longer = list.stream().filter(it -> it.duration == duration).collect(Collectors.toList());

        if (longer.size() > 1) {
            Collections.sort(longer, (a, b) -> b.character - a.character);
            return longer.get(0).character;
        }
        return list.get(0).character;
    }
}
