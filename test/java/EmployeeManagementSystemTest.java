
import com.employee.management.system.Employee;
import com.employee.management.system.EmployeePosition;
import com.employee.management.system.Project;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author osx
 */

public class EmployeeManagementSystemTest {
    
    private Employee employee;
    private Project project;
    
    @BeforeEach
    void setUp(){
        employee = new Employee(1, 
                                "Jane Doe", 
                                23, 
                                "50 Garden st",
                                "jane.doe@example.com", 
                                "27-04-2016", 
                                12, 
                                14);
        
        project = new Project(1, 
                               "Employment Management System", 
                               5, 
                               "18-01-2024");
    }
    
    @Test
    void testEmployeeDetails() {
        String expectedDetails = "Employee Details:\n" +
                                 "Employee ID: 1\n" +
                                 "Employee Name: Jane Doe\n" +
                                 "Employee Age 23\n" +
                                 "Employee Address: 50 Garden st\n" +
                                 "Employee Email: jane.doe@example.com\n" +
                                 "Entry Date: 27-04-2016\n" +
                                 "Contract Duration: 12 months\n" +
                                 "Notice Period: 14 days\n" +
                                 "projects: \n" +
                                 "--------------------------";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        employee.displayDetails();

        // Reset System.out
        System.setOut(System.out);

        assertEquals(expectedDetails, outputStream.toString().trim());
    }
    
    @Test
    void testAddProject() {
        employee.addProject(project);
        assertTrue(employee.getProjects().contains(project));
    }
    
    @Test
    void testRemoveProject() {
        employee.addProject(project);
        employee.removeProject(project);
        assertFalse(employee.getProjects().contains(project));
    }
    
    @Test
    void testCalculateSalary() {
        assertEquals(9000.0, employee.calculateSalary(EmployeePosition.JUNIOR, 10000, 0.10), 0.01);
    }
}
