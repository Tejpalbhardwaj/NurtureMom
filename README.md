## 📱 Vitals Reminder App
/ Simple Android app using Kotlin + Jetpack Compose /

## 🚀 Overview
/ Vitals Reminder App helps users log daily health vitals and reminds them using notifications /

The app allows users to:
- Add health vitals
- View vitals in modern cards
- Delete vitals
- Receive reminder notifications

## 🛠 Tech Stack
/ Modern Android development stack /

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Room Database
- WorkManager
- StateFlow
- Material 3

## ✨ Features
/ Core functionality /

- ➕ Add vitals using dialog
- 📋 View vitals in LazyColumn
- 🗑 Delete vitals (underline delete / swipe)
- 💾 Offline storage using Room
- ⏰ Reminder notifications using WorkManager
- 🔔 Notification click opens app
- ⚡ Real-time UI updates

## 📸 Screenshots
/ Add screenshots in screenshots folder /



## 🧠 Architecture
/ MVVM Architecture /

- UI → Jetpack Compose
- ViewModel → Business logic
- Repository → Data handling
- Room → Local database
- WorkManager → Background reminder

## ⏰ Reminder Logic
/ Notification scheduling /

- Testing: OneTimeWorkRequest (1 minute delay)
- Production: PeriodicWorkRequest (minimum 15 minutes)
- Notification opens app using PendingIntent

## 🧪 How to Run
/ Steps to run project /

1. Clone the repository
2. Open project in Android Studio  
3. Sync Gradle  
4. Run on emulator or real device  
5. Allow notification permission

## 📌 Notes
/ Important points /

- PeriodicWorkRequest minimum time = 15 minutes
- Notification permission required for Android 13+
- Works completely offline

## 🚀 Future Improvements
/ Enhancements /

- Edit vitals
- Snackbar undo delete
- Dark mode
- Charts for vitals
- Cloud backup

## 👨‍💻 Author
/ Developer info /

**Tejpal**  
Android Developer (Kotlin | Jetpack Compose)

## ⭐ Support
/ If you like this project /

Give this repo a ⭐ on GitHub

