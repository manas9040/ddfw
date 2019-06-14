package Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RunnerTest {

	public static void main(String[] args) {
		TestNG runner = new TestNG();
		List<String>list=new ArrayList<String>();
		list.add("C:\\Users\\User\\Downloads\\eclipse-jee-neon-3-win32-x86_64\\eclipse\\seleniumwebdriver\\DDFW\\test-output\\Default suite\\testng-failed.xml");
		
		runner.setTestSuites(list);
		runner.run();

	}

}
