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
		RULE_tableRef = 4, RULE_tableNamesCommaSeparated = 5, RULE_condition = 6, 
		RULE_createTable = 7, RULE_columnDefinition = 8, RULE_insertIntoTable = 9, 
		RULE_updateTable = 10, RULE_deleteFromTable = 11, RULE_tableName = 12, 
		RULE_valueList = 13, RULE_value = 14, RULE_columnList = 15, RULE_columnName = 16, 
		RULE_dataType = 17, RULE_intType = 18, RULE_varcharType = 19, RULE_floatType = 20, 
		RULE_booleanType = 21, RULE_expression = 22, RULE_term = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "statement", "select", "selectFromTable", "tableRef", "tableNamesCommaSeparated", 
			"condition", "createTable", "columnDefinition", "insertIntoTable", "updateTable", 
			"deleteFromTable", "tableName", "valueList", "value", "columnList", "columnName", 
			"dataType", "intType", "varcharType", "floatType", "booleanType", "expression", 
			"term"
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
			setState(48);
			statement();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(49);
				match(SEMICOLON);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
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
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				select();
				}
				break;
			case CREATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				createTable();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				insertIntoTable();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				deleteFromTable();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
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
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				selectFromTable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(SELECT);
				setState(66);
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
		public TableRefContext tableRef() {
			return getRuleContext(TableRefContext.class,0);
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
			setState(69);
			match(SELECT);
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(70);
				columnList();
				}
				break;
			case ASTERISK:
				{
				setState(71);
				match(ASTERISK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(74);
			match(FROM);
			setState(75);
			tableRef();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(76);
				match(WHERE);
				setState(77);
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
	public static class TableRefContext extends ParserRuleContext {
		public TableNamesCommaSeparatedContext tableNamesCommaSeparated() {
			return getRuleContext(TableNamesCommaSeparatedContext.class,0);
		}
		public TableRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRef; }
	}

	public final TableRefContext tableRef() throws RecognitionException {
		TableRefContext _localctx = new TableRefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tableRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			tableNamesCommaSeparated();
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
	public static class TableNamesCommaSeparatedContext extends ParserRuleContext {
		public List<TableNameContext> tableName() {
			return getRuleContexts(TableNameContext.class);
		}
		public TableNameContext tableName(int i) {
			return getRuleContext(TableNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OL.COMMA, i);
		}
		public TableNamesCommaSeparatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableNamesCommaSeparated; }
	}

	public final TableNamesCommaSeparatedContext tableNamesCommaSeparated() throws RecognitionException {
		TableNamesCommaSeparatedContext _localctx = new TableNamesCommaSeparatedContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tableNamesCommaSeparated);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			tableName();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(83);
				match(COMMA);
				setState(84);
				tableName();
				}
				}
				setState(89);
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
		enterRule(_localctx, 12, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			expression();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(91);
				match(AND);
				setState(92);
				expression();
				}
				}
				setState(97);
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
		enterRule(_localctx, 14, RULE_createTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(CREATE);
			setState(99);
			match(TABLE);
			setState(100);
			tableName();
			setState(101);
			match(LPAREN);
			setState(102);
			columnDefinition();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(103);
				match(COMMA);
				setState(104);
				columnDefinition();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
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
		enterRule(_localctx, 16, RULE_columnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			columnName();
			setState(113);
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
		enterRule(_localctx, 18, RULE_insertIntoTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(INSERT);
			setState(116);
			match(INTO);
			setState(117);
			tableName();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(118);
				match(LPAREN);
				setState(119);
				columnList();
				setState(120);
				match(RPAREN);
				}
			}

			setState(124);
			match(VALUES);
			setState(125);
			match(LPAREN);
			setState(126);
			valueList();
			setState(127);
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
		enterRule(_localctx, 20, RULE_updateTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(UPDATE);
			setState(130);
			match(TABLE);
			setState(131);
			tableName();
			setState(132);
			match(SET);
			setState(133);
			term();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(134);
				match(WHERE);
				setState(135);
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
		enterRule(_localctx, 22, RULE_deleteFromTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(DELETE);
			setState(139);
			match(FROM);
			setState(140);
			tableName();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(141);
				match(WHERE);
				setState(142);
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
		enterRule(_localctx, 24, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
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
		enterRule(_localctx, 26, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			value();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(148);
				match(COMMA);
				setState(149);
				value();
				}
				}
				setState(154);
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
		enterRule(_localctx, 28, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
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
		enterRule(_localctx, 30, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			columnName();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(158);
				match(COMMA);
				setState(159);
				columnName();
				}
				}
				setState(164);
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
		enterRule(_localctx, 32, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
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
		enterRule(_localctx, 34, RULE_dataType);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				intType();
				}
				break;
			case VARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				varcharType();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				floatType();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
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
		enterRule(_localctx, 36, RULE_intType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
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
		enterRule(_localctx, 38, RULE_varcharType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(VARCHAR);
			setState(176);
			match(LPAREN);
			setState(177);
			((VarcharTypeContext)_localctx).charLength = match(INTEGER);
			setState(178);
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
		enterRule(_localctx, 40, RULE_floatType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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
		enterRule(_localctx, 42, RULE_booleanType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		enterRule(_localctx, 44, RULE_expression);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				term();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				match(LPAREN);
				setState(186);
				expression();
				setState(187);
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
		enterRule(_localctx, 46, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			columnName();
			setState(192);
			match(EQUAL);
			setState(193);
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
		"\u0004\u00010\u00c4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"?\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002D\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003I\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005V\b\u0005\n\u0005"+
		"\f\u0005Y\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006^\b\u0006"+
		"\n\u0006\f\u0006a\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007j\b\u0007\n\u0007\f\u0007"+
		"m\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t{\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u0089\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u0090\b\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u0097\b\r\n\r\f\r\u009a\t\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00a1\b\u000f\n\u000f"+
		"\f\u000f\u00a4\t\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u00ac\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u00be\b\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.\u0000\u0001\u0001\u0000),\u00bf\u00000\u0001\u0000\u0000\u0000"+
		"\u0002>\u0001\u0000\u0000\u0000\u0004C\u0001\u0000\u0000\u0000\u0006E"+
		"\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\nR\u0001\u0000\u0000"+
		"\u0000\fZ\u0001\u0000\u0000\u0000\u000eb\u0001\u0000\u0000\u0000\u0010"+
		"p\u0001\u0000\u0000\u0000\u0012s\u0001\u0000\u0000\u0000\u0014\u0081\u0001"+
		"\u0000\u0000\u0000\u0016\u008a\u0001\u0000\u0000\u0000\u0018\u0091\u0001"+
		"\u0000\u0000\u0000\u001a\u0093\u0001\u0000\u0000\u0000\u001c\u009b\u0001"+
		"\u0000\u0000\u0000\u001e\u009d\u0001\u0000\u0000\u0000 \u00a5\u0001\u0000"+
		"\u0000\u0000\"\u00ab\u0001\u0000\u0000\u0000$\u00ad\u0001\u0000\u0000"+
		"\u0000&\u00af\u0001\u0000\u0000\u0000(\u00b4\u0001\u0000\u0000\u0000*"+
		"\u00b6\u0001\u0000\u0000\u0000,\u00bd\u0001\u0000\u0000\u0000.\u00bf\u0001"+
		"\u0000\u0000\u000004\u0003\u0002\u0001\u000013\u0005#\u0000\u000021\u0001"+
		"\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u000078\u0005\u0000\u0000\u00018\u0001\u0001\u0000\u0000\u00009?\u0003"+
		"\u0004\u0002\u0000:?\u0003\u000e\u0007\u0000;?\u0003\u0012\t\u0000<?\u0003"+
		"\u0016\u000b\u0000=?\u0003\u0014\n\u0000>9\u0001\u0000\u0000\u0000>:\u0001"+
		"\u0000\u0000\u0000>;\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000"+
		">=\u0001\u0000\u0000\u0000?\u0003\u0001\u0000\u0000\u0000@D\u0003\u0006"+
		"\u0003\u0000AB\u0005\u0001\u0000\u0000BD\u0003,\u0016\u0000C@\u0001\u0000"+
		"\u0000\u0000CA\u0001\u0000\u0000\u0000D\u0005\u0001\u0000\u0000\u0000"+
		"EH\u0005\u0001\u0000\u0000FI\u0003\u001e\u000f\u0000GI\u0005%\u0000\u0000"+
		"HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JK\u0005\u0007\u0000\u0000KN\u0003\b\u0004\u0000LM\u0005\t\u0000"+
		"\u0000MO\u0003\f\u0006\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000"+
		"\u0000O\u0007\u0001\u0000\u0000\u0000PQ\u0003\n\u0005\u0000Q\t\u0001\u0000"+
		"\u0000\u0000RW\u0003\u0018\f\u0000ST\u0005\"\u0000\u0000TV\u0003\u0018"+
		"\f\u0000US\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000X\u000b\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000Z_\u0003,\u0016\u0000[\\\u0005\r\u0000\u0000"+
		"\\^\u0003,\u0016\u0000][\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000"+
		"_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\r\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000bc\u0005\u0002\u0000\u0000cd\u0005\u0005"+
		"\u0000\u0000de\u0003\u0018\f\u0000ef\u0005&\u0000\u0000fk\u0003\u0010"+
		"\b\u0000gh\u0005\"\u0000\u0000hj\u0003\u0010\b\u0000ig\u0001\u0000\u0000"+
		"\u0000jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000ln\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0005"+
		"\'\u0000\u0000o\u000f\u0001\u0000\u0000\u0000pq\u0003 \u0010\u0000qr\u0003"+
		"\"\u0011\u0000r\u0011\u0001\u0000\u0000\u0000st\u0005\u0003\u0000\u0000"+
		"tu\u0005\u000b\u0000\u0000uz\u0003\u0018\f\u0000vw\u0005&\u0000\u0000"+
		"wx\u0003\u001e\u000f\u0000xy\u0005\'\u0000\u0000y{\u0001\u0000\u0000\u0000"+
		"zv\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000"+
		"\u0000|}\u0005\n\u0000\u0000}~\u0005&\u0000\u0000~\u007f\u0003\u001a\r"+
		"\u0000\u007f\u0080\u0005\'\u0000\u0000\u0080\u0013\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005\u0010\u0000\u0000\u0082\u0083\u0005\u0005\u0000\u0000"+
		"\u0083\u0084\u0003\u0018\f\u0000\u0084\u0085\u0005\u0011\u0000\u0000\u0085"+
		"\u0088\u0003.\u0017\u0000\u0086\u0087\u0005\t\u0000\u0000\u0087\u0089"+
		"\u0003\f\u0006\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u0015\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"\u0004\u0000\u0000\u008b\u008c\u0005\u0007\u0000\u0000\u008c\u008f\u0003"+
		"\u0018\f\u0000\u008d\u008e\u0005\t\u0000\u0000\u008e\u0090\u0003\f\u0006"+
		"\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000"+
		"\u0000\u0090\u0017\u0001\u0000\u0000\u0000\u0091\u0092\u0005-\u0000\u0000"+
		"\u0092\u0019\u0001\u0000\u0000\u0000\u0093\u0098\u0003\u001c\u000e\u0000"+
		"\u0094\u0095\u0005\"\u0000\u0000\u0095\u0097\u0003\u001c\u000e\u0000\u0096"+
		"\u0094\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u001b\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0007\u0000\u0000\u0000\u009c\u001d\u0001\u0000\u0000\u0000\u009d"+
		"\u00a2\u0003 \u0010\u0000\u009e\u009f\u0005\"\u0000\u0000\u009f\u00a1"+
		"\u0003 \u0010\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u001f\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005-\u0000\u0000\u00a6!\u0001\u0000\u0000"+
		"\u0000\u00a7\u00ac\u0003$\u0012\u0000\u00a8\u00ac\u0003&\u0013\u0000\u00a9"+
		"\u00ac\u0003(\u0014\u0000\u00aa\u00ac\u0003*\u0015\u0000\u00ab\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a8\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac#\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0005\u001e\u0000\u0000\u00ae%\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005\u001f\u0000\u0000\u00b0\u00b1\u0005&\u0000\u0000"+
		"\u00b1\u00b2\u0005)\u0000\u0000\u00b2\u00b3\u0005\'\u0000\u0000\u00b3"+
		"\'\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005 \u0000\u0000\u00b5)\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0005!\u0000\u0000\u00b7+\u0001\u0000\u0000"+
		"\u0000\u00b8\u00be\u0003.\u0017\u0000\u00b9\u00ba\u0005&\u0000\u0000\u00ba"+
		"\u00bb\u0003,\u0016\u0000\u00bb\u00bc\u0005\'\u0000\u0000\u00bc\u00be"+
		"\u0001\u0000\u0000\u0000\u00bd\u00b8\u0001\u0000\u0000\u0000\u00bd\u00b9"+
		"\u0001\u0000\u0000\u0000\u00be-\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003"+
		" \u0010\u0000\u00c0\u00c1\u0005(\u0000\u0000\u00c1\u00c2\u0003\u001c\u000e"+
		"\u0000\u00c2/\u0001\u0000\u0000\u0000\u000f4>CHNW_kz\u0088\u008f\u0098"+
		"\u00a2\u00ab\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}