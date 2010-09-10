package cxfclient;

import com.berinle.ArrayOfString;
import com.berinle.Employee;
import com.berinle.EmployeeService;
import com.berinle.EmployeeServicePortType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: Sep 10, 2010
 * Time: 9:10:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class WSClient {
    public static void main(String[] args){
        System.out.println("starting...");
        EmployeeService svc = new EmployeeService();
        EmployeeServicePortType port = svc.getEmployeeServiceHttpPort();
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
        port.addEmployee(emp);
        System.out.println("Finish!");
    }
}
