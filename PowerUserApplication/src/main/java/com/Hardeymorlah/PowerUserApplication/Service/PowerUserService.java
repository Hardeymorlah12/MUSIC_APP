package com.Hardeymorlah.PowerUserApplication.Service;

import com.Hardeymorlah.PowerUserApplication.Model.PowerUsers;
import com.Hardeymorlah.PowerUserApplication.Repository.PowerUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PowerUserService {
    @Autowired
    public final PowerUserRepository powerUserRepository;    //    Field Dependency Injection

    public PowerUserService(PowerUserRepository powerUserRepository) {
        this.powerUserRepository = powerUserRepository;
    }

    public ResponseEntity<PowerUsers> createPowerUsers(PowerUsers newPowerUser){    // C
        return new ResponseEntity<>(powerUserRepository.save(newPowerUser), HttpStatus.CREATED);
    }
    public ResponseEntity<PowerUsers> getPowerUserById(int id) {  // R
        return new ResponseEntity<>(powerUserRepository.findById(id).get(), HttpStatus.OK);
    }
    public ResponseEntity<PowerUsers> getPowerUserByEmail(String email){
        return  new ResponseEntity<>(powerUserRepository.findByEmail(email).get(),HttpStatus.OK);
    }
    public ResponseEntity<PowerUsers> getPowerUserByPhoneNumber(String phoneNumber){
        return  new ResponseEntity<>(powerUserRepository.findByPhoneNumber(phoneNumber).get(),HttpStatus.OK);
    }
    public ResponseEntity<List<PowerUsers>> getAllPowerUsers(){  // R
        return new ResponseEntity<>(powerUserRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<PowerUsers> updatePowerUserDetails(int id, PowerUsers updateDetails){   // U
        PowerUsers user = getPowerUserById(id).getBody();
        assert user != null;
        user.setFirstName(updateDetails.getFirstName());
        user.setLastName(updateDetails.getLastName());
        user.setAddress(updateDetails.getAddress());
        user.setEmail(updateDetails.getEmail());
        user.setPhoneNumber(updateDetails.getPhoneNumber());
        user.setCourse(updateDetails.getCourse());
        return new ResponseEntity<>(powerUserRepository.save(user),HttpStatus.OK);
    }
///    public ResponseEntity<Optional<PowerUsers>> deletePowerUser(int id){    // D
//        Optional<PowerUsers> user = powerUserRepository.findById(id);
//        user.ifPresent(powerUserRepository::delete);
//        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
//    }
    public ResponseEntity<PowerUsers> deletePowerUsers(String email){   // D
        PowerUsers user = getPowerUserByEmail(email).getBody();
        powerUserRepository.deleteById(user.getId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
