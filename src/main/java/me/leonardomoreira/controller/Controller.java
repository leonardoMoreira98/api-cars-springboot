package me.leonardomoreira.controller;

import me.leonardomoreira.domain.Car;
import me.leonardomoreira.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class Controller {

    private final CarService carService;

    public Controller(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAll(){
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id){
        return new ResponseEntity<>(carService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Car> replace(@RequestBody Car car){
        return new ResponseEntity<>(carService.replace(car), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        carService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

