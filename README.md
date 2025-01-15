

# How to Build a Phone Number Verification System with Spring Boot and Vue.js


📌 **Spring-Vue-Phone-Verification** is a project that integrates Spring Boot for the backend and Vue.js for the frontend to handle phone number verification via code sending. This project enables the development of secure and efficient verification applications with a simple and user-friendly interface.

## Key Features

- 🚀 **Spring Boot Backend**: Provides API for sending and verifying verification codes.
- 🌐 **Vue.js Frontend**: Provides an interactive user interface to enter phone numbers and verification codes.
- ✅ **Input Validation**: Ensures the entered phone number is valid and the sent verification code is correct.
- 🔐 **Security**: Implements security measures to prevent misuse of the verification API.

## Technologies Used

- **Backend**: Spring Boot
- **Frontend**: Vue.js
- **Database**: (Optional, if using a database to store verification codes)
- **Authentication**: JWT Token (Optional)
- **Validation**: Jakarta Bean Validation (JSR 303)

## Installation

### 1. Clone the Repository

To get started, clone this repository to your local machine:

```bash
git clone https://github.com/dioarafll/spring-vue-phone-verify.git
```

### 2. Set Up the Backend (Spring Boot)

#### Prerequisites:
- Java 17 or higher
- Maven or Gradle as the build tool

After cloning the repository, open the Spring Boot project using an IDE like IntelliJ IDEA or Eclipse.

#### Running the Spring Boot Application

To run the Spring Boot application, open a terminal in the project directory and execute the following command:

```bash
mvn spring-boot:run
```

Or if using Gradle:

```bash
./gradlew bootRun
```

The application will run on `http://localhost:8080`.

### 3. Set Up the Frontend (Vue.js)

#### Prerequisites:
- Node.js (version 14 or higher)
- NPM or Yarn

Navigate to the frontend directory:

```bash
cd frontend
```

Install the dependencies:

```bash
npm install
```

Or using Yarn:

```bash
yarn install
```

#### Running the Vue.js Application

To run the Vue.js application, execute the following command:

```bash
npm run serve
```

Or using Yarn:

```bash
yarn serve
```

The Vue.js application will run on `http://localhost:8081`.

## API Usage

### Endpoint for Sending Verification Code

**URL**: `/api/verification/send`

**Method**: `POST`

**Request Body**:

```json
{
  "phoneNumber": "+6288218440531",
  "channel": "SMS"
}
```

**Response**:

```json
{
  "status": "success",
  "message": "Verification code sent successfully."
}
```

### Endpoint for Verifying Code

**URL**: `/api/verification/verify`

**Method**: `POST`

**Request Body**:

```json
{
  "phoneNumber": "+6288218440531",
  "code": "123456"
}
```

**Response**:

```json
{
  "status": "verified",
  "message": "Phone number verified successfully."
}
```

## Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork this repository
2. Create a new branch for your desired feature or fix
3. Submit a pull request with a clear description

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

---

💻 **External Links**:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Vue.js](https://vuejs.org)
- [GitHub Repository](https://github.com/dioarafll/spring-vue-phone-verify.git)
- [Twilio blog](https://www.twilio.com/en-us/blog/phone-number-verification-java-spring-boot-verify-totp)

---

By following the steps above, you can easily set up and run a phone verification application using Spring Boot and Vue.js.
