package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Organizer;
import com.service.OrganizerService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @PostMapping("/addorg")
    public ResponseEntity<Organizer> addOrganizer(@RequestBody Organizer o) {
        Organizer addedOrganizer = organizerService.addOrganizer(o);
        return new ResponseEntity<>(addedOrganizer, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletorg/{organizerId}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable long organizerId) {
        organizerService.deleteOrganizer(organizerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getallorg")
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        List<Organizer> organizers = organizerService.getAllOrganizer();
        return new ResponseEntity<>(organizers, HttpStatus.OK);
    }

    @PutMapping("/updateorg/{organizerId}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable long organizerId, @RequestBody Organizer org) {
        org.setOrganizerId(organizerId); // Setting the organizerId from path variable
        Organizer updatedOrganizer = organizerService.updateOrganizer(org);
        return new ResponseEntity<>(updatedOrganizer, HttpStatus.OK);
    }
    
//    @GetMapping("findorganizerbyemail/email/{email}")
//    public ResponseEntity<List<Organizer>> findByEmail(@PathVariable String email) {
//        List<Organizer> organizers = organizerService.findByEmail(email);
//        return new ResponseEntity<>(organizers, HttpStatus.OK);
//    }
    
    @PostMapping("/register")
    public ResponseEntity<Organizer> registerOrganizer(@RequestBody Organizer o) {
        // Implement registration logic here
        // You may need to add validation, such as checking if the email is unique
        Organizer registeredOrganizer = organizerService.registerOrganizer(o);
        return new ResponseEntity<>(registeredOrganizer, HttpStatus.CREATED);
    }
//    
//    @PostMapping("/login")
//    public ResponseEntity<Organizer> loginOrganizer(@RequestParam String email, @RequestParam String organizerPass) {
//        // Implement login logic here
//        // You may validate the credentials against the stored data
//        Organizer loggedInOrganizer = organizerService.loginOrganizer(email, organizerPass);
//        if (loggedInOrganizer != null) {
//            return new ResponseEntity<>(loggedInOrganizer, HttpStatus.OK);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<?> loginOrganizer(@RequestBody Organizer loginCredentials) {
        String email = loginCredentials.getEmail();
        String password = loginCredentials.getOrganizerPass();

        // Perform authentication logic based on email and password
        Organizer authenticatedOrganizer = organizerService.authenticateOrganizer(email, password);

        if (authenticatedOrganizer != null) {
            return ResponseEntity.ok(authenticatedOrganizer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .header("login-failed", "Invalid email or password")
                    .build();
        }
    }
}
