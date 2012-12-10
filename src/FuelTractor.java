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
    public void incrConsumedFuel(int v){
        consumedFuel += v;
    }

    //NB: Zurueckgabe wert >= 0
    @Author("Daniel")
    public int getConsumedFuel(){
        return consumedFuel;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FuelTractor [ID="+this.getTractorId()+ " , consumedFuel=" + consumedFuel + ", hours=" +this.getHours()+ "]";
	}
}
