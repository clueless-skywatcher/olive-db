// Generated from /home/epsilonator/GitHub/olive-db/src/main/antlr4/io/db/olive/OL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class OL extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, CREATE=2, INSERT=3, DELETE=4, TABLE=5, DATABASE=6, FROM=7, AS=8, 
		WHERE=9, AND=10, OR=11, NOT=12, UPDATE=13, SET=14, VALUES=15, JOIN=16, 
		INNER=17, LEFT=18, RIGHT=19, UNION=20, DISTINCT=21, ORDER=22, GROUP=23, 
		BY=24, HAVING=25, LIMIT=26, DROP=27, ALTER=28, INTO=29, INT=30, VARCHAR=31, 
		FLOAT=32, BOOLEAN=33, COMMA=34, SEMICOLON=35, DOT=36, ASTERISK=37, LPAREN=38, 
		RPAREN=39, EQUAL=40, INTEGER=41, NUMERIC=42, STRING=43, IDENTIFIER=44, 
		NEWLINE=45, WHITESPACE=46;
	public static final int
		RULE_root = 0, RULE_statement = 1, RULE_select = 2, RULE_selectFromTable = 3, 
		RULE_condition = 4, RULE_createTable = 5, RULE_columnDefinition = 6, RULE_insertIntoTable = 7, 
		RULE_tableName = 8, RULE_valueList = 9, RULE_value = 10, RULE_columnList = 11, 
		RULE_columnName = 12, RULE_dataType = 13, RULE_expression = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "statement", "select", "selectFromTable", "condition", "createTable", 
			"columnDefinition", "insertIntoTable", "tableName", "valueList", "value", 
			"columnList", "columnName", "dataType", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'SELECT'", "'CREATE'", "'INSERT'", "'DELETE'", "'TABLE'", "'DATABASE'", 
			"'FROM'", "'AS'", "'WHERE'", "'AND'", "'OR'", "'NOT'", "'UPDATE'", "'SET'", 
			"'VALUES'", "'JOIN'", "'INNER'", "'LEFT'", "'RIGHT'", "'UNION'", "'DISTINCT'", 
			"'ORDER'", "'GROUP'", "'BY'", "'HAVING'", "'LIMIT'", "'DROP'", "'ALTER'", 
			"'INTO'", "'INT'", "'VARCHAR'", "'FLOAT'", "'BOOLEAN'", "','", "';'", 
			"'.'", "'*'", "'('", "')'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SELECT", "CREATE", "INSERT", "DELETE", "TABLE", "DATABASE", "FROM", 
			"AS", "WHERE", "AND", "OR", "NOT", "UPDATE", "SET", "VALUES", "JOIN", 
			"INNER", "LEFT", "RIGHT", "UNION", "DISTINCT", "ORDER", "GROUP", "BY", 
			"HAVING", "LIMIT", "DROP", "ALTER", "INTO", "INT", "VARCHAR", "FLOAT", 
			"BOOLEAN", "COMMA", "SEMICOLON", "DOT", "ASTERISK", "LPAREN", "RPAREN", 
			"EQUAL", "INTEGER", "NUMERIC", "STRING", "IDENTIFIER", "NEWLINE", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "OL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OL(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(OL.EOF, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(OL.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(OL.SEMICOLON, i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			statement();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(31);
				match(SEMICOLON);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public CreateTableContext createTable() {
			return getRuleContext(CreateTableContext.class,0);
		}
		public InsertIntoTableContext insertIntoTable() {
			return getRuleContext(InsertIntoTableContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				select();
				}
				break;
			case CREATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				createTable();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				insertIntoTable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectContext extends ParserRuleContext {
		public SelectFromTableContext selectFromTable() {
			return getRuleContext(SelectFromTableContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(OL.SELECT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_select);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				selectFromTable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(SELECT);
				setState(46);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectFromTableContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(OL.SELECT, 0); }
		public TerminalNode FROM() { return getToken(OL.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(OL.ASTERISK, 0); }
		public TerminalNode WHERE() { return getToken(OL.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public SelectFromTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectFromTable; }
	}

	public final SelectFromTableContext selectFromTable() throws RecognitionException {
		SelectFromTableContext _localctx = new SelectFromTableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectFromTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(SELECT);
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(50);
				columnList();
				}
				break;
			case ASTERISK:
				{
				setState(51);
				match(ASTERISK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(54);
			match(FROM);
			setState(55);
			tableName();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(56);
				match(WHERE);
				setState(57);
				condition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(OL.AND); }
		public TerminalNode AND(int i) {
			return getToken(OL.AND, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			expression();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(61);
				match(AND);
				setState(62);
				expression();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(OL.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(OL.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(OL.LPAREN, 0); }
		public List<ColumnDefinitionContext> columnDefinition() {
			return getRuleContexts(ColumnDefinitionContext.class);
		}
		public ColumnDefinitionContext columnDefinition(int i) {
			return getRuleContext(ColumnDefinitionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(OL.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(OL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OL.COMMA, i);
		}
		public CreateTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTable; }
	}

	public final CreateTableContext createTable() throws RecognitionException {
		CreateTableContext _localctx = new CreateTableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_createTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(CREATE);
			setState(69);
			match(TABLE);
			setState(70);
			tableName();
			setState(71);
			match(LPAREN);
			setState(72);
			columnDefinition();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(73);
				match(COMMA);
				setState(74);
				columnDefinition();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnDefinitionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_columnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			columnName();
			setState(83);
			dataType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InsertIntoTableContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(OL.INSERT, 0); }
		public TerminalNode INTO() { return getToken(OL.INTO, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<TerminalNode> LPAREN() { return getTokens(OL.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(OL.LPAREN, i);
		}
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(OL.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(OL.RPAREN, i);
		}
		public TerminalNode VALUES() { return getToken(OL.VALUES, 0); }
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public InsertIntoTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertIntoTable; }
	}

	public final InsertIntoTableContext insertIntoTable() throws RecognitionException {
		InsertIntoTableContext _localctx = new InsertIntoTableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_insertIntoTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(INSERT);
			setState(86);
			match(INTO);
			setState(87);
			tableName();
			setState(88);
			match(LPAREN);
			setState(89);
			columnList();
			setState(90);
			match(RPAREN);
			setState(91);
			match(VALUES);
			setState(92);
			match(LPAREN);
			setState(93);
			valueList();
			setState(94);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OL.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueListContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OL.COMMA, i);
		}
		public ValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueList; }
	}

	public final ValueListContext valueList() throws RecognitionException {
		ValueListContext _localctx = new ValueListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			value();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(99);
				match(COMMA);
				setState(100);
				value();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(OL.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(OL.INTEGER, 0); }
		public TerminalNode NUMERIC() { return getToken(OL.NUMERIC, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15393162788864L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnListContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OL.COMMA, i);
		}
		public ColumnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnList; }
	}

	public final ColumnListContext columnList() throws RecognitionException {
		ColumnListContext _localctx = new ColumnListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			columnName();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(109);
				match(COMMA);
				setState(110);
				columnName();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OL.IDENTIFIER, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(OL.INT, 0); }
		public TerminalNode VARCHAR() { return getToken(OL.VARCHAR, 0); }
		public TerminalNode LPAREN() { return getToken(OL.LPAREN, 0); }
		public TerminalNode INTEGER() { return getToken(OL.INTEGER, 0); }
		public TerminalNode RPAREN() { return getToken(OL.RPAREN, 0); }
		public TerminalNode FLOAT() { return getToken(OL.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(OL.BOOLEAN, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dataType);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(INT);
				}
				break;
			case VARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(VARCHAR);
				setState(120);
				match(LPAREN);
				setState(121);
				match(INTEGER);
				setState(122);
				match(RPAREN);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(FLOAT);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(OL.EQUAL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(OL.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OL.RPAREN, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expression);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				columnName();
				setState(128);
				match(EQUAL);
				setState(129);
				value();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(LPAREN);
				setState(132);
				expression();
				setState(133);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u008a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0005\u0000!\b\u0000\n\u0000\f\u0000$\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00020\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u00035\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004@\b\u0004\n\u0004\f\u0004C\t\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"L\b\u0005\n\u0005\f\u0005O\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\tf\b\t\n\t"+
		"\f\ti\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"p\b\u000b\n\u000b\f\u000bs\t\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r~\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0088\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0001"+
		"\u0001\u0000)+\u0088\u0000\u001e\u0001\u0000\u0000\u0000\u0002*\u0001"+
		"\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u00061\u0001\u0000\u0000"+
		"\u0000\b<\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000\u0000\fR\u0001"+
		"\u0000\u0000\u0000\u000eU\u0001\u0000\u0000\u0000\u0010`\u0001\u0000\u0000"+
		"\u0000\u0012b\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016"+
		"l\u0001\u0000\u0000\u0000\u0018t\u0001\u0000\u0000\u0000\u001a}\u0001"+
		"\u0000\u0000\u0000\u001c\u0087\u0001\u0000\u0000\u0000\u001e\"\u0003\u0002"+
		"\u0001\u0000\u001f!\u0005#\u0000\u0000 \u001f\u0001\u0000\u0000\u0000"+
		"!$\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#%\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\u0000"+
		"\u0000\u0001&\u0001\u0001\u0000\u0000\u0000\'+\u0003\u0004\u0002\u0000"+
		"(+\u0003\n\u0005\u0000)+\u0003\u000e\u0007\u0000*\'\u0001\u0000\u0000"+
		"\u0000*(\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000\u0000+\u0003\u0001"+
		"\u0000\u0000\u0000,0\u0003\u0006\u0003\u0000-.\u0005\u0001\u0000\u0000"+
		".0\u0003\u001c\u000e\u0000/,\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000"+
		"\u00000\u0005\u0001\u0000\u0000\u000014\u0005\u0001\u0000\u000025\u0003"+
		"\u0016\u000b\u000035\u0005%\u0000\u000042\u0001\u0000\u0000\u000043\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0005\u0007\u0000\u0000"+
		"7:\u0003\u0010\b\u000089\u0005\t\u0000\u00009;\u0003\b\u0004\u0000:8\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\u0007\u0001\u0000\u0000"+
		"\u0000<A\u0003\u001c\u000e\u0000=>\u0005\n\u0000\u0000>@\u0003\u001c\u000e"+
		"\u0000?=\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000B\t\u0001\u0000\u0000\u0000CA\u0001"+
		"\u0000\u0000\u0000DE\u0005\u0002\u0000\u0000EF\u0005\u0005\u0000\u0000"+
		"FG\u0003\u0010\b\u0000GH\u0005&\u0000\u0000HM\u0003\f\u0006\u0000IJ\u0005"+
		"\"\u0000\u0000JL\u0003\f\u0006\u0000KI\u0001\u0000\u0000\u0000LO\u0001"+
		"\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"NP\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0005\'\u0000\u0000"+
		"Q\u000b\u0001\u0000\u0000\u0000RS\u0003\u0018\f\u0000ST\u0003\u001a\r"+
		"\u0000T\r\u0001\u0000\u0000\u0000UV\u0005\u0003\u0000\u0000VW\u0005\u001d"+
		"\u0000\u0000WX\u0003\u0010\b\u0000XY\u0005&\u0000\u0000YZ\u0003\u0016"+
		"\u000b\u0000Z[\u0005\'\u0000\u0000[\\\u0005\u000f\u0000\u0000\\]\u0005"+
		"&\u0000\u0000]^\u0003\u0012\t\u0000^_\u0005\'\u0000\u0000_\u000f\u0001"+
		"\u0000\u0000\u0000`a\u0005,\u0000\u0000a\u0011\u0001\u0000\u0000\u0000"+
		"bg\u0003\u0014\n\u0000cd\u0005\"\u0000\u0000df\u0003\u0014\n\u0000ec\u0001"+
		"\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000h\u0013\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000jk\u0007\u0000\u0000\u0000k\u0015\u0001\u0000\u0000\u0000"+
		"lq\u0003\u0018\f\u0000mn\u0005\"\u0000\u0000np\u0003\u0018\f\u0000om\u0001"+
		"\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000r\u0017\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000tu\u0005,\u0000\u0000u\u0019\u0001\u0000\u0000\u0000v~\u0005"+
		"\u001e\u0000\u0000wx\u0005\u001f\u0000\u0000xy\u0005&\u0000\u0000yz\u0005"+
		")\u0000\u0000z~\u0005\'\u0000\u0000{~\u0005 \u0000\u0000|~\u0005!\u0000"+
		"\u0000}v\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000}{\u0001\u0000"+
		"\u0000\u0000}|\u0001\u0000\u0000\u0000~\u001b\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0003\u0018\f\u0000\u0080\u0081\u0005(\u0000\u0000\u0081"+
		"\u0082\u0003\u0014\n\u0000\u0082\u0088\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005&\u0000\u0000\u0084\u0085\u0003\u001c\u000e\u0000\u0085\u0086\u0005"+
		"\'\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u007f\u0001\u0000"+
		"\u0000\u0000\u0087\u0083\u0001\u0000\u0000\u0000\u0088\u001d\u0001\u0000"+
		"\u0000\u0000\u000b\"*/4:AMgq}\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}