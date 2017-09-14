import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Borrowers {

    public static class Book implements Comparable<Book> {
        private String title;
        private String author;

        public Book(String t, String a, boolean co) {
            title = t;
            author = a;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }

        public String toString() { return "" + title + " by " + author; }

        public int compareTo(Book book2) {
            if(this.getAuthor().equals(book2.getAuthor())) {
                return this.getTitle().compareTo(book2.getTitle());
            }
            return this.getAuthor().compareTo(book2.getAuthor());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Book> shelved = new ArrayList<>();

        String line;
        while(!(line = in.readLine()).equals("END")) {
            String[] splitLine = line.split("by");
            String title = splitLine[0].replaceAll("\"", "").trim();
            String author = splitLine[1].trim();
            shelved.add(new Book(title, author, false));
        }

        Collections.sort(shelved);

        ArrayList<Book> borrowed = new ArrayList<>();
        ArrayList<Book> returned = new ArrayList<>();

        while(!(line = in.readLine()).equals("END")) {
            String[] splinput = line.replaceAll("\"", "").split(" ");
            String title = "";
            for(int i=1; i<splinput.length; i++) {
                title += splinput[i] + " ";
            }
            title = title.trim();

            if(line.contains("BORROW")) {
                for(int i=0; i<shelved.size(); i++) {
                    if(shelved.get(i).getTitle().equals(title)) {
                        borrowed.add(shelved.get(i));
                        shelved.remove(i);
                        break;
                    }
                }
            } else if(line.contains("RETURN")) {
                for(int i=0; i<borrowed.size(); i++) {
                    if(borrowed.get(i).getTitle().equals(title)) {
                        returned.add(borrowed.get(i));
                        borrowed.remove(i);
                        break;
                    }
                }
            } else { // Shelve.
                Collections.sort(returned);
                for(Book book: returned) {
                    shelved.add(book);
                    Collections.sort(shelved);

                    for(int i=0; i<shelved.size(); i++) {
                        if(shelved.get(i).getTitle().equals(book.getTitle())) {
                            if(i==0) {
                                System.out.println("Put \"" + book.getTitle() + "\" first");
                            } else {
                                System.out.println("Put \"" + book.getTitle() + "\" after \"" + shelved.get(i-1).getTitle() + "\"");
                            }
                            break;
                        }
                    }
                }
                System.out.println("END");
                returned = new ArrayList<>();
            }
        }
    }
}
