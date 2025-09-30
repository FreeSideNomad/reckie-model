# Design Document — v1
_Last updated: 2025-09-29_

## Purpose
This document specifies the **Knowledge Layer** (conceptual types and relationships) and the **Operational Layer** (runtime behavior, lifecycle, governance) for an **LLM‑supported Agile SDLC requirements model**. It implements what we agreed in this session and does **not** introduce new domain types beyond those discussed.

---

## 1. Knowledge Layer (Conceptual Types)

### 1.1 Document Categories
Project artifacts are organized as follows:

- **Vision** — Project‑level root. Has **children: Epics**. Decomposable.
- **Epic** — Child of Vision; **parent of Features**. Also holds **Enhancement Requests**.
- **Feature** — Child of Epic; **parent of User Stories**.
- **User Story** — Child of Feature; **leaf** (no children).
- **Enhancement Request** — Child of Epic.
- **Bug Report** — Child of User Story.
- **Domain Model** — Project‑level standalone (no parent/children).
- **Business Context** — Project‑level standalone.
- **Research** — Project‑level standalone.
- **Test Strategy** — Project‑level standalone.
- **Feature Test Approach** — Child of **Feature** or **Epic**.

These types form a **directed hierarchy** for delivery artifacts (Vision → Epic → Feature → Story) and **adjacent artifacts** that inform them (Domain Model, Business Context, Research, Test Strategy) or extend them (Enhancement Request, Bug Report, Feature Test Approach).

### 1.2 Parent/Child Traits
To express hierarchy **statically**:
- `ParentOfDocumentType<C extends DocumentType>` — types that may have children (e.g., Vision→Epic, Epic→Feature, Feature→UserStory).
- `ChildOfDocumentType<P extends DocumentType>` — types that must have a parent.

### 1.3 Interaction & Prompts
Each decomposable type has **LLM prompt templates** (Mustache) for:
- **System** (baseline role)
- **Validation** (is there enough context to proceed?)
- **Extraction** (decomposition output in JSON)
- **Ask Questions** (clarification questions in JSON)
- **Impact** (assess change ripple effects)

Non‑decomposable types include at least a **System** prompt (e.g., Research, Business Context, Domain Model, Test Strategy, Enhancement Request, Bug Report, Feature Test Approach).

---

## 2. Operational Layer (Runtime Behavior)

### 2.1 Documents & Versions
- **Document** is identified by `id`, `title`, and a **document type**.
- A **Document** maintains a list of **DocumentVersion** snapshots.
- **DocumentVersion** is immutable and contains:
  - `versionNumber`, `timestamp`, `author`
  - `content`
  - `status`: **Draft**, **Submitted for Review**, **Approved**, **Rejected**
  - `conversationLog`: ordered list of exchanges with **User**, **System**, **LLM**

### 2.2 Concurrency & Locks
- **Exclusive editing lock**: only one user can edit a document (Draft/Submitted) at a time.
- **Sliding window**: the lock expires after inactivity and is renewed on interaction.
- Lock applies to **editing only**; during **Submitted for Review** the **author may continue editing**, reviewers cannot edit but can comment/approve/reject.

### 2.3 Review Workflow
- Reviews are performed on **DocumentVersion**.
- A **ReviewRequest** records reviewer decisions and comments.
- A version becomes **Approved** when **min approvers** (from its **PermissionPolicy**) are met.
- If any reviewer **rejects**, the version becomes **Rejected** and returns to **Draft** for further work.
- While a version is **Submitted for Review**, **other users** (not author/reviewers) see the **latest Approved** version for stability.

### 2.4 Roles, Groups, Policies
- **Roles**: Viewer, Creator, Reviewer, Admin.
- **Groups**: Product Owner, Domain Designer, QA Lead, SME.
- **PermissionPolicy** per document type defines:
  - Roles that can view, edit, review
  - `minApprovers` threshold

**Example policy** (Domain Model):
- View: all roles
- Edit: Domain Designer, Admin
- Review: Reviewer, Admin
- `minApprovers = 2`

### 2.5 Events & Services (DDD mapping)
- **Events**: `DocumentSubmittedForReview`, `VersionApproved`, `VersionRejected`, `LockExpired`.
- **Domain Services**: `ConsistencyEvaluator` (impact checks), `ReviewManager` (approval orchestration), `LockManager` (sliding window).

---

## 3. DDD Tactical Mapping

- **Entities**: Document, DocumentVersion, ReviewRequest.
- **Value Objects**: User (id, name, roles, groups), Lock, Status, PromptContext.
- **Aggregates**: DocumentVersion (root, enforces lifecycle invariants and ties to ReviewRequest).
- **Repositories**: DocumentRepository, VersionRepository (not implemented here; reserved).
- **Specifications**: `ApprovalThresholdMet`, `EligibleForSubmission`.
- **Policies**: `ReviewPolicy`, `LockPolicy`.
- **Modules**: Decomposition, Review, Locking, Permissions.

---

## 4. Visibility Rules
- **Current version**: last version (could be Draft or Submitted).
- **Latest Approved version**: last Approved version; shown to non‑reviewers during review periods.
- **Authoring**: only the user holding the lock may change Draft/Submitted.
- **Reviewers**: comment/approve/reject; cannot change content.

---

## 5. Error/Edge Cases
- Lock expired while editing → attempt to renew; otherwise user must reacquire lock.
- Submitting a Draft with missing preconditions → Validation prompt emits **questions**; version remains Draft.
- Conflicting reviews → Rejection takes precedence; author iterates.
- Impact evaluation indicates downstream misalignment → raise tasks to update dependents (Feature, Story).

---

## 6. Artefact Structure
- `v1/docs/` — design.md, narrative.md, ubiquitous-language.md, meta.md, ddd-summary.md
- `v1/prompts/` — Mustache templates by type & purpose
- `src/main/java/v1/` — knowledge & operational Java packages

This completes the design specification in alignment with our session decisions.