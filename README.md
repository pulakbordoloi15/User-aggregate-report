
# User Aggregate Report Application

## Project Description
This Spring Boot application processes and analyzes user data to generate aggregate reports. It includes RESTful APIs for calculating user statistics based on daily step counts and determining the primary league for each user.

---

## Prerequisites
Tools used:
- **Java 8 or later**
- **Maven**
- **MySQL Server**

---

## Steps to Run the Project

1. **Clone the Repository**


2. **Set Up the Database**
   - Create a MySQL database named `userreport`.
   - Also, we can input data in the table.


3. **Build the Project**


4. **Start the Application**

   The application will be accessible at `http://localhost:8080`.

---

## API Endpoints

### 1. **Generate report for a user**
- **Endpoint**: `GET /reports/user-aggregate`
- **Description**: Generate report for the user with given data such as total days, primary league and league percentages. 

---

## Approach and Assumptions

### Approach
1. **Entity Design**:
    - The User entity stores the daily step count of a user. Each record contains a userId, stepsCount, and stepsAt (the date of the record).

2. **Service Layer**:
    - The UserAggregateReportService calculates the aggregate statistics for each user, including the number of gold, silver, and bronze days, and the respective percentages.
    - The primary league is determined based on the user's performance: Gold (steps > 8000), Silver (4000 <= steps <= 8000), and Bronze (steps < 4000).

3. **Controller Layer**:
    - The UserAggregateReportController contains the API for generating the user report. It accepts startDate and endDate as parameters, and uses the service to return the generated report.

4. **Database Queries**:
    - Custom JPA queries are used to fetch user data within the specified date range. The repository method findByUserIdAndStepsAtBetweenDates() retrieves the data.

### Assumptions
- Each user is uniquely identified by their userId.
- A day is classified into one of three leagues based on the number of steps taken:
  - Gold: Steps count greater than 8000.
  - Silver: Steps count between 4000 and 8000.
  - Bronze: Steps count less than 4000.
  Bronze: Steps count less than 4000.
- The primary league is assigned based on the maximum number of league days: if a user has more silver days than gold, they are assigned the "Silver" league, and if they have more bronze days than both, they are assigned the "Bronze" league.
---



