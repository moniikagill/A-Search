
public class Record {
	public Node current;
	public Node prev;
	public double distance;
	public double heuristic;
	public Record(Node current, Node neigh, double distance, double heuristic) {
		this.current = current;
		this.prev = neigh;
		this.distance = distance;
		this.heuristic = heuristic;
	}
}
