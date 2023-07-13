package utility;

import pojo.board.BoardDetails;
import pojo.board.LabelNames;
import pojo.board.Preferences;

import java.lang.reflect.Field;
import java.util.Random;

public class TrelloDataGenerator {
    private static Random random = new Random();
    private static int boardNameLimit = 20;
    Class<LabelNames> boardBackgroundNames = LabelNames.class;
    Field[] fields = boardBackgroundNames.getDeclaredFields();

    public String generateName(int targetStringLength){
        int letterStart = 97;
        int letterLimit = 122;
        return random.ints(letterStart, letterLimit)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String generateRandomName(){
        return generateName(random.nextInt(boardNameLimit)+1);
    }

    public String generateTooLongName(){
        return generateName(random.nextInt(boardNameLimit)+16384);
    }

    public String generateRandomColor() {
        return fields[random.nextInt(7)+2].getName();
    }

    public BoardDetails generateRandomBoard(){
        Preferences prefs = new Preferences();
        prefs.background = generateRandomColor();
        return new BoardDetails(
                generateRandomName(),
                generateRandomName(),
                prefs);
    }

}
