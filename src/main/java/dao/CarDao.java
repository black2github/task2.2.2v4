package dao;

import model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDao {
    private List<Car> list = new ArrayList<>();

    // Создайте список из 5 машин.
    {
        for (int i=1; i < 6; i++) {
            for (int j=1; j < 4; j++) {
                list.add(new Car("f"+i+j, "f"+i+j, "f"+i+j));
            }
        }
    }

    public List<Car> list(int count) {
        // При запросе /cars?count=2 должен отобразиться список из 2 машин,
        // при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.
        int index = (count < 0 || count > 5) ? 5 : count;
        return list.subList(0, index);
    }

    public List<Car> findAll() {
        return list;
    }

    public Car add(Car car) {
        list.add(car);
        return car;
    }
}
