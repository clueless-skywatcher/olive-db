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
		RULE_updateTable = 8, RULE_deleteFromTable = 9, RULE_tableName = 10, RULE_valueList = 11, 
		RULE_value = 12, RULE_columnList = 13, RULE_columnName = 14, RULE_dataType = 15, 
		RULE_intType = 16, RULE_varcharType = 17, RULE_floatType = 18, RULE_booleanType = 19, 
		RULE_expression = 20, RULE_term = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "statement", "select", "selectFromTable", "condition", "createTable", 
			"columnDefinition", "insertIntoTable", "updateTable", "deleteFromTable", 
			"tableName", "valueList", "value", "columnList", "columnName", "dataType", 
			"intType", "varcharType", "floatType", "booleanType", "expression", "term"
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
			setState(44);
			statement();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(45);
				match(SEMICOLON);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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
		public DeleteFromTableContext deleteFromTable() {
			return getRuleContext(DeleteFromTableContext.class,0);
		}
		public UpdateTableContext updateTable() {
			return getRuleContext(UpdateTableContext.class,0);
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
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				select();
				}
				break;
			case CREATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				createTable();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				insertIntoTable();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				deleteFromTable();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				updateTable();
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
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				selectFromTable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(SELECT);
				setState(62);
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
			setState(65);
			match(SELECT);
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(66);
				columnList();
				}
				break;
			case ASTERISK:
				{
				setState(67);
				match(ASTERISK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(70);
			match(FROM);
			setState(71);
			tableName();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(72);
				match(WHERE);
				setState(73);
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
			setState(76);
			expression();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(77);
				match(AND);
				setState(78);
				expression();
				}
				}
				setState(83);
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
			setState(84);
			match(CREATE);
			setState(85);
			match(TABLE);
			setState(86);
			tableName();
			setState(87);
			match(LPAREN);
			setState(88);
			columnDefinition();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89);
				match(COMMA);
				setState(90);
				columnDefinition();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
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
			setState(98);
			columnName();
			setState(99);
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
			setState(101);
			match(INSERT);
			setState(102);
			match(INTO);
			setState(103);
			tableName();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(104);
				match(LPAREN);
				setState(105);
				columnList();
				setState(106);
				match(RPAREN);
				}
			}

			setState(110);
			match(VALUES);
			setState(111);
			match(LPAREN);
			setState(112);
			valueList();
			setState(113);
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
	public static class UpdateTableContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(OL.UPDATE, 0); }
		public TerminalNode TABLE() { return getToken(OL.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode SET() { return getToken(OL.SET, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(OL.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public UpdateTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateTable; }
	}

	public final UpdateTableContext updateTable() throws RecognitionException {
		UpdateTableContext _localctx = new UpdateTableContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_updateTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(UPDATE);
			setState(116);
			match(TABLE);
			setState(117);
			tableName();
			setState(118);
			match(SET);
			setState(119);
			term();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(120);
				match(WHERE);
				setState(121);
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
	public static class DeleteFromTableContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(OL.DELETE, 0); }
		public TerminalNode FROM() { return getToken(OL.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(OL.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DeleteFromTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteFromTable; }
	}

	public final DeleteFromTableContext deleteFromTable() throws RecognitionException {
		DeleteFromTableContext _localctx = new DeleteFromTableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_deleteFromTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(DELETE);
			setState(125);
			match(FROM);
			setState(126);
			tableName();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(127);
				match(WHERE);
				setState(128);
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
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OL.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
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
		enterRule(_localctx, 22, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			value();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(134);
				match(COMMA);
				setState(135);
				value();
				}
				}
				setState(140);
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
		enterRule(_localctx, 24, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
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
		enterRule(_localctx, 26, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			columnName();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(144);
				match(COMMA);
				setState(145);
				columnName();
				}
				}
				setState(150);
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
		enterRule(_localctx, 28, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
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
		enterRule(_localctx, 30, RULE_dataType);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				intType();
				}
				break;
			case VARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				varcharType();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				floatType();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
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
		enterRule(_localctx, 32, RULE_intType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
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
		enterRule(_localctx, 34, RULE_varcharType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(VARCHAR);
			setState(162);
			match(LPAREN);
			setState(163);
			((VarcharTypeContext)_localctx).charLength = match(INTEGER);
			setState(164);
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
		enterRule(_localctx, 36, RULE_floatType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
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
		enterRule(_localctx, 38, RULE_booleanType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
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
		enterRule(_localctx, 40, RULE_expression);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				term();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(LPAREN);
				setState(172);
				expression();
				setState(173);
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
		enterRule(_localctx, 42, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			columnName();
			setState(178);
			match(EQUAL);
			setState(179);
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
		"\u0004\u00010\u00b6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0005\u0000/\b\u0000\n\u0000\f\u00002\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002@\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"E\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"K\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004P\b\u0004\n\u0004"+
		"\f\u0004S\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005\\\b\u0005\n\u0005\f\u0005_"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007m\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b{\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0082"+
		"\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0089"+
		"\b\u000b\n\u000b\f\u000b\u008c\t\u000b\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0005\r\u0093\b\r\n\r\f\r\u0096\t\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u009e\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00b0\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0000\u0000\u0016"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*\u0000\u0001\u0001\u0000),\u00b2\u0000,\u0001\u0000"+
		"\u0000\u0000\u0002:\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000\u0000"+
		"\u0006A\u0001\u0000\u0000\u0000\bL\u0001\u0000\u0000\u0000\nT\u0001\u0000"+
		"\u0000\u0000\fb\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000\u0000"+
		"\u0010s\u0001\u0000\u0000\u0000\u0012|\u0001\u0000\u0000\u0000\u0014\u0083"+
		"\u0001\u0000\u0000\u0000\u0016\u0085\u0001\u0000\u0000\u0000\u0018\u008d"+
		"\u0001\u0000\u0000\u0000\u001a\u008f\u0001\u0000\u0000\u0000\u001c\u0097"+
		"\u0001\u0000\u0000\u0000\u001e\u009d\u0001\u0000\u0000\u0000 \u009f\u0001"+
		"\u0000\u0000\u0000\"\u00a1\u0001\u0000\u0000\u0000$\u00a6\u0001\u0000"+
		"\u0000\u0000&\u00a8\u0001\u0000\u0000\u0000(\u00af\u0001\u0000\u0000\u0000"+
		"*\u00b1\u0001\u0000\u0000\u0000,0\u0003\u0002\u0001\u0000-/\u0005#\u0000"+
		"\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000034\u0005\u0000\u0000\u00014\u0001\u0001\u0000\u0000"+
		"\u00005;\u0003\u0004\u0002\u00006;\u0003\n\u0005\u00007;\u0003\u000e\u0007"+
		"\u00008;\u0003\u0012\t\u00009;\u0003\u0010\b\u0000:5\u0001\u0000\u0000"+
		"\u0000:6\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000:8\u0001\u0000"+
		"\u0000\u0000:9\u0001\u0000\u0000\u0000;\u0003\u0001\u0000\u0000\u0000"+
		"<@\u0003\u0006\u0003\u0000=>\u0005\u0001\u0000\u0000>@\u0003(\u0014\u0000"+
		"?<\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@\u0005\u0001\u0000"+
		"\u0000\u0000AD\u0005\u0001\u0000\u0000BE\u0003\u001a\r\u0000CE\u0005%"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FG\u0005\u0007\u0000\u0000GJ\u0003\u0014\n\u0000HI\u0005"+
		"\t\u0000\u0000IK\u0003\b\u0004\u0000JH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000K\u0007\u0001\u0000\u0000\u0000LQ\u0003(\u0014\u0000"+
		"MN\u0005\r\u0000\u0000NP\u0003(\u0014\u0000OM\u0001\u0000\u0000\u0000"+
		"PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000R\t\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0005\u0002"+
		"\u0000\u0000UV\u0005\u0005\u0000\u0000VW\u0003\u0014\n\u0000WX\u0005&"+
		"\u0000\u0000X]\u0003\f\u0006\u0000YZ\u0005\"\u0000\u0000Z\\\u0003\f\u0006"+
		"\u0000[Y\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000`a\u0005\'\u0000\u0000a\u000b\u0001\u0000\u0000\u0000"+
		"bc\u0003\u001c\u000e\u0000cd\u0003\u001e\u000f\u0000d\r\u0001\u0000\u0000"+
		"\u0000ef\u0005\u0003\u0000\u0000fg\u0005\u000b\u0000\u0000gl\u0003\u0014"+
		"\n\u0000hi\u0005&\u0000\u0000ij\u0003\u001a\r\u0000jk\u0005\'\u0000\u0000"+
		"km\u0001\u0000\u0000\u0000lh\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000no\u0005\n\u0000\u0000op\u0005&\u0000"+
		"\u0000pq\u0003\u0016\u000b\u0000qr\u0005\'\u0000\u0000r\u000f\u0001\u0000"+
		"\u0000\u0000st\u0005\u0010\u0000\u0000tu\u0005\u0005\u0000\u0000uv\u0003"+
		"\u0014\n\u0000vw\u0005\u0011\u0000\u0000wz\u0003*\u0015\u0000xy\u0005"+
		"\t\u0000\u0000y{\u0003\b\u0004\u0000zx\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{\u0011\u0001\u0000\u0000\u0000|}\u0005\u0004\u0000"+
		"\u0000}~\u0005\u0007\u0000\u0000~\u0081\u0003\u0014\n\u0000\u007f\u0080"+
		"\u0005\t\u0000\u0000\u0080\u0082\u0003\b\u0004\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0013\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0005-\u0000\u0000\u0084\u0015\u0001\u0000"+
		"\u0000\u0000\u0085\u008a\u0003\u0018\f\u0000\u0086\u0087\u0005\"\u0000"+
		"\u0000\u0087\u0089\u0003\u0018\f\u0000\u0088\u0086\u0001\u0000\u0000\u0000"+
		"\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0017\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0007\u0000\u0000\u0000"+
		"\u008e\u0019\u0001\u0000\u0000\u0000\u008f\u0094\u0003\u001c\u000e\u0000"+
		"\u0090\u0091\u0005\"\u0000\u0000\u0091\u0093\u0003\u001c\u000e\u0000\u0092"+
		"\u0090\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\u001b\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0005-\u0000\u0000\u0098\u001d\u0001\u0000\u0000\u0000\u0099\u009e"+
		"\u0003 \u0010\u0000\u009a\u009e\u0003\"\u0011\u0000\u009b\u009e\u0003"+
		"$\u0012\u0000\u009c\u009e\u0003&\u0013\u0000\u009d\u0099\u0001\u0000\u0000"+
		"\u0000\u009d\u009a\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u001f\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0005\u001e\u0000\u0000\u00a0!\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a2\u0005\u001f\u0000\u0000\u00a2\u00a3\u0005&\u0000\u0000\u00a3"+
		"\u00a4\u0005)\u0000\u0000\u00a4\u00a5\u0005\'\u0000\u0000\u00a5#\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0005 \u0000\u0000\u00a7%\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a9\u0005!\u0000\u0000\u00a9\'\u0001\u0000\u0000\u0000"+
		"\u00aa\u00b0\u0003*\u0015\u0000\u00ab\u00ac\u0005&\u0000\u0000\u00ac\u00ad"+
		"\u0003(\u0014\u0000\u00ad\u00ae\u0005\'\u0000\u0000\u00ae\u00b0\u0001"+
		"\u0000\u0000\u0000\u00af\u00aa\u0001\u0000\u0000\u0000\u00af\u00ab\u0001"+
		"\u0000\u0000\u0000\u00b0)\u0001\u0000\u0000\u0000\u00b1\u00b2\u0003\u001c"+
		"\u000e\u0000\u00b2\u00b3\u0005(\u0000\u0000\u00b3\u00b4\u0003\u0018\f"+
		"\u0000\u00b4+\u0001\u0000\u0000\u0000\u000e0:?DJQ]lz\u0081\u008a\u0094"+
		"\u009d\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}