
/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/
import java.io.Serializable;

/**
 * 
 */
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
            if(this.healthPoints >= 50) {
                System.out.println("You reached your maximum points of health. Choose a small rest instead.");
            } else {
            this.healthPoints += 10;
            System.out.println("Ahh, finally a rest. You regained 10 health points. Try not to lose them this time...");
            }
        } else {
            if(this.healthPoints >= 50) {
                System.out.println("You reached your maximum points of health. You can't rest any further.");
            } else {
            this.healthPoints += 3;
            System.out.println("A short break can do wonders. You regained 3 health points.");
            }
        }
    }

    /**
     * Methode, damit der Hero flüchten kann.
     * 42% Erfolgschance
     * @return ob Flucht erfolgreich verlaufen ist.
     */
    public boolean flee(){
        int zufallszahl = (int) (Math.random() * 100) + 1;
        if(zufallszahl <= 42) {
            System.out.println("You have successfully fled the battle!");
            return true;
        } else {
            int zufallszahl2 = (int) (Math.random() * 100) + 1;
            if(zufallszahl2 <70) {
            System.out.println("Ahh, your attempt to flee has failed! You have to fight now!");
            } else {
                System.out.println("Bad try. Seems like you have to fight now!");
            }
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
    public int attack(Alien alien){
        int zufallszahl = (int) (Math.random() * 100) + 1;
        if(zufallszahl <= 13) {
            System.out.println("Your attack missed! You dealt no damage.");
            return 0;
        }
        else if(zufallszahl >=14 && zufallszahl <=26){
            System.out.println("Great hit! You dealt " + (int) ((experiencePoints * 2.3 + 1)*2) + " points of damage.");
            alien.takeDamage((int) ((experiencePoints * 2.3 + 1)*2));
            return (int) ((experiencePoints * 2.3 + 1))*2;
        }
        else {
            System.out.println("You dealt " + (int) (experiencePoints * 2.3 + 1) + " points of damage.");
            alien.takeDamage((int) (experiencePoints * 2.3 + 1));
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
                return;
            }
        }        
        for(int i = 0; i < signedExerciseLeaders.length; i++) {
            if(signedExerciseLeaders[i] == null) {
                signedExerciseLeaders[i] = lecturer;
                int zufallszahl = (int) (Math.random() * 100) + 1;
                if(zufallszahl <30) {
                    System.out.println(lecturer.name + ": 'You really want my signature? Fine... here you go.'");
                } else {
                    System.out.println(lecturer.name +": 'Alright, here's my signature. Good luck with your escape!'");
                }
                return;
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
        System.out.println("You gained " + experiencePoints + " experience points!");
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
    public int getHealthPoints() {
        return healthPoints;
    }
}