
/**
* Namen der Autoren des Projekts
* @author Theo Sengespeick
* @auhor Leon von Kielpinski 
*/

import java.io.Serial;
import java.io.Serializable;

public class HTWRoom implements Serializable {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 9065680017147292999L;

    public String identifier;
    public String description;
    public Lecturer lecturer;

    /**
     * Konstruktor für HTWRoom
     */
    public HTWRoom(String identifier, String description, Lecturer lecturer){
        this.identifier = identifier;
        this.description = description;
        this.lecturer = lecturer;
    }
}
