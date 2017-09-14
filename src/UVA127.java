import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UVA127 {

    public static void main(String[] args) {
        // Read in the games
        Scanner in = new Scanner(System.in);
        ArrayList<String> games = new ArrayList();
        String line;
        while(!((line = in.nextLine()).equals("#"))) {
            String newGame = line + " " + in.nextLine();
            games.add(newGame);
        }

        // Play each game
        for(String game: games) {
            // Setup the game by putting the cards into 52 stacks
            ArrayList<Stack<String>> piles = new ArrayList<>();
            for(String card: game.split(" ")) {
                Stack<String> tempPile = new Stack<>();
                tempPile.push(card);
                piles.add(tempPile);
            }

            // Continue to make moves until we can't
            while(makeMove(piles));

            // Print our results
            String results = "";
            results += piles.size()+" "+((piles.size() == 1) ? "pile" : "piles")+" remaining:";
            for(Stack<String> pile: piles) {
                results+=" "+pile.size();
            }
            System.out.println(results);
        }
    }

    /*
    1) When a card matches immediately to its left, or 3 cards left, stack it on its match
    2) Cards match if same suit OR rank
    3) Only the top card of a pile may be moved at any time
    4) Gaps between piles should be closed up immediately by shifting all piles right of the gap
    to the left 1
    5) Game is won if reduced to a single pile
    6) Combine cards left whenever possible
    7) IF two cards may be moved, move the leftmost card first
    8) IF a card may be moved either one OR three cards left, always move three
     */
    public static boolean makeMove(ArrayList<Stack<String>> piles) {
        // If there is only one pile, we've won
        if(piles.size() == 1) {
            return false;
        }

        // Look at each pile from left to right, starting with the second pile
        for(int i=1; i<piles.size(); i++) {
            // See if we have matching cards
            if(i<=2) { // Only check adjacent stack if impossible to see three behind
                // Check if the two match
                if(cardsAreEqual(piles.get(i-1).peek(), piles.get(i).peek())) {
                    // Stack the cards
                    String card = piles.get(i).pop();
                    piles.get(i-1).push(card);
                    // Remove the pile from our piles if it's empty
                    if(piles.get(i).empty()) {
                        piles.remove(i);
                    }
                    return true;
                }
            } else { // We can check both and won't have out of bounds issues
                if(cardsAreEqual(piles.get(i-3).peek(), piles.get(i).peek())) { // Check if we can move 3
                    // Stack the cards
                    String card = piles.get(i).pop();
                    piles.get(i-3).push(card);
                    // Remove the pile from our piles if it's empty
                    if(piles.get(i).empty()) {
                        piles.remove(i);
                    }
                    return true;
                } else if(cardsAreEqual(piles.get(i-1).peek(), piles.get(i).peek())) { // Check if we can move adjacent
                    // Stack the cards
                    String card = piles.get(i).pop();
                    piles.get(i-1).push(card);
                    // Remove the pile from our piles if it's empty
                    if(piles.get(i).empty()) {
                        piles.remove(i);
                    }
                    return true;
                }
            }
        }

        // If we got here, we couldn't make a move
        return false;
    }

    // Returns true if the two cards match, false if they don't match
    public static boolean cardsAreEqual(String card1, String card2) {
        return (card1.charAt(0) == card2.charAt(0) || card1.charAt(1) == card2.charAt(1));
    }
}
