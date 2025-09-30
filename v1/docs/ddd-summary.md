# Domain-Driven Design — Extensive Summary
## Strategic and Tactical Patterns (Evans 2003 “blue book”, with Fowler commentary)

> This document distills DDD into a practical, teachable reference you can use to guide modeling conversations, architecture choices, and artifact design.

---

## 1) Why DDD: the point in one breath
Domain-Driven Design aligns software with the business domain by **crunching knowledge** together with domain experts, evolving a **ubiquitous language** and a model inside **clear boundaries** so complexity is manageable and change is safe. :contentReference[oaicite:0]{index=0}

---

## 2) Knowledge Crunching (the bedrock practice)

**What it is.** Iterative, collaborative distillation of messy domain facts into crisp concepts, rules, and language. It embraces false starts, alternative models, and refactoring toward deeper insight.

**Why it matters.** Without deliberate knowledge crunching, teams drift into inconsistent terms, leaky abstractions, and accidental complexity; with it, the model gets smaller, tighter, and more expressive.

**How to do it (repeatable prompts).**
- “List competing abstractions for X; what trade-offs do they imply?”
- “Which two concepts can we merge without losing behavior?”
- “Name invariants that must hold; where do they live (aggregate vs policy vs process)?”
- “What events would other contexts care about when Y changes?”

**Anchor.** Evans introduces knowledge crunching as the heart of DDD; Fowler’s essays echo its centrality. :contentReference[oaicite:1]{index=1}

---

## 3) Strategic DDD — the “big picture”

Strategic design decides **where models live**, **how they relate**, and **what deserves focus**.

### 3.1 Subdomains
- **Core**: differentiating value → deserves your best modeling.
- **Supporting**: necessary but not differentiating.
- **Generic**: commodity; prefer buy/standardize over build.

Use this lens to prioritize attention and investment. :contentReference[oaicite:2]{index=2}

### 3.2 Bounded Context
A **bounded context** is the boundary within which a model and its ubiquitous language are consistent. The same term can mean different things in different contexts—as long as the boundary is explicit. **This is the central strategic pattern.** :contentReference[oaicite:3]{index=3}

> Rule of thumb: if a single model tries to serve everyone, it usually serves nobody well. Split by meaning, team, and change cadence. :contentReference[oaicite:4]{index=4}

### 3.3 Context Mapping (relationships between contexts)
Label the relationship so collaboration and integration are explicit:

- **Shared Kernel** — teams share a small, carefully managed subset.
- **Customer–Supplier** — downstream (customer) influences upstream priorities.
- **Conformist** — downstream simply conforms to upstream.
- **Anticorruption Layer (ACL)** — translation to protect your model.
- **Published Language** — explicit schema/format for integration.
- **Open Host Service (OHS)** — upstream provides a “hosted” API for many consumers.
- **Partnership** — tight collaboration across teams.
- **Separate Ways** — deliberate decoupling.
- **Big Ball of Mud** — absence of boundaries (warning sign). :contentReference[oaicite:5]{index=5}

### 3.4 Ubiquitous Language
A **precise, shared vocabulary** anchored to the model and used in conversations, documentation, and code. Language is **per bounded context**; cross-context translation is a first-class concern. :contentReference[oaicite:6]{index=6}

### 3.5 Layered Architecture (bridge from strategy to implementation)
Evans’ canonical layers separate concerns: **User Interface**, **Application** (orchestration, no business rules), **Domain** (model + rules), **Infrastructure** (plumbing). It keeps your domain pure and portable. :contentReference[oaicite:7]{index=7}

---

## 4) Tactical DDD — building blocks *inside* a bounded context

> Tactical patterns work **after** boundaries are in place; otherwise they devolve into tightly coupled mud. :contentReference[oaicite:8]{index=8}

### 4.1 Entities
Objects with **identity** that persists through change (e.g., Customer, Order). Keep invariants close, but avoid anemic entities. :contentReference[oaicite:9]{index=9}

### 4.2 Value Objects
**Immutable** objects defined by attributes (e.g., Money, DateRange). Compose liberally; prefer VOs over primitive fields to express meaning. :contentReference[oaicite:10]{index=10}

### 4.3 Aggregates & Aggregate Roots
A consistency boundary with a single **root** that enforces invariants. Keep aggregates **small**; prefer eventual consistency between aggregates. :contentReference[oaicite:11]{index=11}

### 4.4 Repositories
Abstract persistence for **aggregate roots** (not for every class). Expose intent-revealing methods (`findById`, `save`). :contentReference[oaicite:12]{index=12}

