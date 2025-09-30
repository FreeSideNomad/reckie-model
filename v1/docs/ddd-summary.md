# Domain-Driven Design  Extensive Summary
## Strategic and Tactical Patterns (Evans 2003 blue book, with Fowler commentary)

> This document distills DDD into a practical, teachable reference you can use to guide modeling conversations, architecture choices, and artifact design.

---

## 1) Why DDD: the point in one breath
Domain-Driven Design aligns software with the business domain by **crunching knowledge** together with domain experts, evolving a **ubiquitous language** and a model inside **clear boundaries** so complexity is manageable and change is safe.  
(Source: Eric Evans, *Domain-Driven Design: Tackling Complexity in the Heart of Software*, 2003)

---

## 2) Knowledge Crunching (the bedrock practice)

**What it is.** Iterative, collaborative distillation of messy domain facts into crisp concepts, rules, and language. It embraces false starts, alternative models, and refactoring toward deeper insight.

**Why it matters.** Without deliberate knowledge crunching, teams drift into inconsistent terms, leaky abstractions, and accidental complexity; with it, the model gets smaller, tighter, and more expressive.

**How to do it (repeatable prompts).**
- List competing abstractions for X; what trade-offs do they imply?
- Which two concepts can we merge without losing behavior?
- Name invariants that must hold; where do they live (aggregate vs policy vs process)?
- What events would other contexts care about when Y changes?

**Anchor.** Evans introduces knowledge crunching as the heart of DDD; Fowlers essays echo its centrality.  
(See [Fowler on Knowledge Crunching](https://martinfowler.com/bliki/KnowledgeLevel.html))

---

## 3) Strategic DDD  the big picture

### 3.1 Subdomains
- **Core**: differentiating value  deserves your best modeling.
- **Supporting**: necessary but not differentiating.
- **Generic**: commodity; prefer buy/standardize over build.

(Source: Evans, *DDD*, Ch. 14)

### 3.2 Bounded Context
A **bounded context** is the boundary within which a model and its ubiquitous language are consistent.  
(See [Fowler: Bounded Context](https://martinfowler.com/bliki/BoundedContext.html))

> Rule of thumb: if a single model tries to serve everyone, it usually serves nobody well.

### 3.3 Context Mapping (relationships between contexts)
- **Shared Kernel**
- **CustomerSupplier**
- **Conformist**
- **Anticorruption Layer (ACL)**
- **Published Language**
- **Open Host Service (OHS)**
- **Partnership**
- **Separate Ways**
- **Big Ball of Mud**  
(See [Context Mapping Patterns](https://dddcommunity.org/library/vernon_2011/))

### 3.4 Ubiquitous Language
A **precise, shared vocabulary** anchored to the model and used in conversations, documentation, and code.  
(See [Fowler: Ubiquitous Language](https://martinfowler.com/bliki/UbiquitousLanguage.html))

### 3.5 Layered Architecture
Evans canonical layers separate concerns: **User Interface**, **Application**, **Domain**, **Infrastructure**.  
(Source: Evans, *DDD*, Ch. 4)

---

## 4) Tactical DDD  building blocks

### 4.1 Entities
Objects with **identity** that persists through change.  
(Source: Evans, *DDD*, Ch. 5)

### 4.2 Value Objects
**Immutable** objects defined by attributes.  
(Source: Evans, *DDD*, Ch. 5)

### 4.3 Aggregates & Roots
Consistency boundary with a single **root**.  
(Source: Evans, *DDD*, Ch. 6)

### 4.4 Repositories
Abstract persistence for aggregates.  
(Source: Evans, *DDD*, Ch. 6)

### 4.5 Domain Services
Domain logic outside entities/VOs.  
(Source: Evans, *DDD*, Ch. 7)

### 4.6 Domain Events
Named, meaningful facts that happened.  
(Source: Evans, *DDD*, Ch. 8)

### 4.7 Factories
Encapsulate creation logic.  
(Source: Evans, *DDD*, Ch. 6)

### 4.8 Specification Pattern
Encapsulate rules/predicates.  
(Source: Evans, *DDD*, Ch. 9)

### 4.9 Policy
High-level strategies.  
(Source: Evans, *DDD*, Ch. 9)

### 4.10 Process Manager / Saga
Coordinates long-running workflows.  
(Source: Vaughn Vernon, *Implementing DDD*, 2013)

### 4.11 Modules
Organize concepts for cohesion.  
(Source: Evans, *DDD*, Ch. 10)

### 4.12 Refactoring Toward Deeper Insight
Continuously reshape the model.  
(Source: Evans, *DDD*, Ch. 15)

---

## 5) Heuristics

- Prefer many small bounded contexts.  
- Keep aggregates small.  
- Repositories return roots, not ORM.  
- Events as contracts.  
- Use ACL when upstream churn threatens you.  
(See [Fowler on DDD](https://martinfowler.com/bliki/DomainDrivenDesign.html))

---

## 6) Examples

**Retail Orders**  
- Contexts: Sales, Fulfillment, Billing  
- Aggregates: Order, Shipment, Invoice  
- Events: OrderPlaced, OrderShipped  

**AI-assisted Requirements**  
- Contexts: Composition, Review, Consistency  
- Aggregates: DocumentVersion  
- Events: DocumentSubmittedForReview, VersionApproved

---

## 7) Application to Artefacts

- **design.md**  subdomains, contexts, tactical building blocks  
- **narrative.md**  story of boundaries  
- **ubiquitous-language.md**  glossary  
- **meta.md**  process guide

---

## 8) References

- Eric Evans, *Domain-Driven Design: Tackling Complexity in the Heart of Software* (Addison-Wesley, 2003).  
- [Eric Evans  DDD Reference (PDF)](https://domainlanguage.com/ddd/reference/)  
- [Domain Language  DDD Reference](https://domainlanguage.com/ddd/)  
- Martin Fowler  [DDD Overview](https://martinfowler.com/bliki/DomainDrivenDesign.html)  
- Martin Fowler  [Bounded Context](https://martinfowler.com/bliki/BoundedContext.html)  
- Martin Fowler  [Ubiquitous Language](https://martinfowler.com/bliki/UbiquitousLanguage.html)  
- [Context Mapping (Vernon, 2011)](https://dddcommunity.org/library/vernon_2011/)
