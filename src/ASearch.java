import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ASearch {
	public static PriorityQueue<Record> fringe = new PriorityQueue<>(new Comparator<Record>() {

		@Override
		public int compare(Record o1, Record o2) {
			return (int) (o1.heuristic - o2.heuristic);
		}
		
	});
	
	public static List<Segment> search(Node s, Node g) {
		List<Segment> path = new ArrayList<>();
		
		Record start = new Record(s, null, 0, s.location.distance(g.location));
		fringe.offer(start);
		
		while (!fringe.isEmpty()) {
			Record r = fringe.poll();
			if (!r.current.visited) {
				r.current.visited = true;
				r.current.previous = r.prev;
				
				if (r.current.getNodeid() == g.getNodeid()) {
					break;
				}
				
				List<Neighbour> neighbours = r.current.getNeighbours();
				
				for (Neighbour noden : neighbours) {
					Node neigh = noden.n;
					if (!neigh.visited) {
						double dist = r.distance + noden.length;
						double heuristic = dist + neigh.location.distance(g.location);
						fringe.offer(new Record(neigh, r.current, dist, heuristic));
					}
				}
			}
		}
		
		Node n1 = g;
		Node n2 = g.previous;
		
		while (n2 != null) {
			for (Segment seg : n2.segments) {
				if (seg.getNodeid1() == n1.getNodeid() || seg.getNodeid2() == n1.getNodeid()) {
					path.add(seg);
					break;
				}
			}
			n1 = n1.previous;
			n2 = n2.previous;
		}
		
		return path;
	}

}
