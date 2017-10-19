import java.util.*;

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        int comp = Integer.compare(p1.score, p2.score);
        if(comp == 0) {
            if(p1.name.equals(p2.name)) {
                return 0;
            }
            return p1.name.compareTo(p2.name);
        }
        return -1 * Integer.compare(p1.score, p2.score);
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class HRSortingComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}