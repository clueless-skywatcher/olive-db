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
    : INSERT INTO tableName LPAREN columnList RPAREN VALUES LPAREN valueList RPAREN
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
    ;
columnList
    : columnName (COMMA columnName)*
    ;
columnName
    : IDENTIFIER
    ;
dataType
    : INT
    | VARCHAR LPAREN INTEGER RPAREN
    | FLOAT
    | BOOLEAN
    ;
expression
    : columnName EQUAL value
    | LPAREN expression RPAREN
    ;

