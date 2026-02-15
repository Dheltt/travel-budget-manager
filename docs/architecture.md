# Architecture Design Document
## Travel Budget Manager

---

## 1. Overview

Travel Budget Manager is a  REST API desgined to manage trips and their associated expenses.

The system is build following Hexagonal Architecture (Ports and Adapters) to  ensure clear separtion between business logic and infrestructure concerns.

The primary goal of this project is to demostrate clean architecture, domain modeling, and production-ready backend development pratices.

---
# 2. Architectural Style

- Architecture: Hexagonal (Ports and adapters)
- Pattern: Domain-Driven Design (lightweight approach)
- Deploytment Model: Modular Monolith

the domain layer must remain independent  from frameworks such as Spring.

## 3. High-Level Structure

## Domain
Contains core bussines entities, value objects, and bussines rules.
Must not depend on spring or external libraries.

## Application
Contains use cases and orchestration logic.
Coordinates domain operations.

## Infraestructure
Contains controllers, persistence adapters, configuration, and external integrations.

## 4. Tecnology Stack

-java 21
-Spring Boot
-PostgresSQL
-JPA (Hibernate)
-Docker


---

## 5. Desing Principals
-Domain Isolation
-Encaptulation of invariants
-Aggregate boundary protection
-Testability without Sptring context
-Clean separation of concerns

## 6. Future Extensions
-multi-curency support
-Expense categories as separate aggregates
-Audit logging
-Authentication  & authorization