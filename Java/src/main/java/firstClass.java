import javax.lang.model.type.DeclaredType;

public class firstClass {

    public static void sayHello() {
        System.out.println("Hello world");
    }
    
    public static void declareArray() {
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        sayHello();
        declareArray();
     //   String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n=n*3;
        System.out.println(n);

        String binaryString="10101";
        int decimal=Integer.parseInt(binaryString,2);
        System.out.println("Numarul 10101 in binar este:");
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

        int suma=0;
        while(n>0)
        {
            suma=n%10+suma;
            n/=10;
            if (suma<=9) {n=suma; break;}
            else n=suma;
        }
        System.out.println(n);

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}
