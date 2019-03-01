
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.*;

public class Slideshow{

    final String FILE_NAME = "outputFile_a.txt";

    Slide[] rawslides;
    ArrayList<Slide> finalSlides;

    public Slideshow(Slide [] slides){
        this.rawslides = slides;
        finalSlides = new ArrayList<>();
    }

    public void build() {
        int bestIdx;
        int bestScore;
        int change;
        Slide cur;
        finalSlides.add(rawslides[0]);

        for (int i = 1; i < rawslides.length; i++) {
            finalSlides.add(i, rawslides[i]);
        }
    }

    public void outputSlideshow() throws IOException {

        FileWriter fw = new FileWriter(FILE_NAME);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(finalSlides.size());
        Slide cur;
        for (int i = 0; i < finalSlides.size(); i++) {
            cur = finalSlides.get(i);
            if (cur.isPaired) {
                pw.println(cur.photo1.id + " " + cur.photo2.id);
            } else {
                pw.println(cur.photo1.id);
            }
        }
        pw.close();
    }
}