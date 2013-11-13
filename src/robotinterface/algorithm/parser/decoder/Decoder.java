/* Generated By:JavaCC: Do not edit this line. Decoder.java */
package robotinterface.algorithm.parser.decoder;
import robotinterface.algorithm.parser.FunctionToken;
import robotinterface.algorithm.procedure.*;
import robotinterface.algorithm.parser.Parser;
import robotinterface.gui.panels.code.CodeEditorPanel;

public class Decoder implements DecoderConstants {
  private Token mark = null;

  private boolean functionCall = false;

  private Token functionID = null;

  private String parameters = null;

  private Procedure last = null;

  public static void main(String [] args) throws ParseException
  {
    Decoder parser = new Decoder(System.in);
    Function f = parser.decode();
    System.out.println(Parser.encode(f));
  }

  private void mark()
  {
    mark = token;
  }

  private String getString()
  {
    if (mark == null) return null;
    StringBuilder sb = new StringBuilder();
    while (mark != token)
    {
      mark = mark.next;
      sb.append(' ').append(mark);
    }
    mark = null;
    if (sb.length() > 1)
    {
      return sb.substring(1);
    }
    else
    {
      return "";
    }
  }

  final public Function decode() throws ParseException {
  Token tFunction;
  Block block;
    jj_consume_token(FUNCTION);
    tFunction = jj_consume_token(IDENTIFIER);
    arguments();
    Function f = new Function(tFunction.image, null);
    block(f, false);
    {if (true) return f;}
    throw new Error("Missing return statement in function");
  }

  final public void arguments() throws ParseException {
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARIABLE:
      argumentList();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
  }

