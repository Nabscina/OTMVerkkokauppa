
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

        assertEquals(1, kori.tuotteitaKorissa());
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

        assertEquals(2, kori.tuotteitaKorissa());
    }

    @Test
    public void kahdenTuotteenLisaamisenJalkeen2TuotteenHinta() {

        Ostoskori kori = new Ostoskori();

        kori.lisaaTuote(new Tuote("tähti", 7));
        kori.lisaaTuote(new Tuote("kulkunen", 2));

        assertEquals(9, kori.hinta());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKoriSisaltaaYhdenOstoksen() {

        Ostoskori kori = new Ostoskori();
        kori.lisaaTuote(new Tuote("lanttulaatikko", 3));

        assertEquals(1, kori.ostokset().size());
    }

    @Test
    public void korinTuotteenNimiJaLukumaaraOikein() {

        Ostoskori kori = new Ostoskori();
        kori.lisaaTuote(new Tuote("porkkanalaatikko", 3));

        assertEquals("porkkanalaatikko", kori.ostokset().get(0).tuotteenNimi());
        assertEquals(1, kori.ostokset().get(0).lukumaara());
    }

    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKoriSisaltaaKaksiOstosta() {

        Ostoskori kori = new Ostoskori();
        kori.lisaaTuote(new Tuote("lanttulaatikko", 3));
        kori.lisaaTuote(new Tuote("perunalaatikko", 3));

        assertEquals(2, kori.ostokset().size());
    }

    @Test
    public void kahdenSamanTuotteenJalkeenSisaltaaYhdenOstoksen() {

        Ostoskori kori = new Ostoskori();
        kori.lisaaTuote(new Tuote("kinkku", 10));
        kori.lisaaTuote(new Tuote("kinkku", 10));

        assertEquals(1, kori.ostokset().size());
    }

    @Test
    public void kahdellaSamallaTuotteellaSamaNimiJaLukumaara2() {

        Ostoskori kori = new Ostoskori();
        Tuote kynttila = new Tuote("kynttilä", 2);

        kori.lisaaTuote(kynttila);
        kori.lisaaTuote(kynttila);

        assertEquals("kynttilä", kori.ostokset().get(0).tuotteenNimi());
        assertEquals(2, kori.ostokset().get(0).lukumaara());
    }

    @Test
    public void tuotteenPoistaminenOnnistuu() {

        Ostoskori kori = new Ostoskori();
        Tuote piparkakku = new Tuote("piparkakku", 1);

        kori.lisaaTuote(piparkakku);

        assertEquals(1, kori.tuotteitaKorissa());
        assertEquals(1, kori.hinta());
        assertEquals(1, kori.ostokset().size());

        kori.poista(piparkakku);

        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size());
    }

    @Test
    public void kaksiSamaaTuotettaYksiPoistetaanLukumaaraksiJaa1() {

        Ostoskori kori = new Ostoskori();
        Tuote punajuuri = new Tuote("punajuuri", 2);

        kori.lisaaTuote(punajuuri);
        kori.lisaaTuote(punajuuri);

        kori.poista(punajuuri);

        assertEquals(1, kori.tuotteitaKorissa());
        assertEquals(1, kori.ostokset().get(0).lukumaara());
    }

    @Test
    public void korinTyhjennysToimii() {

        Ostoskori kori = new Ostoskori();
        kori.lisaaTuote(new Tuote("peruna", 1));
        kori.lisaaTuote(new Tuote("glögi", 1));
        kori.lisaaTuote(new Tuote("juusto", 2));
        kori.lisaaTuote(new Tuote("joulutorttu", 100));

        kori.tyhjenna();

        assertTrue(kori.ostokset().isEmpty());
        assertEquals(0, kori.ostokset().size());
    }
}
