import java.lang.reflect.Method;
import java.util.Iterator;


@Author("Bernhard")
public class Test {

    /**
     * Hier werden die Punkte aus der Angabe getestet und vorgestellt wie man mit
     * den Klassen umgeht:
     */
    private static Map<String,Farm> farms = new Map<String,Farm>();
	
	
	
	/**
	 * Erstellen Sie eine Menge von Bauernhoefen mit jeweils einigen Traktoren
	 * wirklich eine Menge von Bauernhoefen (eine Form von Collection), 
	 * nicht nur eine Ansammlung einzelner Variablen. Jeder Bauernhof in der
	 * Menge soll ueber seinen eindeutigen Namen angesprochen werden, und 
	 * jeder Traktor eines Bauernhofes ueber seine eindeutige Nummer.
	 */
    @Author("Bernhard")
	private static void testFarms() {
		Farm f;
    	// menge von Bauernhofen erstellen
		farms.insert("Farm1", new Farm("Farm1"));
		farms.insert("Farm2", new Farm("Farm2"));
		farms.insert("Farm3", new Farm("Farm3"));
		
		// Bauernhofen ansprechen nach namen
		f = farms.find("Farm1");
		System.out.println("Zeige Farm1:");
		System.out.println(f);
		
		// Traktoren hinzufuegen
		f.addTractor(new FuelTractor(new Fertilize(12.3)));
		f.addTractor(new BiogasTractor(new Sow(2)));
		f.addTractor(new BiogasTractor(new Fertilize(11.2)));
		f.addTractor(new FuelTractor(new Sow(3)));
		f.addTractor(new FuelTractor(new Fertilize(17.8)));
		farms.find("Farm2").addTractor(new FuelTractor(new Sow(1)));
		farms.find("Farm3").addTractor(new BiogasTractor(new Sow(1)));
		farms.find("Farm3").addTractor(new FuelTractor(new Sow(5)));
		
		// spreche Traktor ueber eigene nummer an (1. Traktor hat nummer 1
		// die folgenden jeweils eins hoeher)
		System.out.println("Zeige den Traktor mit ID 1");
		System.out.println(f.getTractor(1));
		
		System.out.println();
	}
	
    
    /** Fuegen Sie zu einigen Bauernhoefen einzelne Traktoren hinzu, entfernen Sie einzelne Traktoren,
     *  und aendern Sie die Informationen zu einzelnen Traktoren, wobei Sie Traktoren und Bauernhoefe
     *  nur ueber deren Nummern und Namen ansprechen. 
     * @return */
    @Author("Bernhard")
    private static void modifyTractors() {
    	// fuegen sie zu einigen Bauernhofen einzelne Traktoren hinzu:
    	// SIEHE testFarms()
    	
    	// entfernen sie einzelne Traktoren:
    	// entferne Traktor 5 von Farm1
    	farms.find("Farm1").removeTractor(5);
    	// entferne Traktor 8 von Farm3
    	farms.find("Farm3").removeTractor(8);
    	
    	// aender Sie die Informationen zu einzelnen Traktoren
    	// traktor 1 arbeitet 10 stunden
    	farms.find("Farm1").getTractor(1).incrHours(10);
    	// traktor 1 wird ab jetzt zum Saehen eingesetzt und 
    	// arbeit dabei wieder 10 stunden
    	farms.find("Farm1").getTractor(1).setUsageType(new Sow(4));
    	farms.find("Farm1").getTractor(1).incrHours(10);
    	//traktor 2,3,4,6,7 arbeiten jeweils einige stunden
    	farms.find("Farm1").getTractor(2).incrHours(12);
    	farms.find("Farm1").getTractor(3).incrHours(1);
    	farms.find("Farm1").getTractor(4).incrHours(78);
    	farms.find("Farm2").getTractor(6).incrHours(56);
    	farms.find("Farm3").getTractor(7).incrHours(14);
    	
    	// erhoehe Treibstoff/Gas verbrauch
    	FuelTractor ft = (FuelTractor) farms.find("Farm1").getTractor(4);
    	ft.incrConsumedFuel(10000);
    	BiogasTractor bt = (BiogasTractor) farms.find("Farm1").getTractor(2);
    	bt.incrConsumedBiogas(200.3);
    }
    
