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
		WHERE=9, VALUES=10, INTO=11, DROP=12, AND=13, OR=14, NOT=15, UPDATE=16, 
		SET=17, JOIN=18, INNER=19, LEFT=20, RIGHT=21, UNION=22, DISTINCT=23, ORDER=24, 
		GROUP=25, BY=26, HAVING=27, LIMIT=28, ALTER=29, INT=30, VARCHAR=31, FLOAT=32, 
		BOOLEAN=33, COMMA=34, SEMICOLON=35, DOT=36, ASTERISK=37, LPAREN=38, RPAREN=39, 
		EQUAL=40, INTEGER=41, NUMERIC=42, STRING=43, BOOLVALUE=44, IDENTIFIER=45, 
		WS=46, TRUE=47, FALSE=48;
	public static final int
		RULE_root = 0, RULE_statement = 1, RULE_select = 2, RULE_selectFromTable = 3, 
		RULE_condition = 4, RULE_createTable = 5, RULE_columnDefinition = 6, RULE_insertIntoTable = 7, 
		RULE_tableName = 8, RULE_valueList = 9, RULE_value = 10, RULE_columnList = 11, 
		RULE_columnName = 12, RULE_dataType = 13, RULE_intType = 14, RULE_varcharType = 15, 
		RULE_floatType = 16, RULE_booleanType = 17, RULE_expression = 18, RULE_term = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "statement", "select", "selectFromTable", "condition", "createTable", 
			"columnDefinition", "insertIntoTable", "tableName", "valueList", "value", 
			"columnList", "columnName", "dataType", "intType", "varcharType", "floatType", 
			"booleanType", "expression", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "','", "';'", 
			"'.'", "'*'", "'('", "')'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SELECT", "CREATE", "INSERT", "DELETE", "TABLE", "DATABASE", "FROM", 
			"AS", "WHERE", "VALUES", "INTO", "DROP", "AND", "OR", "NOT", "UPDATE", 
			"SET", "JOIN", "INNER", "LEFT", "RIGHT", "UNION", "DISTINCT", "ORDER", 
			"GROUP", "BY", "HAVING", "LIMIT", "ALTER", "INT", "VARCHAR", "FLOAT", 
			"BOOLEAN", "COMMA", "SEMICOLON", "DOT", "ASTERISK", "LPAREN", "RPAREN", 
			"EQUAL", "INTEGER", "NUMERIC", "STRING", "BOOLVALUE", "IDENTIFIER", "WS", 
			"TRUE", "FALSE"
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
			setState(40);
			statement();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(41);
				match(SEMICOLON);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
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
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				select();
				}
				break;
			case CREATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				createTable();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
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
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				selectFromTable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(SELECT);
				setState(56);
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
			setState(59);
			match(SELECT);
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(60);
				columnList();
				}
				break;
			case ASTERISK:
				{
				setState(61);
				match(ASTERISK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(64);
			match(FROM);
			setState(65);
			tableName();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(66);
				match(WHERE);
				setState(67);
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
			setState(70);
			expression();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(71);
				match(AND);
				setState(72);
				expression();
				}
				}
				setState(77);
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
			setState(78);
			match(CREATE);
			setState(79);
			match(TABLE);
			setState(80);
			tableName();
			setState(81);
			match(LPAREN);
			setState(82);
			columnDefinition();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(83);
				match(COMMA);
				setState(84);
				columnDefinition();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
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
			setState(92);
			columnName();
			setState(93);
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
		public TerminalNode VALUES() { return getToken(OL.VALUES, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(OL.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(OL.LPAREN, i);
		}
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(OL.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(OL.RPAREN, i);
		}
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public InsertIntoTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertIntoTable; }
	}

	public final InsertIntoTableContext insertIntoTable() throws RecognitionException {
		InsertIntoTableContext _localctx = new InsertIntoTableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_insertIntoTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(INSERT);
			setState(96);
			match(INTO);
			setState(97);
			tableName();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(98);
				match(LPAREN);
				setState(99);
				columnList();
				setState(100);
				match(RPAREN);
				}
			}

			setState(104);
			match(VALUES);
			setState(105);
			match(LPAREN);
			setState(106);
			valueList();
			setState(107);
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
			setState(109);
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
			setState(111);
			value();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(112);
				match(COMMA);
				setState(113);
				value();
				}
				}
				setState(118);
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
		public TerminalNode BOOLVALUE() { return getToken(OL.BOOLVALUE, 0); }
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
			setState(119);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985348833280L) != 0)) ) {
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
			setState(121);
			columnName();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(122);
				match(COMMA);
				setState(123);
				columnName();
				}
				}
				setState(128);
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
			setState(129);
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
		public IntTypeContext intType() {
			return getRuleContext(IntTypeContext.class,0);
		}
		public VarcharTypeContext varcharType() {
			return getRuleContext(VarcharTypeContext.class,0);
		}
		public FloatTypeContext floatType() {
			return getRuleContext(FloatTypeContext.class,0);
		}
		public BooleanTypeContext booleanType() {
			return getRuleContext(BooleanTypeContext.class,0);
		}
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dataType);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				intType();
				}
				break;
			case VARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				varcharType();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				floatType();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				booleanType();
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
	public static class IntTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(OL.INT, 0); }
		public IntTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intType; }
	}

	public final IntTypeContext intType() throws RecognitionException {
		IntTypeContext _localctx = new IntTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_intType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(INT);
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
	public static class VarcharTypeContext extends ParserRuleContext {
		public Token charLength;
		public TerminalNode VARCHAR() { return getToken(OL.VARCHAR, 0); }
		public TerminalNode LPAREN() { return getToken(OL.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(OL.RPAREN, 0); }
		public TerminalNode INTEGER() { return getToken(OL.INTEGER, 0); }
		public VarcharTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varcharType; }
	}

	public final VarcharTypeContext varcharType() throws RecognitionException {
		VarcharTypeContext _localctx = new VarcharTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varcharType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(VARCHAR);
			setState(140);
			match(LPAREN);
			setState(141);
			((VarcharTypeContext)_localctx).charLength = match(INTEGER);
			setState(142);
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
	public static class FloatTypeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(OL.FLOAT, 0); }
		public FloatTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatType; }
	}

	public final FloatTypeContext floatType() throws RecognitionException {
		FloatTypeContext _localctx = new FloatTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_floatType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(FLOAT);
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
	public static class BooleanTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(OL.BOOLEAN, 0); }
		public BooleanTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanType; }
	}

	public final BooleanTypeContext booleanType() throws RecognitionException {
		BooleanTypeContext _localctx = new BooleanTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_booleanType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(BOOLEAN);
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
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
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
		enterRule(_localctx, 36, RULE_expression);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				term();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(LPAREN);
				setState(150);
				expression();
				setState(151);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(OL.EQUAL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			columnName();
			setState(156);
			match(EQUAL);
			setState(157);
			value();
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
		"\u0004\u00010\u00a0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0005\u0000+\b\u0000"+
		"\n\u0000\f\u0000.\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00015\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002:\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"?\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"E\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004J\b\u0004\n\u0004"+
		"\f\u0004M\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005V\b\u0005\n\u0005\f\u0005Y\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007g\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\ts\b"+
		"\t\n\t\f\tv\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b}\b\u000b\n\u000b\f\u000b\u0080\t\u000b\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u0088\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u009a\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000"+
		"\u0001\u0001\u0000),\u009a\u0000(\u0001\u0000\u0000\u0000\u00024\u0001"+
		"\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000\u0006;\u0001\u0000\u0000"+
		"\u0000\bF\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000\f\\\u0001"+
		"\u0000\u0000\u0000\u000e_\u0001\u0000\u0000\u0000\u0010m\u0001\u0000\u0000"+
		"\u0000\u0012o\u0001\u0000\u0000\u0000\u0014w\u0001\u0000\u0000\u0000\u0016"+
		"y\u0001\u0000\u0000\u0000\u0018\u0081\u0001\u0000\u0000\u0000\u001a\u0087"+
		"\u0001\u0000\u0000\u0000\u001c\u0089\u0001\u0000\u0000\u0000\u001e\u008b"+
		"\u0001\u0000\u0000\u0000 \u0090\u0001\u0000\u0000\u0000\"\u0092\u0001"+
		"\u0000\u0000\u0000$\u0099\u0001\u0000\u0000\u0000&\u009b\u0001\u0000\u0000"+
		"\u0000(,\u0003\u0002\u0001\u0000)+\u0005#\u0000\u0000*)\u0001\u0000\u0000"+
		"\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-/\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/0\u0005"+
		"\u0000\u0000\u00010\u0001\u0001\u0000\u0000\u000015\u0003\u0004\u0002"+
		"\u000025\u0003\n\u0005\u000035\u0003\u000e\u0007\u000041\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u00005\u0003\u0001"+
		"\u0000\u0000\u00006:\u0003\u0006\u0003\u000078\u0005\u0001\u0000\u0000"+
		"8:\u0003$\u0012\u000096\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		":\u0005\u0001\u0000\u0000\u0000;>\u0005\u0001\u0000\u0000<?\u0003\u0016"+
		"\u000b\u0000=?\u0005%\u0000\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0005\u0007\u0000\u0000AD\u0003"+
		"\u0010\b\u0000BC\u0005\t\u0000\u0000CE\u0003\b\u0004\u0000DB\u0001\u0000"+
		"\u0000\u0000DE\u0001\u0000\u0000\u0000E\u0007\u0001\u0000\u0000\u0000"+
		"FK\u0003$\u0012\u0000GH\u0005\r\u0000\u0000HJ\u0003$\u0012\u0000IG\u0001"+
		"\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000L\t\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000NO\u0005\u0002\u0000\u0000OP\u0005\u0005\u0000\u0000PQ\u0003\u0010"+
		"\b\u0000QR\u0005&\u0000\u0000RW\u0003\f\u0006\u0000ST\u0005\"\u0000\u0000"+
		"TV\u0003\f\u0006\u0000US\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000Z[\u0005\'\u0000\u0000[\u000b\u0001\u0000"+
		"\u0000\u0000\\]\u0003\u0018\f\u0000]^\u0003\u001a\r\u0000^\r\u0001\u0000"+
		"\u0000\u0000_`\u0005\u0003\u0000\u0000`a\u0005\u000b\u0000\u0000af\u0003"+
		"\u0010\b\u0000bc\u0005&\u0000\u0000cd\u0003\u0016\u000b\u0000de\u0005"+
		"\'\u0000\u0000eg\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0005\n\u0000\u0000ij\u0005"+
		"&\u0000\u0000jk\u0003\u0012\t\u0000kl\u0005\'\u0000\u0000l\u000f\u0001"+
		"\u0000\u0000\u0000mn\u0005-\u0000\u0000n\u0011\u0001\u0000\u0000\u0000"+
		"ot\u0003\u0014\n\u0000pq\u0005\"\u0000\u0000qs\u0003\u0014\n\u0000rp\u0001"+
		"\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000u\u0013\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000wx\u0007\u0000\u0000\u0000x\u0015\u0001\u0000\u0000\u0000"+
		"y~\u0003\u0018\f\u0000z{\u0005\"\u0000\u0000{}\u0003\u0018\f\u0000|z\u0001"+
		"\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0017\u0001\u0000\u0000\u0000"+
		"\u0080~\u0001\u0000\u0000\u0000\u0081\u0082\u0005-\u0000\u0000\u0082\u0019"+
		"\u0001\u0000\u0000\u0000\u0083\u0088\u0003\u001c\u000e\u0000\u0084\u0088"+
		"\u0003\u001e\u000f\u0000\u0085\u0088\u0003 \u0010\u0000\u0086\u0088\u0003"+
		"\"\u0011\u0000\u0087\u0083\u0001\u0000\u0000\u0000\u0087\u0084\u0001\u0000"+
		"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u001b\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u001e"+
		"\u0000\u0000\u008a\u001d\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u001f"+
		"\u0000\u0000\u008c\u008d\u0005&\u0000\u0000\u008d\u008e\u0005)\u0000\u0000"+
		"\u008e\u008f\u0005\'\u0000\u0000\u008f\u001f\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0005 \u0000\u0000\u0091!\u0001\u0000\u0000\u0000\u0092\u0093\u0005"+
		"!\u0000\u0000\u0093#\u0001\u0000\u0000\u0000\u0094\u009a\u0003&\u0013"+
		"\u0000\u0095\u0096\u0005&\u0000\u0000\u0096\u0097\u0003$\u0012\u0000\u0097"+
		"\u0098\u0005\'\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0094"+
		"\u0001\u0000\u0000\u0000\u0099\u0095\u0001\u0000\u0000\u0000\u009a%\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0003\u0018\f\u0000\u009c\u009d\u0005("+
		"\u0000\u0000\u009d\u009e\u0003\u0014\n\u0000\u009e\'\u0001\u0000\u0000"+
		"\u0000\f,49>DKWft~\u0087\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}