package academy.testobjects;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class testSample {

	@Test(dataProvider="dataDrivenTestNG")
	public static void main(String[] args) throws IOException {
			dataDrivenTestNG d = new dataDrivenTestNG();
			Object[][] data	= d.getData();
			System.out.println(data.length);
	}

}
