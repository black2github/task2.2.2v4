package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public String handle(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count,
                         ModelMap model) {
        System.out.println("handle: <- count=" + count + ", model=" + model);


        model.addAttribute("cars", carService.list(count));
        System.out.println("handle: ->");
        return "cars";
    }
}
