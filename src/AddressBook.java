import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Zak on 2/26/2016.
 */
public class AddressBook extends JFrame {

    private JList people;
    private JPanel panel1;
    private JButton createButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton sortByZipButton;
    private JButton sortAZButton;
    private JButton sortZAButton;
    private JTextField textField1;
    private JButton searchButton;
    private JScrollPane mePane;
    private JButton refreshListButt;
    private JDialog createClassDialog;
    private DefaultListModel<String> model;

    public AddressBook() {
        model = new DefaultListModel<String>();
        model.addElement("fuck this");

        people.setModel(model);

        refreshListButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UpdateJList();
            }
        });

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

//        // TO DO: implement listener to open person's data when selected
//        people.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent listSelectionEvent) {
//
//            }
//        });
        // TO DO: implement listener to delete the selected person's data
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFrame frame = new JFrame();

                JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this contact?",
                        "Confirm Deletion",JOptionPane.WARNING_MESSAGE);

                //TO DO: Delete the selected contact in the list
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
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Frame creation
        JFrame frame = new JFrame("Address Book");

        // Frame properties
        frame.setContentPane(new AddressBook().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    //A, Generated listmodel to store string data from contacts (only testing names now):
    ArrayList<String> person = new ArrayList<String>();

    //A, Read the in method comments:
    private void UpdateJList(){
        addToList();

        //Populate it:
        for(String p : person){
            model.addElement(p.toString());
        }

        //Set the model for the JList and update GUI:
        mePane.revalidate();
    }

    //A, added test input to list:
    public void addToList() {
        person.add("dick cheney");

    }

    //A, saves the list to a "saveState.txt" file:
    public void saveListStat() throws IOException {
        FileWriter writer = new FileWriter("saveState.txt");
        for(String str: person) {
            writer.write(str);
        }
        writer.close();
    }

    //A, loads the saveState.txt file back into the list:
    public void loadList() throws FileNotFoundException {
        Scanner s = new Scanner(new File("saveState.txt"));
        while (s.hasNext()){
            person.add(s.nextLine());
        }
        s.close();
    }

    //A, this method searches the array list based on an input string and returns index of entries:
    public void searchList(){
        String searchMe = textField1.getText();
        int index = people.getNextMatch(searchMe,0, Position.Bias.Forward);
        if (index != -1)
            people.setSelectedValue(searchMe,true);
    }

    //A, this method gets the array values at the index given by the searchList method:
    public void getListVal(int idx){

    }

    // TO DO:
    public void sortAZ() {
        Collections.sort(person);
        for(String p : person){
            model.addElement(p.toString());
        }
        //Set the model for the JList and update GUI:
        people.updateUI();
    }

    // TO DO:
    public void sortZA() {
        Collections.reverse(person);
        for(String p : person){
            model.addElement(p.toString());
        }
        //Set the model for the JList and update GUI:
        people.updateUI();
    }

    // TO DO:
    public void sortZip() {
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        people = new JList();

        mePane = new JScrollPane(people);
    }

}
