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
import org.springframework.web.bind.annotation.RestController;

import com.model.Admin;
import com.service.AdminService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addadmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin a) {
        Admin createdAdmin = adminService.addAdmin(a);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @DeleteMapping("delet/customers/{cid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("cid") long customerId) {
        adminService.deleteCus(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deletadmin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("id") long adminId) {
        adminService.deleteAd(adminId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateadmin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long adminId, @RequestBody Admin admin) {
        admin.setId(adminId);
        Admin updatedAdmin = adminService.updateAdmin(admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }

    @GetMapping("/getalladmin")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
    
//    @GetMapping("/findByEmail/{email}")
//    public List<Admin> findByEmail(@PathVariable("email") String email) {
//        return adminService.findByEmail(email);
//    }
    
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        Admin registeredAdmin = adminService.registerAdmin(admin);
        return new ResponseEntity<>(registeredAdmin, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin loginCredentials) {
        String email = loginCredentials.getEmail();
        String password = loginCredentials.getPassword();

        // Perform authentication logic based on email and password
        Admin authenticatedAdmin = adminService.authenticateAdmin(email, password);

        if (authenticatedAdmin != null) {
            return ResponseEntity.ok(authenticatedAdmin);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .header("login-failed", "Invalid email or password")
                    .build();
        }
    }
    
//    @PostMapping("/login")
//    public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
//        Admin loggedInAdmin = adminService.loginAdmin(admin.getEmail(), admin.getPassword());
//        if (loggedInAdmin != null) {
//            return new ResponseEntity<>(loggedInAdmin, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//    }
    
    
}



/*
 * @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        // Check if the email is already registered
        List<Admin> existingAdmins = adminService.findByEmail(admin.getEmail());
        if (!existingAdmins.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Add the new admin
        Admin createdAdmin = adminService.addAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody Admin admin) {
        // Check if the admin with the provided email exists
        List<Admin> existingAdmins = adminService.findByEmail(admin.getEmail());
        if (existingAdmins.isEmpty()) {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }

        // Check if the provided password matches the stored password
        Admin storedAdmin = existingAdmins.get(0); // Assuming emails are unique
        if (!storedAdmin.getPassword().equals(admin.getPassword())) {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }

        // Return a success message
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }
 */
