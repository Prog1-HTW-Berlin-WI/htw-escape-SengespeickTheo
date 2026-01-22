import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/

/**
 * steuert alles, beinhaltet Hauptmenü und Dinge die indirekt mit dem Spielen zu tun haben
 */
public class EscapeApp {

    public static final String SAVE_FILE_NAME = "save";
    private EscapeGame game;
    private boolean gameRunning = true;

    public static void main(String[] args) {
        System.out.println("Welcome to the HTW escape");
        System.out.println("========================================\n");

        EscapeApp app = new EscapeApp();

        while (true) {
            app.showMainMenu();
            String choice = app.readUserInput();
            System.out.println("");
            app.handleUserInput(choice);
            System.out.println("====================");
        }
    }

    /**
     * zeigt das Hauptmenü auf dem Terminal an, Spieler wird aufgefordert damit zu interagieren
     */
    private void showMainMenu() {
        System.out.println("You're in the main menu");
        System.out.println("What do you want to do next?");
        System.out.println("(1) Start new game");
        if(isGameRunning()) {
            System.out.println("(2) Resume game");
            System.out.println("(3) Save game");
        }
        if(hasSavedGame()) {
            System.out.println("(4) Load game");
            System.out.println("(5) Delete saved game");
        }
        System.out.println("(6) Quit");
        System.out.println("");
        System.out.println("Please choose a given number: ");
    }

    /**
     * liest eine Benutzereingabe vom Terminal ein
     * @return die Benutzereingabe als String
     */    
    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // TBD
        return userInput;
    }
    public String getReadUserInput() {
        return this.readUserInput();
    }

    /**
     * verarbeitet die Benutzereingabe und führt gewünschte Aktion (1-6) im Hauptmenü aus.
     * Falls es nicht funktioniert, wird eine Fehlermeldung ausgegeben.
     * @param input die Benutzereingabe als String.
     */
    private void handleUserInput(String input) {
        switch (input) {
            case "1":
                this.startGame();
                break;
            case "2":
                if(isGameRunning() == false){
                    System.out.println("Invalid Input. Please choose a given number.");
                } else {
                    this.resumeGame();
                }
                break;
            case "3":
                if(isGameRunning() == false) {
                    System.out.println("Invalid Input. Please choose a given number.");
                } else {
                    this.saveGame();
                }
                break;
            case "4":
                if(hasSavedGame() == false) {
                    System.out.println("Invalid Input. Please choose a given number.");
                } else {
                    this.loadGame();
                }
                break;
            case "5":
                if(isGameRunning() == false && hasSavedGame() == false) {
                    System.out.println("Invalid Input. Please choose a given number.");
                } else {
                if(this.hasSavedGame()) {
                    this.deleteGame();
                }
                }
                break;
            case "6":
                break;
            default:
                System.out.println("Invalid input. Please choose a given number.");
                break;
        }
    }
        
    /**
     * prüft, ob Spiel existiert
     * wenn ja: Frage, ob trotzdem neues ein neues Spiel erstellt werden soll oder nicht
     * wenn nein: hero Objekt wird erstellt
     * erstellt neues Objekt der Klasse EscapeGame
     */
    private void startGame() {
        if(this.game != null) {
            while (true) {
                System.out.println("A game already exists. If you haven't saved it yet, it will be lost. Do you want to start a new one anyway? (y/n)");
                String answer = readUserInput();
                if(answer.equalsIgnoreCase("n")) {
                    System.out.println("");
                    return;
                }
                if(answer.equalsIgnoreCase("y")) {
                    System.out.println("");
                    break;
                }
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
            System.out.println("Please enter your hero's name:");
            String name = readUserInput();
            System.out.println("");
            Hero hero = new Hero(name);
            this.game = new EscapeGame(hero, this);
            game.getIntroGame();
        }
        System.out.println("Please enter your hero's name:");
        String name = readUserInput();
        System.out.println("");
        Hero hero = new Hero(name);
        this.game = new EscapeGame(hero, this);
        game.getIntroGame();
    }
    
    /**
     * setzt ein laufendes Spiel fort
     */
    private void resumeGame() {
        this.game.setGameRunning(true);
        this.game.run();
        System.out.println("");
        game.gameMenu();
    }

    /**
     * getter für resumeGame
     */
    public void getResumeGame() {
        this.resumeGame();
    }

    /**
     * löscht die gespeicherte Spielstanddatei, falls eine vorhanden ist.
     * Bestätigung wird auf dem Terminal ausgegeben.
    */
    private void deleteGame() {
        if (new File(SAVE_FILE_NAME).delete()) {
            System.out.println("Game deleted!");
        }
    }

    /**
     * speichert den aktuellen Spielstand in einer Datei
     * @return true, wenn das Spiel erfolgreich gespeichert wurde, sonst false
     * Bestätigung oder Fehler wird auf dem Terminal ausgegeben.
     */
    private void saveGame() {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.flush();
        } catch (Exception ex) {
            System.err.println("Something went wrong while saving the game: " + ex.getMessage());
            return;
        }
        System.out.println("Game saved!");
    }

    /**
     * lädt ein gespeichertes Spiel aus einer Datei und gibt Bestätigung auf dem Terminal aus.
     * Wenn es nicht funktioniert, wird eine Fehlermeldung ausgegeben.
     */
    private void loadGame() {
        try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.game = (EscapeGame) ois.readObject();
            System.out.println("Game loaded!");
        } catch (Exception ex) {
            System.err.println("Something went wrong while loading the game: " + ex.getMessage());
        }
    }

    /**
     * gibt zurück, ob ein Spiel läuft
     * @return true, wenn ein Spiel läuft, sonst false
     */
    private boolean isGameRunning() {
        return game != null;
    }

    /**
     * gibt zurück, ob das Spiel beendet ist
     * @return true, wenn das Spiel beendet ist, sonst false
     */
    private boolean isGameFinished() {
        return game != null && game.isGameFinished();
    }

    /**
     * prüft, ob eine gespeicherte Spielstanddatei existiert
     * @return true, wenn eine gespeicherte Spielstanddatei existiert, sonst false
     */
    private boolean hasSavedGame() {
        return new File(SAVE_FILE_NAME).exists();
    }
}