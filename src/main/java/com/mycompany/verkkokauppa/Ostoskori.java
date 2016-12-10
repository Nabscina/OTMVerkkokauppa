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

        for (Ostos ostos : ostokset) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(ostos.lukumaara());
                return;
            }
        }

        ostokset.add(new Ostos(lisattava));
    }

    public void poista(Tuote poistettava) {

        Ostos p = null;

        for (Ostos ostos : ostokset) {
            if (ostos.tuotteenNimi().equals(poistettava.getNimi())) {
                p = ostos;
            }
        }

        if (p != null) {
            if (p.lukumaara() == 1) {
                ostokset.remove(p);
            } else {
                p.muutaLukumaaraa(-1);
            }
        }
    }

    public List<Ostos> ostokset() {

        return ostokset;
    }

    public void tyhjenna() {

        ostokset.clear();
    }
}
