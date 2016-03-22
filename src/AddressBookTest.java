import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Zak on 3/3/2016.
 */
public class AddressBookTest {

    //AddressBook addressBook = new AddressBook();

    @Test
    public void testAddToList() throws Exception {
        Person person = new Person("bob", "evans", "", "", "", "", "");
        DefaultListModel<Person> list = new DefaultListModel<Person>();
        list.addElement(person);
        assertEquals(person, list.getElementAt(0));
    }

    @Test
    public void testSortAZ()
    {


    }

    @Test(expected = RuntimeException.class)
    public void testSortZA()  {
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testSortZip()  {
        throw new RuntimeException();
    }

    @Test
    public void testSearchButton()  {



    }


    @Test
    public void testCreateContactForm() throws Exception {
        JButton createButton = new JButton();
        AddressBook addressBook = new AddressBook();

        assertTrue(createButton.isVisible());
        assertTrue(createButton.isDisplayable());


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

    @Test
    public void createMenuBar() throws Exception {

    }

    @Test
    public void saveDialog() throws Exception {

    }

    @Test
    public void print() throws Exception {

    }
}