/**
 *
 * 
 */
@Author("Daniel")
public abstract class UsageType {
    protected Object value;

    public UsageType(){
        
    }
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
