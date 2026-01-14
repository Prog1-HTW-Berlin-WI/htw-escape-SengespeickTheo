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
            app.handleUserInput(choice);
            System.out.println("====================");
        }
    }
    /**
     * zeigt das Hauptmenü auf dem Terminal an
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
        System.out.println("Please choose a number between 1 and 6: ");
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
    /**
     * verarbeitet die Benutzereingabe und führt gewünschte Aktion aus.
     * Falls es nicht funktioniert, wird eine Fehlermeldung ausgegeben.
     * @param input die Benutzereingabe als String.
     */
    private void handleUserInput(String input) {
        switch (input) {
            case "1":
                this.startGame();
                break;
            case "2":
                this.resumeGame();
            case "3":
                if(this.hasSavedGame()) {
                    this.loadGame();
                }
                break;
            case "4":
                this.saveGame();
            case "5":
                if(this.hasSavedGame()) {
                    this.deleteGame();
                }
                break;
            case "6":
                break;
            default:
                System.out.println("Invalid input. Please choose a correct number between 1 and 6");
                break;
        }
    }
    /**
     * startet ein neues Spiel
     * erstellt neues Objekt der Klasse EscapeGame
     */
    private void startGame() {
        if(this.game != null) {
            while (true) {
                System.out.println("A game already exists. If you haven't saved it yet, it will be lost. Do you want to start a new one anyway? (y/n)");
                String answer = readUserInput();
                if(answer.equalsIgnoreCase("n")) {
                    return;
                }
                if(answer.equalsIgnoreCase("y")) {
                    break;
                }
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
            System.out.println("Please enter your hero's name:");
            String name = readUserInput();
            Hero hero = new Hero(name);
            this.game = new EscapeGame(hero);
            introGame();
        }
        System.out.println("Please enter your hero's name:");
        String name = readUserInput();
        Hero hero = new Hero(name);
        this.game = new EscapeGame(hero);
        introGame();
    }
    
    /**
     * setzt ein laufendes Spiel fort
     */
    private void resumeGame() {
        this.game.setGameRunning(true);
        this.game.run();
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

    private void introGame() {
        System.out.println("It's 8 am in the morning and you are packing your backpack for university");
        System.out.println("You're still feeling a little bit tired, but you need to be early for your first lecture.");
        System.out.println("After half an hour of traveling by tram, you arrive near the HTW to get a morning coffee.");
        System.out.println("While entering Building A you feel that something is off...");
        System.out.println("Suddenly, a big snail appears right in front of you. In shock, you spill your whole coffee on yourself.");
        System.out.println("What do you want to do now? (1) Try to run away or (2) Talk to the snail?");
        while (true) {
                String answer = readUserInput();
                if(answer.equalsIgnoreCase("1")) {
                    System.out.println("");
                    System.out.println("You try to run away, but the Door of Building A is locked! In panic you realise, that the snail is coming towards you.");
                    break;
                }
                if(answer.equalsIgnoreCase("2")) {
                    System.out.println("");
                    System.out.println(game.getHero().name + ": 'Who are you? What are you doing here?'");
                    System.out.println("Snail: 'Me? Ohh I'm a normal snail, just a little bit bigger than usual.");
                    System.out.println(game.getHero().name + ": Are you dangerous?");
                    break;
                }
                System.out.println("Invalid input. Please enter '1' or '2' in order to continue with the game.");
        }
        System.out.println("");
        System.out.println("Snail: 'Ohh, don't worry. I'm not dangerous at all. In fact, I'm here to help you escape this place. Let me explain...");
        System.out.println("Aliens have invaded the HTW and taken over the building. It's completely locked down and you can't leave.");
        System.out.println("You have to find all the five lecturers, who are also trapped here, and get them to sign your escape paper.");
        System.out.println("Only when you have all five signatures, you will be able to find Prof. Majuntke, who can help you escape this place.");
        System.out.println("But be careful! You only have 24 hours (= rounds) before its too late! There are aliens lurking around the building.");
        System.out.println("Some of them are friendly and will not harm you, but some are dangerous and will not let you pass without a fight. Good luck!'");
        System.out.println("");
        System.out.println("You will now get into the game menu. Each time you press 'explore HTW' you will spend one hour (= round).");
        System.out.println("There will be different scenarios each time you explore and you will have to take action based on the situation.");
        System.out.println("Do you wan't to continue? (y)... You have no other choice... Press (y)");
        while (true) {
            String answer = readUserInput();
            if(answer.equalsIgnoreCase("y")) {
                resumeGame();
                break;
            }
        System.out.println("Sorry, you will have to take the adventure. Press (y) in order to continue.");
    }
}
}
