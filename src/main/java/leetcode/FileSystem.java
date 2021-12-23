package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (dir.equals("/")) {
            return new ArrayList<>(root.files.keySet());
        }
        return null;
    }
}
