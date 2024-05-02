# Movie Booking System

This project is a Movie Booking System developed using Spring Boot. It provides a comprehensive solution for managing movie bookings, cinema halls, customer profiles, movies, and shows.

## Features

### Booking Management

- Book movie tickets for a specific show and cinema hall
- View and manage existing bookings
- Cancel or modify bookings

### Cinema Hall Management

- Add, update, and remove cinema halls
- Manage cinema hall details, including name, location, and seating capacity

### Customer Management

- Create and manage customer profiles
- Update customer information, such as name, contact details, and preferences

### Movie Management

- Add, update, and remove movies
- Manage movie details, including title, genre, duration, and release date

### Show Management

- Create and manage movie show schedules
- Assign movies to specific cinema halls and showtimes
- Update show details, such as date, time, and pricing

## Project Structure

The project is organized into the following packages:

1. **controller**: Contains the controller classes responsible for handling HTTP requests and responses.
2. **exceptions**: Contains custom exception classes for handling specific exceptions in the application.
3. **models**: Contains the data models representing various entities in the system.
4. **repository**: Contains the repository interfaces for interacting with the database.
5. **services**: Contains the service classes that encapsulate the business logic of the application.

### Controllers

The `controller` package consists of the following classes:

- `BookingController`: Handles operations related to movie bookings.
- `CinemaHallController`: Handles operations related to cinema halls.
- `CustomerController`: Handles operations related to customer profiles.
- `MovieController`: Handles operations related to movies.
- `ShowController`: Handles operations related to movie shows.

### Exceptions

The `exceptions` package contains the following custom exception classes:

- `BookingNotFoundException`: Thrown when a booking is not found.
- `CinemaHallNotFoundException`: Thrown when a cinema hall is not found.
- `CustomerNotFoundException`: Thrown when a customer is not found.
- `MovieNotFoundException`: Thrown when a movie is not found.

### Models

The `models` package contains the following data models:

- `BaseModel`: A base class for other models.
- `Booking`: Represents a movie booking.
- `CinemaHall`: Represents a cinema hall.
- `CustomerProfile`: Represents a customer profile.
- `Movie`: Represents a movie.
- `Show`: Represents a movie show.

### Repositories

The `repository` package contains the following repository interfaces for interacting with the database:

- `BookingRepository`: Repository for managing movie bookings.
- `CinemaHallRepository`: Repository for managing cinema halls.
- `CustomerRepository`: Repository for managing customer profiles.
- `MovieRepository`: Repository for managing movies.
- `ShowRepository`: Repository for managing movie shows.

### Services

The `services` package contains the following service classes that encapsulate the business logic of the application:

- `BookingService`: Service class for managing movie bookings.
- `CinemaHallService`: Service class for managing cinema halls.
- `CustomerService`: Service class for managing customer profiles.
- `MovieService`: Service class for managing movies.
- `ShowService`: Service class for managing movie shows.



The application will start running on `http://localhost:8080`.
