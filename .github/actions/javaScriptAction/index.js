import core as core from "@actions/core";
import github as github from "@actions/github";

function run() {
    try {
      // `name-greet` input defined in action metadata file
      core.info("JavaScript Action is running!");
      const nameToGreet = core.getInput("name-greet");
      core.info(`Hello ${nameToGreet}!`);

      // Get the current time and set it as an output variable
      const time = new Date().toTimeString();
      core.setOutput("time-of-greet", time);

      // Get the JSON webhook payload for the event that triggered the workflow
      const payload = JSON.stringify(github.context.payload, undefined, 2);
      core.info(`The event payload: ${payload}`);
    } catch (error) {
      core.info("Action failed");
      core.setFailed(error.message);
    }
}


run();
