package snow.orderService.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import snow.orderService.orderservice.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {
	
	 @Query(value = "select ord_seq_01.nextVal",nativeQuery = true)
	 int getNextVal();

}
