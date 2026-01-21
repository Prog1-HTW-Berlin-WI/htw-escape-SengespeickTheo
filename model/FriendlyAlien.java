/**
 * 
 */
public class FriendlyAlien extends Alien{
    
    /**
     * 
     * @param name
     * @param lifePoints
     * @param friendly
     * @param greeting
     */
    public FriendlyAlien(String name, int lifePoints, boolean friendly, String greeting) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.friendly = friendly;
        this.greeting = greeting;
    }
}
