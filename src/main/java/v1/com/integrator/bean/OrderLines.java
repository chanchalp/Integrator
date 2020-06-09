package v1.com.integrator.bean;

/**
 * 
 * @author chanchal prakash
 *
 */
public class OrderLines {
	private String order_line;

    private String product_number;

    private String payment_mode;

	public String getOrder_line() {
		return order_line;
	}

	public void setOrder_line(String order_line) {
		this.order_line = order_line;
	}

	public String getProduct_number() {
		return product_number;
	}

	public void setProduct_number(String product_number) {
		this.product_number = product_number;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	@Override
	public String toString() {
		return "OrderLines [order_line=" + order_line + ", product_number=" + product_number + ", payment_mode="
				+ payment_mode + "]";
	}
    

}
