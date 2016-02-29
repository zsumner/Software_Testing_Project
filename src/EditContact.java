import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Zak on 2/26/2016.
 */
public class EditContact extends JFrame {
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


    public EditContact(){

        // Create JFrame
        final JFrame contactForm = new JFrame();

        // Set Attributes
        contactForm.setTitle("Edit Contact");
        contactForm.setContentPane(contactPane);
        contactForm.setVisible(true);
        contactForm.pack();
        contactForm.setSize(400,350);
        contactForm.setLocationRelativeTo(null);
        contactForm.setResizable(false);


        // Close window -- CANCEL BUTTON
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contactForm.dispose();
            }
        });
    }



}
