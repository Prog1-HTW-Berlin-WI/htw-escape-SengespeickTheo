/**
 * Unterklasse von Alien
 */
public class UnfriendlyAlien extends Alien {
    
    /**
     * Konstruktor für unfriendlyAlien
     * @param name
     * @param lifePoints
     * @param friendly
     * @param greeting
     */
    public UnfriendlyAlien(String name, int lifePoints, boolean friendly, String greeting) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.friendly = friendly;
        this.greeting = greeting;
    }
}
