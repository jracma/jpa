"use strict";
/**
 * Component Generator
 */
exports.__esModule = true;
exports.componentGenerator = exports.ComponentProptNames = void 0;
var inquirer_1 = require("inquirer");
var utils_1 = require("../utils");
var paths_1 = require("../paths");
inquirer_1["default"].registerPrompt('directory', require('inquirer-directory'));
var ComponentProptNames;
(function (ComponentProptNames) {
    ComponentProptNames["componentName"] = "componentName";
    ComponentProptNames["path"] = "path";
    ComponentProptNames["wantMemo"] = "wantMemo";
    ComponentProptNames["wantStyledComponents"] = "wantStyledComponents";
    ComponentProptNames["wantTranslations"] = "wantTranslations";
    ComponentProptNames["wantLoadable"] = "wantLoadable";
    ComponentProptNames["wantTests"] = "wantTests";
})(ComponentProptNames = exports.ComponentProptNames || (exports.ComponentProptNames = {}));
exports.componentGenerator = {
    description: 'Add a component',
    prompts: [
        {
            type: 'input',
            name: ComponentProptNames.componentName,
            message: 'What should it be called?',
        },
        {
            type: 'directory',
            name: ComponentProptNames.path,
            message: 'Where do you want it to be created?',
            basePath: "" + paths_1.baseGeneratorPath,
        },
        {
            type: 'confirm',
            name: ComponentProptNames.wantMemo,
            "default": false,
            message: 'Do you want to wrap your component in React.memo?',
        },
        {
            type: 'confirm',
            name: ComponentProptNames.wantStyledComponents,
            "default": true,
            message: 'Do you want to use styled-components?',
        },
        {
            type: 'confirm',
            name: ComponentProptNames.wantTranslations,
            "default": false,
            message: 'Do you want i18n translations (i.e. will this component use text)?',
        },
        {
            type: 'confirm',
            name: ComponentProptNames.wantLoadable,
            "default": false,
            message: 'Do you want to load the component asynchronously?',
        },
        {
            type: 'confirm',
            name: ComponentProptNames.wantTests,
            "default": false,
            message: 'Do you want to have tests?',
        },
    ],
    actions: function (data) {
        var answers = data;
        var componentPath = paths_1.baseGeneratorPath + "/" + answers.path + "/{{properCase " + ComponentProptNames.componentName + "}}";
        var actualComponentPath = paths_1.baseGeneratorPath + "/" + answers.path + "/" + answers.componentName;
        if (utils_1.pathExists(actualComponentPath)) {
            throw new Error("Component '" + answers.componentName + "' already exists");
        }
        var actions = [
            {
                type: 'add',
                path: componentPath + "/index.tsx",
                templateFile: './component/index.tsx.hbs',
                abortOnFail: true,
            },
        ];
        if (answers.wantLoadable) {
            actions.push({
                type: 'add',
                path: componentPath + "/Loadable.ts",
                templateFile: './component/loadable.ts.hbs',
                abortOnFail: true,
            });
        }
        if (answers.wantTests) {
            actions.push({
                type: 'add',
                path: componentPath + "/__tests__/index.test.tsx",
                templateFile: './component/index.test.tsx.hbs',
                abortOnFail: true,
            });
        }
        if (answers.wantTranslations) {
            actions.push({
                type: 'add',
                path: componentPath + "/messages.ts",
                templateFile: './component/messages.ts.hbs',
                abortOnFail: true,
            });
        }
        actions.push({
            type: 'prettify',
            data: { path: actualComponentPath + "/**" },
        });
        return actions;
    },
};
//# sourceMappingURL=index.js.map