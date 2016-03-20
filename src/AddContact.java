import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Zak on 2/26/2016.
 */
public class AddContact extends JFrame implements Runnable
{
    private JLabel titleLabel;
    private JTextField firstNameField;
    private JTextField addressField;
    private JTextField zipField;
    private JTextField lastNameField;
    private JLabel stateLabel;
    private JPanel contactPane;
    private JComboBox stateSelecter;
    private JFormattedTextField phoneField;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel zipLabel;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JButton cancelButton;
    private JButton saveButton;
    private JLabel cityLabel;
    private JTextField cityField;
    private JScrollPane mePane;

    private String first, last, address, city, state, zipCode, phone;

    String[] contactArray;
    Person person;
    DefaultListModel<String> model;

    private ArrayList<Person> listPerson = new ArrayList<>();


    public AddContact(DefaultListModel<String> model, JScrollPane mePane)
    {
        this.model = model;
        this.mePane = mePane;

    }



    public void UpdateJList(String first, String last, String address, String city, String state, String zipCode, String phone)
    {
        addToList(first, last, address, city, state, zipCode, phone);

        //Populate it:
        for (Person p : listPerson)
        {
            model.addElement(p.toString());
        }

        //Set the model for the JList and update GUI:
        mePane.revalidate();
        mePane.repaint();
    }

    // TODO: bold variables with string format
    private void addToList(String first, String last, String address, String city, String state, String zipCode, String phone)
    {
        //  listPerson.add(first + "     " + last + "     " + address + "     " + city + "     " + state + "     " + zipCode + "     " + phone);
        listPerson.add(new Person(first, last, address, city, state, zipCode, phone));
//        for(String contact : listPerson)
//        {
//            contactArray = contact.trim().split("\\s+");
//            for (String item : contactArray)
//            {
//                System.out.println("checking "+ item);
//            }
//        }
    }

    @Override
    public void run()
    {
        final JFrame contactForm = new JFrame();

        // Set Attributes
        contactForm.setTitle("Add New Contact");
        contactForm.setContentPane(contactPane);
        contactForm.setVisible(true);
        contactForm.pack();
        contactForm.setSize(400, 350);
        contactForm.setLocationRelativeTo(null);
        contactForm.setResizable(false);


        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                contactForm.dispose();
            }
        });

        // Z, Save button
        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                first = firstNameField.getText();
                last = lastNameField.getText();
                address = addressField.getText();
                city = cityField.getText();
                state = stateSelecter.getSelectedItem().toString();
                zipCode = zipField.getText();
                phone = phoneField.getText();
                city = cityField.getText();


                //person = new Person(first, last, address, state, city, zipCode, phone);

                File file = new File("Contacts.txt");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
                    out.write(String.format("%-15s", first));
                    out.write(String.format("%-15s", last));
                    out.write(String.format("%-15s", address));
                    out.write(String.format("%-15s", city));
                    out.write(String.format("%-15s", state));
                    out.write(String.format("%-15s", zipCode));
                    out.write(String.format("%-15s", phone));
                    out.newLine();
                    out.close();
                    //@@@@@@@@@@@@@@@@@@@@@ Add these fields to the JList @@@@@@@@@@@@@@@@@@@@@@@@@@
                    contactForm.dispose();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                UpdateJList(first, last, address, city, state, zipCode, phone);

            }
        });
    }


}
