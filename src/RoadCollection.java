import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoadCollection {
	public static Map<Integer, Road> roads = new HashMap<>();
	public static Map<Integer, Node> nodes = new HashMap<>();
	public static List<Segment> segments = new ArrayList<>();

	public static void readNodes(File file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] array = sCurrentLine.split("\t");
				int nodeid = Integer.parseInt(array[0]);
				double lat = Double.parseDouble(array[1]);
				double longitude = Double.parseDouble(array[2]);
				nodes.put(nodeid, new Node(nodeid, lat, longitude));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readRoads(File file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			br.readLine();
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] array = sCurrentLine.split("\t");
				int roadid = Integer.parseInt(array[0]);
				int type = Integer.parseInt(array[1]);
				String label = array[2];
				String city = array[3];
				int oneway = Integer.parseInt(array[4]);
				int speed = Integer.parseInt(array[5]);
				int roadclass = Integer.parseInt(array[6]);
				int notforcar = Integer.parseInt(array[7]);
				int notforpede = Integer.parseInt(array[8]);
				int notforbicy = Integer.parseInt(array[9]);

				roads.put(roadid, new Road(roadid, type, label, city, oneway, speed, roadclass, notforcar, notforpede,
						notforbicy));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readSegments(File file) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			br.readLine();
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] array = sCurrentLine.split("\t");
				int roadid = Integer.parseInt(array[0]);
				double length = Double.parseDouble(array[1]);
				int nodeID1 = Integer.parseInt(array[2]);
				int nodeID2 = Integer.parseInt(array[3]);
				List<Double> list = new ArrayList<Double>();

				for (int i = 4; i < array.length; i++) {
					list.add(Double.parseDouble(array[i]));
				}

				Segment segm = new Segment(roadid, length, nodeID1, nodeID2, list);
				segments.add(segm);
				//adding nodes to segments
				//add segment to appropriate node
				//create a node object then use get nodeId to get node linked to that id from nodes static field
				//add this node's segment to segment from the node class
				//add the node object along with that nodeId in nodes hashMap
				Node n1 = nodes.get(nodeID1);
				n1.segments.add(segm);
				nodes.put(nodeID1, n1);
				
				Node n2 = nodes.get(nodeID2);
				n2.segments.add(segm);
				nodes.put(nodeID2, n2);
				//storing segments that belong to the road
				//gets the road linked to that roadId and puts in road object
				//add segment to this road segment field
				//add roadId and road info in roads field
				Road r = roads.get(roadid);
				r.segments.add(segm);
				roads.put(roadid, r);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
