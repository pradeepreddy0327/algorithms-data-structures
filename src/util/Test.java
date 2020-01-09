package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.caltesting.toms.api.dto.CandidateAdministrationDTO;
import org.ets.common.utils.JSONUtils;

public class Test {

    public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
        String jsonStr = "{\"candidateAdminId\":\"57973080\",\"candidateAdminCode\":\"129522230098012001\",\"primaryEnrollment\":true,\"assessmentTypeCode\":\"INT\",\"contentRegId\":\"1295222300980120\",\"programName\":\"Texas\",\"programId\":\"2\",\"testProgramCode\":\"Texas_EOC\",\"testWindowCode\":null,\"testAdminCode\":\"INTEOC112019P\",\"testAdminId\":\"98\",\"testFormCode\":\"TXKIA1INT00003000PKG001\",\"lastUpdatedTime\":\"2019-11-11 12:41:59.497171\",\"subjectCode\":\"A1\",\"createdDate\":\"2019-11-10 21:15:52.563803\",\"startDate\":\"2019-11-22 01:00:01.0\",\"completedDate\":\"2020-04-01 00:59:59.0\",\"attributeMap\":{},\"testType\":\"S\",\"status\":\"SAVED\",\"scoreStatus\":\"SCORE_INITIATED\",\"groupName\":\"NO GROUP NAME GIVEN\",\"isAboveGrade\":false,\"scoreCode\":\"S\",\"testAttributes\":{\"hispanicLatinoCode\":\"\",\"campusName\":\"ZEBRA H S\",\"americanIndianAlaskaNativeCode\":\"\",\"asianCode\":\"\",\"titleIPartAIndicatorCode\":\"\",\"localUseColumnC\":\"\",\"blackAfricanAmericanCode\":\"\",\"localUseColumnB\":\"\",\"localUseColumnD\":\"\",\"localUseColumnA\":\"\",\"giftedTalentedIndicatorCode\":\"\",\"LocalUseD\":\"\",\"homeCountyDistrictCampusCode\":\"\",\"specialEdIndicatorCode\":\"\",\"LocalUseA\":\"\",\"LocalUseB\":\"\",\"bilingualProgramTypeCode\":\"\",\"LocalUseC\":\"\",\"eslProgramTypeCode\":\"\",\"careerAndTechnicalEdIndCd\":\"\",\"newToTexas\":null,\"districtName\":\"ZZ CRUSE ISD\",\"atRiskIndicatorCode\":\"\",\"whiteCode\":\"\",\"tx-staff-id\":\"\",\"lepIndicatorCode\":\"\",\"studentLocalIdByDistrict\":\"\",\"economicDisadvantageCode\":\"\",\"migrantIndicatorCode\":\"\",\"nativeHawaiianPacificIslanderCode\":\"\"},\"interimTestSeq\":\"1\",\"langCode\":\"EN-US\",\"appeals\":null,\"candidateEnrollment\":null,\"candidate\":{\"candidateId\":\"129522230\",\"firstName\":\"ONE\",\"middleName\":\"\",\"lastName\":\"RGTEST\",\"dob\":\"2008-10-01 00:00:00.0\",\"gender\":\"M\",\"lastUpdatedTime\":\"2019-11-10 21:15:52.513569\",\"createdDate\":\"2019-11-10 21:15:52.513569\",\"attributes\":{\"hispanicLatinoCode\":\"\",\"campusName\":\"ZEBRA H S\",\"americanIndianAlaskaNativeCode\":\"\",\"asianCode\":\"\",\"titleIPartAIndicatorCode\":\"\",\"localUseColumnC\":\"\",\"blackAfricanAmericanCode\":\"\",\"localUseColumnB\":\"\",\"localUseColumnD\":\"\",\"localUseColumnA\":\"\",\"giftedTalentedIndicatorCode\":\"\",\"homeCountyDistrictCampusCode\":\"\",\"specialEdIndicatorCode\":\"\",\"bilingualProgramTypeCode\":\"\",\"eslProgramTypeCode\":\"\",\"careerAndTechnicalEdIndCd\":\"\",\"newToTexas\":null,\"districtName\":\"ZZ CRUSE ISD\",\"atRiskIndicatorCode\":\"\",\"whiteCode\":\"\",\"lepIndicatorCode\":\"\",\"studentLocalIdByDistrict\":\"\",\"economicDisadvantageCode\":\"\",\"migrantIndicatorCode\":\"\",\"nativeHawaiianPacificIslanderCode\":\"\"},\"accomodationCodes\":null,\"candidateAttributes\":null,\"accomodations\":\"{\\\"SOA\\\":\\\" \\\",\\\"BR\\\":\\\"0\\\",\\\"pnpGroups\\\":[\\\"TTS\\\",\\\"LS\\\",\\\"CS\\\"],\\\"pnpCodes\\\":[\\\"CSART\\\",\\\"PRS\\\",\\\"WCL\\\",\\\"PTS\\\",\\\"LSART\\\",\\\"STG\\\"],\\\"availablePNPGroups\\\":[\\\"CS\\\",\\\"TTS\\\",\\\"LS\\\"]}\",\"stateStudentId\":\"999999101\",\"localId\":\"129522230\",\"grade\":\"10\",\"tsds\":\"9999999001\"},\"testWindow\":{\"code\":\"INTEOC112019P\",\"startDate\":\"2019-11-22 01:00:01.0\",\"endDate\":\"2020-04-01 00:59:59.0\",\"attributes\":{}},\"testForm\":{\"testFormCode\":\"ETS_TXKIA1INT00003000PKG001_TXKIA100002004000TST002\",\"testName\":\"TXKIA1INT00003000PKG001\",\"packageCode\":\"TXKIA1INT00003000PKG001\",\"testType\":\"S\",\"assessmentTypeCode\":null,\"subjectCode\":\"A1\",\"grade\":\"EOC\",\"formVariant\":{\"testCode\":\"ETS_TXKIA1INT00003000PKG001_TXKIA100002004000TST002\",\"formVariantName\":\"ETS_TXKIA1INT00003000PKG001_TXKIA100002004000TST002\",\"packageCode\":\"TXKIA1INT00003000PKG001\",\"testType\":\"S\"}},\"schoolOfAccountability\":{\"id\":\"11866\",\"code\":\"258999001\",\"name\":\"ZEBRA H S\",\"parentOrgCode\":\"258999000\",\"parentOrgName\":\"ZZ CRUSE ISD\",\"regionNumber\":\"23\",\"primaryUserDTO\":null,\"address\":{\"line1\":\"25899\",\"line2\":\"\",\"city\":\"Austin\",\"state\":\"TX\",\"countryCode\":\"USA\",\"timeZone\":null,\"zip\":\"78701\"}},\"testSite\":{\"id\":\"11866\",\"code\":\"258999001\",\"name\":\"ZEBRA H S\",\"parentOrgCode\":null,\"parentOrgName\":null,\"stateAbbreviation\":\"TX\",\"stateName\":\"Texas\",\"attributes\":{},\"orgAttributes\":null,\"regionNumber\":\"23\",\"primaryUserDTO\":null,\"address\":{\"line1\":\"25899\",\"line2\":\"\",\"city\":\"Austin\",\"state\":\"TX\",\"countryCode\":null,\"timeZone\":null,\"zip\":\"78701\"}},\"primaryUser\":{\"id\":\"29728\",\"firstName\":\"Campus\",\"lastName\":\"PRIN\",\"email\":\"laurenwork4482@gmail.com\"},\"appealSummaryList\":null}";
        CandidateAdministrationDTO dto = JSONUtils.fromJSON(jsonStr,
                CandidateAdministrationDTO.class);
        System.out.println(dto);
        String d = "2019-11-05T17:34:09.815+0000";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .parse(d);
        System.out.println(date1);
        String k = "0";
        System.out.println(new Date(Long.valueOf(k)));
		String s = "-";
		String p = "[0-9e.\\-+]+";
		String p2 = "[\\-+]?";
		Pattern r = Pattern.compile(p);
		Matcher m = r.matcher(s);
		System.out.println(m.matches());
		try {
			System.out.println(" try");
			int[][] a = { { 1, 1, 0 }, { 1, 0, 0 }, { 1, 9, 0 } };
			System.out.println(new Test().bfs(3, 3, a));
		} catch (Exception e) {

		} finally {
			System.out.println(" finally");
		}
	}

	public int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
		// converting 2d list array for easy accessibility
		int[][] areaArray = new int[numRows][numColumns];
		int i = 0;
		int j = 0;
		for (List<Integer> row : area) {
			for (Integer column : row) {
				areaArray[i][j] = column;
				j++;
			}
			j = 0;
			i++;
		}
		return bfs(numRows, numColumns, areaArray);
	}

	private int bfs(int numRows, int numColumns, int[][] areaArray) {
		Queue<String> queue = new LinkedList<>();
		int[][] lvl = new int[numRows][numColumns];
		if (areaArray[0][0] == 0) {
            return -1;
        }
		if (areaArray[0][0] == 9) {
            return 0;
        }
		queue.add("0_0");
		lvl[0][0] = 0;
		while (!queue.isEmpty()) {
			String location = queue.poll();
			int x = Integer.valueOf(location.split("_")[0]);
			int y = Integer.valueOf(location.split("_")[1]);
			if (x + 1 < numRows && areaArray[x + 1][y] != 0 && lvl[x + 1][y] == 0) {
				if (areaArray[x + 1][y] == 1) {
					lvl[x + 1][y] = lvl[x][y] + 1;
					queue.add(x + 1 + "_" + y);
				} else if (areaArray[x + 1][y] == 9) {
					return lvl[x][y] + 1;
				}
			}
			if (y + 1 < numColumns && areaArray[x][y + 1] != 0 && lvl[x][y + 1] == 0) {
				if (areaArray[x][y + 1] == 1) {
					lvl[x][y + 1] = lvl[x][y] + 1;
					queue.add(x + "_" + y + 1);
				} else if (areaArray[x][y + 1] == 9) {
					return lvl[x][y] + 1;
				}
			}
		}
		return -1;
	}

}
