# ADR-OO1: Use Hexagonal Architecture

## Status Accepted


## Context The system requires a clean separation between bussiness logic and infraestructure components in order to maintain long-term maintainability and testability.

## Decision

we will adopt Hexagonal Architecture (Ports and Adapters).
The domain layer will be framework-independent.

## Consequences

Positive:
- Improved testability
- Clear separations of concers
- Easier future refactoring

Negative:
- Slightly higher initial complexity
- Requieres discipline in layer separation