import java.util.MissingResourceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IdiomaTest {

    Manager m;

    @Before
    public void setUp() throws Exception{
        this.m =  Manager.getInstance();
    }

    @Test
    public void testGetText() throws Exception{

        String mes  =  Manager.getInstance().getText("es","frase4");
        Assert.assertEquals("Tengo 5 vestidos!", mes);

    }

//    @Test(expected = MissingResourceException.class)
//    public void testGetTextBundleNotFound() throws Exception{
//
//        //String error =  Manager.getInstance().getText("es","frase4");
//
//    }

}