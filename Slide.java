import java.util.HashSet;
import java.util.Set;

public class Slide implements Comparable<Slide> {
    boolean isPaired;
    Photo photo1;
    Photo photo2;
    HashSet<String> tags;

    Slide(Photo p){
        this.isPaired = false;
        this.photo1 = p;
        this.photo2 = null;
        this.tags = photo1.tags;
    }
    Slide(Photo p1, Photo p2){
        this.isPaired = true;
        this.photo1 = p1;
        this.photo2 = p2;
        tags = new HashSet<>();
        tags.addAll(photo1.tags);
        tags.addAll(photo2.tags);
    }

    public int interest(Slide other) {
        int common, unique1, unique2, min;
        Set<String> intersection = new HashSet<String>(this.tags); // use the copy constructor
        intersection.retainAll(other.tags);
        common = intersection.size();
        unique1 = this.tags.size() - intersection.size();
        unique2 = other.tags.size() - intersection.size();
        min = Math.min(common, unique1);
        min = Math.min(min, unique2);
        return min;
    }
    @Override
    public int compareTo(Slide o) {
        return this.tags.size() - o.tags.size();
    }

}
