package com.example.practitionerservice2;

import com.example.practitionerservice2.Practitioner;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/practitioner")
public class PractitionerController {

    private List<Practitioner> practitioners = new ArrayList<>();

    @GetMapping("/get/{id}")
    public Practitioner getPractitioner(@PathVariable int id){
        return practitioners.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);
    }

    @PostMapping("/add")
    public Practitioner addPractitioner(@RequestBody Practitioner practitioner) {

        practitioners.add(practitioner);
        return practitioner;
    }

    @DeleteMapping("/del/{id}")
    public String delPractitioner(@PathVariable int id) {
        Practitioner practitioner = getPractitioner(id);
        if (practitioner != null) {
            practitioners.remove(practitioner);
            return "Success";
        } else {
            return "Practitioner not found";
        }
    }

    @PutMapping("/update/{id}")
    public String updatePractitioner(@PathVariable int id, @RequestBody Practitioner updatedPractitioner) {
        Practitioner oldPractitioner = getPractitioner(id);
        if (oldPractitioner != null) {
            oldPractitioner.setName(updatedPractitioner.getName());
            oldPractitioner.setEmail(updatedPractitioner.getEmail());
            oldPractitioner.setPhone(updatedPractitioner.getPhone());
            return "Update success";
        } else {
            return "Practitioner not found";
        }
    }
}