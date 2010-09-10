package cxfclient;

import com.berinle.ArrayOfString;
import com.berinle.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: Sep 10, 2010
 * Time: 10:24:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class WSClient2 {
    public static void main(String[] args) {
        Util util = new Util();

        Employee emp = new Employee();
        emp.setFirstName("IntelliJ");
        emp.setLastName("Idea");

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        emp.setDob(new Date(1972,9,1));
        emp.setDobAsString(df.format(new Date()));
        ArrayOfString aos = new ArrayOfString();
        List<String> list = aos.getString();

        list.add("Apache CXF");
        list.add("says");
        list.add("big");
        list.add("hello!");

        emp.setMyList(aos);

        System.out.println("Using util");
        util.invoke("http://localhost:8080/sample-xfire/services/employeeService?wsdl", emp);
        System.out.println("Done with invocation");
    }
}
