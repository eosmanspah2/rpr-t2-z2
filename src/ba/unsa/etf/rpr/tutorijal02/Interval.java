package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna;
    private double krajnja;
    private boolean pripadanjePrve;
    private boolean pripadanjeDruge;
    public Interval(double pocetna, double krajnja, boolean pripadanjePrve, boolean pripadanjeDruge){
        if(pocetna < krajnja){
            this.pocetna=pocetna;
            this.krajnja=krajnja;
            this.pripadanjePrve=pripadanjePrve;
            this.pripadanjeDruge=pripadanjeDruge;
        }
        else{
            throw new IllegalArgumentException("Pocetna tacka je veca od krajnje tacke!");
        }
    }

    public Interval() {
        this.pocetna=0;
        this.krajnja=0;
        this.pripadanjePrve=false;
        this.pripadanjeDruge=false;
    }
    public boolean isNull(){
        if(pocetna == 0 && krajnja == 0 && pripadanjePrve==false && pripadanjeDruge == false){
            return true;
        }
        return false;
    }
    public boolean isIn(double tacka){
        if(tacka<pocetna || tacka>krajnja || (tacka==pocetna && pripadanjePrve==false) || (tacka==krajnja && pripadanjeDruge==false)){
            return false;
        }
        return true;
    }
    public Interval intersect (Interval interval){//treba mi veca pocetna i manja krajnja
        double pocetnaPresjek = pocetna;
        double krajnjaPresjek = krajnja;
        if(interval.pocetna > pocetna){
            pocetnaPresjek = interval.pocetna;
        }
        if(interval.krajnja < krajnja){
            krajnjaPresjek = interval.krajnja;
        }
        boolean pripadanjePocetneNove=false;
        if(isIn(pocetnaPresjek) && interval.isIn(pocetnaPresjek))
            pripadanjePocetneNove=true;
        boolean pripadanjeKrajnjeNove=false;
        if(isIn(krajnjaPresjek) && interval.isIn(krajnjaPresjek))
            pripadanjeKrajnjeNove=true;

        return new Interval(pocetnaPresjek,krajnjaPresjek,pripadanjePocetneNove,pripadanjeKrajnjeNove);
    }
    public static Interval intersect (Interval interval1,Interval interval2){//treba mi veca pocetna i manja krajnja
        double pocetnaPresjek = interval1.pocetna;
        double krajnjaPresjek = interval1.krajnja;
        if(interval2.pocetna > interval1.pocetna){
            pocetnaPresjek = interval2.pocetna;
        }
        if(interval2.krajnja < interval1.krajnja){
            krajnjaPresjek = interval2.krajnja;
        }
        boolean pripadanjePocetneNove=false;
        if(interval1.isIn(pocetnaPresjek) && interval2.isIn(pocetnaPresjek))
            pripadanjePocetneNove=true;
        boolean pripadanjeKrajnjeNove=false;
        if(interval1.isIn(krajnjaPresjek) && interval2.isIn(krajnjaPresjek))
            pripadanjeKrajnjeNove=true;
        return new Interval(pocetnaPresjek,krajnjaPresjek,pripadanjePocetneNove,pripadanjeKrajnjeNove);
    }
    @Override
    public String toString(){
        if(this.isNull()) return "()";
        String novi="";
        if(pripadanjePrve) novi+="[";
        else novi+="(";
        novi+=pocetna;
        novi+=",";
        novi+=krajnja;
        if(pripadanjeDruge) novi+="]";
        else novi+=")";
        return novi;
    }
    @Override
    public boolean equals(Object o){
        Interval novi = (Interval) o;
        return pocetna==novi.pocetna && krajnja==novi.krajnja && pripadanjePrve==novi.pripadanjePrve && pripadanjeDruge==novi.pripadanjeDruge;
    }

}
