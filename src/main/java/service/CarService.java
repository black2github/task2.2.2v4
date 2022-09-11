package service;

import dao.CarDao;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarDao carDao;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public Car add(Car car) {
        return carDao.add(car);
    };

    public List<Car> list(int count) {
        return carDao.list(count);
    }

    public List<Car> findAll() {
        return carDao.findAll();
    }
}
