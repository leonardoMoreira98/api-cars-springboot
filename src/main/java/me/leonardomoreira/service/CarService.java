package me.leonardomoreira.service;

import me.leonardomoreira.domain.Car;
import me.leonardomoreira.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public List<Car> findAll() {
        return carRepository.findAll();
    }
    public Car save(Car car) {
        return carRepository.save(car);
    }
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public Car replace(Car car) {
        findById(car.getId());
        return save(car);
    }
    public void deleteById(Long id) {
        Car car = findById(id);
        carRepository.delete(car);
    }

}
