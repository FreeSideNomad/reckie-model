# Meta‑Process: Evolving a Domain Model with an LLM (Domain‑Agnostic)
_Last updated: 2025-09-29_

This playbook describes **how to run multi‑session conversations with a Large Language Model** to develop and evolve a domain model. It is **domain‑agnostic** and grounded in **knowledge crunching** and **Domain‑Driven Design (DDD)**.

## Principles
1. **Knowledge Crunching** — Iteratively distill the domain into smaller, clearer models and language with domain experts and implementers.
2. **Context First** — Identify **bounded contexts** and their relationships before detailed modeling.
3. **Model Inside Boundaries** — Use **tactical DDD** patterns (aggregates, entities, value objects, services, events) *within* a bounded context.
4. **Eventful Thinking** — Name and use **domain events** to connect contexts and coordinate processes.
5. **Refactor Toward Insight** — Regularly reshape names, boundaries, and structures as understanding grows.

## Phases (repeat each iteration)
**A. Exploration & Divergence** — Gather terms, candidate concepts, conflicts in language, and value hotspots.  
**B. Knowledge Layer Definition** — Name categories/types, define parent/child relations, mark decomposable items.  
**C. Operational Layer Definition** — Define lifecycle, versioning, locks, reviews, roles, groups, permission policies.  
**D. Tactical Mapping** — Identify aggregates, invariants, value objects, events, services, specs, policies.  
**E. Vocabulary Alignment** — Produce/expand a **ubiquitous language** glossary.  
**F. Narrative** — Explain the model as a coherent story for stakeholders.  
**G. Meta‑Reflection** — Capture what changed and why; log alternatives considered; queue next iteration.

## Artefacts
- `design.md` — detailed spec of knowledge + operations layers and tactical mapping.
- `narrative.md` — story‑style explanation of the model.
- `ubiquitous-language.md` — LLM‑friendly glossary with mappings.
- `ddd-summary.md` — strategic & tactical patterns reference (Evans, Fowler).
- `prompts/*.mustache` — reusable LLM instructions.
- `meta.md` — this playbook, embedded in the project.

## Conversation Template (copy/paste)
- “We are designing a domain model for **X**. We will follow the phased method (Exploration → Knowledge → Operations → Tactical → Vocabulary → Narrative → Meta).”
- “List 10–15 key terms stakeholders use; define them in plain language.”
- “Propose 2–3 candidate hierarchies; compare trade‑offs.”
- “Suggest bounded contexts and a simple context map.”
- “Inside **Context A**, propose aggregates, invariants, events, and services.”
- “Write **system/validation/extraction/questions/impact** prompts for **Type Y** with Mustache placeholders and strict output JSON schema.”
- “Identify likely inconsistencies and provide refactoring suggestions.”
- “Summarize what we learned and how to iterate.”

## Quality Gates
- Are boundaries explicit and well‑named?
- Are invariants protected by aggregates (not scattered across services)?
- Are prompts explicit about input placeholders and output schemas?
- Does the glossary reflect the language used in prompts and code?
- Are events named in ubiquitous language, versioned if shared across contexts?

## Example (applied to requirements)
- **Contexts**: Composition, Review/Governance, Consistency/Impact.
- **Aggregates**: DocumentVersion; **Events**: SubmittedForReview, VersionApproved.
- **Prompts**: Validation (readiness), Extraction (decomposition), Impact (alignment after change).
- **Refactoring**: Merge overlapping terms; simplify policies; clarify preconditions for decomposition.