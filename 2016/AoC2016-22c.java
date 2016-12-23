
public class NodeLocation {
	private Node node;
	private int level = 0;
	
	public NodeLocation(Node node, int level){
		this.setNode(node);
		this.setLevel(level);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
