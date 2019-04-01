package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Number: #609. Find Duplicate File in System
 * @Descpription: Given a list of directory info including directory path, and all the files with contents in this directory,
 * you need to find out all the groups of duplicate files in the file system in terms of their paths.
 * A group of duplicate files consists of at least two files that have exactly the same content.
 * The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content.
 * A file path is a string that has the following format:
 * "directory_path/file_name.txt"
 * @Author: Created by xucheng.
 */
public class FindDuplicateFileInSystem {
    /**
     * HashMap<String content, String path>
     *
     * @param paths
     * @return
     */
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths.length == 0)
            return res;

        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] pathArr = path.split(" ");
            String dir = pathArr[0];
            for (int i = 1; i < pathArr.length; i++) {
                int idxBracket = pathArr[i].indexOf("(");
                String fileName = pathArr[i].substring(0, idxBracket);
                String content = pathArr[i].substring(idxBracket + 1, pathArr[i].length() - 1);
                if (!map.containsKey(content))
                    map.put(content, new ArrayList<>());
                map.get(content).add(dir + "/" + fileName);
                System.out.println(dir + "/" + fileName);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                res.add(map.get(key));
        }

        return res;
    }
}
