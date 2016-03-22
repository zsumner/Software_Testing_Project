import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Zak on 3/21/2016.
 */
public class AddContactTest {



    @Test
    public void testAddToList() throws Exception {
        Person person = new Person("Johnny", "Boy", "123 Sesame Street", "Fort Myers", "FL", "33900", "2395555555");
        ArrayList<String> listPerson = new ArrayList<>();
        listPerson.add(person.getAddress());
        assertEquals(person.getAddress(), listPerson.get(0));
    }
}