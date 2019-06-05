package in.phani.springboot.redis.controller;

import in.phani.springboot.redis.pojo.Customer;
import in.phani.springboot.redis.service.RedisRepoService;
import in.phani.springboot.redis.service.RedisTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RedisController {

    private final RedisTemplateService redisTemplateService;
    private final RedisRepoService redisRepoService;

    public RedisController(RedisTemplateService redisTemplateService,
                           RedisRepoService redisRepoService) {
        this.redisTemplateService = redisTemplateService;
        this.redisRepoService = redisRepoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello From Redis";
    }

    @GetMapping("/template/{key}")
    public String getFromTemplate(@PathVariable String key) {
        return redisTemplateService.getFromRedis(key);
    }

    @PostMapping("/template")
    public void putFromTemplate(@RequestParam String key, @RequestParam String value) {
         redisTemplateService.putToRedis(key, value);
    }

    @PostMapping("/customer")
    public ResponseEntity addToRedis(@RequestBody Customer customer) {
        redisRepoService.addToRedis(customer);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customer")
    public List<Customer> getAllFromRedis() {
        return redisRepoService.getAllFromRedis();
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> getAllFromRedis(@PathVariable Long id) {
        return redisRepoService.getFromRedis(id);
    }

    @DeleteMapping("/customer")
    public ResponseEntity deleteAll() {
        redisRepoService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
