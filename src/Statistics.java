/**
 * Beinhaltet alle Methoden um die Statistiken zu erzeugen.
 */
@Author("Daniel")
public class Statistics {
    private Farm farm;

    //VB: farm != null
    public Statistics(Farm farm){
        this.farm = farm;
    }

    //VB: farm != null
    public void setFarm(Farm farm){
        this.farm = farm;
    }

    @Author("Daniel")
    public double avgHoursGeneral(){
        return farm.avgHours(Tractor.class, UsageType.class);
    }

    @Author("Daniel")
    public double avgHoursSow(){
        return farm.avgHours(Tractor.class, Sow.class);
    }

    @Author("Daniel")
    public double avgHoursFertilize(){
        return farm.avgHours(Tractor.class, Fertilize.class);
    }

    @Author("Daniel")
    public double avgHoursBiogas(){
        return farm.avgHours(BiogasTractor.class, UsageType.class);
    }

    @Author("Daniel")
    public double avgHoursDiesel(){
        return farm.avgHours(FuelTractor.class, UsageType.class);
    }

    @Author("Daniel")
    public double avgDieselUsage(){
        return farm.avgDiesel(UsageType.class);
    }

    @Author("Daniel")
    public double avgDieselUsageSow(){
        return farm.avgDiesel(Sow.class);
    }

    @Author("Daniel")
    public double avgDieselFertilize(){
        return farm.avgDiesel(Fertilize.class);
    }

    @Author("Daniel")
    public double avgBiogasUsage(){
        return farm.avgBiogas(UsageType.class);
    }

    @Author("Daniel")
    public double avgBiogasUsageSow(){
        return farm.avgBiogas(Sow.class);
    }

    @Author("Daniel")
    public double avgBiogasUsageFertilize(){
        return farm.avgBiogas(Fertilize.class);
    }
    
    @Author("Bernhard")
    public double avgCapaticity(){
        return farm.avgCapacity(Tractor.class);
    }

    @Author("Bernhard")
    public double avgCapaticityDiesel(){
        return farm.avgCapacity(FuelTractor.class);
    }
    
    @Author("Bernhard")
    public double avgCapaticityBiogas(){
        return farm.avgCapacity(BiogasTractor.class);
    }
    
    @Author("Bernhard")
    public double getMinSaescharen(){
        return farm.getMinSc(Tractor.class);
    }
    
    @Author("Bernhard")
    public double getMinSaescharenDiesel(){
        return farm.getMinSc(FuelTractor.class);
    }
    @Author("Bernhard")
    public double getMinSaescharenBiogas(){
        return farm.getMinSc(BiogasTractor.class);
    }
    
    @Author("Bernhard")
    public double getMaxSaescharen(){
        return farm.getMaxSc(Tractor.class);
    }
    
    @Author("Bernhard")
    public double getMaxSaescharenDiesel(){
        return farm.getMaxSc(FuelTractor.class);
    }
    
    @Author("Bernhard")
    public double getMaxSaescharenBiogas(){
        return farm.getMaxSc(BiogasTractor.class);
    }
        
    

}
