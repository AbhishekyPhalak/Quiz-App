# 🧠 Quiz Web Application

A full-stack Java web application for administering and taking quizzes. The application allows users to register, take quizzes categorized by topics, and view their results. Administrators can manage users, questions, and view quiz performance data.

---

## ✨ Features

### 👤 User Functionality
- ✅ Register and log in to the application
- 🗂 Select a quiz category and take a quiz
- 📈 View personal quiz history and detailed quiz results
- 🧭 Navigate through pages via a global navigation bar
- 📨 Submit inquiries through the contact form

### 🛠️ Administrator Functionality
- 📊 View dashboard with access to user, question, and quiz result management
- 🔄 Activate or suspend user accounts
- ✍️ Add, update, or deactivate quiz questions and choices
- 📑 Review quiz results with filtering and pagination capabilities
- 📬 Manage contact form submissions from users

---

## 🧰 Technology Stack

- **Backend:** Java, Spring Boot, Spring MVC, JDBC Template
- **Frontend:** JSP with JSTL
- **Database:** MySQL
- **Tools Used:** IntelliJ IDEA, Git, GitHub, Apache Tomcat

---

## 🧱 Architecture

The application follows the **Model-View-Controller (MVC)** architectural pattern:

- **Model:** Java classes representing users, quizzes, questions, choices, etc.
- **View:** JSP pages with JSTL for rendering UI
- **Controller:** Spring MVC controllers handling HTTP requests and routing

---

## 📄 Pages Overview

### 👨‍🎓 User Section
- **Login Page:** Entry point to the application
- **Registration Page:** Account creation with necessary user details
- **Home Page:** List of quiz categories and user quiz history
- **Quiz Page:** Multiple-choice quiz interface (3 questions per quiz)
- **Quiz Result Page:** Displays quiz summary, per-question results, and scoring
- **Contact Us Page:** Allows users to send messages to administrators

### 🧑‍💼 Administrator Section
- **Admin Dashboard:** Central hub linking to management pages
- **User Management Page:** Displays user information with activation controls and pagination
- **Question Management Page:** Add, edit, and manage questions and answers
- **Quiz Result Management Page:** View all quiz results with filtering and pagination
- **Contact Us Management Page:** Access user messages submitted through the contact form

---

## 🗄️ Database Schema

The database consists of the following main tables:

- `users`
- `categories`
- `questions`
- `choices`
- `quizzes`
- `quiz_questions`
- `contact_messages`

---

## 🧾 Entity Relationship Diagram (ERD)

![image](https://github.com/user-attachments/assets/a620a833-83d4-448f-aff9-94ea5e3e8e9f)

---

## 📷 Screenshots

### 📌 Register Page  
![image](https://github.com/user-attachments/assets/dc1e3318-5bd8-4877-818c-6dc7833f489a)

### 📌 User Home Page  
![image](https://github.com/user-attachments/assets/fff31b30-7685-4f54-a269-8c254e1d6002)

### 📌 Quiz Page  
![image](https://github.com/user-attachments/assets/d7223514-a03d-4167-98a2-e64148c5a549)

### 📌 Quiz Results Page  
![image](https://github.com/user-attachments/assets/830bb4b8-32a9-4437-9b19-36a60afc45f7)

### 📌 Admin Home Page  
![image](https://github.com/user-attachments/assets/75205971-0b35-4840-80d9-1b6dc7cc57a1)

### 📌 Admin User Management  
![image](https://github.com/user-attachments/assets/42120b8b-27de-4481-bd57-3654b6fae871)

### 📌 Admin Question Management  
![image](https://github.com/user-attachments/assets/acc8ee9f-2dc5-4067-93b2-87b78c4595b5)

---

## 🚀 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/AbhishekyPhalak/Quiz-App.git
