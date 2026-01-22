import model.Hero;

import java.io.Serializable;

import model.HTWRoom;

/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/


/**
 * steuert das Spiel/Spielmenü
 */
public class EscapeGame {
    private EscapeApp app;
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[5];
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    private Alien alien1;
    private Alien alien2;
    private Alien alien3;
    private Alien alien4;
    private Alien alien5;
    private int rounds = 0;
    private int maxRound = 24;
    private boolean shortRestUsed = false;

    /**
     * initialisiert einen neuen Helden, Lecturer, HTWRooms und Aliens mit deren Eigenschaften.
     * vorhanden: Lecturer = 5, Rooms = 5, alien = 5
     */
    public EscapeGame(Hero hero, EscapeApp app) {
        this.hero = hero;
        this.app = app;
        Lecturer lecturer1 = new Lecturer("Poeser");
        Lecturer lecturer2 = new Lecturer("Gärtner");
        Lecturer lecturer3 = new Lecturer("Vaseva");
        Lecturer lecturer4 = new Lecturer("Safitri");
        Lecturer lecturer5 = new Lecturer("Gnaoui");
        this.rooms[0] = new HTWRoom("A238", "You have entered room A238. It's a big lecture hall, to your left you can see stairs going up to the seats. In front of you are big windows, that have been darkened with slime by some aliens. You can only see a slight shimmer of light...", lecturer1);
        this.rooms[1] = new HTWRoom("A219", "You have entered room A219. It's a small lecture hall with a few desks and chairs. There is a strange smell in the air and a weird looking liquid on the floor, probably left by an Alien passing through.", lecturer2);
        this.rooms[2] = new HTWRoom("Mensa", "You have entered the HTW Mensa, where people usually sit and enjoy their delicious food. But today it looks more like a horror scene than a place to eat at. No people, no service, no food. Just a dark room filled with emptiness.", lecturer3);
        this.rooms[3] = new HTWRoom("Internetcafe", "You have entered the room, where students do their homework or wait for the next lecture to start. Filled with a couple of computers, chairs and desks and the view of the courtyard. You look out the window and see aliens running everywhere. Hopefully they don't catch a sight of you!", lecturer4);
        this.rooms[4] = new HTWRoom("Sportshall", "You have entered the sportshall, it's a very big room, but the windows have been darkened by the alien invadors. Because there is no light you can only see half of the room... But you can here some strange noises from the dark side of the hall. You decide not to investigate, because you have a life worth to live.", lecturer5);
        alien1 = new FriendlyAlien("BinaryAlien", 50, true, "'01101000 01101001'");
        alien2 = new UnfriendlyAlien("Blarg", 30, false, "'Grrr'");
        alien3 = new UnfriendlyAlien("JavaAlien", 50, false, "'System.out.println('Do not come near me or you will get decoded')'");
        alien4 = new UnfriendlyAlien("Pi-lien", 50, false, "'My infinite number 3,14... will destroy you'" );
        alien5 = new FriendlyAlien("Booklien", 100, true, "'We have an invasion yes, but i also need you to be silent as i'm still not finished reading my book 'Angewandte Programmierung' for next Semester! So pshhhh.....!!'");
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

    /**
     * Intro zum Spiel mit treffen der Schnecke, kleine Erklärung zum Spielmenü
     */
    private void introGame() {
        System.out.println("");
        System.out.println("It's 8 am in the morning and you are packing your backpack for university");
        System.out.println("You're still feeling a little bit tired, but you need to be early for your first lecture.");
        System.out.println("After half an hour of traveling by tram, you arrive near the HTW to get a morning coffee.");
        System.out.println("While entering Building A you feel that something is off...");
        System.out.println("Suddenly, a big snail appears right in front of you. In shock, you spill your whole coffee on yourself.");
        System.out.println("");
        System.out.println("What do you want to do now? (1) Try to run away or (2) Talk to the snail?");
        while (true) {
                String answer = app.getReadUserInput();
                if(answer.equalsIgnoreCase("1")) {
                    System.out.println("");
                    System.out.println("You try to run away, but the Door of Building A is locked! In panic you realise, that the snail is coming towards you.");
                    break;
                }
                if(answer.equalsIgnoreCase("2")) {
                    System.out.println("");
                    System.out.println(getHero().name + ": 'Who are you? What are you doing here?'");
                    System.out.println("Snail: 'Me? Ohh I'm a normal snail, just a little bit bigger than usual.");
                    System.out.println(getHero().name + ": Are you dangerous?");
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
        System.out.println("");
        System.out.println("Do you wan't to continue? (y)... You have no other choice... Press (y)");
        while (true) {
            String answer = app.getReadUserInput();
            if(answer.equalsIgnoreCase("y")) {
                System.out.println("");
                app.getResumeGame();
                break;
            }
        System.out.println("Sorry, you will have to take the adventure. Press (y) in order to continue.");
        }
    }

        /**
         * getter für IntroGame
         */
    public void getIntroGame() {
        this.introGame();
    }

    /**
    * Anzeige für das Spielmenü und Spieler kann mit Eingabe 4 zurück ins Hauptmenü 
    */
    public void gameMenu() {
        while (true) {
        System.out.println("========================================\n");
        System.out.println("");
        System.out.println("You're now in the game menu.");
        System.out.println("What do you want to do next?");
        System.out.println("(1) Explore HTW");
        System.out.println("(2) Show hero status");
        System.out.println("(3) Rest your hero");
        System.out.println("(4) Back to main menu");

        String answer = app.getReadUserInput();
        if(answer.equals("4")) {
            System.out.println("");
            return;
        }
        handleUserInputGameMenu(answer);
        }
    }

    /**
    * mit User Input von der Spielmenü Anzeige umgehen
    * 1: explore HTW
    * 2: hero status
    * 3: rest:  lange Pause, kurze Pause, oder Quit=zurück ins Spielmenü
    * -entscheidet ob Spieler noch eine kurze Pause in der Runde machen darf
    * 4: back to main menu
    * bei falscher Eingabe bekommt der Spieler eine Fehlermeldung
    * @param input Nutzereingabe für das Spielmenü
    */
    private void handleUserInputGameMenu(String input) {
        switch (input) {
            case "1":        
                if(gameFinished) {
                    System.out.println("You already finished this game. You can start a new one if you want to...");
                    return;
                }       
                exploreHTW();
                break;
            case "2":
                System.out.println("");
                showHeroStatus();
                break;
            case "3":
                System.out.println("");
                System.out.println("Do you want to rest for a long time (+10 HP, costs 1 round) or a short time (+3 HP, only once per round)? (l/s) or go back to the game menu (q)");
                String answer = app.getReadUserInput();
                while(true) {
                    if(answer.equalsIgnoreCase("l")) {
                        System.out.println("");
                        hero.regenerate(true);
                        rounds++;
                        backToGameMenu();
                        break;
                    } else if(answer.equalsIgnoreCase("s")) {
                        System.out.println("");
                        if(shortRestUsed) {
                            System.out.println("You already used your short rest this round. Come back next round!");
                            backToGameMenu();
                            break;
                        } else {
                            hero.regenerate(false);
                            shortRestUsed = true;
                            backToGameMenu();
                            break;
                            }
                    } else if(answer.equalsIgnoreCase("q")) {
                        System.out.println("");
                            break;
                    } else {
                        System.out.println("Invalid input. Please enter 'l' or 's' or 'q'.");
                        answer = app.getReadUserInput();
                        System.out.println("");
                    }
                }
                break;
            default:
                System.out.println("Invalid input. Please choose a correct number between 1 and 4");
                break;
        }
    }

    /**
    * HTW erkunden: 
    * wenn hero zu schwach, Meldung dass er sich erst heilen muss
    * zählt wie viele Runden der Spieler schon gespielt hat
    * Möglichkeit zwischen ereignislos, Alien treffen, Lecturer treffen
    * wenn Spieler alle Unterschriften hat oder max Runden überschritten hat -> endGame()
    */
    public void exploreHTW() {
        if(hero.getHealthPoints() <= 0) {
            System.out.println("You are too weak to explore the HTW. You must rest before you can continue.");
            backToGameMenu();
            return;
        }
        
        System.out.println("");
        rounds++;
        shortRestUsed = false;
        System.out.println("========================================\n");
        System.out.println("");
        System.out.println("Round " + rounds + "/24 has started.");

        int zufallszahl = (int) (Math.random() * 100) + 1;
        if(zufallszahl <=20) {
            eventless();
        } else if(zufallszahl > 20 && zufallszahl <= 72) {
            meetAlien();
        } else {
            meetLecturer();
        }
        allSignaturesCollected();

        if(allSignaturesCollected() && rounds <= maxRound) {
            endGame();
            return;
        }
        if(rounds >= maxRound) {
            endGame();
            return;
        }
    }

    /**
    * Möglichkeit "ereignislos"
    * gibt zufällig verschiedene Texte aus
    */
    public void eventless() {
        int zufallszahl = (int) (Math.random() * 100) + 1;
        if(zufallszahl <= 25) {
            System.out.println("You explored Building B. Sadly you haven't found anything you need. Maybe try somewhere else...");
            backToGameMenu();
        } else if(zufallszahl > 26 && zufallszahl <= 50) {
            System.out.println("You entered room A241. It's very dark in here... you see a strange silouette that's lurking in the corner. Maybe it's better to turn back, it doesn't seem safe in here...");
            backToGameMenu();
        } else if(zufallszahl > 51 && zufallszahl <= 75) {
            System.out.println("You want to enter Building C, but the entrance is covered by aliens. Sadly you're not strong enough to beat that many. Maybe try somewhere else...");
            backToGameMenu();
        } else {
            System.out.println("You see an interesting looking hallway. At the end of it you see a tiny light shimmering, which emits a high pitched sound. You try to approach it, but the closer you come, the worse it gets. Seems like you won't find something here.");
            backToGameMenu();
        }
    }

    /**
     * Möglichkeit "Alien treffen"
     * 2 freundliche Aliens und 3 unfreundliche
     * freundliche geben eine kurze Konversation und etwas EP
     * bei unfreundlichen kann man kämpfen (bis einer 0 LP hat) oder fliehen (nur 1 Fluchtversuch)
     * gibt während dem Kampf LP und Schaden von Alien/Hero an
     * nach einem Kampf gibt es 1EP (verloren) oder 5EP (gewonnen)
     */
    public void meetAlien(){
        int zufallszahl = (int) (Math.random() * 100) + 1;

        // Alien 1 BinaryAlien friendly:
        if(zufallszahl <= 20) {
            System.out.println("You encounter " + alien1.name + "!");
            System.out.println(alien1.name + ": " + alien1.greeting);
            System.out.println("");
            System.out.println(hero.name + ": Hi. Do you only speak binary?'");
            System.out.println("");
            System.out.println(alien1.name + ": '01111001 01100101 01110011 00100000 01110111 01101000 01100001 01110100 00100000 01100001 01110010 01100101 00100000 01111001 01101111 01110101 00100000 01100100 01101111 01101001 01101110 01100111 00100000 01101000 01100101 01110010 01100101 00111111'");
            System.out.println("");
            System.out.println(hero.name + ": 'Luckily i paid attention in my lectures... I'm trying to escape from here. Can you help me?'");
            System.out.println("");
            System.out.println(alien1.name + ": '01001111 01100110 00100000 01100011 01101111 01110101 01110010 01110011 01100101 00100000 01101000 01100101 01110010 01100101 00100000 01100001 01110010 01100101 00100000 00110010 01000101 01010000'");
            hero.addExperiencePoints(2);
            System.out.println("");
            System.out.println(hero.name + ": 'Thank you!'");
            backToGameMenu();

        // Alien 2 Blarg unfriendly:    
        } else if(zufallszahl > 21 && zufallszahl <= 40) {  
            System.out.println("You encounter " + alien2.name + "!");
            System.out.println(alien2.name + ": " + alien2.greeting);
            System.out.println("");    
            alien2.resetLifePoints(30);
            boolean allowedToFlee = true;

            while(!alien2.isDefeated() && hero.isOperational()) {
                System.out.println("");
                System.out.println("What do you want to do?");
                System.out.println("(1) Attack");
                System.out.println("(2) Flee (Warning: You can only try to flee one time!)");
                String answer = app.getReadUserInput();

                if(answer.equals("1")) {
                    System.out.println("");
                    System.out.println("________________________________");
                    hero.attack(alien2);
                    System.out.println(alien2.name + " has " + alien2.getLifePoints() + " life points left.");
                    if(alien2.isDefeated()) {
                        hero.addExperiencePoints(5);
                        backToGameMenu();
                        return;
                    }
                    alien2.attack(hero);
                    System.out.println("You have " + hero.getHealthPoints() + " health points left.");
                    if(!hero.isOperational()) {
                        System.out.println("You have been defeated...");
                        hero.addExperiencePoints(1);
                        backToGameMenu();
                        return;
                    }

                } else if(answer.equals("2") && allowedToFlee) {
                    System.out.println("");
                    System.out.println("________________________________");
                    if(hero.flee()) {
                        backToGameMenu();
                        return;
                    }
                    allowedToFlee = false;
                    alien2.attack(hero);
                    System.out.println("You have " + hero.getHealthPoints() + " health points left");
                    if(!hero.isOperational()) {
                        System.out.println("You have been defeated...");
                        hero.addExperiencePoints(1);
                        backToGameMenu();
                        return;
                    }

                } else {
                    if(answer.equals("2") && allowedToFlee == false){
                        System.out.println("");
                        System.out.println("You already tried to flee. Press (1) to fight!");
                    } else {
                    System.out.println("Invalid Input. Enter (1) or (2).");
                    }
                }
            }

        // Alien 3 JavaAlien unfriendly:
        } else if(zufallszahl > 41 && zufallszahl <= 60) {
            System.out.println("You encounter " + alien3.name + "!");
            System.out.println(alien3.name + ": " + alien3.greeting);
            System.out.println("");
            
            alien3.resetLifePoints(50);
            boolean allowedToFlee = true;

            while(!alien3.isDefeated() && hero.isOperational()) {
                System.out.println("");
                System.out.println("What do you want to do?");
                System.out.println("(1) Attack");
                System.out.println("(2) Flee (Warning: You can only try to flee one time!)");
                String answer = app.getReadUserInput();

                if(answer.equals("1")) {
                    System.out.println("");
                    System.out.println("________________________________");
                    hero.attack(alien3);
                    System.out.println(alien3.name + " has " + alien3.getLifePoints() + " life points left.");
                    if(alien3.isDefeated()) {
                        hero.addExperiencePoints(5);
                        backToGameMenu();
                        return;
                    }
                    alien3.attack(hero);
                    System.out.println("You have " + hero.getHealthPoints() + " health points left.");
                    if(!hero.isOperational()) {
                        System.out.println("You have been defeated...");
                        hero.addExperiencePoints(1);
                        backToGameMenu();
                        return;
                    }

                } else if(answer.equals("2") && allowedToFlee) {
                    System.out.println("");
                    System.out.println("________________________________");
                    if(hero.flee()) {
                        backToGameMenu();
                        return;
                    }
                    allowedToFlee = false;
                    alien3.attack(hero);
                    System.out.println("You have " + hero.getHealthPoints() + " health points left");
                    if(!hero.isOperational()) {
                        System.out.println("You have been defeated...");
                        hero.addExperiencePoints(1);
                        backToGameMenu();
                        return;
                    }

                } else {
                    if(answer.equals("2") && allowedToFlee == false){
                        System.out.println("");
                        System.out.println("You already tried to flee. Press (1) to fight!");
                    } else {
                    System.out.println("Invalid Input. Enter (1) or (2).");
                    }
                }
            }

        // Alien 4 Pi-lien unfriendly:
        } else if(zufallszahl > 61 && zufallszahl <= 81) {
            System.out.println("You encounter " + alien4.name + "!");
            System.out.println(alien4.name + ": " + alien4.greeting);
            System.out.println("");
            
            alien4.resetLifePoints(50);
            boolean allowedToFlee = true;

            while(!alien4.isDefeated() && hero.isOperational()) {
                System.out.println("");
                System.out.println("What do you want to do?");
                System.out.println("(1) Attack");
                System.out.println("(2) Flee (Warning: You can only try to flee one time!)");
                String answer = app.getReadUserInput();

                if(answer.equals("1")) {
                    System.out.println("");
                    System.out.println("________________________________");
                    hero.attack(alien4);
                    System.out.println(alien4.name + " has " + alien4.getLifePoints() + " life points left.");
                    if(alien4.isDefeated()) {
                        hero.addExperiencePoints(5);
                        backToGameMenu();
                        return;
                    }
                    alien4.attack(hero);
                    System.out.println("You have " + hero.getHealthPoints() + " health points left.");
                    if(!hero.isOperational()) {
                        System.out.println("You have been defeated...");
                        hero.addExperiencePoints(1);
                        backToGameMenu();
                        return;
                    }

                } else if(answer.equals("2") && allowedToFlee) {
                    System.out.println("");
                    System.out.println("________________________________");
                    if(hero.flee()) {
                        backToGameMenu();
                        return;
                    }
                    allowedToFlee = false;
                    alien4.attack(hero);
                    System.out.println("You have " + hero.getHealthPoints() + " health points left");
                    if(!hero.isOperational()) {
                        System.out.println("You have been defeated...");
                        hero.addExperiencePoints(1);
                        backToGameMenu();
                        return;
                    }

                } else {
                    if(answer.equals("2") && allowedToFlee == false){
                        System.out.println("");
                        System.out.println("You already tried to flee. Press (1) to fight!");
                    } else {
                    System.out.println("Invalid Input. Enter (1) or (2).");
                    }
                }
            }

        // Alien 5 Booklien friendly:
        } else {
            System.out.println("You encounter " + alien5.name + "!");
            System.out.println(alien5.name + ": " + alien5.greeting);
            System.out.println("");
            System.out.println(hero.name + " *whispering*: 'Im sorry, im just trying to find lecturers. Can you maybe help me?'");
            System.out.println("");
            System.out.println(alien5.name + ": 'If you won't leave otherwise... I heard there's a lecturer in room A238. Maybe try there.'");
            System.out.println("");
            System.out.println(hero.name + ": 'Thank you so mu-'");
            System.out.println("");
            System.out.println(alien5.name + ": 'Silence please!'");
            backToGameMenu();              
        }
    }

    /** Möglichkeit "lecturer treffen"
     * 5 lecturer, alle mit unterschiedlichem Dialog
     * erst wird geprüft, ob schon unterschrieben ist
     * wenn nicht, ob er/sie bereit dazu ist
     * wenn ja wird unterschrieben
     * wenn nicht wird dem Spieler vom Lecturer gesagt, dass er später wiederkommen soll
     * Spieler kann Lecturer mehrfach treffen, wenn er die Unterschrift schon hat, wird ihm gesagt, er soll einen anderen Lecturer finden
     * danach backToGameMenu()
     */
    public void meetLecturer(){
        int zufallszahl = (int) (Math.random() * 100) + 1;
        if(zufallszahl <= 20) {
            System.out.println(rooms[0].description);
            System.out.println("In the darkness you can see a person standing a few meters away from you. It's lecturer " + rooms[0].lecturer.name + ". You sigh in relieve. It's good to see a familiar face.");
            System.out.println("");
            System.out.println(hero.name + ": 'Hello lecturer " + rooms[0].lecturer.name + "! How are you doing?'");
            System.out.println("");
            System.out.println(rooms[0].lecturer.name + ": 'I'm doing fine at the moment, but you shouldn't be here, it's not safe.'");
            System.out.println("");
            System.out.println(hero.name + ": 'You're right, that's why i need your help. Could i please get your signature, so i can find Prof. Majuntke? She'll help us get out of here.'");
            System.out.println("");
            if(rooms[0].lecturer.hasSigned) {
                System.out.println(rooms[0].lecturer.name + ": 'As it seems, you already have my signature. Try to find another one... Good luck!'");
                backToGameMenu();
                return;
            }
            if(rooms[0].lecturer.isReadyToSign()) {
                rooms[0].lecturer.sign();
                hero.signExerciseLeader(rooms[0].lecturer);
                backToGameMenu();
                return;
            }
            backToGameMenu();
            return;
    
        } else if(zufallszahl > 21 && zufallszahl <= 40) {
            System.out.println(rooms[1].description);
            System.out.println("As you try to investigate the liquid on the floor, you realize you're not alone. Luckily it isn't any danger. It's lecturer " + rooms[1].lecturer.name + "." );
            System.out.println("");
            System.out.println(hero.name + ": 'What happened here?'");
            System.out.println("");
            System.out.println(rooms[1].lecturer.name + ": 'I don't know. And we probably don't want to know... Why are you here?'");
            System.out.println("");
            System.out.println(hero.name + ": 'I need to collect signatures in order to find Prof. Majuntke... She can help us get out of here. Could you help me out?'");
            System.out.println("");
            if(rooms[1].lecturer.hasSigned) {
                System.out.println(rooms[1].lecturer.name + ": 'As it seems, you already have my signature. Try to find another one... Good luck!'");
                backToGameMenu();
                return;
            }
            if(rooms[1].lecturer.isReadyToSign()) {
                rooms[1].lecturer.sign();
                hero.signExerciseLeader(rooms[1].lecturer);
                backToGameMenu();
                return;
            }
            backToGameMenu();
            return;

        } else if(zufallszahl > 41 && zufallszahl <= 60) {
            System.out.println(rooms[2].description);
            System.out.println("");
            System.out.println(rooms[2].lecturer.name + ": 'Hello " + hero.name + ", are you also looking for food here? Sadly the aliens ate everything.'");
            System.out.println("");
            System.out.println(hero.name + ": 'No, i was actually looking for you. I'm collecting signatures from all lecturers, they will help me find Prof. Majuntke. She knows how to get out of this place. Could you please help me out?'");
            System.out.println("");
            if(rooms[2].lecturer.hasSigned) {
                System.out.println(rooms[2].lecturer.name + ": 'As it seems, you already have my signature. Try to find another one... Good luck!'");
                backToGameMenu();
                return;
            }
            if(rooms[2].lecturer.isReadyToSign()) {
                rooms[2].lecturer.sign();
                hero.signExerciseLeader(rooms[2].lecturer);
                backToGameMenu();
                return;
            }
            backToGameMenu();
            return;

        } else if(zufallszahl > 61 && zufallszahl <= 81) {
            System.out.println(rooms[3].description);
            System.out.println("");
            System.out.println("Suddenly you hear a sound coming from the corner of the room. Whatever it is, it heard you... You try to peek over a table only to see lecturer " + rooms[3].lecturer.name + " working with PC parts.");
            System.out.println("");
            System.out.println(hero.name + ": 'Lecturer " + rooms[3].lecturer.name + "? What are you doing there? Are you alright?'");
            System.out.println("");
            System.out.println(rooms[3].lecturer.name + ": 'Hello " + hero.name + "! Don't worry, I'm just trying to build some sort of weapon so we can fight these aliens off! What are you doing here?'");
            System.out.println(hero.name + ": 'I'm trying to find Prof. Majuntke. She seems to be the only one to know a way out of here. In order to find her i need to collect signatures... Can you help me?'");
            System.out.println("");
            if(rooms[3].lecturer.hasSigned) {
                System.out.println(rooms[3].lecturer.name + ": 'As it seems, you already have my signature. Try to find another one... Good luck!'");
                backToGameMenu();
                return;
            }
            if(rooms[3].lecturer.isReadyToSign()) {
                rooms[3].lecturer.sign();
                hero.signExerciseLeader(rooms[3].lecturer);
                backToGameMenu();
                return;
            }
            backToGameMenu();
            return;

        } else {
            System.out.println(rooms[4].description);
            System.out.println("");
            System.out.println("Suddenly, you hear a voice whispering behind you. You jump back and turn around...");
            System.out.println("");
            System.out.println(rooms[4].lecturer.name + ": 'Stay silent! We don't want to find out what's on the other side of the hall. What are you doing here?'");
            System.out.println("");
            System.out.println(hero.name + ": 'I'm collecting signatures to find Prof. Majuntke. Can you help me so we can leave this place?'");
            System.out.println("");
            System.out.println(hero.name + ": 'Hello lecturer " + rooms[4].lecturer.name + "! Could you please sign here for me, so i can find Prof. Majuntke?'");
            System.out.println("");
            if(rooms[4].lecturer.hasSigned) {
                System.out.println(rooms[4].lecturer.name + ": 'As it seems, you already have my signature. Try to find another one... Good luck!'");
                backToGameMenu();
                return;
            }
            if(rooms[4].lecturer.isReadyToSign()) {
                rooms[4].lecturer.sign();
                hero.signExerciseLeader(rooms[4].lecturer);
                backToGameMenu();
                return;
            }
            backToGameMenu();
            return;
        }
    }

    /**
     * Hero Status
     * gibt Eigenschaften vom Hero an: name, healthpoints, experiencePoints, Anzahl Unterschriften lecturer und der jeweilige name, Anzahl Runden
     * danach kann Spieler backToGameMenu()
     */
    public void showHeroStatus(){
        int count = 0;
        System.out.println("");
        System.out.println("Name: " + hero.name);
        System.out.println("Health points: " + hero.healthPoints);
        System.out.println("Experience points: " + hero.experiencePoints);
        for(int i = 0; i < hero.signedExerciseLeaders.length; i++) {
            if(hero.signedExerciseLeaders[i] != null) {
                count++;
            }
        }
        System.out.println("Signatures: " + count + "/5");
        System.out.println("Signed Lecturers (names): ");
            
        for(int i = 0; i < hero.signedExerciseLeaders.length; i++) {
            if(hero.signedExerciseLeaders[i] != null) {
                System.out.println("-" + hero.signedExerciseLeaders[i].name);
            }
        }
        System.out.println("Current round: " + rounds + "/" + maxRound);
        backToGameMenu();
    }

    /** 
     * ermöglicht es Spieler mit Eingabe (1) ins Spielmenü zurückzukehren
     * nach bspw. "ereignislos"
     */
    public void backToGameMenu() {
        System.out.println("Press (1) to get back to the game menu.");
        while(true) {
            String answer = app.getReadUserInput();
            if(answer.equals("1")) {
                break;
            }
            System.out.println("Press (1) to get back to the game menu.");
        }
    }

    /**
     * zählt wie viele Unterschriften der Spieler gesammelt hat
     * @return false wenn spieler noch nicht alle hat
     * @return true wenn er alle gesammelt hat
     */
    public boolean allSignaturesCollected() {
        for(int i = 0; i < rooms.length ; i++) {
            if(rooms[i].lecturer.hasSigned == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * je nachdem, wie viele Unterschriften der Spieler hat oder wie viele Runden er hat, bekommt er verschiedene Endszenarien
     * 3 Enden: 
     * -alle Unterschriften und unter 24 Runden und Frage richtig beantwortet
     * -alle Unterschriften und unter 24 Runden und Frage falsch beantwortet
     * -nicht genug Unterschriften und/oder 24 Runden überschritten
     */
    
    public void endGame() {
        gameFinished = true;
        boolean escaped = false;
        if(allSignaturesCollected() && rounds <= maxRound) {
            int attempt = 0;
            System.out.println("Good job you got all 5 signatures!");
            System.out.println("");
            System.out.println("Suddenly you hear a strange noise coming from the roof of the university, like something heavy was moving above the lecture hall. You go upstairs with silent steps, so no alien can hear you walking. Every inch that you are moving more towards the roof, you feel your legs getting heavier with each step.");
            System.out.println("As you approach the door, which is already opened, you see Prof. Majunkte stepping out of an UFO with confidence. She adjusts her glasses like she was about to correct the entire planet. The air feels thick and so wrong that you almost want to go back inside. Within a glimpse of an eye, you saw her walking down the ramp slowly with a presence. She looks around with a small, self-satisfied smile, as if you just failed your final exam.");
            System.out.println("Within seconds, she announces: ' You are finally here...' and somehow it sounds like a final verdict."); 
            System.out.println("");
            System.out.println("Prof. Majuntke: 'You want to get out of here?");
            System.out.println("");
            System.out.println(hero.name + ": 'Yes, i've been looking for you. I collected every signature to find you. You need to help me");
            System.out.println("");
            System.out.println("Prof. Majunkte: 'I can and I will, but only if you can answer one question...");
            System.out.println("");
            int zufallszahl = (int) (Math.random() * 100) + 1;
            if(zufallszahl<33){
                System.out.println("Prof. Majunkte: 'Which statement about the following code snippet is correct?'");
                System.out.println("");
                System.out.println("int sum = 0;");
                System.out.println("for (int i = 1; i <=5; i++) {");
                System.out.println("    sum +=i;");
                System.out.println("}");
                System.out.println("System.out.println(sum)");
                System.out.println("");
                System.out.println("(1) The value of sum after the loop is 5.");
                System.out.println("(2) The loop runs exactly 4 times.");
                System.out.println("(3) The output printed to the console is 15.");
                System.out.println("(4) sum never changes");
                System.out.println("");
                while(attempt < 2) {
                    String answer = app.getReadUserInput();
                    if(answer.equals("3")){
                        escaped = true;
                        break;
                    } else {
                        attempt++;
                        if(attempt == 1){
                            System.out.println("Prof. Majuntke: 'Wrong answer. You got one more try...'");
                        } 
                    }
                }
            } else if(zufallszahl >=34 && zufallszahl <66) {
                System.out.println("Prof. Majunkte: 'What does the operator % do in Java?'");
                System.out.println("");
                System.out.println("(1) Division");
                System.out.println("(2) Modulus");
                System.out.println("(3) Multiplication");
                System.out.println("(4) gives percentage of number");
                System.out.println("");
                while(attempt < 2) {
                    String answer = app.getReadUserInput();
                    if(answer.equals("2")){
                        System.out.println("");
                        escaped = true;
                        break;
                    } else {
                        attempt++;
                        if(attempt == 1){
                            System.out.println("Prof. Majuntke: 'Wrong answer. You got one more try...'");
                        } 
                    }
                }
            } else {
                System.out.println("Prof. Majunkte: 'What is the final value of count after this code runs?'");
                System.out.println("");
                System.out.println("int count = 0;");
                System.out.println("int i = 5");
                System.out.println("while (i-- > 0) {");
                System.out.println("    if((i % 2 == 0) || (i == 3)) {");
                System.out.println("        count++;");
                System.out.println("    }");
                System.out.println("}");
                System.out.println("System.out.println(count);");
                System.out.println("");
                System.out.println("(1) 1");
                System.out.println("(2) 2");
                System.out.println("(3) 3");
                System.out.println("(4) 4");
                System.out.println("");
                while(attempt < 2) {
                    String answer = app.getReadUserInput();
                    if(answer.equals("3")){
                        System.out.println("");
                        escaped = true;
                        break;
                    } else {
                        attempt++;
                        if(attempt == 1){
                            System.out.println("Prof. Majuntke: 'Wrong answer. You got one more try...'");
                        }
                    }
                }
            }

            if(escaped){
                endScene();
            } else {
                System.out.println("Prof. Majuntke: 'Wrong again... All that effort for nothing...");
                System.out.println("");
                System.out.println("Prof. Majuntke gets back into her UFO. In desperation you try to run after her but she's years ahead. Devastated you realize that you will be trapped here forever...");
            }
        
            backToGameMenu();
            return;
        } else {
        System.out.println("You failed to escape the HTW.");
        backToGameMenu();
        return;
        }
    } 

    /**
     * Textausgabe für eins von den Enden von endGame()
     */
    public void endScene() {
        System.out.println("");
        System.out.println("Prof. Majunkte: 'Good job! Here's the key to unlock the HTW entrance. I have to go now... but before i do that i still have something to do.");
        System.out.println("");
        System.out.println("While still being in disbelief, that you finally can leave the university now... Prof. Majuntke snipps with her fingers...");
        System.out.println("");
        System.out.println("Prof. Majunkte: 'Look down in the courtyard.'");
        System.out.println("");
        System.out.println("As you look down in the courtyard filled with aliens, you see them disappearing into thin air, one by one, until there's not one left.");
        System.out.println("You hear a loud high pitched noise behind you and as you turn around you see Prof. Majuntke standing on the ramp of her UFO, which is already in the air, waving towards you.");
        System.out.println("You wave back with a smile on your face and as soon as she's gone you immediately run to the entrance. You unlock the door and smell the air of freedom.");
        System.out.println("In your still coffee drenched tshirt you walk towards the tram.");
        System.out.println("");
        System.out.println("It's time to go home...");
    }
}


