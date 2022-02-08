package feiertage;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
* Prüfer ob ein Ausgewählter Tag ein Feiertag ist
* Dies können deutschlandweite Feiertage sein oder die für ein spezielles Land
* Auch kann sich der Name für einen Feiertag gegeben werden lassen
* 
* Abkürzungen der Länder (Groß/Kleinschreibung ist egal):
* sh=Schleswig Holstein; mv=Mecklenburg Vorpommern; hh=Hamburg; hb=Bremen; ni=Niedersachsen;
* st=Sachsen Anhalt; be=Berlin; bb=Brandenburg; sn=Sachsen; th=Thüringen; nw=Nordrhein Westfalen;
* he=Hessen; rp=Rheinlandpfalz; sl=Saarland; bw=Baden Württemberg; by=Bayern
*
* @version 1.0 vom 13.10.2021
* @author Martin Karbaum
*/

public class Feiertagspruefer {
	
	/*
	 * In feiertage[] werden alle Feiertage gespeichert
	 */
	private Feiertag[] feiertage = new Feiertag[19];

	public Feiertagspruefer() {
		
		/*
		GregorianCalendar today = new GregorianCalendar();
		
		String[] hdk = new String[] {"bw", "by", "st"};
		String[] infr = new String[] {"be"};
		String[] ost = new String[] {"bb"};
		String[] pf = new String[] {"bb"};
		String[] frln = new String[] {"bw", "by", "he", "nw", "rp", "sl"};
		String[] mh = new String[] {"sl"};
		String[] wk = new String[] {"th"};
		String[] ref = new String[] {"bb", "hb", "hh", "mv", "ni", "sn", "st", "sh", "th"};
		String[] alhl = new String[] {"bw", "by", "nw", "rp", "sl"};
		String[] bub = new String[] {"sn"};
		
		feiertage[0] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 0, 1), "Neujahr", null);
		feiertage[1] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 0, 6), "Heilige drei Könige", hdk);
		feiertage[2] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 2, 8), "Internationaler Frauentag", infr);
		feiertage[3] = new Feiertag(new GregorianCalendar(), "Karfreitag", null);
		feiertage[4] = new Feiertag(new GregorianCalendar(), "Ostersonntag", ost);
		feiertage[5] = new Feiertag(new GregorianCalendar(), "Ostermontag", null);
		feiertage[6] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 4, 1), "Tag der Arbeit", null);
		feiertage[7] = new Feiertag(new GregorianCalendar(), "Christi Himmelfahrt", null);
		feiertage[8] = new Feiertag(new GregorianCalendar(), "Pfingstsonntag", pf);
		feiertage[9] = new Feiertag(new GregorianCalendar(), "Pfingstmontag", null);
		feiertage[10] = new Feiertag(new GregorianCalendar(), "Fronleichnam", frln);
		feiertage[11] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 7, 15), "Mariae Himmelfahrt", mh);
		feiertage[12] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 8, 20), "Weltkindertag", wk);
		feiertage[13] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 9, 3), "Tag der deutschen Einheit", null);
		feiertage[14] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 9, 31), "Reformationstag", ref);
		feiertage[15] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 10, 1), "Allerheiligen", alhl);
		feiertage[16] = new Feiertag(new GregorianCalendar(), "Buß- und Bettag", bub);
		feiertage[17] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 11, 25), "1. Weihnachtsfeiertag", null);
		feiertage[18] = new Feiertag(new GregorianCalendar(today.get(Calendar.YEAR), 11, 26), "2. Weihnachtsfeiertag", null);
		*/
	}
	
