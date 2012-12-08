/**
 *
 * 
 */
@Author("Daniel")
public class FuelTractor extends Tractor {
    private int consumedFuel = 0;

    public FuelTractor(UsageType u){
        super(u);
    }

    //VB: v >= 0
    @Author("Daniel")
    public void incrConsumedBiogas(int v){
        consumedFuel += v;
    }

    //NB: Zurueckgabe wert >= 0
    @Author("Daniel")
    public int getConsumedBiogas(){
        return consumedFuel;
    }
}
