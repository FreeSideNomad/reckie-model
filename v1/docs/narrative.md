# Narrative: The Story of the Agile Requirements Domain Model
_Last updated: 2025-09-29_

The team gathered around a shared goal: turn ideas into working software without losing clarity along the way. They knew how requirements behave in the real world. They drift. They fork. They collide with constraints. And every change—no matter how small—can ripple through a plan. So they devised a way to treat requirements not as isolated documents but as **living, governed conversations** between people and an assistant powered by a language model.

## A Tree That Grows
Every project begins with a **Vision**—the “why” and “where”—from which branches **Epics**, **Features**, and **User Stories**. Vision shapes Epics; Epics contain Features; Features yield Stories. Beside the tree, other plants are carefully tended: a **Domain Model** gives names to things that matter; **Business Context** explains customers and products in scope; **Research** records findings; a **Test Strategy** outlines how quality will be proven; and a **Feature Test Approach** brings test depth to a specific Feature or Epic. **Enhancement Requests** and **Bug Reports** enter when reality disagrees with plans.

The team agrees on a shared language. “Epic” means the same thing whether spoken by a product owner, a developer, or the assistant. The language model is instructed by **external prompt templates**: one set for describing the role (system prompts), one set for asking “are we ready?” (validation), one for breaking things down (extraction), one for asking for more information (clarifying questions), and one for checking repercussions downstream (impact).

## Drafts, Reviews, and Locks
A product owner drafts a new Epic. The assistant reads the Vision and the Domain Model through a validation prompt. “Is there enough context to decompose this Epic?” If not, it returns questions. If yes, it proposes Features in a structured JSON list. The author edits, refines, and—whenever necessary—asks for more exploration. Behind the scenes, edits are **locked** to a single user with a **sliding expiration** so others are never surprised by conflicting changes.

When the author is satisfied, the Epic is **Submitted for Review**. Reviewers add comments and cast votes; the author can still adjust text but no one else can edit. Meanwhile, the rest of the organization continues to see the **latest Approved** version for stability. If reviewers approve, the new version becomes the official one. If they reject, it returns to Draft with pointed feedback—fuel for the next iteration.

## Traceability by Conversation
Each saved version keeps a **conversation log**: the user’s instructions, the system’s injected context, and the assistant’s answers. This becomes a breadcrumb trail for every requirement decision. When someone asks “why this Feature?”, the conversation shows its genesis—questions asked, assumptions resolved, and the final shape agreed upon.

## The Ripple of Change
Later the Vision changes—market conditions shifted. The impact prompt runs: “Which Epics or Stories are now misaligned?” The assistant returns a list of items to review or rewrite and those still valid. The team prioritizes work with fewer debates, because the criteria are consistent and articulated in the prompts.

## Roles, Policies, and Confidence
Everyone knows their role. **Viewers** can read; **Creators** craft; **Reviewers** approve; **Admins** configure policies. **Product Owners**, **Domain Designers**, **QA Leads**, and **SMEs** bring specialized insight. Permission policies specify who may view, edit, or review each document type and how many approvals are needed. A **Domain Model** might be viewable by everyone, editable by Domain Designers and Admins, and require two reviewers. The rules are common knowledge and transparently enforced.

## A Rhythm of Refinement
Work proceeds in cycles. Knowledge crunching—the process of distilling domain understanding into sharper forms—never stops. Names improve. Boundaries become clearer. A refactoring of the language model prompts makes the assistant’s questions more incisive and its output more consistent. And each time the team returns to the model, they find it a little tighter and a little easier to work with.

## A System That Learns
This is how the model becomes a partner. The assistant isn’t just a generator of text; it is a participant in a **disciplined workflow**. It helps when asked, pauses when clarity is lacking, and evaluates impacts when change arrives. It is opinionated in the ways that matter—formats, preconditions, and checks—but always deferential to the team’s judgment.

The outcome is not merely tidy documents; it is **confidence**—that the Vision is expressed, that Epics are decomposed with care, that Features roll into Stories that can truly be tested, that conversations are preserved, and that every release reflects the best understanding available at the time.