import model.Hero;
import model.HTWRoom;

/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/



public class EscapeGame {
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[5];
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    /**
     * initialisiert einen neuen Helden, HTWRooms, Lecturer und Aliens.
     */
    public EscapeGame(Hero hero) {
        this.hero = hero;
        Lecturer lecturer1 = new Lecturer("Poeser");
        Lecturer lecturer2 = new Lecturer("Gärt");
        Lecturer lecturer3 = new Lecturer("Vaseva");
        Lecturer lecturer4 = new Lecturer("Safitri");
        Lecturer lecturer5 = new Lecturer("Gnaoui");
        this.rooms[0] = new HTWRoom("A238", "You have entered room A238. It's a big lecture hall, to your left you can see stairs going up to the seats. In front of you are big windows, that have been darkened with slime by some aliens. You can only see a slight shimmer of light...", lecturer1);
        this.rooms[1] = new HTWRoom("A219", "You have entered room A219. It's a small lecture hall with a few desks and chairs. There is a strange smell in the air and a weird looking liquid on the floor, probably left by an Alien passing through.", lecturer2);
        this.rooms[2] = new HTWRoom("test2", "description", lecturer3);
        this.rooms[3] = new HTWRoom("test3", "description", lecturer4);
        this.rooms[4] = new HTWRoom("test4", "description", lecturer5);
        Alien alien1 = new FriendlyAlien("BinaryAlien", 30, true, "01101000 01101001");
        Alien alien2 = new UnfriendlyAlien("Blarg", 70, false, "Grrr");
        Alien alien3 = new UnfriendlyAlien("test", 50, false, "test");
    }
    /** 
     * gibt zurück, ob das Spiel läuft
     * @return true, wenn das Spiel läuft, sonst false
     */
    public boolean isGameRunning() {
        return gameRunning;
    }
    /**
     * legt fest, ob das Spiel läuft oder nicht.
     */
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }
    /**
     * gibt zurück, ob das Spiel beendet ist
     * @return true, wenn das Spiel beendet ist, sonst false
     */
    public boolean isGameFinished() {
        return gameFinished;
    }
    /**
     * legt das Spiel auf beendet oder nicht beendet fest.
     */
    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }
    /**
     * fragt, ob das Spiel gestartet wurde.
     */
    public void run() {
        System.out.println("The game has started. Or not?");
    }
    /**
     * gibt den Helden zurück.
     * @return den Helden
     */
    public Hero getHero() {
        return hero;
    }
}
