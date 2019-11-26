package interop;

import java.io.IOException;

public class TalkingToKotlin {

    public void loadStats(CustomerKotlin customerKotlin) {


        try {
            customerKotlin.loadStats("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CustomerKotlin customerKotlin = new CustomerKotlin(1, "Adrian");
        customerKotlin.getName(); // getter is available
        customerKotlin.setName("New name"); // setter is available

        String someField = customerKotlin.someField;
        customerKotlin.changeStatus("New");
        customerKotlin.changeStatus(); // only works with JvmOverloads
        customerKotlin.pref(); // JvmName, when we want


        // Invoke toplevel function
        MyUtil.prefix("p", "bla");
        MyUtil.getName();
        String constname = MyUtil.constname;

        // Call extension function
        CustomerKotlinKt.extension(customerKotlin);
    }

}
