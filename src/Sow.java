/**
 * Der Verwendungszweck zum Saehen speichert als 
 * Eigenschaftt die Anzahl der Saeschare (ganze Zahl)   
 * 
 */
@Author("Daniel")
public class Sow extends UsageType{

    public Sow(){
        super();
    }

    //VB: value != null, value >= 0
    public Sow(Integer value){
        super(value);
    }

    @Override
    @Author("Daniel")
    public void setValue(Object value) throws IllegalArgumentException{
        if( value instanceof Integer ){
            this.value = (Integer)value;
        }else{
            throw new IllegalArgumentException("Ungueltiges Argument");
        }
    }

    @Override
    @Author("Daniel")
    public Integer getValue(){
        return (Integer)value;
    }


}
