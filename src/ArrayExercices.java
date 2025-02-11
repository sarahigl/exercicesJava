import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayExercices {
    public static void main(String[] args) {
        int [] tab = {10,33,56,89,7,11,2,16} ;
//        min(tab);
//        max(tab);
//        average(tab);
//        averageScore();
        userValuesPosNeg();
    }
    public static void min(int []arr){
        if(arr.length>0){
            int resultMin = arr[0];
            for(int i=1; i<=arr.length-1; i++){
                if(resultMin>arr[i]){
                    resultMin = arr[i];
                }
            }
            System.out.println(resultMin);
        }else{
            System.out.println("Tableau ne contient pas assez de valeurs.");
        }
    }
    public static void max(int[] arr){
        if(arr.length>0){
            int result = arr[0];
            for(int i=0; i<=arr.length-1; i++){
                if(result<arr[i]){
                    result = arr[i];
                }
            }
            System.out.println(result);
        }else{
            System.out.println("Tableau ne contient pas assez de valeurs.");
        }
    }
    public static void average(int[] arr){
        if(arr.length>0){
            int result = 0;
            for(int i=0; i<arr.length; i++){
                result+=arr[i];
            }
            System.out.println("Average : "+result/(arr.length));
        }else{
            System.out.println("Tableau ne contient pas assez de valeurs.");
        }
    }
    public static void averageScore(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> notes = new ArrayList<>();
        try{
            System.out.println("Veuillez saisir des notes puis tapez exit :");
            int count =0;
            int sum = 0;
            while(scanner.hasNextInt()){
                count++;
                int note = scanner.nextInt();
                notes.add(note);
            }
            for(int value: notes){
                sum+=value;
            }
            System.out.println("Average : "+ (sum/count));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void userValuesPosNeg(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Veuillez saisir la taille de votre tableau :");
            int lengthArray = scanner.nextInt();
            int[] values = new int[lengthArray];
            int countPos = 0;
            int countNeg = 0;
            System.out.println("Veuillez saisir les valeurs du tableau :");
            for(int i=0; i<values.length;i++){
                int nbr = scanner.nextInt();
                values[i] = nbr;
                if(values[i]>=0){
                    countPos++;
                }else{
                    countNeg++;
                }
            }
            System.out.println("positives values : "+countPos+", negative values : "+countNeg);
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }
}
