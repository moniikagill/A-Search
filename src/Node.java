import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Node {
	private int nodeid;
	private double latitude;
	private double longitude;
	public Location location;
	public boolean highlighted;
	public List<Segment> segments = new ArrayList<>();
	public boolean visited;
	public Node previous;
	
	public Node(int nodeid, double latitude, double longitude) {
		this.nodeid = nodeid;
		this.latitude = latitude;
		this.longitude = longitude;
		location = Location.newFromLatLon(latitude, longitude);
		highlighted = false;
	}
	
	public int getNodeid() {
		return nodeid;
	}
	public void setNodeid(int nodeid) {
		this.nodeid = nodeid;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public void draw(Graphics g, Location origin, double scale) {
		
		Point pos = location.asPoint(origin, scale); //Makes a new Point object from this Location object and returns it
		
		g.drawRect((int)pos.x, (int)pos.y, 2, 2);
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
	
	public List<Neighbour> getNeighbours() {
		List<Neighbour> neigh = new ArrayList<>();
		for (Segment s : segments) {
			int node1 = s.getNodeid1();
			int node2 = s.getNodeid2();
			if (node1 != this.getNodeid()) {
				neigh.add(new Neighbour(RoadCollection.nodes.get(node1), s.getLength()));
			}
			else {
				neigh.add(new Neighbour(RoadCollection.nodes.get(node2), s.getLength()));
			}
		}
		
		return neigh;
	}
}
