import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File inputFile = new File("a_example.txt");


        Scanner scanner = new Scanner(inputFile);


        int numPhotos = scanner.nextInt();

        int numTags;
        char orient;
        int id;
        HashSet<String> tags;
        Photo p;
        ArrayList<Photo> album = new ArrayList<Photo>();
        ArrayList<Photo> verts = new ArrayList<Photo>();

        // turn file inputs into photos
        for (int i = 0; i < numPhotos; i++) {
            orient = scanner.next().charAt(0);
            numTags = scanner.nextInt();
            tags = new HashSet<String>();


            for (int j = 0; j < numTags; j++) {
                tags.add(scanner.next());
            }
            p = new Photo(orient, numTags, tags, i);

            if (orient == 'H') {
                album.add(p);
            } else {
                verts.add(p);
            }
        }

        Collections.sort(verts);
        ArrayList<Slide> rawSlides = new ArrayList<Slide>();

        // pair vertical photos and add to slide show
        Slide s;
        for (int i = 0; i < verts.size() / 2; i++) {
            s = new Slide(verts.get(i), verts.get(verts.size() - i - 1));
            rawSlides.add(s);
        }

        // add horizontal slides to slideshow
        for (int i = 0; i < album.size(); i++) {
            s = new Slide(album.get(i));
            rawSlides.add(s);
        }

        Slide[] rawSlideShow = new Slide[rawSlides.size()];
        Collections.sort(rawSlides);
        rawSlideShow = rawSlides.toArray(rawSlideShow);



        Slideshow ss = new Slideshow(rawSlideShow);
        ss.build();

        ss.outputSlideshow();

    }
}