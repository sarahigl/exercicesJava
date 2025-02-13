import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card extends JDialog{
    private JPanel jpCard;
    private JPanel jpBook;
    private JPanel jpList;
    private JButton btQuitter;
    private JButton btCo;
    private JButton btForm;

    public Card(JDialog parent) {
        super(parent);
        setTitle("Mon Menu");
        jpCard = new JPanel(new CardLayout());
        // Initialiser les panneaux (assurez-vous que ces panneaux sont définis dans votre fichier .form)
        jpBook = new JPanel(new GridBagLayout());
        jpList = new JPanel(new BorderLayout());

        // Ajouter les panneaux au conteneur principal
        jpCard.add(jpBook, "Form");
        jpCard.add(jpList, "List");

        setContentPane(jpCard);
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setVisible(true);

        btForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) jpCard.getLayout();
                cardLayout.show(jpCard, "Form");
            }
        });
    }
}
