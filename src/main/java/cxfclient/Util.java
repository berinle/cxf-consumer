package cxfclient;

import com.berinle.Employee;
import com.berinle.EmployeeService;
import com.berinle.EmployeeServicePortType;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: Sep 10, 2010
 * Time: 9:43:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public void invoke(String wsdlLocation, Employee emp){
        URL url = null;
        try {
            url = new URL(wsdlLocation);
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        EmployeeService svc = new EmployeeService(url);
        EmployeeServicePortType port = svc.getEmployeeServiceHttpPort();
        port.addEmployee(emp);
    }
}
