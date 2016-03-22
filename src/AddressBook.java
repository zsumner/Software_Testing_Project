import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.*;
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
public class AddressBook extends JFrame implements Printable {

    private JList<String> people;
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
    private JDialog createClassDialog;
    private DefaultListModel<String> model;
    public static JFrame frame;
    static JMenuBar menuBar;
    static JMenu menu;
    static JMenuItem printButton;
    static JMenuItem saveButton;
    private int start = 0;

    private ArrayList<String> person = new ArrayList<>();

    AddressBook() {

        model = new DefaultListModel<>();
        people.setModel(model);


        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                PrinterJob job = PrinterJob.getPrinterJob();
                PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
                PageFormat pf = job.pageDialog(aset);
                job.setPrintable(new AddressBook(), pf);
                boolean ok = job.printDialog(aset);
                if (ok) {
                    try {
                        job.print(aset);
                    } catch (PrinterException ex) {
             /* The job did not successfully complete */
                    }
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveDialog();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddContact contactForm = new AddContact(model, mePane);
                contactForm.run();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EditContact editForm = new EditContact();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                searchList();
            }
        });

        // TO DO: implement listener to delete the selected person's data
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedIndex = people.getSelectedIndex();
                JFrame frame = new JFrame();

                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this contact?",
                        "Confirm Deletion", JOptionPane.WARNING_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    System.out.println(selectedIndex);
                    if (selectedIndex != -1) {
                        ((DefaultListModel) people.getModel()).remove(selectedIndex);
                        System.out.println("hello");
                    }
                }


            }
        });

        sortAZButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToList(start);
                sortAZ();
                start = model.getSize();
            }
        });

        sortZAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addToList(start);
                sortZA();
                start = model.getSize();
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
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }




        // Frame creation
        frame = new JFrame("Address Book");


        // Frame properties
        frame.setJMenuBar(createMenuBar());
       frame.setContentPane(new AddressBook().panel1);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    }

    //Z, create menu bar that includes print option
    public static JMenuBar createMenuBar(){
        //Create the menuBar
        menuBar = new JMenuBar();

        //Build the first menu
        menu = new JMenu("File");
        printButton = new JMenuItem("Print");
        //Add print menu option
        menu.add(printButton);
        //Add save menu option
        saveButton = new JMenuItem("Save List");
        menu.add(saveButton);
        menuBar.add(menu);



        return menuBar;
    }

    //A, Read the in method comments:
    public void UpdateJList(String first, String last){
        addToList(1);

        //Populate it:
        for(String p : person){
            model.addElement(p);
        }

        //Set the model for the JList and update GUI:
        mePane.revalidate();
        mePane.repaint();
    }

    //A, added test input to list:
    private void addToList(int start) {
        //Populate it:
        for(int i = start; i < model.getSize(); i++){
            person.add(model.getElementAt(i));
        }
        model.clear();

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
        if(index != -1) {
            textField1.setText(people.getModel().getElementAt(index));
        }
        else{
            textField1.setText("No Results Found...");
        }
    }

    //A, this method gets the array values at the index given by the searchList method:
    public void getListVal(int idx){

    }

    // TO DO: Sort contact alphabetically
    public void sortAZ() {
        model.clear();
        Collections.sort(person);
        for(String p : person){
            model.addElement(p);
        }
        //Set the model for the JList and update GUI:
        people.revalidate();
        mePane.revalidate();
        mePane.repaint();
    }

    // TO DO: Sort contact alphabetically reverse
    public void sortZA() {
        model.clear();
        Collections.reverse(person);
        for(String p : person){
            model.addElement(p);
        }
        //Set the model for the JList and update GUI:
        people.revalidate();
        mePane.revalidate();
        mePane.repaint();
    }

    // TO DO: Sort contact by zipcode numerical order
    public void sortZip() {
    }

    // Z, used to verify the user to save current state of the program
    public void saveDialog(){
        int confirmed = JOptionPane.showConfirmDialog(frame, "Would you like to save your contacts?", "Save",
                JOptionPane.YES_NO_OPTION);

        if(confirmed == JOptionPane.YES_OPTION){
           JOptionPane.showMessageDialog(frame, "Contacts saved!", "Success!" ,JOptionPane.INFORMATION_MESSAGE);

        }
    }


    public int print(Graphics g, PageFormat pf, int page) throws
            PrinterException {

        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Now we perform our rendering */
        g.drawString("Test the print dialog!", 100, 100);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        people = new JList<String>();

        mePane = new JScrollPane(people);
    }

}
