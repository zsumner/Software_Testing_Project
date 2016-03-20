/**
 * Created by John Michael on 2/8/2016.
 */
public class Person
{
    static String firstName;
    static String lastName;
    static String address;
    static String city;
    static String state;
    static String zip;
    static String phone;

    public Person(String firstName, String lastName, String address, String city, String state, String zip, String phone)
    {
        Person.firstName = firstName;
        Person.lastName = lastName;
        Person.address = address;
        Person.city = city;
        Person.state = state;
        Person.zip = zip;
        Person.phone = phone;
    }

    public static String getFirstName()
    {
        return firstName;
    }

    public static String getLastName()
    {
        return lastName;
    }

    public static String getAddress()
    {
        return address;
    }

    public static String getCity()
    {
        return city;
    }

    public static String getState()
    {
        return state;
    }

    public static String getZip()
    {
        return zip;
    }

    public static String getPhone()
    {
        return phone;
    }

    @Override
    public String toString()
    {
        return firstName + "     " + lastName + "     " + address + "     "
                + city + "     " + state + "     " + zip + "     " + phone;
    }
}