    /**
     *  Berechnen Sie die statistischen Werte aller Bauernhoefe 
     */
	private static void printStatistic() {
		Farm f; 
		Iterator<Farm> i = farms.iterator();
		Statistics st;
		while (i.hasNext()) {
			f = i.next();
			st = new Statistics(f);
			
			System.out.println("PRINT STATISTICS FOR : "+f);
			//Betriebstunden
			System.out.println("Schnitt-Betriebstunden aller Traktoren: "+st.avgHoursGeneral());
			System.out.println("Schnitt-Betriebstunden aller Saeh-Traktoren: "+st.avgHoursSow());
			System.out.println("Schnitt-Betriebstunden aller Dueng-Traktoren: "+st.avgHoursFertilize());
			System.out.println("Schnitt-Betriebstunden aller Biogas-Traktoren: "+st.avgHoursBiogas());
			System.out.println("Schnitt-Betriebstunden aller Disel-Traktoren: "+st.avgHoursDiesel());
			// Dieselverbrauch
			System.out.println("Schnitt-Diselverbrauch aller Traktoren: "+st.avgDieselUsage());
			System.out.println("Schnitt-Diselverbrauch aller Saeh-Traktoren: "+st.avgDieselUsageSow());
			System.out.println("Schnitt-Diselverbrauch aller Dueng-Traktoren: "+st.avgDieselFertilize());
			// Gasverbrauch
			System.out.println("Schnitt-Gasverbrauch aller Traktoren: "+st.avgBiogasUsage());
			System.out.println("Schnitt-Gasverbrauch aller Saeh-Traktoren: "+st.avgBiogasUsageSow());
			System.out.println("Schnitt-Gasverbrauch aller Dueng-Traktoren: "+st.avgBiogasUsageFertilize());
			//  minimale und maximale Anzahl an Saescharen
			System.out.println("Minimale Saescharen aller Traktoren: "+st.getMinSaescharen());
			System.out.println("Minimale Saescharen aller Diesel-Traktoren: "+st.getMinSaescharenDiesel());
			System.out.println("Minimale Saescharen aller Biogas-Traktoren: "+st.getMinSaescharenBiogas());
			System.out.println("Maximale Saescharen aller Traktoren: "+st.getMaxSaescharen());
			System.out.println("Maximale Saescharen aller Diesel-Traktoren: "+st.getMaxSaescharenDiesel());
			System.out.println("Maximale Saescharen aller Biogas-Traktoren: "+st.getMaxSaescharenBiogas());
			// durschnittliche Duengemittel
			System.out.println("Schnitt-Duengerbehaelter aller Traktoren: "+st.avgCapaticity());
			System.out.println("Schnitt-Duengerbehaelter aller Biogas-Traktoren: "+st.avgCapaticityBiogas());
			System.out.println("Schnitt-Duengerbehaelter aller Diesel-Traktoren: "+st.avgCapaticityDiesel());
			
			System.out.println();
			System.out.println();
		}
	}
	
	/**
	 * Geben Sie die Namen der von Ihnen geschriebenen Klassen und Methoden
	 * zusammen mit den Personen, die dafuer hauptsaechlich verantwortlich sind,
	 * aus. Dabei sollen die Methodennamen sowie die verantwortlichen Personen
	 * ausschliesslich ueber Reflection aus den Klassen mithilfe der Annotationen
	 * ermittelt werden.
	 */
    @Author("Florian")
    public static void printAuthors(Class<?> cls) {
        Author clsAuthor = cls.getAnnotation(Author.class);
        if (clsAuthor != null) {
            System.out.println(cls.getName() + ": " + clsAuthor.value());
        } else {
            System.out.println(cls.getName() + ": unknown");
        }
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; ++i) {
            Author mthAuthor = methods[i].getAnnotation(Author.class);
            if (mthAuthor != null) {
                System.out.println("- " + methods[i].getName() + ": " + mthAuthor.value());
            }
        }
    }
    
    @Author("Bernhard")
    public static void main(String[] args) {
    	testFarms();
    	modifyTractors();
    	printStatistic();
    	
    	printAuthors(Author.class);
        printAuthors(BiogasTractor.class);
        printAuthors(Farm.class);
        printAuthors(Fertilize.class);
        printAuthors(FuelTractor.class);
        printAuthors(Map.class);
        printAuthors(Sow.class);
        printAuthors(Test.class);
        printAuthors(Tractor.class);
        printAuthors(UsageType.class);

    }
}
