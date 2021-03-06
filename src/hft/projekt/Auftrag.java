package hft.projekt;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Auftrag implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected int auftragsNr;
	protected LocalDate auftragsdatum;
	protected List<Artikel> artikelListe;
	//private Rechnung rechnung; --> Rechnung kann noch implementiert werden
	
	public Auftrag(List<Artikel> artikel) {
		super();
		this.auftragsdatum = LocalDate.now(); //--> jetziges Datum wird genommen
		this.auftragsNr = auftragsNummerErstellen(); //--> individuelle Nummer wird erstellt
		this.artikelListe = artikel;
		
	}

//	public void bestellen(List<Artikel> artikel) {
//		Rechnung rechnung = new Rechnung(artikel);
//	}
	
	public int getAuftragsNr() {
		return auftragsNr;
	}

	public LocalDate getAuftragsdatum() {
		return auftragsdatum;
	}

	public List<Artikel> getArtikelListe() {
		return artikelListe;
	}

	public void setAuftragsNr(int auftragsNr) {
		this.auftragsNr = auftragsNr;
	}

	public void setAuftragsdatum(LocalDate auftragsdatum) {
		this.auftragsdatum = auftragsdatum;
	}

	public void setArtikelListe(List<Artikel> artikelListe) {
		this.artikelListe = artikelListe;
	}

	/**
	 * @return int, zufällige Autragsnummer die indivduell ist
	 * für genauere Beschreibung siehe kundenNummerErstellen in 'Kunde', gleiches Prinzip
	 */
	public int auftragsNummerErstellen() {
		
		Random rand = new Random();
		int[] ziffern = {0,1,2,3,4,5,6,7,8,9};
		Kundenverwaltung k = Speicherverwaltung.loadKundenverwaltung();
		
		while(true) {
		String num = "";
		boolean duplicate = false;
		
		num = num + ziffern[rand.nextInt(9)+1];
		for(int i = 0; i<4; i++) {
			int index = rand.nextInt(10);
			num = num + ziffern[index];
		}
		for(int i : k.getKunden().keySet()) {
			if(i == Integer.parseInt(num)) {
				duplicate = true;
				
			}
		}
		
		if(duplicate == false) {
			return Integer.parseInt(num);	
			}
		}
	}
	
}
