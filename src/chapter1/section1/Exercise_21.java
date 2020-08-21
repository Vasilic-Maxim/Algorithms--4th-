package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Exercise_21 {
    public static void main(String[] args) {
        // After you lunch the program, start typing in the command line
        // payer's names, hits they made, and at bats times. To display
        // the results, you have to stop the program waiting for another
        // inputs. In Intellij IDEA for Windows users, press Ctrl+D combo.
        ArrayList<BaseballPlayer> players = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] data = line.split(" ");
            int hits = Integer.parseInt(data[1]);
            int atBats = Integer.parseInt(data[2]);
            players.add(new BaseballPlayer(data[0], hits, atBats));
        }

        StdOut.println("|       Name |    Hits | At bats | Batting average |");
        StdOut.println("----------------------------------------------------");
        for (BaseballPlayer s : players) {
            String format = "| %10s | %7d | %7d |     %11.3f |%n";
            StdOut.printf(format, s.name, s.points, s.atBats, s.average);
        }
    }

    private static class BaseballPlayer {
        private final String name;
        private final int points, atBats;
        private final float average;

        public BaseballPlayer(String name, int points, int atBats) {
            this.name = name;
            this.points = points;
            this.atBats = atBats;
            this.average = (float) points / atBats;
        }
    }
}
