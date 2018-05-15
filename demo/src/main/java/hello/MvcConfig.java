package hello;

import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;
import java.sql.Time;

@Controller
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private String jnuStationName = "";
    private int jnuBusStationId, jnuBusSequence, goOceanScience;
    private String course;
    private boolean oceanScience;

    Time departureTime;

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

        jnuBusStationId = jnuBusStation.getId();
        jnuStationName = jnuBusStation.getStationName();

        JnuBusScheduleDao jnuBusScheduleDao = new JnuBusScheduleDao();
        int jnu_bus_schedule_id = 1;
        JnuBusSchedule jnuBusSchedule = jnuBusScheduleDao.get(jnu_bus_schedule_id);

        jnuBusSequence = jnuBusSchedule.getId();
        departureTime = jnuBusSchedule.getDeparture_time();
        course = jnuBusSchedule.getCourse();
        goOceanScience = jnuBusSchedule.getGo_ocean_science();

        if (goOceanScience == 1)
            oceanScience = true;
        else
            oceanScience = false;
    }

    // thymeleaf test
    @RequestMapping("/hello")
    public String index(Model model) throws SQLException, ClassNotFoundException {
        get();
        model.addAttribute("jnuBusStationId", jnuBusStationId);
        model.addAttribute("jnuStationName", jnuStationName);
        model.addAttribute("jnuBusSequence", jnuBusSequence);
        model.addAttribute("departureTime", departureTime);
        model.addAttribute("course", course);
        model.addAttribute("oceanScience", oceanScience);

        return "hello";
    }
}
