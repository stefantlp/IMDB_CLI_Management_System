# IMDB_CLI_Management_System

This repository contains a command-line application developed as part of an Object-Oriented Programming (OOP) course in the second semester of the second year of my studies at university. The project simulates a simple version of the IMDB platform, managing information related to movies, actors, TV shows, and more.

## 📂 Repository Structure

- **Sources:**
  - [Actor](src/Actor)               – Contains class related to actors and their attributes.  
  - [Admin](src/Admin)               – Contains class for adminin user, implementing functionalities like user management.  
  - [Contributor](src/Contributor)   – Handles the functionalities for contributors who add content.  
  - [Credentials](src/Credentials)   – Contains class related to credentials.  
  - [Episode](src/Episode)           – Manages the data related to episodes in series.  
  - [IMDb](src/IMDB)                 – Core functionality of the IMDb-like application, responsible for managing movies, series, actors, etc.
  - [Input](src/Input)               – Handles user input and parsing.
  - [Movie](src/Movie)               – Contains classes for managing movie data, including titles, genres, and release dates.  
  - [Production](src/Production)     – Manages production-related details of movies and series.  
  - [Rating](src/Rating)             – Manages rating and review functionality for movies and series.  
  - [Regular](src/Regular)           – Contains regular user functionalities like rating and managing requests.  
  - [Request](src/Request)           – Contains class related to user requests for specific movie, actor, account or other.  
  - [Requests Manager](src/RequestsManager) – Interface that manages user requests.
  - [Series](src/Series)             – Manages data related to TV series, including episodes and seasons.  
  - [Staff](src/Staff)               – Contains class related to the staff users (contributor and admin) and functionalities like adding or removing productions or actors.  
  - [Staff Interface](src/StaffInterface) – Interface for handling staff functionalities.
  - [Test](src/Test)                 – The file that should be run for testing the IMDb-like application 
  - [User](src/User)                 – Manages the user data, such as registration and profile.  
  - [Userfactory](src/UserFactory)   – Factory pattern to handle user creation and management.

 ## 🛠 Features 
- **User Authentication**: Users can log in to the system by providing their email and password.
- **Production Details**: View detailed information about movies and series, including genres, release dates, and other attributes.
- **Actor Information**: Display detailed information about actors, such as their biography, movies, and roles.
- **Search Functionality**: Users can search for specific movies, series, or actors within the system.
- **Notifications**: View notifications related to actions taken within the system, such as updates or requests.
- **Favorites**: Add or remove productions and actors from the favorites list.
- **Requests**: Create, withdraw, or view requests for specific movies, series, or actors.
- **Update Content**: Modify information about movies, series, or actors, such as adding new productions or updating existing details.
- **Manage Requests**: View and resolve incoming requests related to the system's content.
- **Reviews**: Add or remove reviews for productions, giving users the ability to share their opinions.
- **User Management**: Administrators can manage users, including adding or removing users from the system.

## 🚀 Running the Application

To run the application, simply execute the `Test` class. It will create an `IMDb` object and call the `run()` function to start the application.
