
/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/
public abstract class Alien {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 1729389822767173584L;

    public String name;
    public int lifePoints;
    public boolean friendly;
    public String greeting;

    /**
     * Methode, die dem Alien Schaden zufügt und LP abzieht.
     * @param damage
     * @return Nachricht mit angerichtetem Schaden und restlichen LP
     */
    public String takeDamage(int damage){
        lifePoints -= damage;
        if(lifePoints < 0) {
            lifePoints = 0;
        }
        return name + " lost " + damage + " life points and has now " + lifePoints + " life points left.";
    }

    /**
     * Methode, die zurückgibt, ob das Alien besiegt wurde.
     * @return true, wenn besiegt; false, wenn nicht besiegt
     */
    public boolean isDefeated(){
        if(lifePoints <= 0) {
            System.out.println(name + " has been defeated!");
            return true;
        } else {
            return false;
        }
    }
}
