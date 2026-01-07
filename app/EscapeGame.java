import model.Hero;
import model.HTWRoom;

/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/



public class EscapeGame {
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[3];
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    /**
     * initialisiert einen neuen Helden
     */
    public EscapeGame() {
        this.hero = new Hero();
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
