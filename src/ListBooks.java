import Beans.Livre;
import DB.SQLRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListBooks extends JDialog {
    private JPanel jpList;
    private JButton btBack;
    private JLabel jpTitle;
    private JButton btList;
    private JList jlListBooks;

    public ListBooks(JDialog parent) {
        super(parent);
        setTitle("Liste de Livres");
        setContentPane(jpList);
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800, 600));
        setModal(false);
        setVisible(true);
        btBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getBooks();
            }
        });
    }

    public void getBooks(){
        List<Livre> livres = SQLRequest.getCollection();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Livre livre : livres) {
            listModel.addElement(livre.getTitre());
        }
        jlListBooks.setModel(listModel);
    }
}
