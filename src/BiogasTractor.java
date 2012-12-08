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

    //VB: v >= 0
    @Author("Daniel")
    public void incrConsumedBiogas(double v){
        consumedBiogas += v;
    }

    //NB: Zurueckgabe wert >= 0
    @Author("Daniel")
    public double getConsumedBiogas(){
        return consumedBiogas;
    }

}
