
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

        Tuote olkipukki = new Tuote("olkipukki", 6);
        Ostoskori kori = new Ostoskori();

        kori.lisaaTuote(olkipukki);

        assertEquals(6, kori.hinta());
    }

    @Test
    public void kahdenTuotteenLisaamisenJalkeen2Tuotetta() {

        Ostoskori kori = new Ostoskori();

        kori.lisaaTuote(new Tuote("joulukuusi", 25));
        kori.lisaaTuote(new Tuote("joulusukka", 2));

        assertEquals(2, kori.ostokset().size());
    }

    @Test
    public void kahdenTuotteenLisaamisenJalkeen2TuotteenHinta() {

        Ostoskori kori = new Ostoskori();

        kori.lisaaTuote(new Tuote("tähti", 7));
        kori.lisaaTuote(new Tuote("kulkunen", 2));

        assertEquals(9, kori.hinta());
    }
}
