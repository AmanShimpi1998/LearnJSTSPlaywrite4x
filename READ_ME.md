# AIPlaywright4x

Learning and deliverable repository for **AI / LLM fundamentals**, **JavaScript basics**, and **AI-assisted QA & test engineering**.

Content is organised by chapter. Chapter 00 combines **prompt engineering** (the RICE POT framework and a worked QA test plan) with **LLM basics**, and applies a strict, source-traceable documentation standard. Chapters 01 and 02 cover **JavaScript foundations** needed for Playwright test automation.

---

## Repository structure

```
AIPlaywright4x/
├── Chapter_00_Prompt_Eng/
│   ├── 00_RICE_POT_FullForm.md
│   ├── 01_RICE_POT_Prompt.md
│   ├── 02_Problem_Statement.md
│   ├── 03_Anti_Hallucinations.md
│   ├── 04_RICE_POT_Generic_QA_Template.md
│   ├── Test Plan using RICEPOT template.md
│   ├── Test Plan Prompt using RICEPOT template.md
│   ├── LLM_Basics/
│   │   ├── AI_Glossary_Keywords.md
│   │   ├── AI_Glossary_Infographic.png / .svg
│   │   ├── ML,AI&Deep_Learning.png
│   │   ├── Open_vs_Closed_Source_Models_Guide.md
│   │   ├── Open_vs_Closed_Models_Infographic.png / .svg
│   │   ├── Anti-Hallucination_Rules.md
│   │   ├── VWO_Test_Plan.md
│   │   ├── VWO_Test_Plan_Extracted_PRD.txt
│   │   └── Product Requirements Document (PRD) VWO.com.pdf
│   └── Selenium_Framework/
│       └── selenium/
│           ├── pom.xml
│           ├── testng.xml
│           └── src/test/java/com/salesforce/automation/
│               ├── base/BaseTest.java
│               ├── pages/LoginPage.java
│               └── tests/{ValidLoginTest,InvalidLoginTest}.java
├── Chapter_01_JS_Basics/
│   ├── 01_Hellowworld.js
│   ├── 02_Math.js
│   └── 03_DOM_Basics.md
├── Chapter_02_JS_Keaywrods_Identifiers/
│   ├── 01_Keywords_and_Identifiers.md
│   ├── 02_js_engine.js
│   ├── 03_letengine.js
│   ├── 04_KW_IND.js
│   ├── 05_KW_IND_Rules.js
│   ├── 06_IND_Rules2.js
│   ├── 07_Comments.js
│   └── 08_IQ.js
└── README.md
```

---

## Chapter 00 — Prompt Engineering (`Chapter_00_Prompt_Eng/`)

The RICE POT framework (**R**ole, **I**nstructions, **C**ontext, **E**xample, **P**arameters, **O**utput, **T**one) and a generic QA prompt template, applied to a real PRD.

| File | Description |
| --- | --- |
| `00_RICE_POT_FullForm.md` | Breakdown of the RICE POT framework with QA-automation examples for each component. |
| `01_RICE_POT_Prompt.md` | A worked RICE POT prompt: an enterprise Selenium + Java + Maven + TestNG login-automation request. |
| `02_Problem_Statement.md` | The problem statement driving the automation deliverable. |
| `03_Anti_Hallucinations.md` | Anti-hallucination techniques for prompt engineering (version anchoring, negative constraints, grounding, self-verification). |
| `04_RICE_POT_Generic_QA_Template.md` | Copy-ready master RICE POT prompt with four task profiles (General QA, Test plan, Test cases, Automation) and a final review checklist. |
| `Test Plan using RICEPOT template.md` | VWO test plan generated with the RICE POT template: 12 sections with 35 traced coverage items. |
| `Test Plan Prompt using RICEPOT template.md` | The filled RICE POT prompt that generates the VWO test plan. |
| `Selenium_Framework/selenium/` | A Maven + TestNG Selenium 4 framework (Java 17) for Salesforce login: Page Object Model with PageFactory and XPath, `WebDriverWait` only (no `Thread.sleep`), and credentials supplied via `SALESFORCE_USERNAME` / `SALESFORCE_PASSWORD` environment variables. |

---

## Chapter 00 — LLM Basics (`Chapter_00_Prompt_Eng/LLM_Basics/`)

