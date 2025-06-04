# Quiz Web Application

A full-stack Java web application for administering and taking quizzes. The application allows users to register, take quizzes categorized by topics, and view their results. Administrators can manage users, questions, and view quiz performance data.

---

## Features

### User Functionality
- Register and log in to the application
- Select a quiz category and take a quiz
- View personal quiz history and detailed quiz results
- Navigate through pages via a global navigation bar
- Submit inquiries through the contact form

### Administrator Functionality
- View dashboard with access to user, question, and quiz result management
- Activate or suspend user accounts
- Add, update, or deactivate quiz questions and choices
- Review quiz results with filtering and pagination capabilities
- Manage contact form submissions from users

---

## Technology Stack

- **Backend:** Java, Spring Boot, Spring MVC, JDBC Template
- **Frontend:** JSP with JSTL
- **Database:** MySQL
- **Tools Used:** IntelliJ IDEA, Git, GitHub, Apache Tomcat

---

## Architecture

The application follows the Model-View-Controller (MVC) architectural pattern:

- **Model:** Java classes representing users, quizzes, questions, choices, etc.
- **View:** JSP pages with JSTL for rendering UI
- **Controller:** Spring MVC controllers handling HTTP requests and routing

---

## Pages Overview

### User Section
- **Login Page:** Entry point to the application
- **Registration Page:** Account creation with necessary user details
- **Home Page:** List of quiz categories and user quiz history
- **Quiz Page:** Multiple-choice quiz interface (3 questions per quiz)
- **Quiz Result Page:** Displays quiz summary, per-question results, and scoring
- **Contact Us Page:** Allows users to send messages to administrators

### Administrator Section
- **Admin Dashboard:** Central hub linking to management pages
- **User Management Page:** Displays user information with activation controls and pagination
- **Question Management Page:** Add, edit, and manage questions and answers
- **Quiz Result Management Page:** View all quiz results with filtering and pagination
- **Contact Us Management Page:** Access user messages submitted through the contact form

---

## Database Schema

The database consists of the following main tables:
- `users`
- `categories`
- `questions`
- `choices`
- `quizzes`
- `quiz_questions`
- `contact_messages`

---

## Entity Relationship Diagram (ERD)

![ERD](![image](https://github.com/user-attachments/assets/a620a833-83d4-448f-aff9-94ea5e3e8e9f))

---

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/AbhishekyPhalak/Quiz-App.git
