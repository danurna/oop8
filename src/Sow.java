/**
 * Der Verwendungszweck zum Saehen speichert als 
 * Eigenschaftt die Anzahl der Saeschare (ganze Zahl)   
 * 
 */
@Author("Daniel")
public class Sow extends UsageType{

	private int num;
	
    public Sow(){
        super();
    }

    //VB: value != null, value >= 0
    public Sow(Integer value){
    	num = value;
    }

    @Override
    @Author("Daniel")
    public void setValue(Object value) throws IllegalArgumentException{
        if( value instanceof Integer ){
            num = (Integer)value;
        }else{
            throw new IllegalArgumentException("Ungueltiges Argument");
        }
    }

    @Override
    @Author("Daniel")
    public Integer getValue(){
        return num;
    }


}
