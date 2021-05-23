"use strict";
exports.__esModule = true;
var component_1 = require("./component");
var shelljs_1 = require("shelljs");
var slice_1 = require("./slice");
function plop(plop) {
    plop.setGenerator('component', component_1.componentGenerator);
    plop.setGenerator('slice', slice_1.sliceGenerator);
    plop.setActionType('prettify', function (answers, config) {
        var data = config.data;
        shelljs_1["default"].exec("yarn run prettify -- \"" + data.path + "\"", { silent: true });
        return '';
    });
}
exports["default"] = plop;
//# sourceMappingURL=plopfile.js.map