
import com.mycompany.verkkokauppa.Ostoskori;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VerkkokauppaTest {

    public VerkkokauppaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    @Test
    public void ostoskorinHintaJaTuotteetAluksi0() {

        Ostoskori kori = new Ostoskori();

        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
    }
}
