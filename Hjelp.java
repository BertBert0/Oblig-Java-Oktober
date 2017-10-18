/* Leksjon 4: Obligatorisk oppgave (Bankinformasjon)
 *********************************************************
 * Levert av: Studentnr og navn
 *********************************************************
 * Verktøyklasse med hjelpemetoder til Bank-programmet.
 * NB! Filen lagres i mappen med BankInfo, som: Hjelp.java
 */

// Evt. import av nødvendige bibliotekressurser 

public class Hjelp {
    // Dagens valutakurs settes utenfor bankprogrammet.
    //      final -> konstant    
    //     static -> brukes uten objekt: Klasse.KONSTANT
  final static double USD_NKR = 0;  // Må endre verdi
    // Viser aktuelle brukervalg via en tekstkonstant.
  final static String MENY = "Vis valg (0-3)";  // Må endres

  public static double lesInn(String ledetekst) {  	
    // Metode som ber om og leser inn en desimalverdi fra 
    // brukeren, presentert ved 'ledetekst' i inndialogvindu.
    return 0;
  } 
  
  public static double avrund(double tall) {
    // Metode som avrunder et desimaltall til to siffer 
    // etter komma. Se læreboka side 58.
    return 0;
  }

}
