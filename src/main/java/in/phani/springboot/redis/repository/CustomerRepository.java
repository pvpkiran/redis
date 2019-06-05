package in.phani.springboot.redis.repository;

import in.phani.springboot.redis.pojo.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
