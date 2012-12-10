/**
 * Der Verwendungszweck zum Duengen speichert als Eigenschaft die 
 * Kapazitaet des Behaelters in Liter  
 */
@Author("Daniel")
public class Fertilize extends UsageType{
	private Double liter;
		
    public Fertilize(){
        super();
    }

    //VB: value != null, value >= 0
    public Fertilize(Double value){
        this.liter = value;
    }

    @Override
    @Author("Daniel")
    public void setValue(Object value) throws IllegalArgumentException{
        if( value instanceof Double ){
            liter = (Double)value;
        }else{
            throw new IllegalArgumentException("Ungueltiges Argument");
        }
    }

    @Override
    @Author("Daniel")
    public Double getValue(){
        return liter;
    }

}
