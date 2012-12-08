import java.lang.reflect.Method;


@Author("Bernhard")
public class Test {

    /**
     * Hier werden die Punkte aus der Angabe getestet und vorgestellt wie man mit
     * den Klassen umgeht:
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
    public static void main(String[] args) {
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
