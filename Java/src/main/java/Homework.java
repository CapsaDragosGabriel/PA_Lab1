
import java.util.Random;
import java.util.Scanner;

public class Homework {
    private static class List
    {
       public String word;
      // public StringBuilder[] neighbours;
        public String[] neighbours = {"NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL"};
        public int number=0;
    }
    public static void printList(List listToPrint)
    {
        System.out.println();
        System.out.print("The word "+listToPrint.word+" has "
                +listToPrint.number+" neighbours: ");
        for (int i=0;i< listToPrint.number;i++)
        {
            System.out.print(listToPrint.neighbours[i]+" ");
        }
        //System.out.println();
    }
    public static int CheckInput(char[] toCheck)
    {
        int err=0;
        int i=0;
        int j=1;
        for (i=0;i<toCheck.length-1 && err==0 ;i++)
        {
            for (j=i+1;j<toCheck.length && err==0;j++)
            {
                if(toCheck[i]==toCheck[j])
                    err=1;
            }
        }
    return err;
    }

    public static void Neighbours(int n,int p,String[] words,boolean adjMatrix[][]){
        boolean nbrs=false;

        for (int i=0;i<n;i++) {
            for (int j = i; j < n; j++) {
                nbrs=false;
                for (int k=0;k<p;k++)
                {
                    if(words[j].indexOf(words[i].charAt(k))!=-1)
                        //indexOf cauta un caracter si returneaza pozitia lui,-1 daca nu-l gaseste
                        nbrs=true;
                }

                adjMatrix[i][j]=nbrs;
                adjMatrix[j][i]=nbrs;
            }
        }
    }
    public static void FillList(int n,String[] words, boolean adjMatrix[][])
    {
       int i,j;

        for (i=0;i<n;i++)
        { List adjList= new List();
           adjList.word=words[i];
            for (j=0;j<n;j++)
            {
                if (adjMatrix[i][j]==true && i!=j)
                {
                    adjList.neighbours[adjList.number]=words[j];
                   adjList.number++;
                }
            }
        printList(adjList);
        }
        /*for (int i = 0; i < n; i++) {
            List myList = new List();
            myList.word = words[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == true && i != j) {
                    myList.neighbours[count] = words[j];
                    count++;
                }
            }
            System.out.print(myList.word + ": ");
            for (int j = 0; j < count; j++) {
                System.out.print(myList.neighbours[j] + " ");
            }
            System.out.println();
        }*/
    }
    public static void main(String args[]) {
        long startTime = System.nanoTime();
        Homework app = new Homework();
        if (args.length < 3) {
            System.out.println(
                    "Usage: number, number, one or more characters");
            System.exit(-1);
        }
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char alphabet[] = new char[m];
        for(int i=0; i<m; i++) {
            alphabet[i] = args[i + 2].charAt(0);
        }
        if (CheckInput(alphabet)==1)
            System.out.println("The alphabet contains duplicates.");
        else
        {
            String[] words = new String[n];
            for (int i=0;i<n;i++)//creates n words with random p letters
            {words[i]=app.createRandomWord(p,alphabet);}

            boolean[][] adjMatrix=new boolean[n][n];

           Neighbours(n,p,words,adjMatrix);

            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++)
                System.out.print(adjMatrix[i][j]+" ");
                System.out.println();
            }
            for (int i=0;i<n;i++)
                System.out.print(words[i]+" ");


            FillList(n,words,adjMatrix);
            

         //   printList(List[0]);
            //System.out.println(alphabet);
        }
        /*Homework app = new Homework();
        Scanner myObj = new Scanner(System.in);

        System.out.println("n = ");
        int n = Integer.parseInt(myObj.nextLine());

        System.out.println("p = ");
        int p = Integer.parseInt(myObj.nextLine());

        System.out.println("alphabet = ");
        String str=myObj.nextLine();
        String[] arr=str.split("");

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
*/

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
    /*private String createRandomWord(int len, String alphabet) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();



        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alphabet.length());
            word.append(alphabet.charAt(k));
        }
        return word.toString();
    }
*/
}
