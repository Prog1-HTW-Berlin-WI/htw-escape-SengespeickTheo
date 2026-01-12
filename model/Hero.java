
/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/
import java.util.Random;
import java.io.Serializable;

public class Hero implements Serializable {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 3578735620108186013L;

    public String name;
    public int healthPoints;
    public int experiencePoints;
    public Lecturer[] signedExerciseLeaders = new Lecturer[5];

    /**
     * Konstruktor für Hero
     */
    public Hero(String name){
        this.name = name;
        this.healthPoints = 50;
        this.experiencePoints = 0;
    }

    /**
     * Methode, die dem Hero Schaden zufügt und entpsrechend LP abzieht.
     * @param amount von zugefügten Schaden
     * @return neue LP des Heros nach Schaden
     */
    public int takeDamage(int amount){
        this.healthPoints -= amount;
        if(this.healthPoints <= 0) {
            System.out.println("You have been defeated!");
            this.healthPoints = 0;
        }
        return this.healthPoints;
    }
   
    /**
     * Methode, mit dem der Hero longRest (true) und +10LP oder 
     * small Rest (false) und +3LP machen kann.
     * Wenn er die maximalen LP, überschreitet, wird ihm gesagt, er kann
     * eine kleinere oder keine Pause machen.
     * @param longRest
     */
    public void regenerate(boolean longRest){
        if(longRest) {
            this.healthPoints += 10;
            if(this.healthPoints > 50) {
                System.out.println("You reached your maximum points of health. Choose a small rest instead.");
                this.healthPoints -= 10;
            }

            // RUNDE WIRD BEI SPIELMENÜ NOCH HINZUGEFÜGT
        } else {
            this.healthPoints += 3;
            if(this.healthPoints > 50) {
                System.out.println("You reached your maximum points of health. You can't rest any further.");
                this.healthPoints -= 3;
            }
        }
    }

    /**
     * Methode, damit der Hero flüchten kann.
     * 42% Erfolgschance
     * @return ob Flucht erfolgreich verlaufen ist.
     */
    public boolean flee(){
        Random random = new Random();
        int zufallszahl = random.nextInt(100) + 1;
        if(zufallszahl <= 42) {
            System.out.println("You have successfully fled the battle!");
            return true;
        } else {
            System.out.println("Ahhh, your attempt to flee has failed! You have to fight now!");
            return false;
        }
    }
    /**
     * Methode, mit der der Hero angreifen kann.
     * @param zufallszahl berechent Zufallszahl zwischen 1 und 100 für Angriffschaden
     * 13% Chance Angriff schlägt fehl -> kein Schaden
     * 12% guter Treffer -> doppelter Schaden
     * sonst normaler Schaden
     * @return hinzugefügten Schaden
     */
    public int attack(){
        Random random = new Random();
        int zufallszahl = random.nextInt(100) + 1;
        if(zufallszahl <= 13) {
            return 0;
        }
        else if(zufallszahl >=14 && zufallszahl <=26){
            return (int) ((experiencePoints * 2.3 + 1))*2;
        }
        else {
            return (int) (experiencePoints * 2.3 + 1);
        }
    }
    /**
     * Methode dafür, wenn der Hero einen Lecturer trifft, um ihn den
     * Laufzettel unterschreiben zu lassen.
     * @param lecturer
     */
    public void signExerciseLeader(Lecturer lecturer){
        for(int i = 0; i < signedExerciseLeaders.length; i++) {
            if(signedExerciseLeaders[i] == lecturer) {
                System.out.println("You already have my signature. Search for another lecturer to sign.");
                break;
            }
        }
        for(int i = 0; i < signedExerciseLeaders.length; i++) {
            if(signedExerciseLeaders[i] == null) {
                signedExerciseLeaders[i] = lecturer;
                break;
            }
        }
    }
    /**
     * getter für experiencePoints
     * @return experiencePoints
     */
    public int getExperiencePoints(){
        return this.experiencePoints;
    }
    /**
     * Methode, die experiencePoints hinzufügt.
     * @param experiencePoints
     */
    public void addExperiencePoints(int experiencePoints){
        this.experiencePoints += experiencePoints;
    }
    /**
     * Methode, die zurück gibt, ob der Hero noch handlungsfähig ist.
     * @return ob Hero noch handlungsfähig ist.
     */
    public boolean isOperational(){
        if(this.healthPoints > 0) {
            return true;
        } else {
            return false;
        }
    }
}