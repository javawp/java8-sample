var esprima, log, readFile, timestamp;

function init() {
    if (typeof process === 'object') {
        // Assuming Node.js
        esprima = require('./esprima');
        log = console.log.bind(console);
        readFile = function(fname) { return require('fs').readFileSync(fname, 'utf-8'); };
        timestamp = function() { return process.hrtime()[1] / 1e6; };
    } else if (typeof load === 'function') {
        // Assuming V8 shell
        load('./esprima.js');
        log = print;
        readFile = read;
        timestamp = Date.now;
    }
}

function parse(code) {
    var i, tokens, tree;
    log('Starting to parse', code.length, 'bytes...');
    for (i = 0; i < 7; ++i) {
        var start, stop;
        start = timestamp();
        tree = esprima.parse(code);
        tokens = esprima.tokenize(code);
        stop = timestamp();
        log('Run #' + (i + 1) + ':', (stop - start), 'ms');
    }
    log('Data is', tokens.length, 'and', tree);
}

init();
parse(readFile('./jquery.js'));
