# Library Management System

A simple Spring Boot Library Management System demonstrating JPA, Lombok, Java Streams, and REST APIs.

## Project Setup

**Group:** `com.ctos.dummy`  
**Artifact:** `library`  
**Version:** `1.0.0`  

**Dependencies:**  
- Spring Web  
- Spring Data JPA  
- Lombok  
- MySQL Connector  

**Java Version:** 21

---

## Entities

### Library
- `libraryId` (Integer, auto-generated)  
- `libraryName` (String)  
- One Library has many Aisles  

### Aisle
- `aisleId` (Integer, auto-generated)  
- `aisleName` (String)  
- Many Aisles belong to one Library  
- Many-to-Many with Books  

### Book
- `bookId` (Integer, auto-generated)  
- `bookName` (String)  
- Many-to-Many with Aisles  

---

## Features

1. Find libraries by name (using named query)  
2. Get all aisles by library  
3. Get all books by aisle  
4. Save new library with aisles  
5. Update library information  
6. Get all books in a specific aisle and library  
7. REST APIs for CRUD operations  

---

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/libraries` | Get all libraries |
| GET | `/libraries/{id}/aisles` | Get all aisles in a library |
| GET | `/libraries/{libraryName}/aisles/{aisleName}/books` | Get all books in an aisle |
| POST | `/libraries` | Save a new library with aisles |
| PUT | `/libraries/{id}` | Update existing library information |

---

## Sample JSON

**Save Library Example**

```json
{
  "libraryName": "Central Library",
  "aisles": [
    {
      "aisleName": "Natural History",
      "books": [
        {"bookName": "The Evolution of Species"},
        {"bookName": "History of Dinosaurs"}
      ]
    },
    {
      "aisleName": "Science & Tech",
      "books": [
        {"bookName": "Physics Fundamentals"},
        {"bookName": "AI Revolution"}
      ]
    }
  ]
}

