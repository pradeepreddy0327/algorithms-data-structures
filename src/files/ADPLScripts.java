package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class ADPLScripts {

	public static void main(String[] args) {
		readPrecode();

	}

	private static void readPrecode() {
		try {
			//File csvFile = new File("/Users/pmuchchanthula/Desktop/ADPL/5-8042019P_Adpl_orgs.csv");
			//File csvFile = new File("/Users/pmuchchanthula/Desktop/ADPL/4-7042019P_Adpl_orgs.csv");
			File csvFile = new File("/Users/pmuchchanthula/Desktop/ADPL/4-7042019P_Adpl_orgs.csv");
			CSVReader br = new CSVReader(new FileReader(csvFile));
			List<String> l = new ArrayList<>();
			String[] row = br.readNext();
			while(row != null) {
				l.add(row[0]);
				row = br.readNext();
			}
			System.out.println(l.size());
			
			File csvFile2 = new File("/Users/pmuchchanthula/Desktop/ADPL/4-7042019P_Adpl_entries.csv");
			CSVReader br2 = new CSVReader(new FileReader(csvFile2));
			String[] row2 = br2.readNext();
			while(row2 != null) {
				l.remove(row2[0]);
				row2 = br2.readNext();
			}
		  System.out.println(l.size());
		  System.out.println(l);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
