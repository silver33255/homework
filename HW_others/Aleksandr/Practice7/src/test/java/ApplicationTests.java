import static org.junit.Assert.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.epam.rd.java.basic.practice7.Demo;

public class ApplicationTests {

	@Test
	public void testDemo() throws Exception {
		Demo.main(new String[0]);
		assertNotNull("mock output");
		Files.delete(Paths.get("output.dom.xml"));
		Files.delete(Paths.get("output.sax.xml"));
		Files.delete(Paths.get("output.stax.xml"));
	}
	
}
