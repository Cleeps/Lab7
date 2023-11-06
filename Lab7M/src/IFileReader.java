package Lab7;

import java.util.TreeMap;
import java.util.TreeSet;

public interface IFileReader {
    public TreeMap<String, TreeSet<String>> readFileToTreeMap(String filePath);
}
