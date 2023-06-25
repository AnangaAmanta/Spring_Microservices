package snow.orderService.orderservice.common;

import snow.orderService.orderservice.entity.Order;

public class TransactionResponse {
	
	private Order ord;
	private Double amount;
	private String transactionid;
	private String message;
	
  
	
	
	public TransactionResponse(Order ord, Double amount, String transactionid, String message) {
		super();
		this.ord = ord;
		this.amount = amount;
		this.transactionid = transactionid;
		this.message = message;
	}
	
	public Order getOrd() {
		return ord;
	}
	public void setOrd(Order ord) {
		this.ord = ord;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "TransactionResponse [ord=" + ord + ", amount=" + amount + ", transactionid=" + transactionid
				+ ", message=" + message + "]";
	}
	
	
	
	

}
