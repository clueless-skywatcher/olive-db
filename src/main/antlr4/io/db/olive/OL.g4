parser grammar OL;

options {
    tokenVocab = OLLexer;
}

root
    : statement SEMICOLON* EOF
    ;

statement
    : select
    | createTable
    | insertIntoTable
    // | deleteFromTable
    // | updateTable
    // | dropTable
    ;

select
    : selectFromTable
    | SELECT expression
    ;

// Select statement
selectFromTable
    : SELECT (columnList | ASTERISK) FROM tableName (WHERE condition)?
    ;
condition
    : expression (AND expression)*
    ;

// Create table statement
createTable
    : CREATE TABLE tableName LPAREN columnDefinition (COMMA columnDefinition)* RPAREN
    ;
columnDefinition
    : columnName dataType
    ;

// Insert into table statement
insertIntoTable
    : INSERT INTO tableName (LPAREN columnList RPAREN)? VALUES LPAREN valueList RPAREN
    ;

// Common shit
tableName
    : IDENTIFIER
    ;
valueList
    : value (COMMA value)*
    ;
value
    : STRING
    | INTEGER
    | NUMERIC
    | BOOLVALUE
    ;
columnList
    : columnName (COMMA columnName)*
    ;
columnName
    : IDENTIFIER
    ;
dataType
    : intType
    | varcharType
    | floatType
    | booleanType
    ;

intType
    : INT
    ;

varcharType
    : VARCHAR LPAREN charLength=INTEGER RPAREN
    ;

floatType
    : FLOAT
    ;

booleanType
    : BOOLEAN
    ;

expression
    : term
    | LPAREN expression RPAREN
    ;

term
    : columnName EQUAL value
    ;