	/*
	 * Prüft ob der Gewählte Tag in dem gewählten Gültigkeitsbereich ein Feiertag ist.
	 * @param pDatum Das Datum des gewünschten Tages, was überprüft werden soll
	 * @param pBundesland Hier wird das gewünschte Bundesland ausgewählt, sollte ein leerer String übergeben werden wird geprüft ob er in ganz Deutschland gilt
	 * @return liefert boolischen Wert ob der Tag ein Feiertag ist oder nicht
	 */
	public boolean istFeiertag(GregorianCalendar pDatum, String pBundesland) {
		int feiertagNummer = ermittleFeiertag(pDatum, pBundesland);
		//System.out.println(feiertagNummer);
		if(feiertagNummer == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
	 * Prüft ob der Gewählte Tag in dem gewählten Gültigkeitsbereich ein Feiertag ist und liefert den Namen des Tages.
	 * @param pDatum Das Datum des gewünschten Tages, was überprüft werden soll
	 * @param pBundesland Hier wird das gewünschte Bundesland ausgewählt, sollte ein leerer String übergeben werden wird geprüft ob er in ganz Deutschland gilt
	 * @return liefert einen String mit dem Namen des Feiertags, wenn der gewählte Tag kein Feiertag ist, wird ein leerer String übergeben
	 */
	public String nameFeiertag(GregorianCalendar pDatum, String pBundesland) {
		int feiertagNummer = ermittleFeiertag(pDatum, pBundesland);
		if(feiertagNummer == -1) {
			return "";
		} else {
			return feiertage[feiertagNummer].getName();
		}
	}
	
	private int ermittleFeiertag(GregorianCalendar pDatum, String pBundesland) {
		ladeStatischeFeiertage(pDatum);
		berechneVariableFeiertage(pDatum);
		
		int stelleFeiertag = -1;
		for(int i = 0; i < feiertage.length; i++) {
			if(tageSindGleich(feiertage[i].getDatum(),pDatum)) {
				stelleFeiertag = i;
				//System.out.println("i: "+i + " - Name: " + feiertage[i].getName());
			}
		}
		//System.out.println(stelleFeiertag);
		if(stelleFeiertag == -1) {
			//der Tag ist kein Feiertag
			return -1;
		}
		
		boolean inBundeslandGueltig = true;
		if(pBundesland.isEmpty()) {
			//Feiertag gilt nur in bestimmten Bundesländern und ist nicht allgemein Gültig
			if(feiertage[stelleFeiertag].getGueltigkeit() != null) {
				inBundeslandGueltig = false;
			}
		} else {
			if(feiertage[stelleFeiertag].getGueltigkeit() == null) {
				//Tag bezieht sich auf ein konkretes Bundesland, ist aber allgemein gültig
				inBundeslandGueltig = true;
			} else {
				//Prüft ob der Tag in dem Ausgewählten Bundesland ein Feiertag ist
				inBundeslandGueltig = Arrays.stream(feiertage[stelleFeiertag].getGueltigkeit()).anyMatch(pBundesland::equalsIgnoreCase);
			}
		}
		
		if(inBundeslandGueltig) {
			//Tag ist sowohl ein Feiertag als auch im Gewählten Land gültig
			return stelleFeiertag;
		}
		//Feiertag gilt nicht im ausgewählten Bundesland
		return -1;
		
	}
	
	private void berechneVariableFeiertage(GregorianCalendar pDatum) {
		int year = pDatum.get(Calendar.YEAR);
		
		GregorianCalendar osterDatum;
		
		//Ostern nach Gauß berechnen
		int a = year % 4;
		int b = year % 7;
		int c = year % 19;
		int d = (19*c + 24) % 30;
		int e = (2*a + 4*b + 6*d + 5) % 7;
		int f = (c + 11*d + 22*e) / 451;
		
		int ostern = 22 + d + e - 7*f;
		if(ostern > 31) {
			ostern = d + e - 7*f - 9;
			if(ostern == 26) {
				osterDatum = new GregorianCalendar(year, 2, 19);
			} else {
				osterDatum = new GregorianCalendar(year, 3, ostern);
			}
		} else {
			osterDatum = new GregorianCalendar(year, 2, ostern);
		}
		feiertage[4].setDatum(osterDatum);
		//System.out.println(ostern + " - " + year);
		
		//Karfreitag ist 2 Tage vor Ostern
		GregorianCalendar karfreitag = (GregorianCalendar) osterDatum.clone();
		karfreitag.add(Calendar.DAY_OF_MONTH, -2);
		feiertage[3].setDatum(karfreitag);
		
		//Ostermontag ist 1 Tag nach Ostern
		GregorianCalendar ostermontag = (GregorianCalendar) osterDatum.clone();
		ostermontag.add(Calendar.DAY_OF_MONTH, 1);
		feiertage[5].setDatum(ostermontag);
		
		//Christi Himmelfahrt ist 39 Tage nach Ostern
		GregorianCalendar christiHimmelfahrt = (GregorianCalendar) osterDatum.clone();
		christiHimmelfahrt.add(Calendar.DAY_OF_MONTH, 39);
		feiertage[7].setDatum(christiHimmelfahrt);
		
		//Pfingstsonntag ist 49 Tage nach Ostern
		GregorianCalendar pfingstsonntag = (GregorianCalendar) osterDatum.clone();
		pfingstsonntag.add(Calendar.DAY_OF_MONTH, 49);
		feiertage[8].setDatum(pfingstsonntag);
		
		//Pfingstmontag ist 50 Tage nach Ostern
		GregorianCalendar pfingstmontag = (GregorianCalendar) osterDatum.clone();
		pfingstmontag.add(Calendar.DAY_OF_MONTH, 50);
		feiertage[9].setDatum(pfingstmontag);
		
		//Fronleichname ist 60 Tage nach Ostern
		GregorianCalendar fronleichnam = (GregorianCalendar) osterDatum.clone();
		fronleichnam.add(Calendar.DAY_OF_MONTH, 60);
		feiertage[10].setDatum(fronleichnam);
		
		
		//Buß und Bettag berechnen. Dieser ist der letzt Mittwoch vor dem 23.11.
		//zdee = 2311 => 23.11.
		GregorianCalendar zdee = new GregorianCalendar(pDatum.get(Calendar.YEAR), 10, 23);
		boolean istMittwoch = false;
		while(!istMittwoch) {
			zdee.add(Calendar.DAY_OF_MONTH, -1);
			//DAY_OF_WEEK = 4 bedeutet es ist Mittwoch
			if(zdee.get(Calendar.DAY_OF_WEEK) == 4) {
				istMittwoch = true;
			}
		}
		feiertage[16].setDatum(zdee);
	}
	
	private boolean tageSindGleich(GregorianCalendar pDatum1, GregorianCalendar pDatum2) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM");
		fmt.setCalendar(pDatum1);
		String tm1 = fmt.format(pDatum1.getTime());
		String tm2 = fmt.format(pDatum2.getTime());
		//System.out.println(tm1 + " entspricht " + tm2);
		return tm1.equals(tm2);
	}
	
	private void ladeStatischeFeiertage(GregorianCalendar pDate) {
		
		String[] hdk = new String[] {"bw", "by", "st"};
		String[] infr = new String[] {"be"};
		String[] ost = new String[] {"bb"};
		String[] pf = new String[] {"bb"};
		String[] frln = new String[] {"bw", "by", "he", "nw", "rp", "sl"};
		String[] mh = new String[] {"sl"};
		String[] wk = new String[] {"th"};
		String[] ref = new String[] {"bb", "hb", "hh", "mv", "ni", "sn", "st", "sh", "th"};
		String[] alhl = new String[] {"bw", "by", "nw", "rp", "sl"};
		String[] bub = new String[] {"sn"};
		
		feiertage[0] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 0, 1), "Neujahr", null);
		feiertage[1] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 0, 6), "Heilige drei Könige", hdk);
		feiertage[2] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 2, 8), "Internationaler Frauentag", infr);
		feiertage[3] = new Feiertag(new GregorianCalendar(), "Karfreitag", null);
		feiertage[4] = new Feiertag(new GregorianCalendar(), "Ostersonntag", ost);
		feiertage[5] = new Feiertag(new GregorianCalendar(), "Ostermontag", null);
		feiertage[6] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 4, 1), "Tag der Arbeit", null);
		feiertage[7] = new Feiertag(new GregorianCalendar(), "Christi Himmelfahrt", null);
		feiertage[8] = new Feiertag(new GregorianCalendar(), "Pfingstsonntag", pf);
		feiertage[9] = new Feiertag(new GregorianCalendar(), "Pfingstmontag", null);
		feiertage[10] = new Feiertag(new GregorianCalendar(), "Fronleichnam", frln);
		feiertage[11] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 7, 15), "Mariae Himmelfahrt", mh);
		feiertage[12] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 8, 20), "Weltkindertag", wk);
		feiertage[13] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 9, 3), "Tag der deutschen Einheit", null);
		feiertage[14] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 9, 31), "Reformationstag", ref);
		feiertage[15] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 10, 1), "Allerheiligen", alhl);
		feiertage[16] = new Feiertag(new GregorianCalendar(), "Buß- und Bettag", bub);
		feiertage[17] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 11, 25), "1. Weihnachtsfeiertag", null);
		feiertage[18] = new Feiertag(new GregorianCalendar(pDate.get(Calendar.YEAR), 11, 26), "2. Weihnachtsfeiertag", null);
	}

}
