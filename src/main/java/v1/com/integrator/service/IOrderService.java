package v1.com.integrator.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import v1.com.integrator.bean.Order;
import v1.com.integrator.bean.Response;
import v1.com.integrator.bean.WmsOrder;

public interface IOrderService {
	
	public List<WmsOrder> transformOrderRequest(List<Order> orders) throws Exception;
	
	public ResponseEntity<Response> dispatchRequstToWms(List<WmsOrder> listwmsOrder) throws Exception;

}
