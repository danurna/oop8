/**
 *
 * 
 */
@Author("Daniel")
public class Sow extends UsageType{

    public Sow(){
        super();
    }

    //VB: value != null
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
