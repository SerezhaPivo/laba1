package rfe.bsu.laba1;
import java.util.*;

public class Main {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        final int size = args.length;
        Vector<Food> breakfast = new Vector<Food>();

        try {
            for (int i = 0; i < size; ++i) {
                switch (args[i]) {
                    case "Milk": {
                        Milk coctail = new Milk("Milk", args[++i]);
                        coctail.consum();
                        breakfast.add(coctail);

                        break;
                    }
                    case "Chees": {
                        Chees ch = new Chees();
                        ch.consum();
                        breakfast.add(ch);
                        break;
                    }
                    case "Apple": {
                        Apple ap = new Apple("Apple", args[++i]);
                        ap.consum();
                        breakfast.add(ap);
                        break;
                    }
                    default: {
                        if (args[i].charAt(0) == '-') {
                            break;
                        }
                        throw new RuntimeException("Class " + args[i] + " not Found");
                    }
                }
            }
        } catch (RuntimeException error){
            System.out.println(error.toString());
        }


        System.out.println("Youre breakfast: ");
        for(Food f : breakfast){
            System.out.println(f.toString());
        }


        System.out.println("Enter Milk to Compare: ");

        String fat = console.nextLine();
        Milk ToCompear = new Milk("Coctail", fat);

        if(IfCalories(args)) {
            System.out.println("Tatal caloris is: " + Calculate(breakfast));
        }

        if(IfSorted(args)) {
            TreeSet<Food> sortBreakfast = new TreeSet<Food>(new Comparator<Food>() {
                @Override
                public int compare(Food i1, Food i2) {
                    if (i1.calculateCalories() > i2.calculateCalories()) {
                        return -1;
                    } else if (i1.calculateCalories() < i2.calculateCalories()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

            sortBreakfast.addAll(breakfast);

            for(Food f : sortBreakfast){
                System.out.println(f);
            }

        }
    }

    static int Calculate(Vector<Food> breakfast){
        int caloris = 0;
        for(int i = 0; i < breakfast.size(); i++){
            caloris += breakfast.elementAt(i).calculateCalories();
        }
        return caloris;
    }

    static void Count(Vector<Food> breakfast, Milk ToCompear) {
        int counter = 0;
        for(int i = 0; i < breakfast.size(); i++){
            if(breakfast.elementAt(i).equals(ToCompear)){
                counter++;
            }
        }
        System.out.println("Num of same elements is/are: " + counter + "/n");
    }

    static boolean IfCalories(String[] arguments){
        for(String s : arguments){
            if(s.compareTo("-calories") == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean IfSorted(String[] arguments){
        for(String s : arguments){
            if(s.compareTo("-sort") == 0) {
                return true;
            }
        }
        return false;
    }

}
