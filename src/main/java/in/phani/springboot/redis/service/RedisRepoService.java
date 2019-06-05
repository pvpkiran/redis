package in.phani.springboot.redis.service;

import com.google.common.collect.Lists;
import in.phani.springboot.redis.pojo.Customer;
import in.phani.springboot.redis.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Access Redis vis spring-data repository layer
 */
@Service
public class RedisRepoService {

    private final CustomerRepository customerRepository;

    public RedisRepoService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllFromRedis() {
        List<Customer> allCustomers = Lists.newArrayList();
        customerRepository.findAll().forEach(allCustomers::add);
        return allCustomers;
    }

    public void addToRedis(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }

    public Optional<Customer> getFromRedis(Long id){
        return customerRepository.findById(id);
    }

}
