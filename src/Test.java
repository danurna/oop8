import java.lang.reflect.Method;


public class Test {

    /**
     * Hier werden die Punkte aus der Angabe getestet und vorgestellt wie man mit
     * den Klassen umgeht:
     */
    
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
        printAuthors(Map.class);


    }
}
