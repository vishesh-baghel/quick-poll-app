# Polling App API

This API allows users to create polls, vote on them, and retrieve poll results.

## **1. Create a User**
### **Endpoint:**
```http
POST /users
```
### **Request Body:**
```json
{
  "username": "John Doe",
  "email": "john@example.com"
}
```
### **Response:**
```json
"Created user successfully"
```

---

## **2. Create a Poll**
### **Endpoint:**
```http
POST /polls
```
### **Request Body:**
```json
{
  "question": "What is your favorite programming language?",
  "options": ["Java", "Python", "Go"],
  "createdBy": {
      "id": 1
  }
}
```
### **Response:**
```json
"Created poll successfully"
```

---

## **3. Get a Poll by ID**
### **Endpoint:**
```http
GET /polls/{id}
```
### **Response Example:**
```json
{
  "id": 1,
  "question": "What is your favorite programming language?",
  "options": ["Java", "Python", "Go"]
}
```

---

## **4. Get All Polls**
### **Endpoint:**
```http
GET /polls
```
### **Response Example:**
```json
[
  {
    "id": 1,
    "question": "What is your favorite programming language?",
    "options": ["Java", "Python", "Go"]
  }
]
```

---

## **5. Cast a Vote**
### **Endpoint:**
```http
POST /votes
```
### **Request Body:**
```json
{
  "pollId": 1,
  "userId": 2,
  "selectedOption": "Java"
}
```
### **Response:**
```json
"Saved vote successfully"
```

---

## **6. Get Poll Results**
### **Endpoint:**
```http
GET /votes/results/{pollId}
```
### **Response Example:**
```json
[
  {
    "optionText": "Java",
    "voteCount": 10
  },
  {
    "optionText": "Python",
    "voteCount": 5
  }
]
```

---

## **7. Test API**
### **Endpoint:**
```http
GET /polls/test
```
### **Response:**
```json
"working perfectly"
```

---

## **Models**

### **User Model**
```java
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
```

### **Poll Model**
```java
@Entity
@Data
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @ElementCollection
    private List<String> options;
}
```

### **Vote Model**
```java
@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pollId;
    private Long userId;
    private String selectedOption;
}
```


