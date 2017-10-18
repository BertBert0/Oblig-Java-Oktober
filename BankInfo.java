/* Leksjon 4: Obligatorisk oppgave (Bankinformasjon) 
 *******************************************************************
 * Levert av: Studentnr og navn
 *******************************************************************
 * Programmet bruker verktøyklassen 'Hjelp' som inneholder relevante
 * metoder (innlesing, avrunding) og konstanter (kurs og meny). 
 * NB! Filen lagres i mappen sammen med Hjelp, som: BankInfo.java
 */ 

// Import av nødvendige bibliotekressurser 
import static java.lang.Integer.*;
import static javax.swing.JOptionPane.*;

public class BankInfo {

  public static void main(String[] args) {

    // Variabel for programgjentak
    boolean fortsett = true;
    do {
      // Leser inn ønsket info-tjeneste fra en meny
      int valg = parseInt( showInputDialog(Hjelp.MENY) ); 
      if (valg == 0)
        fortsett = false;
      else 
        switch ( valg ) {
           case 1: veksling(); break;
           case 2: sparing(); break;
           case 3: låning(); break;
          default: feilmelding();  break;
        }
    } while ( fortsett );

  } // slutt på main-metoden



  /* Hjelpemetode for å gi info om valutaveksling fra et beløp
   * i USdollar til norske kroner ved en fastsatt valutakurs.
   */
  private static void veksling() {    
    // Les inn et dollarbeløp via kall på hjelpe-metode. 
    // Hvis lovlig beløp
       // beregn beløp i norske kroner
       // skriv ut beløpene avrundet til 2 siffer etter komma
       // skriv ut vekslingskursen
    // Skriv feilmelding ved ulovlig beløp
    showMessageDialog(null, "1: Veksling");
  }

  /* Hjelpemetode for å gi info om sparing med ett innskud som
   * følges over et gitt antall år til en gitt årsrente (%).
   */
  private static void sparing() {     
    // Les inn via kall på hjelpe-metode: et sparebeløp, en årsrente 
    // og et antall år i spareperioden.
    // Hvis lovlige inndata
       // skriv ut (kvitter) de aktuelle inndataene
       // beregn år for år: påløpt rente og ny saldo (økt beløp)
       // hvis mindre enn eller lik 10 år 
          // skriv ut år, renter og saldo
       // Etter beregningene skrives sluttsaldo ut hvis år er over 10 
    // Skriv feilmelding ved ulovlige inndata 
    showMessageDialog(null, "2: Sparing");
  } 

  /* Hjelpemetode for å gi info om annuitetslån, dvs. et fast årlig 
   * beløp for å betale et lån til en gitt rente over et antall år. 
   */
  private static void låning() {     
    // Les inn via kall på hjelpe-metode: et lånebeløp, en årsrente  
    // og et antall år for nedbetalingsperioden.
    // Hvis lovlige inndata:
       // skriv ut (kvitter) de aktuelle inndataene
       // beregn årlig betaling (nettsøk: formel for annuitetslån)
       //        bruk matematiske metoder (Math) til regnearbeidet
       // skriv ut årlig betaling
    // Skriv feilmelding ved ulovlige inndata 
    showMessageDialog(null, "3: Låning"); 
  }

  /* Hjelpemetode for å gi en standard feilmelding i situasjonene
   * som er aktuelle i dette programmet. 
   */ 
  private static void feilmelding() {  
    // Skriv en generell feilmelding som kan brukes overalt her
  }  

}
