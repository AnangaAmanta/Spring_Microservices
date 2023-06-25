package snow.orderService.orderservice.co;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import snow.orderService.orderservice.common.TransactionRequest;
import snow.orderService.orderservice.common.TransactionResponse;
import snow.orderService.orderservice.entity.Order;
import snow.orderService.orderservice.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderCO {

	@Autowired
	private OrderService serv;

	@PostMapping("/save")
	public TransactionResponse trans(@RequestBody TransactionRequest trans) {
		

		return serv.saveTransaction(trans);

	}

}
