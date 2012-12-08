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

    @Author("Daniel")
    public void incrConsumedBiogas(int v){
        consumedFuel += v;
    }

    @Author("Daniel")
    public int getConsumedBiogas(){
        return consumedFuel;
    }
}
