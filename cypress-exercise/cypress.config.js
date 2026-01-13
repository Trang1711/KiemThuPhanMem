const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    video: true,
    videoCompression: false,
    screenshotOnRunFailure: true,

    videosFolder: "cypress/videos",
    screenshotsFolder: "cypress/screenshots",
  },
});