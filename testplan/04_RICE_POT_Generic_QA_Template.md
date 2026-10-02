# Test Plan 04 — Salesforce Sales and Service Cloud

| Field | Value |
|---|---|
| Test Plan ID | TP-04-SF-001 (locally assigned) |
| Status | Draft — proposed baseline for review |
| Application | Salesforce |
| Scope | Application-level Sales Cloud and Service Cloud |
| Workflow | Guided; scope and structure approved before drafting |
| Test execution status | Not executed; this document is a test plan |

## 1. Test Plan ID and Title

**TP-04-SF-001 — Salesforce Sales and Service Cloud Application-Level Test Plan**

This plan describes a proposed baseline for testing Salesforce Sales Cloud and Service Cloud. It is not a substitute for organization-specific requirements, configured acceptance criteria, or approval of the proposed thresholds in this document.

## 2. Objective and References

### Objective

Define a risk-based, reviewable test approach for the Salesforce Sales and Service Cloud areas, emphasizing:

- Lead-to-opportunity workflows.
- Case-to-resolution workflows.
- Access appropriate to sales reps, sales managers, service agents, and admins.
- Regression of agreed, in-scope workflows.
- Targeted accessibility, performance, and authorized access-control/configuration checks.

Testing is planned for a non-production Salesforce org using synthetic records. No execution or product behavior is asserted by this plan.

### References

- User-provided scope and preferences captured during test-plan discovery.
- [Generic RICE POT QA template](../00_prompt_engg/rice-pot-qa-template.md), Profile B — Test plan.
- Salesforce org-specific requirements, configuration, and acceptance criteria: **Not provided**.

## 3. In Scope and Out of Scope

### In scope

- Salesforce Sales Cloud and Service Cloud at a broad application level.
- Lead-to-opportunity and case-to-resolution workflows, subject to confirmation against the target org’s configuration and acceptance criteria.
- Positive, negative, boundary, and role-based functional checks where supported by approved requirements.
- Integration checks only for integrations confirmed to exist and included in the approved scope.
- Regression testing of agreed workflows affected by the release or change under test.
- Targeted accessibility and performance assessment after applicable standards, workloads, and thresholds are agreed.
- Authorized checks of configured access controls and role permissions in the non-production org.
- Manual execution with targeted automation where stable, approved, and valuable.
- Current Chrome and Edge on desktop as proposed browser targets.

### Out of scope

- Changes to Salesforce configuration, code, profiles, or permission sets.
- Production testing or use of real customer data.
- Unapproved penetration testing, exploitation, or other intrusive security activity.
- SSO, MFA, external integrations, mobile devices, additional clouds, or other workflows unless added through scope review.
- Formal load, stress, or endurance testing until workloads, tools, and thresholds are approved.
- Certification of Salesforce platform behavior beyond the tested org configuration.

## 4. Requirements and Planned Coverage

No formal requirements or acceptance criteria were supplied. The identifiers below are **locally assigned proposed coverage IDs**, not Salesforce requirement IDs. Expected outcomes and detailed test conditions must be agreed from the target org’s requirements before execution.

| Proposed coverage ID | Area / risk | Planned coverage | Traceability and expected outcome |
|---|---|---|---|
| SF-PL-01 | User access and authentication | Confirm approved user roles can access the Salesforce org and unauthorized roles are denied access to restricted functions or records. | Map to approved authentication and authorization requirements; exact role grants and denial behavior are not provided. |
| SF-PL-02 | Lead management | Exercise agreed lead creation, required-field validation, updates, and lifecycle actions. | Map to Sales Cloud lead requirements; field rules and lifecycle states are not provided. |
| SF-PL-03 | Lead-to-opportunity | Exercise conversion of an eligible lead and verify resulting records and relationships. | Map to approved conversion rules; duplicate handling, field mapping, and conversion criteria are not provided. |
| SF-PL-04 | Opportunity management | Exercise agreed opportunity creation, updates, stage changes, and role-appropriate visibility. | Map to approved opportunity requirements; stage definitions, required fields, and close criteria are not provided. |
| SF-PL-05 | Case intake and assignment | Exercise agreed case creation and configured assignment or routing behavior. | Map to approved service intake and routing rules; channels, queues, and assignment configuration are not provided. |
| SF-PL-06 | Case-to-resolution | Exercise agreed case status changes, updates, resolution, and access to related records. | Map to approved case lifecycle requirements; statuses, service targets, and resolution criteria are not provided. |
| SF-PL-07 | Validation and negative paths | Check invalid or incomplete input, boundary values, and prohibited actions for the approved workflows. | Use approved field rules and error behavior; do not invent exact messages or validation policy. |
| SF-PL-08 | Integration behavior | Verify data exchange and failure handling only for named, in-scope integrations. | Integration inventory, contracts, environments, and expected behavior are open dependencies. |
| SF-PL-09 | Regression | Re-run selected high-risk and release-affected Sales and Service workflows. | Regression selection depends on the change inventory and approved requirements. |
| SF-PL-10 | Accessibility | Assess representative agreed workflows against the approved accessibility standard and target. | Standard, conformance level, tooling, and remediation threshold require agreement. |
| SF-PL-11 | Performance | Measure representative agreed workflows using an approved workload and environment. | Workload, concurrency, measurement method, and pass/fail thresholds require agreement. |
| SF-PL-12 | Access-control configuration | Review and test authorized role and record access in the sandbox using test accounts. | Requires approved role-permission matrix and authorization; no intrusive security testing is included. |

