package com.mycompany.verkkokauppa;

import java.util.ArrayList;
import java.util.List;

public class Ostoskori {

    private List<Ostos> ostokset;

    public Ostoskori() {

        ostokset = new ArrayList<>();
    }

    public int tuotteitaKorissa() {

        return ostokset.size();
    }

    public int hinta() {

        int yhteensa = 0;

        for (Ostos ostos : ostokset) {
            yhteensa += ostos.hinta();
        }

        return yhteensa;
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
