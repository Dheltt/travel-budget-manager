# Domain Model

## Core Concepts
## Trip (Aggregate Root)

Represents a travel event with a defined lifecycle.

Responsabilities:

- Manage expenses
- Enforce bussinesss rules
- Evaluate budget status
- Control lifecycle transitions

- Trip (Aggregate Root)
- Expense (Entity)
- Money (Value Object)
- DateRange (Value Object)

Atributtes:
- id (UUID)
- description
- dateRange (Value Object)
- budget (Money, optional)
- status (TripStatus)
- expenses (List of Expenses)


---

### Expense (Entity)

Represents a monetary transaction  associated with a Trip.

Attributes:
- id (UUID)
- description
- amount (Money)
- category
- date

---

### Money (Value Object)

Respesents a monetary amount.

Rules: 
- Cannot be negative
- Must preserve precision
- Encapsulates arithmetic operations


---
### DateRange (Value Object)

Represents a start and end date.

Rules:
- startDate must bot be after endDate
- Immutable once created

---

##Business Rules

1. A trip may exist witout a budget.
2. Exprenses cannot be added to a finished Trip.
3. Encapsulates arithmetic operations
4. If expenses fall back within budget -> status becomes ACTIVE.
5. Expense amounts must be positive.

---


