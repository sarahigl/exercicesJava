import Beans.Livre;
import DB.SQLRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Book extends JDialog {
    private JPanel jpBook;
    private JLabel jlName;
    private JTextField tfName;
    private JTextField tfDescription;
    private JLabel jlCommand;
    private JButton btAdd;
    private JButton btClose;
    private JTextField tfGenre;
    private JLabel jlDescription;
    private JLabel jlGenre;
    private JLabel jlBookName;
    private JTextField tfDate;
    private JLabel jlDate;



    public Book(JDialog parent) {
        super(parent);
        setTitle("Mon formulaire");
        //assigner le conteneur de la fenetre
        setContentPane(jpBook);
        //indique la hauteur et largeur de la fenetre si 1 des deux cela permet de redimenssionner
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800, 600));
        //choisir si la window va etre par dessus les autres
        setModal(false); //pas en Jframe
        //propiéré de visibilité ou non
        setVisible(true);//par ex pour cacher une fenetre mais avoir les donnees
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        });

    }
    public void addBook() {
        // Récupérer les valeurs des champs de texte
        String titre = tfName.getText();
        String description = tfDescription.getText();
        String datePublication = tfDate.getText();
        String genres = tfGenre.getText();

        // Convertir la chaîne de genres en une liste
        ArrayList<String> genreLivre = new ArrayList<>();

        // Créer une instance de Livre
        Livre livre = new Livre();
        livre.setTitre(titre);
        livre.setDescription(description);
        livre.setDatePublication(datePublication);
        livre.setGenre(genreLivre);

        // Ajouter le livre à la base de données
        SQLRequest.addBook(livre);

        // Afficher un message de confirmation
        JOptionPane.showMessageDialog(this, "Livre ajouté avec succès !");
    }




    public void onClose(){
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JTextField getTfName() {
        return tfName;
    }

    public void setTfName(JTextField tfName) {
        this.tfName = tfName;
    }
}

