package TextComp;

import java.util.ArrayList;
import java.util.Map;

public class Interpreter {
	public static String errorCheck(String n, Units units) {
		if(n.toLowerCase().contains("to")) {
			return "BRUH";
		}
		return "ERROR";
	}
	//finds the path in the dictionary in units to convert n to n1 then returns the coefficent needed to convert 
	public static double getPath(String n1, String n2,Units units) {
		Map<String,Map<String,Double>> dict = units.getUnits();
		double coe1 = 1;
		double coe2 = 1;
		String current1 = "";
		String current2 = "";
		for(String k : dict.keySet()) {
			if(k.equals(n1)) {
				current1 = n1;
				break;
			}
			if(dict.get(k).containsKey(n1)) {
				current1 = k;
				coe1 = coe1*dict.get(k).get(n1);
			}
		}
		for(String k : dict.keySet()) {
			if(k.equals(n2)) {
				current2 = n2;
				break;
			}
			if(dict.get(k).containsKey(n2)) {
				current2 = k;
				coe2 = coe2*dict.get(k).get(n2);
			}
		}
		System.out.println("current1: "+current1);
		System.out.println("current2:"+current2);
		System.out.println("coe1:"+coe1);
		System.out.println("coe2:"+coe2);
		if(current1 == "" || current2 == "") {
			return 0.0;
		}
		String v = current1;
		ArrayList<String> list = new ArrayList<String>();
		int count = 0;
		while(v != current2 && count < 100) {
			System.out.println(v);
			for(String key: dict.get(v).keySet()) {
				if(dict.keySet().contains(key)) {
					list.add(key);
					v = key;
				}
			}
			count++;
		}
		if(count == 100) {
			v = current2;
			list = new ArrayList<String>();
			System.out.println("count:"+count);
			while(v != current1) {
				//System.out.println(v);
				for(String key: dict.get(v).keySet()) {
					if(dict.keySet().contains(key)) {
						list.add(key);
						v = key;
					}
				}
			}
		}
		for(int i = 0; i < list.size();i++) {
			System.out.println(list.get(i));
		}
		while(current1 != current2 && count < 100) {
			System.out.println(coe1);
			coe1 = coe1*dict.get(current1).get(list.get(0));
			current1 = list.get(0);
			list.remove(0);
		}
		if(count == 100) {
			while(current1 != current2 && count == 100) {
				System.out.println(coe2);
				coe2 = coe2*dict.get(current2).get(list.get(0));
				current2 = list.get(0);
				list.remove(0);
			}
		}
		return coe1/coe2;
	}
}
