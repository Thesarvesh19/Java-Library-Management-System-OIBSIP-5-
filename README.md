# Digital Library Management System

This project is a comprehensive, console-based Digital Library Management System developed in Java. It simulates a real-world library environment with a dual-module architecture, providing distinct functionalities for administrators and regular users. The interface is enhanced with ANSI color codes for better readability and an improved user experience.

## Key Features

The system is divided into two primary modules, each with a specific set of permissions and capabilities.

### 🔑 Admin Module

The password-protected Admin Module provides complete control over the library's catalog and member records.

-   **Secure Access:** Requires a password to ensure only authorized personnel can access administrative functions.
-   **Book Management:**
    -   **Add Books:** Effortlessly add new books to the library with a title and author.
    -   **Delete Books:** Remove books from the catalog to keep it up-to-date.
-   **Member Management:**
    -   **Add Members:** Register new users into the library system.
-   **System Oversight:**
    -   **View Full Catalog:** Access a complete list of all books and see their real-time status (e.g., `Available` or `Issued to [Member Name]`).

### 📚 User Module

The User Module is designed for a simple and efficient user experience, allowing members to interact with the library's collection seamlessly.

-   **Browse Collection:** View the entire list of books, with clear, color-coded indicators showing which are available and which are currently checked out.
-   **Powerful Search:** Find books quickly using a flexible, case-insensitive search that matches any part of a book's title.
-   **Issue Books:** Check out an available book, which immediately updates its status across the system to prevent double-booking.
-   **Return Books:** Easily return a borrowed book, which instantly updates its status to `Available` for other members.
