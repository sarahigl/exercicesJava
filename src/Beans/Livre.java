package Beans;

import DB.SQLRequest;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Livre {
    private String titre;
    private String description;
    private String datePublication;
    private ArrayList<String> genre;
    private static ArrayList<Livre> collection = new ArrayList<>();

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public Livre(String titre, String description, String datePublication, ArrayList<String> genre) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.genre = genre;
    }

    public Livre() {
    }

    public static void main(String[] args) {
       menu();



    }
    static void add(){
        Scanner scanner = new Scanner(System.in);
        Livre livre1 = new Livre();
        try{
            System.out.println("entrez le titre de votre livre :");
            String titreLivre = scanner.next();

            ArrayList <String> genreLivre = new ArrayList<>();
            System.out.println("entrez 2 genres maximum liés à vôtre livre : ");
            System.out.println("genre 1 :");
            String genreLivre1 = scanner.next();
            System.out.println("genre 2 ? si oui tapez oui si non tapez non :");
            String moreGenre = scanner.next();
            if(moreGenre.equals("oui")){
                System.out.println("genre 2 :");
                String genreLivre2 = scanner.next();
                genreLivre.add(genreLivre1);
                genreLivre.add(genreLivre2);
            }else{
                genreLivre.add(genreLivre1);
            }

            System.out.println("entrez la description de votre livre :");
            String descriptionLivre = scanner.next();

            System.out.println("entrez la date de publication de votre livre :");
            String dateLivre = scanner.next();

            livre1.setTitre(titreLivre);
            livre1.setGenre(genreLivre);
            livre1.setDescription(descriptionLivre);
            livre1.setDatePublication(dateLivre);
            //locale add
            collection.add(livre1);
            //bdd add
            SQLRequest.addBook(livre1);
            System.out.println("Livre ajouté avec succès !");

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage() + "Mauvais type de données");
        }
    }
    static void remove(){
        Scanner scanner = new Scanner(System.in);
        collection = SQLRequest.getCollection();
        if(collection.isEmpty()){
            System.out.println("collection de livres vide");
        }
        findAll();
        try{
            System.out.println("entrez le n° du livre à supprimer:");
            int nbr = scanner.nextInt() -1;

            if(collection.get(nbr) != null){
                SQLRequest.deleteBook(collection.get(nbr));
                collection.remove(nbr);
            }else{
                System.out.println("livre non inclut dans la collection");
            }
            System.out.println("le livre "+ collection.get(nbr).getTitre() + "est supprimé");
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }
    static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Souhaitez vous taper une commande ? oui ou exit");
        String command2 = scanner.nextLine();
        while(command2.equals("oui")){

            System.out.println("entrez add, delete, all:");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    add();
                    break;
                case "delete":
                    remove();
                    break;
                case "all":
                    findAll();
                    break;
                default:
                    System.out.println("Tâpez une commande valable");
                    break;

            }
            System.out.println("Souhaitez vous taper une commande ? oui ou exit");
            command2 = scanner.nextLine();
        }

    }
    static void findAll(){
        collection = SQLRequest.getCollection();
        if(collection.isEmpty()){
            System.out.println("aucun livre");
        }
        try{
            Livre livreUnity = new Livre();
            for(int i=0; i<collection.size();i++){
                livreUnity = collection.get(i);

                System.out.println("N°" + (i+1) +
                        "- Titre: " + livreUnity.getTitre() +
                        "- Description: " + livreUnity.getTitre() +
                        "- Date De Publication: " + livreUnity.getDatePublication() +
                        "- Genres: " + livreUnity.getGenre());
            }

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

}
