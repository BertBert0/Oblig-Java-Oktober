/* Leksjon 4: Obligatorisk oppgave (Bankinformasjon)
 *********************************************************
 * Levert av: 216756, Robert Anholt
 *********************************************************
 * Verktøyklasse med hjelpemetoder til Bank-programmet.
 * NB! Filen lagres i mappen med BankInfo, som: Hjelp.java
 */

// Evt. import av nødvendige bibliotekressurser 
import static javax.swing.JOptionPane.*;
import static java.lang.Double.*;


public class Hjelp {
    // Dagens valutakurs settes utenfor bankprogrammet.
    //      final -> konstant    
    //     static -> brukes uten objekt: Klasse.KONSTANT
  final static double USD_NKR = 8.28;  // Må endre verdi
    // Viser aktuelle brukervalg via en tekstkonstant.
  final static String MENY = "Konkus bank" + "\n"
                           + "____________________" + "\n"
                           + "Her får du info om:" + "\n"
                           + "[1] Valutaveksling" + "\n"
                           + "[2] Sparing" + "\n"
                           + "[3] Lån" + "\n"
                           + "[0] Avslutt" + "\n"
                           + "Skriv inn tjenestekode (0-3): ";  // Må endres

  public static double lesInn(String ledetekst) {  	
    // Metode som ber om og leser inn en desimalverdi fra 
    // brukeren, presentert ved 'ledetekst' i inndialogvindu.
    String tallTekst = showInputDialog(ledetekst);
    double tall = parseDouble(tallTekst);
    return tall;
  } 
  
  public static double avrund(double tall) {
    // Metode som avrunder et desimaltall til to siffer 
    // etter komma. Se læreboka side 58.
    return (int)(tall*100 + 0.5)/100.0;
  }

}