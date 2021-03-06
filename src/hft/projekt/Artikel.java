package hft.projekt;

import java.io.Serializable;
import java.util.Comparator;

public class Artikel implements Serializable{
	
	//Objektattribute
	private String artikelName;
	private int artikelNr;
	private double preis;
	private int menge;
	private String kategorie;
	
	//Konstruktor
	public Artikel(String artikelName, int artikelNr, double preis,int menge, String kategorie) {
		super();
		this.artikelName = artikelName;
		this.artikelNr = artikelNr;
		this.preis = preis;
		this.menge = menge;
		this.kategorie = kategorie;
	}

	public String getArtikelName() {
		return artikelName;
	}

	public void setArtikelName(String artikelName) {
		this.artikelName = artikelName;
	}

	public int getArtikelNr() {
		return artikelNr;
	}

	public void setArtikelNr(int artikelNr) {
		this.artikelNr = artikelNr;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	

	//Comperator fürs sortieren
	public static Comparator<Artikel> compareByName(){
		return new Comparator<Artikel>() {
			@Override
			public int compare(Artikel k1,Artikel k2) {
				return(k1.artikelName.compareTo(k2.artikelName));
			}
		};
	}
	
	public static Comparator<Artikel> compareByNr(){
		return new Comparator<Artikel>() {
			@Override
			public int compare(Artikel k1,Artikel k2) {
				return(k1.artikelNr- k2.artikelNr);
			}
		};
	}
	public static Comparator<Artikel> compareByPreis(){
		return new Comparator<Artikel>() {
			@Override
			public int compare(Artikel k1,Artikel k2) {
				if(k1.getPreis() < k2.getPreis()) {
					return -1;
				}
				else if(k1.getPreis() > k2.getPreis()){
					return 1;
				}
				else{
					return 0;
				}
			}
		};
	}
	
	public static Comparator<Artikel> compareByMenge(){
		return new Comparator<Artikel>() {
			@Override
			public int compare(Artikel k1,Artikel k2) {
				return(k1.menge-k2.menge);
			}
		};
	}

	public static Comparator<Artikel> compareByKategorie(){
		return new Comparator<Artikel>() {
			@Override
			public int compare(Artikel k1,Artikel k2) {
				return(k1.kategorie.compareTo(k2.kategorie));
			}
		};
	}
//s
	
}
