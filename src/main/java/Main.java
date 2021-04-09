import java.awt.print.Book;

public class Main {

    public static void main(String[] args) {

        /* Все эти 4 исключения являются unchecked и обработка с try - catch не является обязательной, хотя технически возможна.
        Но, мне кажется, что в некоторых случаях, когда это возможно, лучше обрабатывать через условие, чтобы не допускать ошибку */

        // CastClassException
        Car car = new Car();
        try {
            castClass(car);
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }

        // NullPointerException
        Bike myBike = new Bike();
        myBike = null;
        try {
            myBike.printName();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // Вариант с условием, если объект null, мы просто не выполняем вызываемый метод и предупреждаем об этом.
        // NullPointerException
        Bike myBike2 = new Bike();
        myBike2 = null;
        if(myBike2 != null){
            myBike2.printName();
        } else {
            System.out.println("Object myBike2 is null. Impossible to call method printName");
        }


        //NumberFormatException
        String s = "Hi";
        try {
            int myInt = Integer.valueOf((String) s);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        //ArrayIndexOutOfBoundsException
        int[] array = new int[]{1,2,3,4,5};
        int counter = 0;
        try {
            for (int i = 0; i < 6; i++) {
                array[i] = 5;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void castClass(Object obj){
        obj = (Bike) obj;
    }
}
