package snow.orderService.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import snow.orderService.orderservice.common.Payment;
import snow.orderService.orderservice.common.TransactionRequest;
import snow.orderService.orderservice.common.TransactionResponse;
import snow.orderService.orderservice.entity.Order;
import snow.orderService.orderservice.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo ordRepo;

	@Autowired
	private RestTemplate template;

	public Order save(Order ord) {
		ord.setId(ordRepo.getNextVal());
		return ordRepo.save(ord);
	}

	public TransactionResponse saveTransaction(TransactionRequest trans) {

		Order ord = trans.getOrder();
		Payment pay = trans.getPayment();
		ord.setId(ordRepo.getNextVal());
		pay.setOrderId(ord.getId());
		pay.setAmount(ord.getPrice());

		 Payment paymentResponse = template.postForObject("http://PAYMENT_SERVICE/Payment/doPayment", pay, Payment.class);
		//Payment paymentResponse = template.postForObject("http://host.docker.internal:PAYMENT_SERVICE/Payment/doPayment", pay, Payment.class);

	String response = paymentResponse.getPaymentStatus()
			.equals("success")?"Payment Success":"Payment Failed";
		
		
		ordRepo.save(ord);

		return new TransactionResponse(ord,paymentResponse.getAmount()
				                          ,paymentResponse.getTransactionId()
				                          ,response);

	}

}