### 4.5 Domain Services
Domain logic that **doesn’t fit** a single entity or value object (stateless, meaningful to the domain). :contentReference[oaicite:13]{index=13}

### 4.6 Domain Events
Named, meaningful facts that **happened** (“PaymentReceived”). Great for integrating bounded contexts and for auditability. :contentReference[oaicite:14]{index=14}

### 4.7 Factories
Encapsulate complex creation; keep aggregates valid at birth. :contentReference[oaicite:15]{index=15}

### 4.8 Specification Pattern (commonly omitted but important)
Encapsulate a **business predicate** as an object. Compose with AND/OR/NOT; reuse rules across repositories, services, and policies.  
*Example*: `IsPreferredCustomer = ActiveFor(>2y) AND NoOutstandingBalance`. :contentReference[oaicite:16]{index=16}

### 4.9 Policy
A higher-level strategy object that orchestrates specifications and rules for a decision (“ShippingPolicy”, “ReviewPolicy”). :contentReference[oaicite:17]{index=17}

### 4.10 Process Manager / Saga (coordination)
Coordinates **long-running** interactions across multiple aggregates/contexts; often event-driven. While not a “blue book” chapter heading, it’s widely used in DDD practice to preserve aggregate boundaries without losing flow. (Practice influenced by DDD + messaging literature.) :contentReference[oaicite:18]{index=18}

### 4.11 Modules
Package model elements for **cohesion and clarity**; name modules in the ubiquitous language. :contentReference[oaicite:19]{index=19}

### 4.12 Refactoring Toward Deeper Insight
A discipline to routinely reshape the model and language as understanding grows. It’s as essential as any pattern above. :contentReference[oaicite:20]{index=20}

---

## 5) Practical Heuristics & Trade-offs

- **Prefer many small bounded contexts** over one “enterprise model”. :contentReference[oaicite:21]{index=21}
- **Aggregate size**: small enough for clear invariants and fast transactions; larger only when invariants demand it. :contentReference[oaicite:22]{index=22}
- **Repositories** return roots; avoid leaking ORM notions through your domain API. :contentReference[oaicite:23]{index=23}
- **Events** name business facts in ubiquitous language; version them like contracts. :contentReference[oaicite:24]{index=24}
- **ACL vs Conformist**: if upstream churn/pollution hurts you, add an ACL; if you must move fast and upstream is stable, conformist may be fine. :contentReference[oaicite:25]{index=25}

---

## 6) Examples (generic + your context)

> These are illustrative only; keep your concrete model the same as already defined.

### Example A — Retail Orders (generic)
- Contexts: **Sales** (taking orders), **Fulfillment** (picking/packing), **Billing** (invoices).
- Map: Sales → (Published Language) → Billing; Sales ↔ Fulfillment via Customer–Supplier.
- Aggregates: `Order` (lines), `Shipment`, `Invoice`.  
- Events: `OrderPlaced`, `OrderShipped`, `InvoiceSent`.  
- Specs/Policies: `EligibleForFreeShipping`, `ReturnPolicy`.

### Example B — AI-assisted requirements (your context)
- Contexts: **Composition** (creating documents), **Review/Governance**, **Consistency/Impact**.
- Map: Composition → (Events) → Review; Review → (Events) → Consistency checks.
- Aggregates: `DocumentVersion` (root), with value objects `Status`, `Lock`, `PromptConfig`.
- Events: `DocumentSubmittedForReview`, `VersionApproved`.
- Specs/Policies: `ApprovalThresholdMet`, `EligibleForSubmission`.  
*(No new document types introduced; this just casts our existing ones in DDD terms.)*

---

## 7) How this informs your project docs

- **design.md** — include:
  - Strategic: subdomains, bounded contexts, context map (labels like ACL, Conformist, OHS).
  - Tactical: aggregates + invariants, entities, value objects, repositories, services, events, specifications, policies, process managers.
- **narrative.md** — tell the story of boundaries and change (why contexts, how events flow).
- **ubiquitous-language.md** — define terms per context, include cross-context mappings.
- **meta.md** — make knowledge crunching explicit; add steps for boundary-first design, event naming, spec/policy capture, and periodic refactoring.

---

## 8) Authoritative References (bookmark these)

- **Eric Evans — DDD Reference (free PDF)**: concise, canonical pattern summaries. :contentReference[oaicite:26]{index=26}
- **Domain Language — DDD Reference landing page**. :contentReference[oaicite:27]{index=27}
- **Martin Fowler — Bounded Context (bliki)**; **Ubiquitous Language (bliki)**; **DDD overview**. :contentReference[oaicite:28]{index=28}
- **Context mapping primers** (patterns list and roles). :contentReference[oaicite:29]{index=29}

