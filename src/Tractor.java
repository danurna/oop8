/**
 * Repraesentiert einen Tractor.
 *
 */
@Author("Daniel")
public abstract class Tractor {
    //IV: tid nicht veraenderbar
    private final int tid;
    private static int tractors = 0;
    private int hours = 0;
    private UsageType usageType = null;

    public Tractor(UsageType t){
        tractors++;
        this.tid = tractors;
        this.usageType = t;
    }

    //VB u ist Untertyp von UsageType und != null
    @Author("Daniel")
    public void setUsageType(UsageType u){
        usageType = u;
    }

    @Author("Daniel")
    public UsageType getUsageType(){
        return usageType;
    }

    //VB: h >= 0
    @Author("Daniel")
    public void incrHours(int h){
        hours += h;
    }

    //NB: Rueckgabewert >= 0
    @Author("Daniel")
    public int getHours(){
        return hours;
    }

    //NB: Rueckgabewert >= 1
    @Author("Daniel")
    public int getTractorId(){
        return tid;
    }

    @Override
    @Author("Daniel")
    public boolean equals(Object other){
        if( this == other ){
            return true;
        }
        if( other == null ){
            return false;
        }
        if( getClass() != other.getClass() ){
            return false;
        }
        Tractor otherTractor = (Tractor)other;
        if( tid != otherTractor.tid ){
            return false;
        }
        return true;
    }

    @Override
    @Author("Daniel")
    public int hashCode(){
        int hash = 3;
        hash = (71 * hash) + tid;
        return hash;
    }

    public abstract String toString();
}
