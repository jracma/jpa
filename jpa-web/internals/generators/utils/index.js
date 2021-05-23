"use strict";
exports.__esModule = true;
exports.pathExists = void 0;
var fs_1 = require("fs");
function pathExists(path) {
    return fs_1["default"].existsSync(path);
}
exports.pathExists = pathExists;
//# sourceMappingURL=index.js.map