import org.junit.Test;
import org.omg.SendingContext.RunTime;

import javax.swing.*;
import static org.junit.Assert.*;

/**
 * Created by Zak on 3/3/2016.
 */
public class AddressBookTest {

    @Test
    public void testAddToList() throws Exception {
        Person person = new Person("bob", "evans", "", "", "", "", "");
        DefaultListModel list = new DefaultListModel();
        list.addElement(person);
        assertEquals(person, list.getElementAt(0));
    }

    @Test(expected = RuntimeException.class)
    public void testSortAZ(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testSortZA()  {
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testSortZip()  {
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testSearchButton()  {
        throw new RuntimeException();
    }


    @Test
    public void testCreateContactForm() throws Exception {
        JButton createButton = new JButton();
        AddressBook addressBook = new AddressBook();

        createButton.doClick();
        assertEquals("",addressBook.getTitle());
    }


    @Test
    public void testEditContactForm() throws Exception {
        JButton editButton = new JButton();
        AddressBook addressBook = new AddressBook();

        editButton.doClick();
        assertEquals("",addressBook.getTitle());
    }

    @Test
    public void testDeleteDialog() throws Exception {
        JButton deleteButton = new JButton();
        AddressBook addressBook = new AddressBook();

        deleteButton.doClick();
        assertEquals("",addressBook.getTitle());
    }



    @Test(expected = RuntimeException.class)
    public void testSaveListStat() {
       throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testLoadList() {
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testSearchList() {
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testGetListVal(){
        throw new RuntimeException();
    }
}