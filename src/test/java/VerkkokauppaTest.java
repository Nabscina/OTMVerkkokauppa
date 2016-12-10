
import com.mycompany.verkkokauppa.Ostoskori;
import com.mycompany.verkkokauppa.Tuote;
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

    @Test
    public void yhdenTuotteenLisaamisenJalkeen1Tuote() {

        Tuote lasienkeli = new Tuote("lasienkeli", 4);
        Ostoskori kori = new Ostoskori();

        kori.lisaaTuote(lasienkeli);

        assertEquals(1, kori.ostokset().size());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenHintaTuotteenHinta() {

        Tuote olkipukki = new Tuote("lasienkeli", 6);
        Ostoskori kori = new Ostoskori();

        kori.lisaaTuote(olkipukki);

        assertEquals(6, kori.hinta());
    }
}
