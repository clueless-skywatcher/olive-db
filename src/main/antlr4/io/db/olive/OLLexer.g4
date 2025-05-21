lexer grammar OLLexer;

// Keywords
SELECT: 'SELECT' | 'select';
CREATE: 'CREATE' | 'create';
INSERT: 'INSERT' | 'insert';
DELETE: 'DELETE' | 'delete';
TABLE: 'TABLE' | 'table';
DATABASE: 'DATABASE' | 'database';
FROM: 'FROM' | 'from';
AS: 'AS' | 'as';
WHERE: 'WHERE' | 'where';
VALUES: 'VALUES' | 'values';
INTO: 'INTO' | 'into';
DROP: 'DROP' | 'drop';
AND: 'AND' | 'and';
OR: 'OR' | 'or';
NOT: 'NOT' | 'not';
UPDATE: 'UPDATE' | 'update';
SET: 'SET' | 'set';
JOIN: 'JOIN' | 'join';
INNER: 'INNER' | 'inner';
LEFT: 'LEFT' | 'left';
RIGHT: 'RIGHT' | 'right';
UNION: 'UNION' | 'union';
DISTINCT: 'DISTINCT' | 'distinct';
ORDER: 'ORDER' | 'order';
GROUP: 'GROUP' | 'group';
BY: 'BY' | 'by';
HAVING: 'HAVING' | 'having';
LIMIT: 'LIMIT' | 'limit';
ALTER: 'ALTER' | 'alter';

// Data types
INT: 'INT' | 'int';
VARCHAR: 'VARCHAR' | 'varchar';
FLOAT: 'FLOAT' | 'float';
BOOLEAN: 'BOOLEAN' | 'boolean';

// Symbols
COMMA: ',';
SEMICOLON: ';';
DOT: '.';
ASTERISK: '*';
LPAREN: '(';
RPAREN: ')';
EQUAL: '=';

INTEGER: DIGITS;
NUMERIC: DIGITS '.' DIGITS;
STRING: '\'' ( '\\' . | ~[\\'])* '\'';
IDENTIFIER: [a-zA-Z][a-zA-Z0-9_]*;
WS: [ \t\r\n]+ -> skip;

fragment DIGITS: [0-9]+;