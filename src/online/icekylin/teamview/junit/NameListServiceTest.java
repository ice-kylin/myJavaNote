package online.icekylin.teamview.junit;

import online.icekylin.teamview.domain.Employee;
import online.icekylin.teamview.service.NameListService;
import org.junit.Test;

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService n = new NameListService();
        Employee[] employees = n.getAllEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService n = new NameListService();

        for (Employee employee : n.getAllEmployees()) {
            System.out.println(n.getEmployee(employee.getId()));
        }
    }
}
