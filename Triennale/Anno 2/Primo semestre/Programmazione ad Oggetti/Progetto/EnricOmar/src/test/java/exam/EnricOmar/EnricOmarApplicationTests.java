package exam.EnricOmar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import project.service.connection;

@SpringBootTest(classes=connection.class)
class EnricOmarApplicationTests {
	
	private connection conn;
    private String data;
    
    @BeforeEach
    void setUp() {
    	conn = new connection();
    }

	@Test
	void TestDataOK() {
		data = "13.11.2020";
		equals(conn.getToday(data));
	}
	
	@Test
	void TestDataNoOK() {
		data = "13.11.2021";
		equals(conn.getToday(data));
	}
	
	@Test
	void Test2Data() {
		String data1, data2;
		data1 = "7.3.2021";
		data2 = "13.1.2020";
		equals(conn.get2days(data1, data2));
	}
	
	@Test
	void TestWeekOK() {
		data = "8.2.2021";
		equals(conn.getToday(data));
	}
	
	@Test
	void TestWeekNoOK() {
		data = "8.3.2021";
		equals(conn.getToday(data));
	}
	
	@Test
	void TestMonthOK() {
		String month, year;
		month = "april";
		year = "2020";
		equals(conn.getMonth(month, year));
	}
	
	@Test
	void TestColourOK() {
		String colour = "White";
		equals(conn.getColour(colour));
	}
	
	@Test
	void TestColourNoOK() {
		String colour = "Purple";
		equals(conn.getColour(colour));
	}

}
