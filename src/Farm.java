/**
 *
 * 
 */
@Author("Daniel")
public class Farm {
    //IV: name darf nicht veraendert werden.
    private final String name;
    private Object tractors;

    public Farm(String name){
        this.name = name;
        this.tractors = new Object();
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
        if( true ) {
        //if( tractors.find( t.getTractorId() ) == null ){
        //    tractors.add(t.getTractorId(), t);
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
        //return tractors.remove(tid);
        return true;
    }

    //VB: id != null
    //Liefert Traktor mit tid zurueck. Falls Traktor
    //nicht vorhanden wir null zurueckgegeben.
    @Author("Daniel")
    public Tractor getTractor(int tid){
        //return (Tractor)tractors.find(tid);
        return null;
    }

    @Author("Daniel")
    private double avgHours (Class tractorType, Class usageTypeType){
        Tractor tractor = null;
        int hours = 0;
        int numberOfTractors = 0;
        /*
        if( (tractor instanceof tractorType) &&
                (tractor.getUsageType() instanceof usageTypeType)){
            numberOfTractors += 1;
            hours += tractor.getHours();
        }
        */

        if( numberOfTractors == 0 ){
            return 0;
        }else{
            return hours / (double) numberOfTractors;
        }
    }

    //FIXME
    /*
    public double avgHoursTest(Tractor.class, Saehen.class){
        return 0;
    }
    * */

}
