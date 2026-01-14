
/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/

import java.io.Serializable;
import java.util.Random;

public class Lecturer implements Serializable {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 540082607047283589L;

    public String name;
    public boolean hasSigned;

    /**
     * Konstruktor für Lecturer
     */
    public Lecturer(String name){
        this.name = name;
        this.hasSigned = false;
    }
    
    /**
     * Methode, die überprüft, ob Lecturer bereit ist, den Laufzettel zu unterschreiben.
     * 70% Chance, dass er bereit ist.
     * @return true, wenn bereit; false, wenn nicht bereit
     */
    public boolean isReadyToSign(){
        int zufallszahl = (int) (Math.random() * 100) + 1;
        if(zufallszahl <= 70) {
            return true;
        } else {
            int zufallszahl2 = (int) (Math.random() * 100) + 1;
            if(zufallszahl2 < 75) {
                System.out.println("Sorry, I'm busy right now. Please come back later.");
            }
            else {
            System.out.println("I don't have time for you right now. Come back later again.");
            }
            return false;
        }
    }

    /**
     * Methode, die den Laufzettel vom Lecturer unterschreiben lässt.
     */
    public boolean sign(){
        return hasSigned = true;
    }
}