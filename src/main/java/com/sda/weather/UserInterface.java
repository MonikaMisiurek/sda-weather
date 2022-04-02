package com.sda.weather;

import com.sda.weather.location.LocationController;

import java.util.Scanner;

public class UserInterface {

    private LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;
    }

    public void run() {
        System.out.println("Aplikacja została uruchomiona.\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWitaj w 'pogodynce', co chcesz zrobić?");
            System.out.println("1.Dodać konkretną lokalizację?");
            System.out.println("2.Wyświetlić aktualnie dodane lokalizacje?");
            System.out.println("3.Pobrać wartości pogodowe?");
            System.out.println("4.Zamknij aplikację.");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addLocation();
                    break;
                case 2:
                    showLocation(); // todo rename to showLocations
                    break;
                case 3:
                    loadWeather(); // todo add a break
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji.");
            }
        }
    }

    private void loadWeather() {
        System.out.println("Pobieram aktualną pogodę...");
    }

    private void showLocation() {
        System.out.println("Wyświetlam aktualne lokalizacje: ");
    }

    private void addLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta");
        String city = scanner.nextLine();
        System.out.println("Podaj nazwę długość geograficzną");
        long longitude = scanner.nextLong();
        System.out.println("Podaj nazwę szerokość geograficzną");
        long latitude = scanner.nextLong();
        System.out.println("Podaj nazwę region");
        String region = scanner.nextLine();
        System.out.println("Podaj nazwę nazwę kraju");
        String country = scanner.nextLine();

        String requestBody = String.format("{\"city\":\"%s\"," +
                "\"longitude\":\"%s\"," +
                "\"latitude\":\"%s\"," +
                "\"region\":\"%s\"," +
                "\"country\":\"%s\"}", city, longitude, latitude, region, country);
        System.out.println("Wysyłany http request: " + requestBody);
        // todo use locationController
        String responseBody = locationController.createLocation(requestBody);
        System.out.println("Odebrany http response: " + responseBody);
    }
}