| File | Description |
| --- | --- |
| `AI_Glossary_Keywords.md` | Beginner-friendly glossary of 30 AI/LLM keywords (token, RAG, embeddings, temperature, MCP, agents, evals, guardrails, etc.). Each term has a plain-language meaning, an everyday analogy, why it matters, and a cited source. |
| `AI_Glossary_Infographic.png` | One-page visual summary of the glossary: six colour-coded categories plus a production pipeline. |
| `Open_vs_Closed_Source_Models_Guide.md` | Research guide covering what *open source* vs *open weight* vs *closed source* models are, an inventory of available open-weight and closed models (2026), licensing, and a head-to-head comparison. |
| `Open_vs_Closed_Models_Infographic.png` | One-page visual summary of the open vs closed comparison. |
| `ML,AI&Deep_Learning.png` | Reference diagram of the relationship between AI, machine learning and deep learning. |
| `Anti-Hallucination_Rules.md` | Governing rules for AI-assisted documentation in this repo. |
| `VWO_Test_Plan.md` | Test plan for the VWO platform at `https://app.vwo.com/`, derived from the PRD with full requirement traceability. |
| `VWO_Test_Plan_Extracted_PRD.txt` | Plain-text extraction of the PRD, used as the traceability source for the test plans. |
| `Product Requirements Document (PRD) VWO.com.pdf` | Source PRD for VWO.com. |

---

## Chapter 01 — JavaScript Basics (`Chapter_01_JS_Basics/`)

First steps in JavaScript, written with a QA/Playwright mindset.

| File | Description |
| --- | --- |
| `01_Hellowworld.js` | The classic `console.log("Hello, World!")` first program. |
| `02_Math.js` | Basic arithmetic operators: `+`, `*`, `/`, and exponentiation `**`. |
| `03_DOM_Basics.md` | Plain-language explanation of the DOM (house analogy, node tree, `find → change → react`), event propagation, and why it matters for Playwright locators. |

---

## Chapter 02 — JavaScript Keywords & Identifiers (`Chapter_02_JS_Keaywrods_Identifiers/`)

Naming rules, keywords, and code conventions in JavaScript.

| File | Description |
| --- | --- |
| `01_Keywords_and_Identifiers.md` | Keywords vs identifiers, the 5 identifier rules, valid/invalid examples, case sensitivity, and the full reserved-word list. |
| `02_js_engine.js` | `let` declaration and a commented "hot code" example to explain how the engine runs loops. |
| `03_letengine.js` | Minimal `let` declaration. |
| `04_KW_IND.js` | `var` vs `let` vs `const` with a practical QA usage split (`let` 96%, `const` 3%, `var` 1%). |
| `05_KW_IND_Rules.js` | Identifier rules with valid/invalid examples: `_`, `$`, digits, and case sensitivity. |
| `06_IND_Rules2.js` | Naming conventions: camelCase, PascalCase, snake_case, SCREAMING_SNAKE_CASE, and Hungarian notation. |
| `07_Comments.js` | Single-line, multi-line, and JSDoc-style comments. |
| `08_IQ.js` | Identifier "IQ" quiz: valid vs invalid names, Unicode identifiers, and all four naming cases with constants. |

---

## Conventions

Deliverables follow the `Anti-Hallucination_Rules.md`:

- **Verified Facts** — every assertion is traceable to a cited source.
- **Missing / Unknown Information** — gaps are declared ("Insufficient information to determine") rather than filled with assumptions.
- **Inferences** — anything inferred is explicitly labelled as low confidence.
- **Self-Validation** — each document ends with a self-check for accuracy and consistency.

---

## VWO test plans at a glance

- **Scope:** experimentation (A/B, Split URL, Multivariate), SmartStats, visual/code editors, heatmaps & session recordings, audience targeting, real-time reporting, personalization, integrations, collaboration.
- **Non-functional:** performance (≤ 2 s editing), security (2FA / RBAC / activity logs), scalability, data privacy (GDPR / CCPA), reliability (99.9% uptime SLA).
- **Two plans:** `VWO_Test_Plan.md` (Anti-Hallucination block format, 25 test cases) and `Test Plan using RICEPOT template.md` (RICE POT, 35 planned coverage items).