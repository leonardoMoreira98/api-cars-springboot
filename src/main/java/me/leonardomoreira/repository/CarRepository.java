package me.leonardomoreira.repository;

import me.leonardomoreira.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
