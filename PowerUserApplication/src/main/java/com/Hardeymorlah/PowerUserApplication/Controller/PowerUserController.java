package com.Hardeymorlah.PowerUserApplication.Controller;
import com.Hardeymorlah.PowerUserApplication.Model.PowerUsers;
import com.Hardeymorlah.PowerUserApplication.Service.PowerUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PowerUserController {
    @Autowired
    private  PowerUserService powerUserService;

    public PowerUserController(PowerUserService powerUserService) {
        this.powerUserService = powerUserService;
    }

    @PostMapping("/postPowerUser")
    public ResponseEntity<PowerUsers> createPowerUsers(@RequestBody @Valid PowerUsers newPowerUser){     // C
        return powerUserService.createPowerUsers(newPowerUser);
    }
    @GetMapping("/powerUser/{id}")
    public ResponseEntity<PowerUsers> getPowerUserById(@PathVariable int id){       // R
        return powerUserService.getPowerUserById(id);
    }
    @GetMapping("/powerUserEmail")
    public ResponseEntity<PowerUsers> getPowerUserByEmail(@RequestParam String email){       // R
        return powerUserService.getPowerUserByEmail(email);
    }
    @GetMapping("/powerUserPhoneNumber")
    public ResponseEntity<PowerUsers> getPowerUserByPhoneNumber(@RequestParam String phoneNumber){       // R
        return powerUserService.getPowerUserByPhoneNumber(phoneNumber);
    }
    @GetMapping(value = "/powerUser")
    public ResponseEntity<List<PowerUsers>> getAllPowerUsers(){     // R
        return powerUserService.getAllPowerUsers();
    }
    @PutMapping("/powerUser/{id}")
    public ResponseEntity<PowerUsers> updatePowerUserDetails(@PathVariable int id, @RequestBody @Valid PowerUsers updateUserDetails){
        return powerUserService.updatePowerUserDetails(id, updateUserDetails);      // U
    }
    @DeleteMapping("/powerUser/{email}")
    public ResponseEntity<PowerUsers> deletePowerUser(@PathVariable String email){    // D
        return powerUserService.deletePowerUsers(email);
    }
}
