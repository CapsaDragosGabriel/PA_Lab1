import java.util.Random;

public class Homework {
    public static void main(String args[]) {
        Homework app = new Homework();
        char alphabet[] = {'A', 'C', 'G', 'T'};
        String word = app.createRandomWord(7, alphabet);
        System.out.println(word);
    }
    private String createRandomWord(int len, char[] alphabet) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alphabet.length);
            word.append(alphabet[k]);
        }
        return word.toString();
    }

}
