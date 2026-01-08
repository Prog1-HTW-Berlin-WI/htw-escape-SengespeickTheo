
/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/

import java.io.Serializable;

public class Hero implements Serializable {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 3578735620108186013L;

    public String name;
    public int healthPoints;
    public int experiencePoints;
    public Lecturer[] signedExerciseLeaders;

    public int takeDamage(int amount){
        this.healthPoints -= amount;
        return this.healthPoints;
    }
   
    public void regenerate(boolean longRest){
        if(longRest) {
            this.healthPoints += 10;
            if(this.healthPoints > 50) {
                System.out.println("You reached your maximum points of health. Choose a small rest instead.");
                this.healthPoints -= 10;
            }
        } else {
            this.healthPoints += 3;
            if(this.healthPoints > 50) {
                System.out.println("You reached your maximum points of health. You can't rest any further.");
                this.healthPoints -= 3;
            }
        }
    }

    public boolean flee(){

    }

    public int attack(){

    }

    public void signExerciseLeader(Lecturer lecturer){

    }

    public int getExperiencePoints(){

    }

    public int addExperiencePoints(){

    }

    public boolean isOperational(){

    }
}