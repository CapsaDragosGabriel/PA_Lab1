import java.util.*;

import java.util.Scanner;

public class Homework {
    static int k=0;
    static int maxi=0;
    private static class List
    {
       public String word;

        //altfel nu mergea, imi dadea nullpointer exception, cred ca ar fi trebuit sa folosesc StringBuilder
        //dar mi-a fost mai usor asa
        public String[] neighbours = {"NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL"};
        public int number=0;
    }
    public static void printList(List listToPrint)//pentru afisarea structurii de date
    {

        System.out.print("The word "+listToPrint.word+" has "
                +listToPrint.number+" neighbours: ");
        for (int i=0;i< listToPrint.number;i++)
        {
            System.out.print(listToPrint.neighbours[i]+" ");
        }
        System.out.println();
        //System.out.println();
    }
    public static int CheckInput(char[] toCheck)//pentru validarea inputului
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

    public static void Neighbours(int n,int p,String[] words,boolean adjMatrix[][]){//pentru matricea de adiacenta
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
    public static void FillList(int n,String[] words, boolean adjMatrix[][],boolean doPrint)
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
        if(doPrint==true)printList(adjList);
        }

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
    static void dfs(int start,boolean adjMatrix[][], boolean[] visited)
    {
        // Print the current node
        System.out.print(start + " ");
        k++;
        // Set current node as visited
        visited[start] = true;

        // For every node of the graph
        for (int i = 0; i < adjMatrix[start].length; i++) {

            // If some node is adjacent to the current node
            // and it has not already been visited
            if (adjMatrix[start][i] == true && (!visited[i])) {
                dfs(i,adjMatrix, visited);
            }
        }
    }
    static int maxEdges(boolean adjMatrix[][],int n)
    {
        int res=0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if (visited[i]==false)
            {
                dfs(i,adjMatrix, visited);
                if (maxi<k && adjMatrix[i][n-1]==true && k>=3 ) maxi=k;

                k=0;
            }
        }
        return maxi;
    }
    public static void main(String args[]) {
        long startTime = System.nanoTime();
        Homework app = new Homework();
        if (args.length < 3) {//verificam sa fie cel putin 3 argumente
            System.out.println(
                    "Usage: number, number, one or more characters");
            System.exit(-1);
        }
        int n=0,p=0,m=0;
        try {
            n = Integer.parseInt(args[0]);
            p = Integer.parseInt(args[1]);
            m = args.length - 2;
        }
        catch  (Exception e)
        {
            System.out.println("N and P are supposed to be integers");
        }
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
//the boolean matrix
          /*  for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++)
                System.out.print(adjMatrix[i][j]+" ");
                System.out.println();
            }*/
           for (int i=0;i<n;i++)
                System.out.print(words[i]+" ");
            System.out.println();
            //true daca dorim sa afisam structurile, false in caz contrar
            FillList(n,words,adjMatrix,true);
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;

            System.out.println("Execution time in nanoseconds: " + timeElapsed);
            System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
            boolean[] visited= new boolean[n];
            maxEdges(adjMatrix,n);
           // dfs(0,adjMatrix,visited);
            System.out.println("The largest possible k is " + maxi);
        }

    }
}
