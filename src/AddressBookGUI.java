import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Zak on 2/26/2016.
 */
public class AddressBookGUI extends JFrame{


    private JList people;
    private JPanel panel1;
    private JTextField search;
    private JButton createButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton sortByZipButton;
    private JButton sortAZButton;
    private JButton sortZAButton;
    private JDialog createClassDialog;

    public AddressBookGUI(){


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddContact contactForm = new AddContact();

            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EditContact editForm = new EditContact();
            }
        });

        // TO DO: implement listener to open person's data
        people.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {

            }
        });
    }

    public static void main(String[] args) {

        //  Sets the Nimbus look and feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddressBookGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddressBookGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddressBookGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AddressBookGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Creation
        JFrame frame = new JFrame("Address Book");

        // Frame properties
        frame.setContentPane(new AddressBookGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    }

   public void addToList(){

   }



}
