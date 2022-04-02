package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.location.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class WeatherApplication {

    public static void main(String[] args) {
        //inicjalizacja hibernate
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        // todo crate LocationRepository, LocationService, LocationController, UserInterface
        //  use userInterface.run()
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositorylmpl(sessionFactory);
        LocationService locationService = new LocationService(locationRepository, objectMapper);
        LocationController locationController = new LocationController(objectMapper, locationService);
        UserInterface userInterface = new UserInterface(locationController);

        userInterface.run();


    }
}