  final public void argumentList() throws ParseException {
    jj_consume_token(VARIABLE);
    simpleVariableDeclaration();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      jj_consume_token(VARIABLE);
      simpleVariableDeclaration();
    }
  }

  final public void simpleVariableDeclaration() throws ParseException {
    jj_consume_token(IDENTIFIER);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACKET:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(LBRACKET);
      jj_consume_token(RBRACKET);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      jj_consume_token(ASSIGN);
      variableInitialization();
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

  final public void variableDeclaration() throws ParseException {
    jj_consume_token(VARIABLE);
    simpleVariableDeclaration();
    label_3:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_3;
      }
      jj_consume_token(COMMA);
      simpleVariableDeclaration();
    }
  }

  final public void variableInitialization() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACKET:
      jj_consume_token(LBRACKET);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
      case LPAREN:
      case LBRACKET:
      case 55:
      case 56:
        variableInitialization();
        label_4:
        while (true) {
          if (jj_2_2(2)) {
            ;
          } else {
            break label_4;
          }
          jj_consume_token(COMMA);
          variableInitialization();
        }
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        jj_consume_token(COMMA);
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
      jj_consume_token(RBRACKET);
      break;
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
      literal();
      break;
    case IDENTIFIER:
    case INCR:
    case DECR:
    case PLUS:
    case MINUS:
    case LPAREN:
    case 55:
    case 56:
      expression();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void assignment() throws ParseException {
    PrimaryExpression();
    jj_consume_token(ASSIGN);
    variableInitialization();
  }

  final public void expression() throws ParseException {
    if (jj_2_3(2147483647)) {
      assignment();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
      case LPAREN:
      case 55:
      case 56:
        ConditionalOrExpression();
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void ConditionalOrExpression() throws ParseException {
    ConditionalAndExpression();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SC_OR:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      jj_consume_token(SC_OR);
      ConditionalAndExpression();
    }
  }

  final public void ConditionalAndExpression() throws ParseException {
    InclusiveOrExpression();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SC_AND:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_6;
      }
      jj_consume_token(SC_AND);
      InclusiveOrExpression();
    }
  }

  final public void InclusiveOrExpression() throws ParseException {
    ExclusiveOrExpression();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT_OR:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_7;
      }
      jj_consume_token(BIT_OR);
      ExclusiveOrExpression();
    }
  }

  final public void ExclusiveOrExpression() throws ParseException {
    AndExpression();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case XOR:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_8;
      }
      jj_consume_token(XOR);
      AndExpression();
    }
  }

  final public void AndExpression() throws ParseException {
    EqualityExpression();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT_AND:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_9;
      }
      jj_consume_token(BIT_AND);
      EqualityExpression();
    }
  }

  final public void EqualityExpression() throws ParseException {
    RelationalExpression();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQ:
      case NE:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQ:
        jj_consume_token(EQ);
        break;
      case NE:
        jj_consume_token(NE);
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      RelationalExpression();
    }
  }

  final public void RelationalExpression() throws ParseException {
    ShiftExpression();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GT:
      case LT:
      case LE:
      case GE:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LT:
        jj_consume_token(LT);
        break;
      case GT:
        jj_consume_token(GT);
        break;
      case LE:
        jj_consume_token(LE);
        break;
      case GE:
        jj_consume_token(GE);
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      ShiftExpression();
    }
  }

  final public void ShiftExpression() throws ParseException {
    AdditiveExpression();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 52:
      case 53:
      case 54:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_12;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 52:
        jj_consume_token(52);
        break;
      case 53:
        jj_consume_token(53);
        break;
      case 54:
        jj_consume_token(54);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      AdditiveExpression();
    }
  }

  final public void AdditiveExpression() throws ParseException {
    MultiplicativeExpression();
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_13;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      MultiplicativeExpression();
    }
  }

  final public void MultiplicativeExpression() throws ParseException {
    UnaryExpression();
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case SLASH:
      case REM:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_14;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
        jj_consume_token(STAR);
        break;
      case SLASH:
        jj_consume_token(SLASH);
        break;
      case REM:
        jj_consume_token(REM);
        break;
      default:
        jj_la1[22] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      UnaryExpression();
    }
  }

  final public void UnaryExpression() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      UnaryExpression();
      break;
    case INCR:
      PreIncrementExpression();
      break;
    case DECR:
      PreDecrementExpression();
      break;
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case 55:
    case 56:
      UnaryExpressionNotPlusMinus();
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void PreIncrementExpression() throws ParseException {
    jj_consume_token(INCR);
    PrimaryExpression();
  }

  final public void PreDecrementExpression() throws ParseException {
    jj_consume_token(DECR);
    PrimaryExpression();
  }

  final public void UnaryExpressionNotPlusMinus() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 55:
    case 56:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 55:
        jj_consume_token(55);
        break;
      case 56:
        jj_consume_token(56);
        break;
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      UnaryExpression();
      break;
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case LPAREN:
      PostfixExpression();
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void PostfixExpression() throws ParseException {
    PrimaryExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INCR:
    case DECR:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCR:
        jj_consume_token(INCR);
        break;
      case DECR:
        jj_consume_token(DECR);
        break;
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[28] = jj_gen;
      ;
    }
  }

  final public void PrimaryExpression() throws ParseException {
    primaryPrefix();
    label_15:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
      case LBRACKET:
      case DOT:
        ;
        break;
      default:
        jj_la1[29] = jj_gen;
        break label_15;
      }
      primarySuffix();
    }
  }

  final public void primaryPrefix() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
      literal();
      break;
    case IDENTIFIER:
      functionID = jj_consume_token(IDENTIFIER);
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      expression();
      jj_consume_token(RPAREN);
      break;
    default:
      jj_la1[30] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void literal() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      jj_consume_token(INTEGER_LITERAL);
      break;
    case FLOATING_POINT_LITERAL:
      jj_consume_token(FLOATING_POINT_LITERAL);
      break;
    case STRING_LITERAL:
      jj_consume_token(STRING_LITERAL);
      break;
    default:
      jj_la1[31] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void primarySuffix() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACKET:
      jj_consume_token(LBRACKET);
      expression();
      jj_consume_token(RBRACKET);
      break;
    case DOT:
      jj_consume_token(DOT);
      jj_consume_token(IDENTIFIER);
      break;
    case LPAREN:
      mark = jj_consume_token(LPAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
        name();
        label_16:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMA:
            ;
            break;
          default:
            jj_la1[32] = jj_gen;
            break label_16;
          }
          jj_consume_token(COMMA);
          name();
        }
        break;
      default:
        jj_la1[33] = jj_gen;
        ;
      }
    if (functionID != null)
    {
      parameters = getString();
      functionCall = true;
    }
    else
    {
      functionID = null;
      parameters = null;
      functionCall = false;
    }
      jj_consume_token(RPAREN);
      break;
    default:
      jj_la1[34] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void name() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
      literal();
      break;
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      break;
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void block(Block block, boolean add) throws ParseException {
  if (add)
  {
    Block b = new Block();
    block.add(b);
    block = b;
  }
    jj_consume_token(LBRACE);
    label_17:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VARIABLE:
      case IF:
      case WHILE:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
      case LPAREN:
      case LBRACE:
      case SEMICOLON:
      case 55:
      case 56:
        ;
        break;
      default:
        jj_la1[36] = jj_gen;
        break label_17;
      }
      statement(block);
    }
    jj_consume_token(RBRACE);
    last = null;
  }

  final public void statement(Block block) throws ParseException {
  boolean add =
  (
    block != null && block.getClass() == Block.class
  )
  ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
      block(block, add);
      break;
    case SEMICOLON:
      jj_consume_token(SEMICOLON);
      break;
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case INCR:
    case DECR:
    case PLUS:
    case MINUS:
    case LPAREN:
    case 55:
    case 56:
    mark();
      expression();
    if (block != null)
    {
      if (functionCall)
      {
        boolean error = true;
        for (FunctionToken ftoken : CodeEditorPanel.getFunctionTokens())
        {
          if (ftoken.getToken().equals(functionID.toString()))
          {
            parameters = parameters.trim();
            block.add(ftoken.createInstance(parameters));
            error = false;
            break;
          }
        }

                if (error)
                {
                        {if (true) throw new ParseException("Invalid function call: " + functionID.toString());}
        }
        last = null;
      }
      else
      {
        if (last == null || last.getClass() != Procedure.class)
        {
          last = new Procedure(getString());
          block.add(last);
        }
        else
        {
          last.append(getString());
        }
      }
      functionCall = false;
    }
      break;
    case IF:
      ifStatement(block);
      break;
    case WHILE:
      whileStatement(block);
      break;
    case VARIABLE:
    mark();
      variableDeclaration();
    if (block != null)
    {
      if (last == null || last.getClass() != Procedure.class)
      {
        last = new Procedure(getString());
        block.add(last);
      }
      else
      {
        last.append(getString());
      }
    }
      break;
    default:
      jj_la1[37] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ifStatement(Block b) throws ParseException {
  String ex;
  If i = new If();
  last = i;
  Block bTrue = i.getBlockTrue(), bFalse = i.getBlockFalse();
    jj_consume_token(IF);
    mark = jj_consume_token(LPAREN);
    expression();
    ex = getString();
    jj_consume_token(RPAREN);
    statement(bTrue);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      statement(bFalse);
      break;
    default:
      jj_la1[38] = jj_gen;
      ;
    }
    i.setProcedure(ex);
    b.add(i);
  }

  final public void whileStatement(Block b) throws ParseException {
  While w = new While();
  last = w;
  String ex;
    jj_consume_token(WHILE);
    mark = jj_consume_token(LPAREN);
    expression();
    ex = getString();
    jj_consume_token(RPAREN);
    statement(w);
    w.setProcedure(ex);
    b.add(w);
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_3R_46() {
    if (jj_scan_token(SC_AND)) return true;
    if (jj_3R_42()) return true;
    return false;
  }

  private boolean jj_3R_66() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(37)) {
    jj_scanpos = xsp;
    if (jj_scan_token(38)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) return true;
    }
    }
    if (jj_3R_60()) return true;
    return false;
  }

  private boolean jj_3R_39() {
    if (jj_3R_42()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_46()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_58() {
    if (jj_3R_60()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_66()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_41() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_40()) return true;
    return false;
  }

  private boolean jj_3R_43() {
    if (jj_scan_token(SC_OR)) return true;
    if (jj_3R_39()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_20()) return true;
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_38() {
    if (jj_3R_40()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_41()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_37() {
    if (jj_3R_39()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_43()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_35() {
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_38()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_61() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_scan_token(36)) return true;
    }
    if (jj_3R_58()) return true;
    return false;
  }

  private boolean jj_3R_34() {
    if (jj_scan_token(DOT)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3R_30() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_33()) {
    jj_scanpos = xsp;
    if (jj_3R_34()) {
    jj_scanpos = xsp;
    if (jj_3R_35()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_33() {
    if (jj_scan_token(LBRACKET)) return true;
    if (jj_3R_27()) return true;
    if (jj_scan_token(RBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_32() {
    if (jj_3R_37()) return true;
    return false;
  }

  private boolean jj_3R_56() {
    if (jj_3R_58()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_61()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_31() {
    if (jj_3R_36()) return true;
    return false;
  }

  private boolean jj_3R_27() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) return true;
    }
    return false;
  }

  private boolean jj_3R_26() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(13)) {
    jj_scanpos = xsp;
    if (jj_scan_token(17)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_36() {
    if (jj_3R_20()) return true;
    if (jj_scan_token(ASSIGN)) return true;
    if (jj_3R_19()) return true;
    return false;
  }

  private boolean jj_3R_59() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(52)) {
    jj_scanpos = xsp;
    if (jj_scan_token(53)) {
    jj_scanpos = xsp;
    if (jj_scan_token(54)) return true;
    }
    }
    if (jj_3R_56()) return true;
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_27()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_23() {
    if (jj_3R_27()) return true;
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_3R_26()) return true;
    return false;
  }

  private boolean jj_3R_28() {
    if (jj_3R_26()) return true;
    return false;
  }

  private boolean jj_3R_24() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_scan_token(20)) {
    jj_scanpos = xsp;
    if (jj_3R_29()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_54() {
    if (jj_3R_56()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_59()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_19()) return true;
    return false;
  }

  private boolean jj_3R_48() {
    if (jj_3R_19()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_2()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_25() {
    if (jj_3R_30()) return true;
    return false;
  }

  private boolean jj_3R_19() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_21() {
    if (jj_scan_token(LBRACKET)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_48()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(50)) jj_scanpos = xsp;
    if (jj_scan_token(RBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_20() {
    if (jj_3R_24()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_25()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_57() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(26)) {
    jj_scanpos = xsp;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(28)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) return true;
    }
    }
    }
    if (jj_3R_54()) return true;
    return false;
  }

  private boolean jj_3R_73() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(33)) {
    jj_scanpos = xsp;
    if (jj_scan_token(34)) return true;
    }
    return false;
  }

  private boolean jj_3R_52() {
    if (jj_3R_54()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_57()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3R_72() {
    if (jj_3R_20()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_73()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_71() {
    if (jj_3R_72()) return true;
    return false;
  }

  private boolean jj_3R_55() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(27)) {
    jj_scanpos = xsp;
    if (jj_scan_token(30)) return true;
    }
    if (jj_3R_52()) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3R_50() {
    if (jj_3R_52()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_55()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_70() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(55)) {
    jj_scanpos = xsp;
    if (jj_scan_token(56)) return true;
    }
    if (jj_3R_60()) return true;
    return false;
  }

  private boolean jj_3R_69() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_70()) {
    jj_scanpos = xsp;
    if (jj_3R_71()) return true;
    }
    return false;
  }

  private boolean jj_3R_53() {
    if (jj_scan_token(BIT_AND)) return true;
    if (jj_3R_50()) return true;
    return false;
  }

  private boolean jj_3R_68() {
    if (jj_scan_token(DECR)) return true;
    if (jj_3R_20()) return true;
    return false;
  }

  private boolean jj_3R_47() {
    if (jj_3R_50()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_53()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_67() {
    if (jj_scan_token(INCR)) return true;
    if (jj_3R_20()) return true;
    return false;
  }

  private boolean jj_3R_51() {
    if (jj_scan_token(XOR)) return true;
    if (jj_3R_47()) return true;
    return false;
  }

  private boolean jj_3R_45() {
    if (jj_3R_47()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_51()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_65() {
    if (jj_3R_69()) return true;
    return false;
  }

  private boolean jj_3R_64() {
    if (jj_3R_68()) return true;
    return false;
  }

  private boolean jj_3R_63() {
    if (jj_3R_67()) return true;
    return false;
  }

  private boolean jj_3R_40() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_44()) {
    jj_scanpos = xsp;
    if (jj_scan_token(20)) return true;
    }
    return false;
  }

  private boolean jj_3R_44() {
    if (jj_3R_26()) return true;
    return false;
  }

  private boolean jj_3R_49() {
    if (jj_scan_token(BIT_OR)) return true;
    if (jj_3R_45()) return true;
    return false;
  }

  private boolean jj_3R_62() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_scan_token(36)) return true;
    }
    if (jj_3R_60()) return true;
    return false;
  }

  private boolean jj_3R_60() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_62()) {
    jj_scanpos = xsp;
    if (jj_3R_63()) {
    jj_scanpos = xsp;
    if (jj_3R_64()) {
    jj_scanpos = xsp;
    if (jj_3R_65()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_42() {
    if (jj_3R_45()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_49()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  /** Generated Token Manager. */
  public DecoderTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[39];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20,0x0,0x0,0x1000000,0x1a2000,0x0,0x1a2000,0x1a2000,0x80000000,0x0,0x0,0x0,0x0,0x48000000,0x48000000,0x36000000,0x36000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1a2000,0x0,0x1a2000,0x0,0x0,0x0,0x1a2000,0xa2000,0x0,0x1a2000,0x0,0x1a2000,0x1a22a0,0x1a22a0,0x100,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x40000,0x8000,0x0,0x180881e,0x40000,0x180881e,0x180081e,0x0,0x1,0x100,0x200,0x80,0x0,0x0,0x0,0x0,0x700000,0x700000,0x18,0x18,0x460,0x460,0x18,0x180081e,0x1800000,0x1800800,0x6,0x6,0x88800,0x800,0x0,0x40000,0x0,0x88800,0x0,0x182281e,0x182281e,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[3];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Decoder(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Decoder(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new DecoderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Decoder(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new DecoderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Decoder(DecoderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(DecoderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[57];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 39; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 57; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 3; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