Before test-case design, replace or supplement these proposed coverage IDs with supplied requirement IDs and acceptance criteria. Any untraceable or untestable item must be raised for clarification rather than treated as confirmed expected behavior.

## 5. Test Approach, Levels, and Types

### Approach

1. Review the target org, approved requirements, release/change scope, role-permission matrix, and configured workflows.
2. Refine the proposed coverage IDs into traceable scenarios and test cases with observable expected results.
3. Prepare synthetic data and role-based accounts in the non-production org.
4. Execute manual checks first where workflow behavior or configuration is not yet stable.
5. Automate selected repeatable regression checks after selectors, test data, outcomes, and environment stability are confirmed.
6. Record actual results and evidence; report defects with reproduction steps and affected requirements.
7. Retest fixes and perform risk-based regression before release approval.

### Test levels

- **System testing:** End-to-end Sales Cloud and Service Cloud workflows in the sandbox.
- **Integration testing:** Only confirmed integrations included in the agreed scope.
- **Regression testing:** Agreed workflows selected based on change impact and business risk.
- **User acceptance support:** Business representatives review agreed business scenarios; formal UAT ownership and sign-off remain to be assigned.

Unit testing, Salesforce platform certification, and a separate production-acceptance activity are not defined in this plan.

### Test types

- Functional positive, negative, boundary, and role-based testing.
- Integration and regression testing where relevant to confirmed scope.
- Targeted accessibility and performance testing after agreeing standards and measurable thresholds.
- Authorized access-control/configuration testing; no penetration testing or exploitation.

## 6. Environment, Tools, Access, and Test Data

| Item | Plan / status |
|---|---|
| Salesforce org | Non-production sandbox expected; org name, edition, configuration, and availability are **Not provided**. |
| Environment URL | **Not provided**; obtain the approved sandbox login URL through the organization’s secure channel. |
| Browser targets | Current Chrome and Edge desktop are proposed. Exact versions, operating system, and support policy are **Not provided**. |
| User roles | Sales reps, sales managers, service agents, and admins are in the proposed role scope. Provisioned accounts and permissions are **Not provided**. |
| Test data | Synthetic test records are expected. Data setup, ownership, reset process, and masking requirements are **Not provided**. Do not use real customer data. |
| Test management / defect tools | **Not provided**; select approved tools before execution. |
| Automation tools | Targeted automation is in scope as an approach; framework, language, versions, execution infrastructure, and ownership are **Not provided**. |
| Integrations | Inventory, test endpoints, credentials, and monitoring access are **Not provided**; integration testing is conditional on their confirmation. |
| Secrets | Do not put credentials or tokens in this plan, source control, test reports, or test data. Use the organization-approved secret mechanism. |

## 7. Entry and Exit Criteria

All numeric thresholds below are **proposed for review**, not agreed release policy. Obtain owner approval before using them as a release gate.

### Entry criteria

- Approved requirements, acceptance criteria, and change scope are available and mapped to test coverage.
- A sandbox URL and stable target build/configuration are available.
- Required role-based accounts are provisioned and access is confirmed.
- Synthetic data is prepared with a documented reset or cleanup approach.
- Supported browser and operating-system versions are confirmed.
- Defect reporting, evidence handling, and escalation channels are agreed.
- Performance workloads and accessibility standard/thresholds are approved before those test types begin.
- No unresolved scope conflict blocks test design or execution.

### Exit criteria — proposed

- 100% of approved critical/high-risk scenarios have an execution result; deferred scenarios have documented risk acceptance and an owner.
- At least 95% of planned in-scope scenarios have been executed, unless an approved exception is recorded.
- All critical scenarios pass; any exception requires documented approval by the designated business and release owners.
- No open critical or high-severity defects remain without documented risk acceptance.
- All failed tests have linked defects or an approved explanation and retest disposition.
- Requirements-to-test traceability and test evidence are complete for executed scenarios.
- Accessibility and performance results are reported against approved thresholds. They cannot be marked pass/fail until those thresholds are set.
- Business/UAT and release approvals are recorded by named approvers before release; approvers are currently **Not provided**.

## 8. Roles, Responsibilities, Estimates, and Schedule

Named individuals, availability, and dates are **Not provided**. The assignments and estimates below are planning proposals only.

| Role | Proposed responsibility |
|---|---|
| QA/Test Lead | Confirm scope, maintain traceability, coordinate execution, triage defects, report status and risks. |
| QA Engineer(s) | Design and execute tests, maintain evidence, report defects, retest fixes, and support targeted automation. |
| Salesforce Admin/Developer | Prepare the sandbox, explain configuration, provision approved access/data, support diagnosis, and deploy fixes. |
| Sales and Service business representatives | Validate workflow expectations, review proposed outcomes, support UAT, and accept business risks where authorized. |
| Release owner | Confirm release scope, coordinate go/no-go decisions, and record release approval. |

