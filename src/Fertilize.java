/**
 *
 * 
 */
@Author("Daniel")
public class Fertilize extends UsageType{

    public Fertilize(){
        super();
    }

    //VB: value != null
    public Fertilize(Integer value){
        super(value);
    }

    @Override
    @Author("Daniel")
    public void setValue(Object value) throws IllegalArgumentException{
        if( value instanceof Double ){
            this.value = (Double)value;
        }else{
            throw new IllegalArgumentException("Ungueltiges Argument");
        }
    }

    @Override
    @Author("Daniel")
    public Double getValue(){
        return (Double)value;
    }

}
