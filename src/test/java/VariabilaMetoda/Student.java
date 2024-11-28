package VariabilaMetoda;

import com.google.common.annotations.VisibleForTesting;
import org.testng.annotations.Test;

public class Student {

    //clasa = sablon care defineste proprietatile si comportamentul unei entitati specifice (Student)
    //intr un fisier java putem avea mai multe casediferentiate pe baza numelui(nu este un practice bun sa avem mai multe clase cu acelasi nume
    //intr o clasa putem defini proprietatile si actiunile aentitatii (in cazul nostru a clasei Student)
    //variabila=proprietatea uuni clase
    //variabilele pot sa fie de 2 feluri: globale si locale
    //variabele globale=sunt vizibile peste tot in proiect
    //variabile locale=sunt locale doar in locul unde sunt declarate
    //ca sa definim o variabila globala: accessControl(public), tipul variabilei, numele variabilei
    //in momentul cand definim o variabila nu este obligatoriu sa ii dam o valoare

    //metoda = actiunea unei clase
    //exista 2 tipuri de metode: void si return

    public String Nume;

    public String Prenume;

    public Integer Varsta;

    public String Adresa;

    public Double Inaltime;

    public Float Greutate;

    public Character Sex;

    public Boolean AreDiploma;



    @Test
    public void prezentareStudent(){
        Nume="Negrea";
        Prenume="Cristian";
        Varsta=31;
        Adresa="Cluj-Napoca";
        Inaltime=1.90;
        Greutate=89.0f;
        Sex='M';
        AreDiploma=true;

        //System.out.println(Nume+" "+Prenume+" "+Varsta+" "+Adresa);
        //System.out.println(Inaltime);
        System.out.println("Numele studentului este: "+Nume);
        System.out.println("Prenumele studentului este: "+Prenume);
        System.out.println("Varsta studentului este: "+Varsta);
        System.out.println("Adresa studentului este: "+Adresa);
        System.out.println("Greutatea studentului este: "+Greutate);
        System.out.println("Sexul studentului este: "+Sex);
        System.out.println("Are diploma studentul? "+AreDiploma);

        calculMedie();



    }

    public void calculMedie(){
        Integer nota1=8;
        Integer nota2=7;
        Integer nota3=9;
        Integer medie=(nota1+nota2+nota3)/3;
        System.out.println("Media studentului este: "+medie);
    }

}
