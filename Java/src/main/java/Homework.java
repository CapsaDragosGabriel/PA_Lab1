import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static int CheckInput(String toCheck)
    {
        int err=0;
        int i=0;
        int j=1;
        for (i=0;i<toCheck.length()-1 && err==0 ;i++)
        {
            for (j=i+1;j<toCheck.length() && err==0;j++)
            {
                if(toCheck.charAt(i)==toCheck.charAt(j))
                    err=1;
                else if (toCheck.charAt(i)==' ')
                    err=2;
                else if (toCheck.charAt(j)==' ')
                    err=2;
            }
        }
    return err;
    }

    public static void main(String args[]) {

        Homework app = new Homework();
        Scanner myObj = new Scanner(System.in);

        System.out.println("n = ");
        int n = Integer.parseInt(myObj.nextLine());

        System.out.println("p = ");
        int p = Integer.parseInt(myObj.nextLine());

        System.out.println("alphabet = ");
        String str=myObj.nextLine();
        String[] arr=str.split("");

        /*System.out.println("");
        System.out.println("n="+n);
        System.out.println("p="+p);
        for(String character : arr)
            System.out.print(character+" ");
        */
        if (CheckInput(str)==1)
            System.out.println("The alphabet contains duplicates.");
        else if (CheckInput(str)==2)
            System.out.println("The alphabet contains whitespaces.");
        else{
           String[] words = new String[100];
           for (int i=0;i<n;i++)
           {words[i]=app.createRandomWord(p,str);}


           for (int i=0;i<n;i++)
            System.out.println(words[i]);
        }



       // char alphabet[] = {'A', 'C', 'G', 'T'};
      /*  String word = app.createRandomWord(7, alphabet);
        System.out.println(word);
*/


    }
    private String createRandomWord(int len, String alphabet) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();



        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alphabet.length());
            word.append(alphabet.charAt(k));
        }
        return word.toString();
    }

}
