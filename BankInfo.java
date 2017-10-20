/* Leksjon 4: Obligatorisk oppgave (Bankinformasjon) 
 *******************************************************************
 * Levert av: 216756, Robert Anholt
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
        double valuta = 0;
        do { 
           valuta = Hjelp.lesInn("Gi et dollarbeløp:");
          if (valuta < 0)
            showMessageDialog(null, "Ulovlig beløp!");
        } while (valuta < 0);
         double bUSD = Hjelp.avrund(valuta);
         double bNOK = Hjelp.avrund(Hjelp.USD_NKR*bUSD);
         showMessageDialog(null,  "1: Veksling" + "\n"
                           + "____________________" + "\n"
                           + "Beløp i USD: " + bUSD + "\n"
                           + "Kurs: 1 USD = " + Hjelp.USD_NKR + " NOK" + "\n"
                           + "Beløp i NOK: " + bNOK + "\n"
                           + "____________________");
  }

  /* Hjelpemetode for å gi info om sparing med ett innskud som
   * følges over et gitt antall år til en gitt årsrente (%).
   */
  private static void sparing() {
    String utTekst = "";
    // Les inn via kall på hjelpe-metode: et sparebeløp, en årsrente 
    double sparebeløp = Hjelp.lesInn("Gi sparebeløp:");
    double årsrente = Hjelp.lesInn("Gi årsrente:");
    // og et antall år i spareperioden.
    int antallår = (int)Hjelp.lesInn("Gi antall år:");
    // Hvis lovlige inndata
    if (sparebeløp < 1 || årsrente < 1 || antallår < 1)
      showMessageDialog(null, "Ulovlig Inndata!");
       // skriv ut (kvitter) de aktuelle inndataene
    else {
      utTekst = "2: Sparing" + "\n"
              + "____________________" + "\n"; 

      utTekst += ("Sparebeløp: " + sparebeløp + "\n"
                             + "Årlig rente: " + årsrente + "%" + "\n"
                             + "Antall år: " + antallår + "\n"
                             + "____________________" + "\n");
       // beregn år for år: påløpt rente og ny saldo (økt beløp)
        utTekst += ("År     Rente     Saldo" + "\n");
        double rente ;
        double saldo = sparebeløp;  

      for(int i = 1; i<=antallår; i++){
          rente = saldo*årsrente/100;
          saldo += rente;
       // hvis mindre enn eller lik 10 år
          // skriv ut år, renter og saldo
            rente = Hjelp.avrund(rente);
            saldo = Hjelp.avrund(saldo);

           if (i <=10) 
            utTekst += (i + ":    " + rente + "     " + saldo + "\n");   
       // Etter beregningene skrives sluttsaldo ut hvis år er over 10
              if (antallår > 10 && i == antallår) 
                utTekst += ("____________________" + "\n"
                        + "Saldo etter " + antallår + " År:" + " " + saldo);
        }
        showMessageDialog(null, utTekst);
    // Skriv feilmelding ved ulovlige inndata
   }

  } 

  /* Hjelpemetode for å gi info om annuitetslån, dvs. et fast årlig 
   * beløp for å betale et lån til en gitt rente over et antall år. 
   */
  private static void låning() { 
    String utTekst = "";    
    // Les inn via kall på hjelpe-metode: et lånebeløp, en årsrente  
    double lånebeløp = Hjelp.lesInn("Gi lånebeløp:");
    double årsrente = Hjelp.lesInn("Gi årsrente:");
    // og et antall år for nedbetalingsperioden.
    int antallår = (int)Hjelp.lesInn("Gi antall år for nedbetaling:");
    // Hvis lovlige inndata:
     if (lånebeløp < 1 || årsrente < 1 || antallår < 1)
          showMessageDialog(null, "Ulovlig inndata!");

     else {
       // skriv ut (kvitter) de aktuelle inndataene
        utTekst = "3: Lån" + "\n"
                + "____________________" + "\n"; 

        utTekst += ("Lånebeløp: " + lånebeløp + "\n"
                 + "Årlig rente: " + årsrente + "%" + "\n"
                 + "Antall år: " + antallår + "\n"
                 + "____________________" + "\n");
       // beregn årlig betaling (nettsøk: formel for annuitetslån)
       //        bruk matematiske metoder (Math) til regnearbeidet
        double betaling = lånebeløp * årsrente / (1- 1 / Math.pow(1 + årsrente/100, antallår))/100;
        betaling = Hjelp.avrund(betaling);
       // skriv ut årlig betaling
        utTekst += ("Årlig betaling: " + betaling);        
        showMessageDialog(null, utTekst); 
        }
    // Skriv feilmelding ved ulovlige inndata 
  
  }

  /* Hjelpemetode for å gi en standard feilmelding i situasjonene
   * som er aktuelle i dette programmet. 
   */ 
  private static void feilmelding() {  
    // Skriv en generell feilmelding som kan brukes overalt her
    showMessageDialog(null, "404: Brain not found!");
  }  

}