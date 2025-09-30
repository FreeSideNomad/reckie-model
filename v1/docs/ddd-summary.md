# Domain‑Driven Design — Extensive Summary (Evans + Fowler)
_Last updated: 2025-09-29_

## Strategic DDD
- **Subdomains**: Core, Supporting, Generic — focus effort where it differentiates.
- **Bounded Context**: Boundary where a model and its language are consistent.
- **Context Mapping**: Shared Kernel, Customer–Supplier, Conformist, Anticorruption Layer (ACL), Published Language, Open Host Service, Separate Ways, Partnership, Big Ball of Mud.
- **Ubiquitous Language**: Vocabulary tied to the model; per context.
- **Layered Architecture**: UI, Application (orchestration), Domain (pure model), Infrastructure.

## Tactical DDD
- **Entities**, **Value Objects**, **Aggregates/Roots**, **Repositories**, **Domain Services**, **Domain Events**, **Factories**, **Modules**.
- **Specification Pattern**: Encapsulate rules/predicates; compose with AND/OR/NOT.
- **Policy**: Strategy object orchestrating rules/specifications.
- **Process Manager (Saga)**: Coordinate long‑running workflows across aggregates.
- **Refactoring Toward Deeper Insight**: Continuous model improvement.

## Heuristics
- Prefer smaller aggregates; model invariants explicitly.
- Use events to connect contexts; version public contracts.
- Add ACL when upstream churn threatens your model; conform only if safe.
- Keep domain pure; push IO/ORM to Infrastructure.

## Examples
- **Generic**: Retail split into Sales, Fulfillment, Billing; events connect; ACL shields models.
- **Project context**: Composition → Review → Consistency. DocumentVersion as aggregate; events drive impact checks; prompts enforce format and preconditions.

## References
- Eric Evans, *Domain‑Driven Design* (2003); Domain Language DDD Reference.
- Martin Fowler, Bliki entries on DDD, Bounded Context, Ubiquitous Language.