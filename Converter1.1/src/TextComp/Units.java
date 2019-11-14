package TextComp;

import java.util.HashMap;
import java.util.Map;

public class Units {
	private static Map<String,Map<String,Double>> units;
	public Units() {
		Map<String,Map<String,Double>> units = new HashMap<String,Map<String,Double>>();
		//main units Length Mi KM M MM UM
		Map<String,Double> units1 = new HashMap<String,Double>();
		//units1.put("km",new Double(1.609));
		//units.put("mi",units1);
		units1 = new HashMap<String,Double>();
		units1.put("mi",new Double(1.60934));
		units1.put("nmi",new Double(1/1.852));
		units1.put("m",new Double(1000));
		units.put("km",units1);
		units1 = new HashMap<String,Double>();
		units1.put("mm",new Double(1000));
		units1.put("cm",new Double(100));
		units1.put("chain",new Double(1/20.1168));
		units1.put("link",new Double(1/.201168));
		units1.put("ft",new Double(1/3.048));
		units.put("m",units1);
		units1 = new HashMap<String,Double>();
		units1.put("um",new Double(1000));
		units1.put("in",new Double(25.4));
		units.put("mm",units1);
		//main units Area mi2 km2 m2 mm2
		units1 = new HashMap<String,Double>();
		units1.put("km2",new Double(2.589988));
		units.put("mi2",units1);
		units1 = new HashMap<String,Double>();
		units1.put("m2",new Double(1000000));
		units.put("km2",units1);
		units1 = new HashMap<String,Double>();
		units1.put("mm2",new Double(1000000));
		units1.put("cm2",new Double(10000));
		units1.put("ha",new Double(1/10000));
		units1.put("acre",new Double(1/4046.856));
		units1.put("section",new Double(1/2589998));
		units1.put("ft2",new Double(1/.09290304));
		units.put("m2",units1);
		units1 = new HashMap<String,Double>();
		units1.put("um2",new Double(1000000));
		units1.put("in2",new Double(1/645.16));
		units.put("mm2",units1);
		//main units Volume km3 mi3 m3 dm3
		this.units = units;
	}
	public Map<String,Map<String,Double>> getUnits(){
		return units;
	}
}

