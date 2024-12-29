package leetcode;

import java.util.*;

/*
* Time:
* ls: O(m + n + k log k): m for length of word for splitting, n the number of splits in array, klogk for sorting the k files
* mkdir: O(m + n)
* addContentToFile: O(m + n)
*
* Space:
* O(m + ck)
* */

public class FileSystem {

    class File {
        boolean isFile = false;
        HashMap <String, File> files = new HashMap <>();
        String content = "";
    }
    File root;
    public FileSystem() {
        root = new File();
    }

    public List <String> ls(String path) {
        File t = root;
        // not root dir
        if (!path.equals("/")) {
            String[] dirs = path.split("/");
            for (int i = 1; i < dirs.length; i++) {
                t = t.files.get(dirs[i]);
            }
            // return a single file
            if (t.isFile) {
                List<String> files = new ArrayList<>();
                files.add(dirs[dirs.length - 1]);
                return files;
            }
        }
        // return all files in dir
        List<String> files = new ArrayList<>(t.files.keySet());
        Collections.sort(files);
        return files;
    }

    public void mkdir(String path) {
        File t = root;
        String[] dirs = path.split("/");
        for (int i = 1; i < dirs.length; i++) {
            t.files.putIfAbsent(dirs[i], new File());
            t = t.files.get(dirs[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] dirs = filePath.split("/");
        // stop one before end to only create dirs
        for (int i = 1; i < dirs.length; i++) {
            t.files.putIfAbsent(dirs[i], new File());
            t = t.files.get(dirs[i]);
        }
        t.isFile = true;
        t.content = t.content + content;
    }

    public String readContentFromFile(String filePath) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length; i++) {
            t = t.files.get(d[i]);
        }
        return t.content;
    }
}
