package hello;

import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;

@Controller
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private String stationName = "";

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/bus_one").setViewName("bus_one");
        registry.addViewController("/bus_two").setViewName("bus_two");
    }

    public void get() throws SQLException, ClassNotFoundException {

        // bus station information
        JnuBusStationDao jnuBusStationDao = new JnuBusStationDao();
        int bus_station_id = 1;
        JnuBusStation jnuBusStation = jnuBusStationDao.get(bus_station_id);
        System.out.println(jnuBusStation.getId());
        stationName = jnuBusStation.getStationName();

        JnuBusScheduleDao jnuBusScheduleDao = new JnuBusScheduleDao();
        int jnu_bus_schedule_id = 1;
        JnuBusSchedule jnuBusSchedule = jnuBusScheduleDao.get(jnu_bus_schedule_id);
        System.out.println(jnuBusSchedule.getId());
        System.out.println(jnuBusSchedule.getDeparture_time());
        System.out.println(jnuBusSchedule.getCourse());
        System.out.println(jnuBusSchedule.getGo_ocean_science());
    }

    // thymeleaf test
    @RequestMapping("/hello")
    public String index(Model model) throws SQLException, ClassNotFoundException {
        get();
        model.addAttribute("name", stationName);
        return "hello";
    }
}
