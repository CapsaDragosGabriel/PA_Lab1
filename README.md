# PA_Lab1
Primul laborator

-afisez "Hello World!".

-declar un array de stringuri denumit languages care contine : {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}

-am declarat un numar n aleator

  -numarul respectiv a fost inmultit cu 3
  
  -am adaugat nr binar 10101 (l-am convertit mai intai in zecimal)
  
  -am adaugat nr hex FF (l-am convertit in zecimal)
  
  -am multiplicat rezultatul cu 6
  
-am facut suma cifrelor in mod repetat pana cand am obtinut un numar dintr-o cifra 

-am afisat pe ecran mesajul :"Willy-nilly, this semester I will learn " si am afisat languages[] de numarul respectiv

Homework:


-am realizat functia CheckInput pentru a valida arguments ( sa nu se repete literele din multime )

-am preluat functia createRandomWord de pe slide-uri

-am creat functia Neighbours pentru a crea matricea de adiacenta: -merg din litera in litera, si din cuvant in cuvant, iar daca gasesc litera din primul cuvant in al doilea adaug ambele  pozitii ale cuvintelor la matricea de adiacente

-am creat tipul de date List care contine word= denumirea cuvantului, neighbours= vecinii cuvantului si number=numerul vecinilor

-pentru a crea listele de adiacenta am folosit matricea creata anterior. Aceasta functie are parametrul doPrint pe care-l putem modifica daca este nevoie

Bonus:

-am incercat o parcurgere dfs pe matricea de adiacenta booleana

-plec din fiecare nod si tin minte secventa vizitata

-dupa ce nu mai pot vizita niciun nod ma duc in nodul cel mai mare si verific daca-l pot vizita pe primul

-daca da, salvez noul maxim

-programul ar mai putea fi optimizat evitand parcurgeri dfs echivalente
de ex, daca am parcurs 0 1 2 sa nu parcurg si 1 2 0

