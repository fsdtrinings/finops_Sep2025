package streamapi.flatmap.assignment;

public class Transaction {
	
	private int tId;
	private int tAmount;
	private String tType;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int tId, int tAmount, String tType) {
		super();
		this.tId = tId;
		this.tAmount = tAmount;
		this.tType = tType;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public int gettAmount() {
		return tAmount;
	}
	public void settAmount(int tAmount) {
		this.tAmount = tAmount;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	
	 

}
