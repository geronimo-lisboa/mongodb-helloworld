package don.geronimo.helloMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloMongoApplication implements CommandLineRunner{
        @Autowired
        private CustomerRepository customerRepository;
        
	public static void main(String[] args) {
		SpringApplication.run(HelloMongoApplication.class, args);
	}
        @Override
        public void run(String... args)throws Exception{
            customerRepository.deleteAll();
            customerRepository.save(new Customer("Jon", "Smith"));
            customerRepository.save(new Customer("Alice", "Smith"));
            customerRepository.save(new Customer("Bob", "Kane"));
            for(Customer c : customerRepository.findAll()){
                System.out.println(c);
            }

            Customer c0 = customerRepository.findByLastName("Kane").get(0);
            System.out.println(c0);
            Customer c1 = customerRepository.findByLastName("Smith").get(0);
            System.out.println(c1);
            Customer c2 = customerRepository.findByLastName("Smith").get(0);
            System.out.println(c2);
            
        }
}
