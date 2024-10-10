package com.spring.backend.bootstrap;

import com.spring.backend.dao.CustomerRepository;
import com.spring.backend.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository ;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() < 2) {

            Customer customer2 = new Customer();
            customer2.setFirstName("John");
            customer2.setLastName("Smith");
            customer2.setAddress("406 Harbor Square Lane");
            customer2.setPostalCode("08223");
            customer2.setPhone("646-557-0923");
            customerRepository.save(customer2);

            Customer customer3 = new Customer();
            customer3.setFirstName("Cindy");
            customer3.setLastName("Beth");
            customer3.setAddress("101 South Lane");
            customer3.setPostalCode("23456");
            customer3.setPhone("546-587-0223");
            customerRepository.save(customer3);

            Customer customer4 = new Customer();
            customer4.setFirstName("Luke");
            customer4.setLastName("Lance");
            customer4.setAddress("20 New Road");
            customer4.setPostalCode("56789");
            customer4.setPhone("356-557-0911");
            customerRepository.save(customer4);

            Customer customer5 = new Customer();
            customer5.setFirstName("Maria");
            customer5.setLastName("Kelth");
            customer5.setAddress("19 Shore Road");
            customer5.setPostalCode("89012");
            customer5.setPhone("737-527-8776");
            customerRepository.save(customer5);

            Customer customer6 = new Customer();
            customer6.setFirstName("John");
            customer6.setLastName("Smith");
            customer6.setAddress("35 West Jersey Lane");
            customer6.setPostalCode("08223");
            customer6.setPhone("646-557-0923");
            customerRepository.save(customer6);
        }
    }
}
