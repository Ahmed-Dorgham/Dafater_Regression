const { defineConfig } = require('cypress');

const scope = process.env.DAFATER_SCOPE || 'Regression'; // Regression | Comparing
const baseUrl =
  process.env.DAFATER_BASE_URL ||
  (scope === 'Regression'
    ? 'https://almorished-v4.dafater.biz'
    : 'https://dafater-qc-1.dafater.biz');

module.exports = defineConfig({
  e2e: {
    baseUrl,
    defaultCommandTimeout: 40000,
    pageLoadTimeout: 120000,
    video: false,
    supportFile: 'cypress/support/e2e.js',
    env: {
      scope,
    },
    setupNodeEvents(on, config) {
      return config;
    },
  },
});
