package com.mycompany.verkkokauppa;

import java.util.List;

public class Ostoskori {

    public int tuotteitaKorissa() {
        // kertoo korissa olevien tuotteiden määrän
        // metodin nimi on hieman huono, kyseessä oikeastaan koriin lisättyjen "asioiden" määrä
        // eli jos koriin lisätty 2 kpl tuotetta "Koff", tulee metodin palauttaa 2     

        return -1;
    }

    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan

        return -1;
    }

    public void lisaaTuote(Tuote lisattava) {
        // lisää tuotteen
    }

    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }

    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset

        return null;
    }

    public void tyhjenna() {
        // tyhjentää korin
    }
}
