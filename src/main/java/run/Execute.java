package run;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.Address;
import entity.Contact;
import entity.Emp;

public class Execute {
    public static void main2(String[] args) throws IOException {
	FileInputStream file = new FileInputStream(new File("abhi.xls"));

	// Create Workbook instance holding reference to .xlsx file
	HSSFWorkbook workbook = new HSSFWorkbook(file);

	// Get employee sheet
	Iterator<Row> employees = workbook.getSheetAt(0).iterator();
	Iterator<Row> contacts = workbook.getSheetAt(1).iterator();
	Iterator<Row> addresses = workbook.getSheetAt(2).iterator();

	List<Emp> allEmps = new ArrayList<Emp>();

	boolean isHeaderRow = true;

	while (employees.hasNext()) {

	    // create
	    Iterator<Cell> empRow = employees.next().cellIterator();

	    // skipping first row
	    if (isHeaderRow) {
		isHeaderRow = false;
		continue;
	    }

	    Emp emp = new Emp();
	    while (empRow.hasNext()) {
		Cell cell = empRow.next();

		switch (cell.getColumnIndex()) {
		case 0:
		    emp.setEmpid(Double.valueOf(cell.getNumericCellValue()));
		    break;

		case 1:
		    emp.setEmpName(cell.getStringCellValue());
		    break;

		default:
		    break;
		}

	    }
	    // adding emp object to list
	    allEmps.add(emp);
	}
    }

    public static void main(String[] args) throws JsonGenerationException,
	    JsonMappingException, IOException {

	List<Address> addrs1 = new ArrayList<Address>();
	addrs1.add(new Address("Ggn", "121"));
	addrs1.add(new Address("Del", "111"));
	addrs1.add(new Address("Noi", "201"));

	List<Contact> contatcs1 = new ArrayList<Contact>();
	contatcs1.add(new Contact(1, "Home", addrs1));

	List<Address> addrs2 = new ArrayList<Address>();
	addrs2.add(new Address("Chicago", "404"));

	contatcs1.add(new Contact(2, "Work", addrs2));

	Emp e = new Emp(1, "Abhi");
	e.setContacts(contatcs1);

	// ObjectMapper mapper = new ObjectMapper();
	// mapper.writeValue(new File("emp.json"), e);
	// mapper.writeValue(new File("emp2.json"), e);

	Gson gson = new Gson();
	java.lang.reflect.Type type = new TypeToken<Emp>() {
	}.getType();
	String json = gson.toJson(e, type);

	System.out.println(json);
    }
}
