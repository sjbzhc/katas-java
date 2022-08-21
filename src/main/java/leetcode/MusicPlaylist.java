package leetcode;


/*
* Most recently played songs. 10
* getSong: search in playlist
* addSong: add if not present
*
* play: add to top of list
*
* */

import java.util.HashMap;
import java.util.Map;

public class MusicPlaylist {
    class LinkedList {
        LinkedList prev;
        LinkedList next;
        String song;
    }

    int capacity;
    int size = 0;
    LinkedList head = new LinkedList();
    LinkedList tail = new LinkedList();
    Map<String, LinkedList> map = new HashMap<>();

    public MusicPlaylist(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void add(String song) {
        if (map.containsKey(song)) {
            removeFromList(map.get(song));
            LinkedList newSong = new LinkedList();
            newSong.song = song;
            addToList(newSong);
        } else {
            LinkedList newSong = new LinkedList();
            newSong.song = song;
            addToList(newSong);
            map.put(song, newSong);
            if (size > capacity) {
                removeFromList(tail.prev);
                map.remove(song);
            }
        }
    }

    public String getTopSongs() {
        StringBuilder sb = new StringBuilder();
        LinkedList current = head;
        while (current != null) {
            if (current.song != null) {
                sb.append(current.song);
                sb.append(", ");
            }
            current =  current.next;
        }

        return sb.toString();
    }

    public void addToList(LinkedList list) {
        list.next = head.next;
        list.prev = head.next.prev;

        head.next.prev = list;
        head.next = list;
    }

    public void removeFromList(LinkedList list) {
        LinkedList prev = list.prev;
        LinkedList next = list.next;

        prev.next = next;
        next.prev = prev;
    }

}
