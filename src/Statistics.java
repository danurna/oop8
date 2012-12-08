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


}
