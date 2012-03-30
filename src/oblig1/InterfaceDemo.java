package oblig1;

public class InterfaceDemo {

    public static void main(String[] args){
        Country[] t = {new Country("Norge",4500000),new Country("Island",1000000),
                new Country ("Sverige",6500000),new Country("Luxemburg",2000000),
                new Country ("Liechtenstein",400000)};
        
        System.out.println("Original");
        System.out.println("========");
        for (int i = 0; i < t.length; i++)
            System.out.println(t[i]);

        Sort.selectionSort(t, t.length);

        System.out.println();
        System.out.println("Sorted");
        System.out.println("======");
        for (int i = 0; i < t.length; i++)
            System.out.println(t[i]);

        
    }
}