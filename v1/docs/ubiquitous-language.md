# Ubiquitous Language — Agile LLM Requirements Model
_Last updated: 2025-09-29_

> This glossary defines shared terms used by stakeholders and implementers. Each term includes a **definition** and a **mapping** to the Java domain model.

## Core

**Document** — A project artifact (Vision, Epic, Feature, Story, etc.) that evolves through versions.  
*Mapping*: `v1.operational.Document<T extends v1.knowledge.DocumentType>`

**Document Type** — The category/role of a document, including relationships to other types.  
*Mapping*: `v1.knowledge.DocumentType` (+ `ParentOfDocumentType`, `ChildOfDocumentType`)

**Document Version** — An immutable snapshot with author, timestamp, content, status, conversation log.  
*Mapping*: `v1.operational.DocumentVersion`

**Conversation Log** — The ordered exchange between **User**, **System**, and **LLM** that produced a version.  
*Mapping*: `v1.operational.ConversationEntry`

**User** — A person identified by id and name, with roles and groups.  
*Mapping*: `v1.operational.User`

## Hierarchy

**Vision** — The project’s overarching goals; parent of Epics.  
*Mapping*: `v1.knowledge.VisionDocumentType`

**Epic** — Large capability; child of Vision, parent of Features; holds Enhancement Requests.  
*Mapping*: `v1.knowledge.EpicDocumentType`

**Feature** — Functional capability; child of Epic, parent of User Stories.  
*Mapping*: `v1.knowledge.FeatureDocumentType`

**User Story** — Small, testable slice; child of Feature; leaf.  
*Mapping*: `v1.knowledge.UserStoryDocumentType`

**Enhancement Request** — Proposal to extend an Epic; child of Epic.  
*Mapping*: `v1.knowledge.EnhancementRequestDocumentType`

**Bug Report** — Defect tied to a User Story; child of Story.  
*Mapping*: `v1.knowledge.BugReportDocumentType`

**Feature Test Approach** — Testing plan for a Feature or Epic.  
*Mapping*: `v1.knowledge.FeatureTestApproachDocumentType`

**Domain Model** — Business entities and relationships at project level.  
*Mapping*: `v1.knowledge.DomainModelDocumentType`

**Business Context** — Business units, customer segments, and products in scope.  
*Mapping*: `v1.knowledge.BusinessContextDocumentType`

**Research** — Structured exploration and findings.  
*Mapping*: `v1.knowledge.ResearchDocumentType`

**Test Strategy** — Project‑level testing approach.  
*Mapping*: `v1.knowledge.TestStrategyDocumentType`

## Lifecycle

**Draft** — Editable by the lock holder.  
**Submitted for Review** — Author may continue edits; reviewers comment and vote; others see latest Approved version.  
**Approved** — Required approvals reached; becomes official.  
**Rejected** — Rejected by a reviewer; returns to Draft.  
*Mapping*: `v1.operational.DocumentStatus`

## Governance

**Lock** — Exclusive editing claim with sliding expiration.  
*Mapping*: `v1.operational.DocumentLock`

**Review Request** — Records approvals/rejections for a specific version.  
*Mapping*: `v1.operational.ReviewRequest`

**Permission Policy** — Who can view/edit/review; approval threshold.  
*Mapping*: `v1.operational.PermissionPolicy`

## LLM Prompts

**System Prompt** — Baseline role definition for the assistant.  
**Validation Prompt** — Checks if prerequisites are satisfied.  
**Extraction Prompt** — Decomposition into children in JSON.  
**Clarification Prompt** — Questions to collect missing information.  
**Impact Prompt** — Assessment of downstream/upstream changes.  
*Mapping*: external Mustache in `v1/prompts/`