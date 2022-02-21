import java.sql.SQLOutput;

public class firstclass {


    public static void main(String[] args) {
        System.out.println("Hello world");
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n=n*3;
        System.out.println(n);

        String binaryString="1010";
        int decimal=Integer.parseInt(binaryString,2);
        System.out.println("Numarul 1010 in binar este:");
        System.out.println(decimal);

        n=n+decimal;
        System.out.println("Numarul n+numarul binar este:");
        System.out.println(n);

        String hex="FF";
        decimal=Integer.parseInt(hex,16);
        System.out.println("Numarul FF hexadecimal este:");
        System.out.println(decimal);

        System.out.println("Numarul n+FF este:");
        n=n+decimal;
        System.out.println(n);

        System.out.println("Numarul final este:");
        n=n*6;
        System.out.println(n);
    }
}

