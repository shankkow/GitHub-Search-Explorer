# GitHub Repository Explorer

## Clean Architecture: MVVM, Repo Pattern, ROOM, Caching, Coroutines, HILT, ViewModel

## Description

**GitHub Repository Explorer** is a Kotlin-based Android application that allows users to search and explore GitHub repositories using the GitHub API. Users can view details of selected repositories, see information about contributors, and explore repositories tagged to the selected contributors. The application is built using modern Android development practices, leveraging Coroutines, Room, MVVM, JetPack libraries, and the Repository pattern. Bonus points for implementing parts of the app with Jetpack Compose!

## Features

### Home Screen

- **Search Bar:** Users can search through GitHub repositories by entering keywords in the search bar.
- **RecyclerView with CardView:** Displays a list of repositories matching the search query. Each result is shown as a card item.
- **Pagination:** Results are limited to 10 items per page, enabling efficient and responsive loading.
- **Offline Data Storage:** The app saves data for the first 15 items fetched so users can view them even when offline.
- **Navigation to Repo Details:** Clicking on a repository item navigates to the detailed view of the selected repository.

### Repo Details Screen

- **Detailed Information:** Shows detailed information about the selected repository, including:
  - **Image:** Repository owner’s avatar.
  - **Name:** Repository name.
  - **Project Link:** A link to the repository on GitHub.
  - **Description:** A brief description of the repository.
  - **Contributors:** A list of contributors for the selected repository.
- **WebView Integration:** Clicking on the "Project Link" opens the content in a WebView within the app.
- **Contributor Exploration:** Clicking on a contributor's name navigates to a list of repositories tagged to that contributor.

## Technology Stack

- **Kotlin:** The primary programming language.
- **Coroutines:** For efficient asynchronous programming.
- **Room:** To store data locally and allow offline viewing of the first 15 search results.
- **MVVM Architecture:** For clean, maintainable code structure.
- **JetPack Libraries:** Including ViewModel, and more for robust app architecture.
- **Repository Pattern:** Ensures separation of data handling, making the code more modular and testable.

## How It Works

1. **Search Repositories:** Users enter search terms, and the app fetches matching repositories using the GitHub API.
2. **View Repository Details:** Users click on a repository to view more details, including the project link and contributors.
3. **Explore Contributors:** From the details screen, users can explore repositories associated with specific contributors.
4. **Offline Access:** The app saves data for the first 15 search results, making them accessible offline.

## Notes

- The app efficiently fetches 10 items per page using pagination to ensure smooth and responsive scrolling.
- Data saved offline provides a seamless user experience even when network access is unavailable.
- The use of modern Android development practices ensures the app is scalable, efficient, and maintainable.

## Getting Started

### Prerequisites

- Android Studio 4.0+
- JDK 8+
- Gradle

### Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/shankkow/Teachmint-Github-Assignment.git

![Screenshot_2024-12-06-13-45-30-175_com example assignmenttrial1](https://github.com/user-attachments/assets/b7b63aba-a4b6-4bc1-a400-f01664897c29)
![Screenshot_2024-12-06-13-45-43-728_com example assignmenttrial1](https://github.com/user-attachments/assets/d74c7bc5-87d8-4756-b18a-e91464ae8b7a)

   
