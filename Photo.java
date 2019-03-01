import java.util.HashSet;
import java.util.Set;

public class Photo implements Comparable<Photo> {
    char orient;
    int numTags;
    int id;
    HashSet<String> tags;

    public Photo (char o, int num, HashSet<String> tags, int id) {
        this.orient = o;
        this.tags = tags;
        this.numTags = num;
        this.id = id;
    }

    public int compareVerts(Photo other) {
        int unique, common;
        if (orient == 'H') {
            throw new UnsupportedOperationException();
        }

        Set<String> intersection = new HashSet<String>(this.tags); // use the copy constructor
        intersection.retainAll(other.tags);
        common = intersection.size();
        unique = this.tags.size() + other.tags.size() - common;
        return unique;
    }

    @Override
    public int compareTo(Photo o) {
        return this.tags.size() - o.tags.size();
    }

}
