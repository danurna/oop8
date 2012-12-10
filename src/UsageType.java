/**
 * Jeder Traktor kann fuer verschiedene Zwecke verwendet.
 * Dies ist eine abstrakte Superklasse fuer einen solchen 
 * Verwendungszweck.
 * 
 */
@Author("Daniel")
public abstract class UsageType {
    
	// jeder Vewrwendungszweck hat eine charaktarisierende eigenschaft die gesetzt
	// gespeichert und geaendert werden darf.
	protected Object value;

    // Default konstruktor
    public UsageType() { }
    
    //VB: value != null
    public UsageType(Object value){
        this.value = value;
    }

    //Falls Typ von value nicht passt, wird eine Exception geworfen.
    //Methode wird von Untertyp implementiert.
    public abstract void setValue(Object value) throws IllegalArgumentException;
    
    //Liefert value zurueck.
    //Wird von Untertyp implementiert.
    public abstract Object getValue();
    
}
