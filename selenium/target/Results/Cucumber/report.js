$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/newToursFeatureFile3.feature");
formatter.feature({
  "line": 1,
  "name": "New Tours",
  "description": "",
  "id": "new-tours",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Validate Login Functionality",
  "description": "",
  "id": "new-tours;validate-login-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@DiffrentData"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Launch the New Tours",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Enter user name as \"\u003cUsername\u003e\" and Password as \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on Login",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Successful Login",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "new-tours;validate-login-functionality;",
  "rows": [
    {
      "cells": [
        "Username",
        "password"
      ],
      "line": 10,
      "id": "new-tours;validate-login-functionality;;1"
    },
    {
      "cells": [
        "bcp",
        "bcp"
      ],
      "line": 11,
      "id": "new-tours;validate-login-functionality;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 32233185700,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Validate Login Functionality",
  "description": "",
  "id": "new-tours;validate-login-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@DiffrentData"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Launch the New Tours",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Enter user name as \"bcp\" and Password as \"bcp\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on Login",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Successful Login",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.launch_the_New_Tours()"
});
formatter.result({
  "duration": 38847621000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "bcp",
      "offset": 20
    },
    {
      "val": "bcp",
      "offset": 42
    }
  ],
  "location": "StepDefinition.enter_user_name_as_and_Password_as(String,String)"
});
formatter.result({
  "duration": 180259700,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.click_on_Login()"
});
formatter.result({
  "duration": 4244967000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.successful_Login()"
});
formatter.result({
  "duration": 15583493000,
  "status": "passed"
});
});