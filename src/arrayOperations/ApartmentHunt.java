package arrayOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ApartmentHunt {

	static List<Integer> apartmentOptions(List<HashMap<String, Boolean>> apartments, List<String> requirements) {

		HashMap<Integer, Integer> check = new HashMap<>();
		List<Integer> options = new ArrayList<>();

		for (int i = 0; i < apartments.size(); i++) {
//			System.out.println("current apt: " + i);

			for (int j = 0; j < apartments.size(); j++) {
//				System.out.println("current compared to: " + j);

				for (String req : requirements) {
					int minDist = Integer.MAX_VALUE;
					
					for (Entry<String, Boolean> entry : apartments.get(j).entrySet()) {
						if (req == entry.getKey()) {
							if (entry.getValue()) {
								if (minDist >= j) {
									minDist=j;
									System.out.println("curr min dist to req " + req + " : " + minDist);
									check.put(i, minDist);
								} else check.put(i, minDist);


							} else {
								System.out.println("req not existant in: " + j + " : " + req);
							}
 
						}
					}
				}
				
				
			}
		}
		for (Entry<Integer, Integer> entry : check.entrySet()) {
			System.out.println("check " + entry.getKey() + " - " + entry.getValue());
		}
		return options;

	}

	public static void main(String[] args) {
		List<HashMap<String, Boolean>> apartments = new ArrayList<>();
		HashMap<String, Boolean> ap1 = new HashMap<>();
		ap1.put("gym", true);
		ap1.put("store", false);
		ap1.put("school", false);
		apartments.add(ap1);
		HashMap<String, Boolean> ap2 = new HashMap<>();
		ap2.put("gym", false);
		ap2.put("store", true);
		ap2.put("school", false);
		apartments.add(ap2);
		HashMap<String, Boolean> ap3 = new HashMap<>();
		ap3.put("gym", false);
		ap3.put("store", false);
		ap3.put("school", true);
		apartments.add(ap3);
		HashMap<String, Boolean> ap4 = new HashMap<>();
		ap3.put("gym", false);
		ap3.put("store", false);
		ap3.put("school", true);
		apartments.add(ap4);

		List<String> requirements = new ArrayList<>();
		requirements.add("gym");
		requirements.add("store");
		requirements.add("school");

		System.out.println(apartmentOptions(apartments, requirements));

	}

}
