package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.service.CustomerService;
@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //done
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) {
        Customer createdCustomer = customerService.addCustomer(c);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    //done
    @PutMapping("/updatecustomer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") long customerId,
            @RequestBody Customer customer) {
        customer.setCustomerId(customerId);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    //done
    @DeleteMapping("/deletcustomer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //done
    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //done
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") long customerId) {
        Customer customer = customerService.getOneCustomer(customerId);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
//    @GetMapping("/Customeremail/{email}")
//    public List<Customer> findByEmail(@PathVariable String email) {
//        return customerService.findByEmail(email);
//    }
    
 // Registration endpoint
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }
    
 // Login endpoint(@RequestParam String param1, @RequestParam("param2") int param2)
//    @PostMapping("/login")
//    public ResponseEntity<Customer> loginCustomer(@RequestParam String email, @RequestParam ("password")String password){
//        Customer loggedInCustomer = customerService.loginCustomer(email, password);
//        if (loggedInCustomer != null) {
//            return new ResponseEntity<>(loggedInCustomer, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody Customer loginCredentials) {
        String email = loginCredentials.getEmail();
        String password = loginCredentials.getPassword();

        // Perform authentication logic based on email and password
        Customer authenticatedCustomer = customerService.authenticateCustomer(email, password);

        if (authenticatedCustomer != null) {
            return ResponseEntity.ok(authenticatedCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .header("login-failed", "Invalid email or password")
                    .build();
        }
    }

}
