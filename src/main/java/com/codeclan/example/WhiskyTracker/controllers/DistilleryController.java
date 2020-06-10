package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    private DistilleryRepository distilleryRepository;

    //Get ALL distilleries
//    @GetMapping
//    public ResponseEntity<List<Distillery>> getAllDistilleries(){
//        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Distillery> getOneDistillery(@PathVariable Long id){
        return new ResponseEntity<>(distilleryRepository.findById(id).get(),HttpStatus.OK);
    }

    //Get all the distilleries for a particular region
    //distilleries?region=Highland
    @GetMapping
    public ResponseEntity<List<Distillery>> getAllDistilleriesByRegion(
            @RequestParam(name="region", required=false) String region
    ){
        if (region !=null){
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

}
