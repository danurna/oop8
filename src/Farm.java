import java.util.Iterator;

/**
 *
 * 
 */
@Author("Daniel")
public class Farm {
    //IV: name darf nicht veraendert werden.
    private final String name;
    private Map tractors;

    public Farm(String name){
        this.name = name;
        this.tractors = new Map();
    }

    @Author("Daniel")
    public String getName(){
        return name;
    }

    //VB: t != null
    //Liefert zurueck, ob der Traktor t erfolgreich eingefuegt wurde.
    //False, wenn schon ein Traktor t mit der id von t existiert.
    @Author("Daniel")
    public boolean addTractor(Tractor t){
        if( tractors.find((Integer) t.getTractorId() ) == null ){
            tractors.insert((Integer) t.getTractorId(), (Tractor) t);
            return true;
        }else{
            return false;
        }
    }
    
    //VB: id != null
    //NB: Traktor mit id nicht mehr in tractors.
    //Liefert zurueck, ob der Traktor t erfolgreich entfernt wurde.
    //False, wenn Traktor schon vor dem Aufruf nicht vorhanden war.
    @Author("Daniel")
    public boolean removeTractor(int tid){
        return tractors.remove((Integer) tid);
    }

    //VB: id != null
    //Liefert Traktor mit tid zurueck. Falls Traktor
    //nicht vorhanden wir null zurueckgegeben.
    @Author("Daniel")
    public Tractor getTractor(int tid){
        return (Tractor)tractors.find((Integer) tid);
    }

    //VB tractor type != null, usageTypeType != null
    @Author("Daniel")
    public double avgHours (Class tractorType, Class usageTypeType){
        Tractor tractor;
        int hours = 0;
        int numberOfTractors = 0;

        Iterator iter = tractors.iterator();

        while(iter.hasNext()){
            Object next = iter.next();
            if( tractorType.isInstance(next) ){
                tractor = (Tractor) next;
                if( usageTypeType.isInstance(tractor.getUsageType()) ){
                    numberOfTractors += 1;
                    hours += tractor.getHours();
                }
            }
        }
        
        if( numberOfTractors == 0 ){
            return 0;
        }else{
            return hours / (double) numberOfTractors;
        }
    }

  //VB  usageTypeType != null
    @Author("Daniel")
    public double avgDiesel (Class usageTypeType){
        Class tractorType = FuelTractor.class;
        FuelTractor tractor = null;
        int consumedFuel = 0;
        int numberOfTractors = 0;

        Iterator iter = tractors.iterator();

        while(iter.hasNext()){
            Object next = iter.next();
            if( tractorType.isInstance(next) ){
                tractor = (FuelTractor) next;
                if( usageTypeType.isInstance(tractor.getUsageType()) ){
                    numberOfTractors += 1;
                    consumedFuel += tractor.getConsumedFuel();
                }
            }
        }

        if( numberOfTractors == 0 ){
            return 0;
        }else{
            return consumedFuel / (double) numberOfTractors;
        }
    }


  //VB  usageTypeType != null
    @Author("Daniel")
    public double avgBiogas (Class usageTypeType){
        Class tractorType = BiogasTractor.class;
        BiogasTractor tractor = null;
        double consumedBiogas = 0;
        int numberOfTractors = 0;

        Iterator iter = tractors.iterator();

        while(iter.hasNext()){
            Object next = iter.next();
            if( tractorType.isInstance(next) ){
                tractor = (BiogasTractor) next;
                if( usageTypeType.isInstance(tractor.getUsageType()) ){
                    numberOfTractors += 1;
                    consumedBiogas += tractor.getConsumedBiogas();
                }
            }
        }

        if( numberOfTractors == 0 ){
            return 0;
        }else{
            return consumedBiogas / (double) numberOfTractors;
        }
    }
    
    // liefert die durchschnittliche kapazitaet des duengerBehaelters
    // VB tractor Type != null
    @Author("Bernhard")
    public double avgCapacity (Class tractorType) {
    	Tractor tractor;
    	Class usageType = Fertilize.class;
        double cap = 0;
        int numberOfTractors = 0;

        Iterator iter = tractors.iterator();

        while(iter.hasNext()){
            Object next = iter.next();
            if( tractorType.isInstance(next) ){
                tractor = (Tractor) next;
                if( usageType.isInstance(tractor.getUsageType()) ){
                    Fertilize f = (Fertilize) tractor.getUsageType();
                	numberOfTractors += 1;
                    cap += f.getValue();
                }
            }
        }

        if( numberOfTractors == 0 ){
            return 0;
        }else{
            return cap / (double) numberOfTractors;
        }
    }

    // liefert die minimale anzahl an saescharen des tractorType
    // VB tractor Type != null
    @Author("Bernhard")
    public int getMinSc (Class tractorType) {
    	Tractor tractor;
    	Class usageType = Sow.class;
        int min = Integer.MAX_VALUE;

        Iterator iter = tractors.iterator();

        while(iter.hasNext()){
            Object next = iter.next();
            if( tractorType.isInstance(next) ){
                tractor = (Tractor) next;
                if( usageType.isInstance(tractor.getUsageType()) ){
                	Sow f = (Sow) tractor.getUsageType();
                	if (min > f.getValue()) {
                		min = f.getValue();
                	}
                }
            }
        }
        return (min==Integer.MAX_VALUE) ? 0 : min;
    }
    
    //liefert die maximale anzahl an saescharen des tractorType
    // VB tractor Type != null
    @Author("Bernhard")
    public int getMaxSc (Class tractorType) {
    	Tractor tractor;
    	Class usageType = Sow.class;
        int max = Integer.MIN_VALUE;

        Iterator iter = tractors.iterator();

        while(iter.hasNext()){
            Object next = iter.next();
            if( tractorType.isInstance(next) ){
                tractor = (Tractor) next;
                if( usageType.isInstance(tractor.getUsageType()) ){
                	Sow f = (Sow) tractor.getUsageType();
                	if (max < f.getValue()) {
                		max = f.getValue();
                	}
                }
            }
        }
        return (max==Integer.MIN_VALUE) ? 0 : max;
    }
    
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Farm [name=" + name + "]";
	}
}
