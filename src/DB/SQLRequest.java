package DB;
import Beans.Livre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SQLRequest {

    static final String DB_URL =
            "jdbc:mysql://localhost/Bibliotheque?serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    //Connexion à la BDD
    private static Connection connexion;
    static {
        try {
            connexion = DriverManager.getConnection(DB_URL, USERNAME,
                    PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void main() {

    }
    public static Livre addBook(Livre livre) {
        //instancier un Objet null
        Livre livreAdd= null;
        /*
         try (PreparedStatement statement = dbConnection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();){
             EN AJOUTANT CE TYPE DE PARAM DANS LE TRY CA OPTIMISE LE STOCKAGE CAR AUTOMATIQUEMENT ILS SONT CLOSED A LA FIN
         */
        try{
            //Connection à la BDD...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "INSERT INTO livre (titre, description, date_publication, genre) " + "VALUES (?, ?, ?, ?)"; //autant de point d'interrogation que de données a enregistrer
            //Préparation de la requête
            PreparedStatement preparedStatement =
                    connexion.prepareStatement(sql);
            //Bind des paramètres
            preparedStatement.setString(1, livre.getTitre()); //le chiffre correspond à son emplacement dans le insert
            preparedStatement.setString(2, livre.getDescription());
            preparedStatement.setString(3, livre.getDatePublication());
            String genreString = "";
            for (String unGenre: livre.getGenre()){
                genreString += unGenre + ",";
            }
            preparedStatement.setString(4, genreString);

            //Exécution de la requête
            int addedRows = preparedStatement.executeUpdate(); //dans la plus part des cas on utilise executeUpdate sauf si on fais un SELECT => executeQuery
            //test si l'enregistrement est ok
            if (addedRows > 0) {
                //Création d'un Objet User
                livreAdd = new Livre();
                livreAdd.setTitre(livre.getTitre());
                livreAdd.setDescription(livre.getDescription());
                livreAdd.setDatePublication(livre.getDatePublication());
                livreAdd.setGenre(livre.getGenre());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //Retourne un Objet User
        return livreAdd;
    }

    public static ArrayList<Livre> getCollection(){
        ArrayList<Livre> collection = new ArrayList<>();
        Livre livreGet = null;
        try{
            // Connection à la BDD ...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "SELECT titre, description, date_publication, genre FROM livre";
            //Préparation de la requête
            PreparedStatement preparedStatement =
                    connexion.prepareStatement(sql);
            //Bind des paramètres
            ResultSet rs = preparedStatement.executeQuery();
            //Parcours du résultat
            while(rs.next()){
                //Si la réponse est différente de null
                if (rs.getString(1)!= null){
                    livreGet = new Livre();
                    livreGet.setTitre(rs.getString("titre"));
                    livreGet.setDescription(rs.getString("description"));
                    livreGet.setDatePublication(rs.getString("date_publication"));

                    String[] genresList = rs.getString("genre").split(Pattern.quote("."));
                    ArrayList<String> genreArrayList = new ArrayList<>();
                    for(String genre : genresList){
                        genreArrayList.add(genre);
                    }
                    livreGet.setGenre(genreArrayList);
                    collection.add(livreGet);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//retourne un objet
        return collection;
    }
    public static boolean deleteBook(Livre livre){
        Livre livreDel = null;
        boolean deleted = false;
        try{
            // Connection à la BDD ...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "DELETE FROM livre WHERE titre=?";
            //Préparation de la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);
            //Bind des paramètres
            preparedStatement.setString(1, livre.getTitre());
            //execute req
            int deletedRows = preparedStatement.executeUpdate();
            // réussie ?
            if (deletedRows > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }
    //suppression réussie mais erreur index Out of bound.. pourquoi ?
}




