package ScoreBoard;

import java.util.Arrays;

public class ScoreBoard {
    int numEntries = 0;
    public GameEntry[] entries;

    public ScoreBoard(int numEntries){
        entries = new GameEntry[numEntries];
    }

    // Add the high score entry in the Game entry array
    public void add(GameEntry entry){
        int newScore = entry.getScore();
        if(numEntries < entries.length || entries[numEntries-1].getScore() < newScore ){
            if(numEntries < entries.length){ // if the total number of entries is less than the total score board
                numEntries++;                // increment the entries
            }

            int i = numEntries - 1; // starting from end and comparing the values
            // looping to find the correct location in our score board
            while( i > 0 && entries[i-1].getScore() < newScore){
                entries[i] = entries[i-1]; // shifting elements to the right
                i--;
            }
            entries[i] = entry;
        }
    }

    // Remove a score entry from the Score Board
    public GameEntry remove(int index) throws IndexOutOfBoundsException{
        // for invalid syntax throw IndexOutOfBoundsException
        if(index < 0 || index > numEntries -1){
            throw new IndexOutOfBoundsException();
        }

        GameEntry entry = entries[index];
        while(index < numEntries-1){
            entries[index] = entries[index+1]; // left shift elements to fill the removed record space
            index++;
        }
        entries[numEntries-1] = null;
        numEntries--;
        return entry;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "numEntries=" + numEntries +
                ", entries=" + Arrays.toString(entries) +
                '}';
    }

    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard(10);
        scoreBoard.add(new GameEntry("BoomBoom", 100));
        System.out.println(scoreBoard);
        scoreBoard.remove(0);
        System.out.println(scoreBoard);
        for(int i = 1; i< 10; i++){
            scoreBoard.add(new GameEntry(String.valueOf(i), i*10));
        }
        System.out.println(scoreBoard);
        scoreBoard.remove(13);
    }

}
