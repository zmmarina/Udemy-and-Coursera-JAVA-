package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> orders = new ArrayList<>();
	
	
		public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	
	public List<OrderItem> getOrders() {
		return orders;
	}


	public void addItem (OrderItem item) {
		orders.add(item);
	}
	
	public void removeItem (OrderItem item) {
		orders.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem o : orders) {
			sum += o.subTotal();
		} 
		return sum;
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append ("Order moment: ");
		sb.append(sdf.format(moment)+"\n");
		sb.append("Order status: ");
		sb.append (status +"\n");
		sb.append("Client: ");
		sb.append(client+"\n");
		sb.append("Order items: "+"\n");
		for (OrderItem order : orders) {
			sb.append(order + "\n");
		}
		
		sb.append("Total price: $");
		sb.append (String.format("%.2f", total()));
		return sb.toString();
		
	}
}
