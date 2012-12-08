/**
 *
 * 
 */
@Author("Daniel")
public class BiogasTractor extends Tractor {
    private double consumedBiogas = 0;


    public BiogasTractor(UsageType u){
        super(u);
    }

    @Author("Daniel")
    public void incrConsumedBiogas(double v){
        consumedBiogas += v;
    }

    @Author("Daniel")
    public double getConsumedBiogas(){
        return consumedBiogas;
    }

}
