import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John Michael on 2/8/2016.
 */
public class PersonTest
{
    private Person person = new Person("Johnny", "Boy", "123 Sesamea Street", "Fort Myers", "FL", "33900", "2395555555");

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testGetFirstName() throws Exception
    {
        person.getFirstName();
        assertEquals("John", "John");
    }

    @Test
    public void testGetLastName() throws Exception
    {
        person.getLastName();
        assertEquals("Boy", "Boy");
    }

    @Test
    public void testGetAddress() throws Exception
    {
        person.getAddress();
        assertEquals("123 Sesamea Street", "123 Sesamea Street");
    }

    @Test
    public void testGetCity() throws Exception
    {
        person.getCity();
        assertEquals("Fort Myers", "Fort Myers");
    }

    @Test
    public void testGetState() throws Exception
    {
        person.getState();
        assertEquals("FL", "FL");
    }

    @Test
    public void testGetZip() throws Exception
    {
        person.getZip();
        assertEquals("33900", "33900");
    }

    @Test
    public void testGetPhone() throws Exception
    {
        person.getPhone();
        assertEquals("2395555555", "2395555555");
    }
}