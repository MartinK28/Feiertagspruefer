package feiertage;

import java.util.GregorianCalendar;

/**
* Mit dieser Klasse lassen sich Feiertage speichern
* Ein Feiertag beinhaltet immer ein Datum, einen Namen und die Gültigkeiten, also in welchen Bundesländern der Tag gültig ist
*
* @version 1.0 vom 13.10.2021
* @author Martin Karbaum
*/

public class Feiertag {
	private GregorianCalendar datum;
	private String name;
	private String[] gueltigkeit;
	
	public Feiertag(GregorianCalendar pDatum, String pName, String[] pGueltigkeit) {
		datum = pDatum;
		name = pName;
		gueltigkeit = pGueltigkeit;
	}
	
	public GregorianCalendar getDatum() {
		return datum;
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getGueltigkeit() {
		return gueltigkeit;
	}
	
	public void setDatum(GregorianCalendar pDatum) {
		datum = pDatum;
	}
	
	public void setName(String pName) {
		name = pName;
	}
}
