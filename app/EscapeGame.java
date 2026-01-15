import model.Hero;
import model.HTWRoom;

/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/



public class EscapeGame {
    private EscapeApp app;
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[5];
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    /**
     * initialisiert einen neuen Helden, HTWRooms, Lecturer und Aliens.
     */
    public EscapeGame(Hero hero, EscapeApp app) {
        this.hero = hero;
        this.app = app;
        Lecturer lecturer1 = new Lecturer("Poeser");
        Lecturer lecturer2 = new Lecturer("Gärt");
        Lecturer lecturer3 = new Lecturer("Vaseva");
        Lecturer lecturer4 = new Lecturer("Safitri");
        Lecturer lecturer5 = new Lecturer("Gnaoui");
        this.rooms[0] = new HTWRoom("A238", "You have entered room A238. It's a big lecture hall, to your left you can see stairs going up to the seats. In front of you are big windows, that have been darkened with slime by some aliens. You can only see a slight shimmer of light...", lecturer1);
        this.rooms[1] = new HTWRoom("A219", "You have entered room A219. It's a small lecture hall with a few desks and chairs. There is a strange smell in the air and a weird looking liquid on the floor, probably left by an Alien passing through.", lecturer2);
        this.rooms[2] = new HTWRoom("Mensa", "You have entered the HTW Mensa, where the people usually sit and enjoy delicious food. But now it looks more of a horror scene than a place to eat at. No people, no service, no food. Just a dark room filled with emptiness.", lecturer3);
        this.rooms[3] = new HTWRoom("Internetcafe", "You have entered the room, where students do their homework or wait for the next lecture to start. Filled with a couple of computers, chairs and desks and the view of the courtyard. You look out the window and see aliens running everywhere. Hopefully they don't catch a sight of you!", lecturer4);
        this.rooms[4] = new HTWRoom("Sportshall", "You have entered the sportshall, it's a very big room, but the windows have been darkened by the alien invadors. Because there is no light you can only see half of the room... But you can here some strange noises from the dark side of the hall. You decide not to investigate, because you have a life worth to live.", lecturer5);
        Alien alien1 = new FriendlyAlien("BinaryAlien", 50, true, "01101000 01101001");
        Alien alien2 = new UnfriendlyAlien("Blag", 30, false, "Grrr");
        Alien alien3 = new UnfriendlyAlien("JavaAlien", 50, false, "System.out.println('Do not come near me or you will get decoded')");
        Alien alien4 = new UnfriendlyAlien("Pi-lien", 50, false, "My infinite number 3,14... will destroy your math skills" );
        Alien alien5 = new FriendlyAlien("Booklien", 100, true, "We have an invasion yes, but i also need you to be silent as i'm still not finished reading my book 'angewandte Programmierung' for next Semester! So pshhhh.....!! ");
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

    private void introGame() {
        System.out.println("It's 8 am in the morning and you are packing your backpack for university");
        System.out.println("You're still feeling a little bit tired, but you need to be early for your first lecture.");
        System.out.println("After half an hour of traveling by tram, you arrive near the HTW to get a morning coffee.");
        System.out.println("While entering Building A you feel that something is off...");
        System.out.println("Suddenly, a big snail appears right in front of you. In shock, you spill your whole coffee on yourself.");
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
        System.out.println("Do you wan't to continue? (y)... You have no other choice... Press (y)");
        while (true) {
            String answer = app.getReadUserInput();
            if(answer.equalsIgnoreCase("y")) {
                app.getResumeGame();
                break;
            }
        System.out.println("Sorry, you will have to take the adventure. Press (y) in order to continue.");
    }
}
        public void getIntroGame() {
            this.introGame();
        }

        public void gameMenu() {
            while (true) {
            System.out.println("");
            System.out.println("You're now in the game menu.");
            System.out.println("What do you want to do next?");
            System.out.println("(1) Explore HTW");
            System.out.println("(2) Show hero status");
            System.out.println("(3) Show escape paper");
            System.out.println("(4) Rest your hero");
            System.out.println("(5) Back to main menu");

            String answer = app.getReadUserInput();
            if(answer.equals("5")) {
                return;
            }
            handleUserInputGameMenu(answer);
            }
    }

        private void handleUserInputGameMenu(String input) {
        switch (input) {
                case "1":
                    exploreHTW();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("Do you want to rest for a long time (+10 HP, costs 1 round) or a short time (+3 HP, only once per round)? (l/s) or go back to the game menu (q)");
                    String answer = app.getReadUserInput();
                    while(true) {
                        if(answer.equalsIgnoreCase("l")) {
                            getHero().regenerate(true);
                            break;
                        } else if(answer.equalsIgnoreCase("s")) {
                            getHero().regenerate(false);
                            break;
                        } else if(answer.equalsIgnoreCase("q")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter 'l' or 's' or 'q'.");
                            answer = app.getReadUserInput();
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please choose a correct number between 1 and 5");
                    break;
            }
        }

        public void exploreHTW() {
            int zufallszahl = (int) (Math.random() * 100) + 1;
            if(zufallszahl <=20) {
                eventless();
            } else if(zufallszahl > 20 && zufallszahl <= 72) {
                // Alien
            } else {
                // Lecturer
            }
        }

        public void eventless() {
            int zufallszahl = (int) (Math.random() * 100) + 1;
            if(zufallszahl <= 25) {
                System.out.println("You explored Building B. Sadly you haven't found anything you need. Maybe try somewhere else...");
            } else if(zufallszahl > 26 && zufallszahl <= 50) {
                System.out.println("You entered room A241. It's very dark in here... you see a strange silouette that's lurking in the corner. Maybe it's better to turn back, it doesn't seem safe in here...");
            } else if(zufallszahl > 51 && zufallszahl <= 75) {
                System.out.println("You want to enter Building C, but the entrance is covered by aliens. Sadly you're not strong enough to beat that many. Maybe try somewhere else...");
            } else {
                System.out.println("You see an interesting looking hallway. At the end of it you see a tiny light shimmering, which emits a high pitched sound. You try to approach it, but the closer you come, the worse it gets. Seems like you won't find something here.");
        }
    }
        public void meetAlien(){
            int zufallszahl = (int) (Math.random() * 100) + 1;
            if(zufallszahl <= 20) {
                //Alien1
            } else if(zufallszahl > 21 && zufallszahl <= 40) {
                //Alien2
            } else if(zufallszahl > 41 && zufallszahl <= 60) {
                //Alien3
            } else if(zufallszahl > 61 && zufallszahl <= 81) {
                //Alien4
            } else {
                //Alien5
            }
        }

        public void meetLecturer(){
            int zufallszahl = (int) (Math.random() * 100) + 1;
            if(zufallszahl <= 20) {
                //Lecturer1
            } else if(zufallszahl > 21 && zufallszahl <= 40) {
                //Lecturer2
            } else if(zufallszahl > 41 && zufallszahl <= 60) {
                //Lecturer3
            } else if(zufallszahl > 61 && zufallszahl <= 81) {
                //Lecturer4
            } else {
                //Lecturer5
            }
        }
}
