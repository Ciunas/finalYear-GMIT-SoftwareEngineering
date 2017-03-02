package assignmentJUNIT.multiclass;

public class Asset

{

	private int id;

	private String type;

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getType() {

		return type;

	}

	public void setType(String type) {

		this.type = type;

	}

	public void printDescription() {

		System.out.println("Asset ID: " + id);

		System.out.println("Asset type: " + type);

	}

}
