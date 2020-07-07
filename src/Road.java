import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Road {
	private int roadid;
	private int type;
	private String label;
	private String city;
	private int oneway;
	private int speed;
	private int roadclass;
	private boolean notforcar;
	private boolean notforpede;
	private boolean notforbicy;
	public List<Segment> segments = new ArrayList<>();

	public Road(int roadid, int type, String label, String city, int oneway, int speed, int roadclass, int notforcar,
			int notforpede, int notforbicy) {
		this.roadid = roadid;
		this.type = type;
		this.label = label;
		this.city = city;
		this.oneway = oneway;
		this.speed = speed;
		this.roadclass = roadclass;
		this.notforcar = notforcar == 1 ? true : false;
		this.notforpede = notforpede == 1 ? true : false;
		this.notforbicy = notforbicy == 1 ? true : false;
	}

	public int getRoadid() {
		return roadid;
	}

	public void setRoadid(int roadid) {
		this.roadid = roadid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getOneway() {
		return oneway;
	}

	public void setOneway(int oneway) {
		this.oneway = oneway;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRoadclass() {
		return roadclass;
	}

	public void setRoadclass(int roadclass) {
		this.roadclass = roadclass;
	}

	public boolean isNotforcar() {
		return notforcar;
	}

	public void setNotforcar(boolean notforcar) {
		this.notforcar = notforcar;
	}

	public boolean isNotforpede() {
		return notforpede;
	}

	public void setNotforpede(boolean notforpede) {
		this.notforpede = notforpede;
	}

	public boolean isNotforbicy() {
		return notforbicy;
	}

	public void setNotforbicy(boolean notforbicy) {
		this.notforbicy = notforbicy;
	}

	public void draw(Graphics g) {

	}
}
