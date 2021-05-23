package reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;  

public class ComapreClasses {

	public static void main(String[] args) throws ClassNotFoundException {
		ComapreClasses obj = new ComapreClasses();
//		obj.comapreClasses("org.ets.commons.mt.api.dto.upload.UploadOnlineWindowDTO",
//				"org.ets.mt.api.services.model.bl.OnlineWindowData");
//		obj.comapreClasses("org.ets.commons.mt.api.dto.upload.UploadDemographicWindowDTO",
//				"org.ets.mt.api.services.model.bl.DemographicWindowData");
//		obj.comapreClasses("org.ets.commons.mt.api.dto.upload.UploadOrderWindowDTO",
//				"org.ets.mt.api.services.model.bl.OrderWindowData");
//		obj.comapreClasses("org.ets.commons.mt.api.dto.upload.UploadTestAdminOrderTypeDTO",
//				"org.ets.mt.api.services.model.bl.TestAdminOrderTypeData");
		obj.comapreClasses("org.ets.commons.mt.api.dto.upload.UploadAdminParametersSetupDTO",
				"org.ets.mt.api.services.model.bl.AdminParametersSetupData");
	}

	private void comapreClasses(String n1, String n2) throws ClassNotFoundException {
		Class<?> c1 = Class.forName(n1);
		Class<?> c2 = Class.forName(n2);
		List<String> c1Fields = getFields(c1);
		List<String> c2Fields = getFields(c2);
		System.out.println(c1Fields);
		System.out.println(c2Fields);
		System.out.println(c1Fields.equals(c2Fields));
		System.out.println(diff(c1Fields, c2Fields));
	}

	private List<String> getFields(Class c) {
		List<String> fields = new ArrayList<>();
		for (Field f : c.getDeclaredFields()) {
			fields.add(f.getName());
		}
		Collections.sort(fields);
		return fields;
	}

	private List<String> diff(List<String> l1, List<String> l2) {
		if (l1.size() < l2.size())
			return diff(l2, l1);
		List<String> diff = new ArrayList<>();
		for (String f : l2) {
			if (!l1.contains(f)) {
				diff.add(f);
			} else {
				l1.remove(f);
			}
		}
		if (l1.size() > 0)
			diff.addAll(l1);
		return diff;
	}

}
