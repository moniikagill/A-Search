import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Segment {
	private int roadid;
	private double length;
	private int nodeid1;
	private int nodeid2;
	private List<Double> coords;
	
	
	public Segment(int roadid, double length, int nodeid1, int nodeid2, List<Double> coords) {
		this.roadid = roadid;
		this.length = length;
		this.nodeid1 = nodeid1;
		this.nodeid2 = nodeid2;
		this.coords = coords;
	}
	public int getRoadid() {
		return roadid;
	}
	public void setRoadid(int roadid) {
		this.roadid = roadid;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public int getNodeid1() {
		return nodeid1;
	}
	public void setNodeid1(int nodeid1) {
		this.nodeid1 = nodeid1;
	}
	public int getNodeid2() {
		return nodeid2;
	}
	public void setNodeid2(int nodeid2) {
		this.nodeid2 = nodeid2;
	}
	public List<Double> getCoords() {
		return coords;
	}
	public void setCoords(List<Double> coords) {
		this.coords = coords;
	}
	
	public void draw(Graphics g, Location origin, double scale) {
		List<Location> coordsLoc = new ArrayList<>();
		for (int i = 0; i < coords.size(); i = i + 2) {
			coordsLoc.add(Location.newFromLatLon(coords.get(i), coords.get(i+1)));
		}
		
		Point point1 = coordsLoc.get(0).asPoint(origin, scale);
		
		for (int i = 1; i < coordsLoc.size(); i++) {
			Point point2 = coordsLoc.get(i).asPoint(origin, scale);
			g.drawLine((int)point1.x, (int)point1.y,(int) point2.x, (int)point2.y);
			point1 = point2;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nodeid1;
		result = prime * result + nodeid2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segment other = (Segment) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (nodeid1 != other.nodeid1)
			return false;
		if (nodeid2 != other.nodeid2)
			return false;
		return true;
	}
}
