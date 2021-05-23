"use strict";
/**
 * Container Generator
 */
exports.__esModule = true;
exports.sliceGenerator = exports.rootStatePath = exports.SliceProptNames = void 0;
var path_1 = require("path");
var inquirer_1 = require("inquirer");
var utils_1 = require("../utils");
var paths_1 = require("../paths");
inquirer_1["default"].registerPrompt('directory', require('inquirer-directory'));
var SliceProptNames;
(function (SliceProptNames) {
    SliceProptNames["sliceName"] = "sliceName";
    SliceProptNames["path"] = "path";
    SliceProptNames["wantSaga"] = "wantSaga";
})(SliceProptNames = exports.SliceProptNames || (exports.SliceProptNames = {}));
exports.rootStatePath = path_1["default"].join(__dirname, '../../../src/types/RootState.ts');
exports.sliceGenerator = {
    description: 'Add a redux toolkit slice',
    prompts: [
        {
            type: 'input',
            name: SliceProptNames.sliceName,
            message: 'What should it be called (automatically adds ...Slice postfix)',
        },
        {
            type: 'directory',
            name: SliceProptNames.path,
            message: 'Where do you want it to be created?',
            basePath: "" + paths_1.baseGeneratorPath,
        },
        {
            type: 'confirm',
            name: SliceProptNames.wantSaga,
            "default": true,
            message: 'Do you want sagas for asynchronous flows? (e.g. fetching data)',
        },
    ],
    actions: function (data) {
        var answers = data;
        var slicePath = paths_1.baseGeneratorPath + "/" + answers.path + "/slice";
        if (utils_1.pathExists(slicePath)) {
            throw new Error("Slice '" + answers.sliceName + "' already exists");
        }
        var actions = [];
        actions.push({
            type: 'add',
            path: slicePath + "/index.ts",
            templateFile: './slice/index.ts.hbs',
            abortOnFail: true,
        });
        actions.push({
            type: 'add',
            path: slicePath + "/selectors.ts",
            templateFile: './slice/selectors.ts.hbs',
            abortOnFail: true,
        });
        actions.push({
            type: 'add',
            path: slicePath + "/types.ts",
            templateFile: './slice/types.ts.hbs',
            abortOnFail: true,
        });
        actions.push({
            type: 'modify',
            path: "" + exports.rootStatePath,
            pattern: new RegExp(/.*\/\/.*\[IMPORT NEW CONTAINERSTATE ABOVE\].+\n/),
            templateFile: './slice/importContainerState.hbs',
            abortOnFail: true,
        });
        actions.push({
            type: 'modify',
            path: "" + exports.rootStatePath,
            pattern: new RegExp(/.*\/\/.*\[INSERT NEW REDUCER KEY ABOVE\].+\n/),
            templateFile: './slice/appendRootState.hbs',
            abortOnFail: true,
        });
        if (answers.wantSaga) {
            actions.push({
                type: 'add',
                path: slicePath + "/saga.ts",
                templateFile: './slice/saga.ts.hbs',
                abortOnFail: true,
            });
        }
        actions.push({
            type: 'prettify',
            data: { path: slicePath + "/**" },
        });
        return actions;
    },
};
//# sourceMappingURL=index.js.map