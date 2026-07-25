class UndergroundSystem {
public class CustInfo {
		private int id;
		private String stationName;
		private int t;

		public CustInfo(int id, String stationName, int t) {
			super();
			this.id = id;
			this.stationName = stationName;
			this.t = t;
		}
	}

	public class StationInfo {
		private String startStation;
		private String endStation;
		private double avgTime;
		private int custCount;

		public StationInfo(String startStation, String endStation, double avgTime, int custCount) {
			super();
			this.startStation = startStation;
			this.endStation = endStation;
			this.avgTime = avgTime;
			this.custCount = custCount;
		}
	}

	Map<Integer, CustInfo> custMap;
	Map<String, StationInfo> stationMap;

	public UndergroundSystem() {
		custMap = new HashMap<>();
		stationMap = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		CustInfo cust = new CustInfo(id, stationName, t);
		custMap.put(id, cust);
	}

	public void checkOut(int id, String stationName, int t) {
        CustInfo cust = custMap.get(id);
		String stationKey = cust.stationName + "_" + stationName;
		int custCount = 0;
		double avgTime = 0;
		int timeTaken = t-cust.t;
		if (stationMap.containsKey(stationKey)) {
			StationInfo station = stationMap.get(stationKey);
			custCount = station.custCount;
			avgTime = station.avgTime;
		}
		avgTime = (custCount * avgTime + timeTaken) / (custCount + 1);
		StationInfo station = new StationInfo(cust.stationName, stationName, avgTime, custCount + 1);
		stationMap.put(stationKey, station);
	}

	public double getAverageTime(String startStation, String endStation) {
		String stationKey = startStation + "_" + endStation;
		return stationMap.get(stationKey).avgTime;
	}
}