### Rough schedule proposal

Assuming one QA lead, one or two QA engineers, timely sandbox access, and prompt business review:

| Phase | Proposed estimate |
|---|---:|
| Scope, requirements, and risk review | 1–2 working days |
| Test design and data/access preparation | 2–3 working days |
| Functional and integration execution | 3–5 working days |
| Retest, regression, and reporting | 2–3 working days |
| **Indicative total** | **8–13 working days** |

These estimates exclude environment delays, major defects, unconfirmed integrations, and expanded performance/accessibility work. Confirm schedule and staffing after scope and dependencies are resolved.

## 9. Defect Management and Reporting

The defect tool and organization-specific severity definitions are **Not provided**. The following workflow is proposed for approval:

1. Record each defect in the approved tool with a unique ID, title, environment/build, role, preconditions, synthetic data, reproducible steps, expected result, actual result, evidence, and linked coverage/requirement IDs.
2. Do not include credentials, tokens, or real customer data in defect reports or screenshots.
3. Triage defects daily during active execution, with critical blockers escalated promptly to the QA lead and release owner.
4. Assign severity and priority using the organization’s approved definitions; until supplied, any classification is explicitly proposed.
5. Link retests to the original defect and record retest outcome and regression impact.
6. Publish a concise daily status during execution and a final summary containing scope, execution counts, pass/fail/blocked/not-run counts, open defects, risks, and approval status.

## 10. Risks, Dependencies, Assumptions, and Open Questions

### Risks

- Broad application-level scope may miss org-specific customizations, workflows, integrations, or high-risk business rules.
- Missing acceptance criteria can lead to inconsistent expected results and invalid release decisions.
- Sandbox configuration may differ from production or change during test execution.
- Delayed role access, synthetic data, or environment stability may affect schedule and coverage.
- Performance and accessibility findings cannot be evaluated against release thresholds until targets are approved.
- Targeted automation may require additional setup and maintenance depending on the org’s UI and available test infrastructure.

### Assumptions

- “Salesforce” means Sales Cloud and Service Cloud for this plan; other clouds are excluded unless the scope is revised.
- A non-production sandbox and synthetic data will be arranged.
- Lead-to-opportunity and case-to-resolution are the priority workflows.
- Manual functional testing with targeted automation is the intended approach.
- Current Chrome and Edge desktop are proposed browser targets.
- Proposed coverage IDs and criteria in this document are planning aids, not confirmed Salesforce requirements.

### Dependencies and open questions

- What is the sandbox URL, org edition, configured release, and target build?
- Which requirements, acceptance criteria, custom fields, lifecycle states, and business rules apply?
- Which integrations are configured and included?
- Which accounts and permission sets represent each role, and who provisions them?
- What are the approved browser/OS support matrix and browser versions?
- What are the accessibility standard and conformance target?
- What workloads and response-time thresholds apply to performance testing?
- Which defect/test-management tools, automation stack, and secret-management process are approved?
- Who owns test execution, UAT, defect triage, release decisions, and formal sign-off?
- What dates, staffing, estimates, and release window are committed?
- What are the organization’s defect severity, priority, suspension, and reporting policies?

## 11. Suspension and Resumption Criteria

### Suspend testing when

- The sandbox is unavailable or unstable enough to prevent reliable execution.
- The deployed build or org configuration changes without a recorded change notification.
- Required role access or synthetic data is missing or invalid.
- A critical defect blocks a key workflow or makes subsequent results unreliable.
- Test activity risks modifying production or exposing real customer data.
- Required performance/accessibility criteria or security authorization are absent for the activity about to be performed.

### Resume testing when

- The environment/build is confirmed stable and its version/configuration is recorded.
- Access and synthetic data are restored and verified.
- Blocking defects are fixed or have an approved workaround and risk disposition.
- The affected tests are reviewed for invalidated results and reset as needed.
- The QA lead and relevant environment/business owner agree to resume.

Record suspension and resumption time, reason, affected coverage, owner, and impact on schedule.

## 12. Test Deliverables and Approval

### Deliverables

- Approved test plan and change history.
- Requirement-to-coverage mapping and detailed test cases.
- Synthetic test-data setup/reset notes.
- Automation code and execution instructions for the agreed automated subset, if approved.
- Execution evidence and test summary.
- Defect report and retest/regression results.
- Risk, exception, and release/UAT approval records.

### Approval

This draft requires review of the proposed scope, coverage, thresholds, schedule, and responsibilities. **No approval names or dates have been provided.**

| Approval role | Name | Decision / date |
|---|---|---|
| QA/Test Lead | Not provided | Pending |
| Sales business owner | Not provided | Pending |
| Service business owner | Not provided | Pending |
| Salesforce org/environment owner | Not provided | Pending |
| Release owner | Not provided | Pending |

## Validation Status

- Created from the approved proposed scope and the supplied generic test-plan template.
- Planned testing only; no Salesforce tests have been executed.
- Requirements, environment details, exact targets, owners, schedule, and formal approvals remain open as identified above.
