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
        Map<String, File> files = new HashMap<>();
        String content = "";

        public File() {
        }

        public File(String content) {
            this.content = content;
            isFile = true;
        }
    }

    File root = new File();

    public String readContentFromFile(String dir) {
        String[] dirs = dir.split("/");
        File f = root;

        for (int i = 1; i < dirs.length; i++) {
            f = f.files.get(dirs[i]);
        }

        return f.content;

    }

    public void addContentToFile(String file, String content) {
        String[] dirs = file.split("/");
        String fileName = dirs[dirs.length - 1];
        File f = root;

        for (int i =1; i < dirs.length - 1; i++) {
            f = f.files.get(dirs[i]);
        }

        f.files.put(fileName, new File(content));
    }

    public void mkdir(String dir) {
        String[] dirs = dir.split("/");
        File file = root;
        for (int i=1; i < dirs.length; i++) {
            if (!file.files.containsKey(dirs[i])) {
                file.files.put(dirs[i], new File());
            }
            file = file.files.get(dirs[i]);
        }
    }

    public List<String> ls(String dir) {
        File f = root;
        List<String> files = new ArrayList<>();
        if (!dir.equals("/")) {
            String[] dirs = dir.split("/");

            for (int i=1; i< dirs.length; i++) {
                f = f.files.get(dirs[i]);
            }

            if (f.isFile) {
                files.add(dirs[dirs.length - 1]);
                return files;
            }
        }
        files.addAll(f.files.keySet());
        Collections.sort(files);
        return files;
    }
}
