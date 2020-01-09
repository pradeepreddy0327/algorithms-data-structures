package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ORSScript {
    static Map<String,String> map = new HashMap<>();
    static Set<String> subjSet = new HashSet<>();
    static Set<String> grade = new HashSet<>();
    static Set<String> standSet = new HashSet<>();
	public static void main(String[] args) throws IOException {
		populateMap();
		File folder = new File("/Users/pmuchchanthula/Downloads/rc-conversions");
		File[] listOfFiles = folder.listFiles();
		FileOutputStream out = new FileOutputStream("/Users/pmuchchanthula/Downloads/rc-conversions/scipt.sql");
		int html = 0;
		int others =0;
		System.out.println(listOfFiles.length);
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				File f = listOfFiles[i];
				String extension = f.getName().substring(f.getName().lastIndexOf('.')+1);
				if(extension.equals("html")) {
					html++;
					String sql = readFile(f);
					out.write(sql.getBytes());
					out.write("\n".getBytes());
					//return;
				} else others++;
				System.out.println("File " + f.getName() + " extension "+extension);
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		out.close();
		System.out.println("html : "+html + " png : "+others);
		System.out.println(subjSet);
		System.out.println(grade);
		System.out.println(standSet);
	}
    
	private static String readFile(File file) throws IOException {
			String fileName = file.getName();
			DTO dto = getDTO(fileName);
			String content = new String ( Files.readAllBytes( file.toPath() ) );
			content = content.replaceAll("'", "''");
			StringBuilder s = new StringBuilder();
			s.append(" UPDATE rs.standard set html_tag_description = '");
			s.append(content+"' ");
			s.append(" WHERE standard_code = '"+dto.standard+"' AND subject = '"+dto.subject +"' AND grade = '"+dto.grade+"' ;");
			return s.toString();
	}
	private static DTO getDTO(String fileName) {
	   String[] a = fileName.split("-");
	   String s = a[0];
	   subjSet.add(map.get(s.substring(0, s.length()-3)));
	   grade.add(map.get(s.substring(s.length()-3)));
	   standSet.add(map.get(a[1].substring(0, a[1].lastIndexOf('.'))));
//	   System.out.println("subject : " + s.substring(0, s.length()-3));
//	   System.out.println("grade : " + s.substring(s.length()-3));
//	   System.out.println("standard : " + a[1].substring(0, a[1].lastIndexOf('.')));
		return new DTO(map.get(s.substring(0, s.length()-3)), map.get(s.substring(s.length()-3)), map.get(a[1].substring(0, a[1].lastIndexOf('.'))));
	}
	
	private static void populateMap() {
		map.put("rc1", "RC1");
		map.put("rc2", "RC2");
		map.put("rc3", "RC3");
		map.put("rc4", "RC4");
		map.put("rc5", "RC5");
		map.put("rc6", "RC6");
		
		map.put("G03", "03");
		map.put("G04", "04");
		map.put("G05", "05");
		map.put("G06", "06");
		map.put("G07", "07");
		map.put("G08", "08");
		map.put("Eoc", "EOC");
		
		map.put("alg1", "A1");
		map.put("alg2", "A2");
		map.put("bio", "BI");
		map.put("eng1", "E1");
		map.put("eng2", "E2");
		map.put("eng3", "E3");
		map.put("ushistory", "US");
		
		map.put("math", "MA");
		map.put("read", "RE");
		map.put("scie", "SC");
		map.put("socstudies", "SS");
		map.put("writ", "WR");
		
	}
}

class DTO{
	String subject;
	String grade;
	String standard;
	
	DTO(String subject,String grade,String standard){
		this.subject = subject;
		this.grade= grade;
		this.standard = standard;
	}

	@Override
	public String toString() {
		return "DTO [subject=" + subject + ", grade=" + grade + ", standard=" + standard + "]";
	}
	
}
