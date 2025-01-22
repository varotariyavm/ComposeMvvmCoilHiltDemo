SheekhoTask
Android Development Assignment
This is an Android project that displays a list of anime fetched from the Jikan API. Users can view details about anime.

Assumptions Made
The anime list and details are fetched from the Jikan API:
Anime list: https://api.jikan.moe/v4/top/anime
Anime details: https://api.jikan.moe/v4/anime/{anime_id}
Trailers are expected to have a valid YouTube ID. If unavailable, the anime's poster image is used as a fallback.
Internet connectivity is required to fetch data from the API; no offline mode is implemented.
The app uses ExoPlayer for video playback and falls back to the poster image when the trailer is unavailable.
Features Implemented
Anime List Page
Displays a list of anime with the following details:
Title
Number of Episodes
Rating
Poster Image
Clicking an anime navigates to the Anime Detail Page.
Anime Detail Page
Displays:
Trailer (if available) or Poster Image (fallback).
Title
Synopsis
Genres
Main Cast
Number of Episodes
Rating
Video Player implemented using ExoPlayer.
Modern Android Architecture
Jetpack Compose for UI.
MVVM pattern.
ViewModel for managing UI-related data.
Hilt for dependency injection.
Coroutines and Flow for asynchronous operations.
Coil for loading images.
Navigation
Integrated with Jetpack Compose Navigation to navigate between screens.
Limitations or Future Improvements
Add pagination to the anime list.
Support offline caching using Room or another database.
Implement better error handling with user-friendly messages.
Integrate the YouTube Player API for seamless trailer playback.
Add unit tests and UI tests to ensure reliability.
