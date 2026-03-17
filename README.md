# Dafater_Regression

## Cypress E2E
1. Install dependencies: `npm install`
2. Open runner UI: `npm run cypress:open`
3. Headless run: `npm run cypress:run`

The added suite lives at `cypress/e2e/addingItems.cy.js` and mirrors the Selenium `AddingItemsTest` TC01 path (item creation, list count assertion, price list navigation, item price entry). Base URL defaults to the Regression site from `BaseTest` (`https://dafater-qc-1.dafater.biz`) and can switch to the Comparing site via env.

Optional env overrides for the spec:
- `DAFATER_USER` (default `Administrator`)
- `DAFATER_PASS` (default `012345MM@@` for Regression, `cAAscAAxhv7N` for Comparing)
- `DAFATER_ITEM_PRICE` (default `100`)
- `DAFATER_SCOPE` (default `Regression`, set to `Comparing` to target `websiteLink_4`)
- `DAFATER_BASE_URL` (override site origin, e.g., `https://dafater-qc-1.dafater.biz`)
- `DAFATER_HOME_URL` (override post-login dashboard URL if it differs)

Example: `DAFATER_SCOPE=Comparing npm run cypress:run`

Note: the spec builds the full login URL from `baseUrl` or `DAFATER_BASE_URL`, so runs won’t fall back to a local `/login` path when the config isn’t picked up.
