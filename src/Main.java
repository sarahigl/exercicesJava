import Beans.Livre;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static double nbr1;

    public static void main(String[] args) {
        //Scanner scanner1 = new Scanner(System.in);
        //scannerCarre(scanner1);
        //scannerSomme(scanner1);
        //scannerAverage(scanner1);
        //scannerTTCPrice(scanner1);
        //scannerCalculator(scanner1);

//        System.out.println(livre.getTitre());
        //Card cardmenu = new Card(null);
        //ListBooks list = new ListBooks(null);
        Book bookForm = new Book(null);
    }

    public static void scannerCarre(Scanner scanner1){
        try {
            System.out.println("Veuillez saisir un nombre:");
            int number = scanner1.nextInt();
            System.out.println(" Le résultat est : " + number*number);
        } catch (InputMismatchException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    public static void scannerSomme(Scanner scanner1){
        System.out.println("Veuillez saisir 2 nombre:");
        int number1 = scanner1.nextInt();
        int number2 = scanner1.nextInt();
        System.out.println(" Le résultat est : " + (number1+number2));
    }
    public static void scannerAverage(Scanner scanner1){
        System.out.println("Veuillez saisir 3 nombre:");
        int number1 = scanner1.nextInt();
        int number2 = scanner1.nextInt();
        int number3 = scanner1.nextInt();
        System.out.println(" Le résultat est : " + (number1+number2+number3)/3);
    }
    public static void scannerTTCPrice(Scanner scanner1){
        System.out.println("Veuillez saisir le prix TTC de votre article :");
        double priceHT = scanner1.nextDouble();
        System.out.println("Veuillez saisir la quantité d’articles :");
        int quantity = scanner1.nextInt();
        System.out.println("Veuillez saisir le taux de TVA :");
        double tvaAmount = scanner1.nextDouble();
        System.out.println("Le prix TTC totale est de : " + (priceHT*quantity)*(1+(tvaAmount/100.0)));
        System.out.println("priceHT = " + priceHT);
        System.out.println("quantity = " + quantity);
        System.out.println("tvaAmount = " + tvaAmount);
    }

    public static void scannerCalculator(Scanner scanner1){
        try{
            //l'ordre des scanners influ sur operator : oparator au millieu ou en dernier ne renvoie rien
            // lorsqu'il est en premier la valeur de la string est bien prix en compte
            System.out.println("Veuillez entrer un opérateur : * - / ou + ");
            String operator = scanner1.nextLine();
            System.out.println("Veuillez saisir un nombre :");
            double nbr1 = scanner1.nextDouble();
            System.out.println("Veuillez saisir un nombre :");
            double nbr2 = scanner1.nextDouble();

            switch (operator){
                case "+":
                    System.out.println("Addition :"+(nbr1+nbr2));
                    break;
                case "-":
                    System.out.println("Soustraction: "+ (nbr1-nbr2));
                    break;
                case "/":
                    System.out.println("division: "+ (nbr1/nbr2));
                    break;
                case "*":
                    if(nbr1>0 && nbr2 >0){
                        System.out.println("multiplication" + (nbr1*nbr2));
                        break;
                    }else{
                        System.out.println("Impossible de multiplier des nombre négatif");
                        break;
                    }
                default:
                    System.out.println("Veuillez n'avez pas saisis d'operateur correct");

            }

        } catch (InputMismatchException e) {
            System.out.println("Mauvais format "+e.getMessage());
            scanner1.nextLine(); //nettoyage
        }
    }
    //    public static void useScanner(){
//        Scanner scanner1 = new Scanner(System.in);
//        String prenom = scanner1.nextLine();
//        System.out.println(" Le prénom saisi est : " +prenom);
//    }

    public static int somme(int i, int j){
        //System.out.println(i+j);
        return (i+j);
    }

    public static int soustraction(int i, int j, int k){
        //System.out.println((i-j) - k);
        return (i-j) - k;
    }

    public static int moyenne(int i, int j, int k, int l){
        return(i+j+k+l/4);
    }

    public static void intervert(int i, int j){

        System.out.println( j + " " + i);
    }
    //immuable length dont change but you can change values

    int [] nombres = new int[10];
    public static void exempleArray(){
        int [] tableau = {5, 34, 89, 0};
        int copie [] = tableau.clone();
        tableau[6] = 45;
        System.out.println(copie + " " + tableau);
    }


}
