/* Generated By:JavaCC: Do not edit this line. DecoderTokenManager.java */
package robotinterface.algorithm.parser.decoder;
import java.util.Stack;
import org.nfunk.jep.JEP;
import robotinterface.algorithm.parser.FunctionToken;
import robotinterface.algorithm.procedure.*;
import robotinterface.algorithm.parser.Parser;
import robotinterface.algorithm.parser.parameterparser.Argument;
import robotinterface.algorithm.parser.parameterparser.ParameterParser;
import robotinterface.gui.panels.editor.EditorPanel;
import robotinterface.interpreter.Get;
import robotinterface.gui.panels.robot.RobotControlPanel;
import robotinterface.robot.device.Device;

/** Token Manager. */
public class DecoderTokenManager implements DecoderConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x10000000000000L) != 0L)
            return 4;
         if ((active0 & 0x7f80L) != 0L)
         {
            jjmatchedKind = 22;
            return 19;
         }
         if ((active0 & 0x8000000000L) != 0L)
            return 40;
         return -1;
      case 1:
         if ((active0 & 0x200L) != 0L)
            return 19;
         if ((active0 & 0x7d80L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 1;
            }
            return 19;
         }
         return -1;
      case 2:
         if ((active0 & 0x7d00L) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 2;
            return 19;
         }
         if ((active0 & 0x80L) != 0L)
            return 19;
         return -1;
      case 3:
         if ((active0 & 0x7800L) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 3;
            return 19;
         }
         if ((active0 & 0x500L) != 0L)
            return 19;
         return -1;
      case 4:
         if ((active0 & 0x6000L) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 4;
            return 19;
         }
         if ((active0 & 0x1800L) != 0L)
            return 19;
         return -1;
      case 5:
         if ((active0 & 0x2000L) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 5;
            return 19;
         }
         if ((active0 & 0x4000L) != 0L)
            return 19;
         return -1;
      case 6:
         if ((active0 & 0x2000L) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 6;
            return 19;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 57;
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 37:
         return jjStopAtPos(0, 43);
      case 38:
         jjmatchedKind = 40;
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 40:
         return jjStopAtPos(0, 44);
      case 41:
         return jjStopAtPos(0, 45);
      case 42:
         return jjStopAtPos(0, 38);
      case 43:
         jjmatchedKind = 36;
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 44:
         return jjStopAtPos(0, 51);
      case 45:
         jjmatchedKind = 37;
         return jjMoveStringLiteralDfa1_0(0x800000000L);
      case 46:
         return jjStartNfaWithStates_0(0, 52, 4);
      case 47:
         return jjStartNfaWithStates_0(0, 39, 40);
      case 59:
         return jjStopAtPos(0, 50);
      case 60:
         jjmatchedKind = 27;
         return jjMoveStringLiteralDfa1_0(0x20000020000000L);
      case 61:
         jjmatchedKind = 25;
         return jjMoveStringLiteralDfa1_0(0x10000000L);
      case 62:
         jjmatchedKind = 26;
         return jjMoveStringLiteralDfa1_0(0xc0000040000000L);
      case 91:
         return jjStopAtPos(0, 48);
      case 93:
         return jjStopAtPos(0, 49);
      case 94:
         return jjStopAtPos(0, 42);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 123:
         return jjStopAtPos(0, 46);
      case 124:
         jjmatchedKind = 41;
         return jjMoveStringLiteralDfa1_0(0x100000000L);
      case 125:
         return jjStopAtPos(0, 47);
      case 126:
         return jjStopAtPos(0, 56);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(1, 33);
         break;
      case 43:
         if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(1, 34);
         break;
      case 45:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(1, 35);
         break;
      case 60:
         if ((active0 & 0x20000000000000L) != 0L)
            return jjStopAtPos(1, 53);
         break;
      case 61:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 28);
         else if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 29);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(1, 31);
         break;
      case 62:
         if ((active0 & 0x40000000000000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000000000L);
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x80L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      case 102:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(1, 9, 19);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x100L);
      case 124:
         if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(1, 32);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStopAtPos(2, 55);
         break;
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x800L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x2100L);
      case 114:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(2, 7, 19);
         break;
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
      case 99:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(3, 8, 19);
         break;
      case 101:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 19);
         break;
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(4, 11, 19);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000L);
      case 107:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(4, 12, 19);
         break;
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(5, 14, 19);
         return jjMoveStringLiteralDfa6_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(7, 13, 19);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec3 = {
   0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
};
static final long[] jjbitVec4 = {
   0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec5 = {
   0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec6 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
};
static final long[] jjbitVec7 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
};
static final long[] jjbitVec8 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 51;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 40:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(46, 47);
                  else if (curChar == 47)
                     jjCheckNAddStates(0, 2);
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 9);
                  else if (curChar == 47)
                     jjAddStates(10, 11);
                  else if (curChar == 36)
                  {
                     if (kind > 22)
                        kind = 22;
                     jjCheckNAdd(19);
                  }
                  else if (curChar == 34)
                     jjCheckNAddStates(12, 14);
                  else if (curChar == 46)
                     jjCheckNAdd(4);
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAddTwoStates(1, 2);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAddStates(15, 17);
                  }
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(1, 2);
                  break;
               case 3:
                  if (curChar == 46)
                     jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(18, 20);
                  break;
               case 6:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(7);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(7, 8);
                  break;
               case 9:
                  if (curChar == 34)
                     jjCheckNAddStates(12, 14);
                  break;
               case 10:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(12, 14);
                  break;
               case 12:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(12, 14);
                  break;
               case 13:
                  if (curChar == 34 && kind > 21)
                     kind = 21;
                  break;
               case 14:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(21, 24);
                  break;
               case 15:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(12, 14);
                  break;
               case 16:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 17:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 18:
                  if (curChar != 36)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(19);
                  break;
               case 19:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(19);
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 9);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(21, 22);
                  break;
               case 22:
                  if (curChar != 46)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(25, 27);
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(25, 27);
                  break;
               case 25:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(26);
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(26, 8);
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(27, 28);
                  break;
               case 29:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(30);
                  break;
               case 30:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(30, 8);
                  break;
               case 31:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(28, 30);
                  break;
               case 33:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(34);
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(34, 8);
                  break;
               case 35:
                  if (curChar != 48)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddStates(15, 17);
                  break;
               case 37:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(37, 2);
                  break;
               case 38:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(38, 2);
                  break;
               case 39:
                  if (curChar == 47)
                     jjAddStates(10, 11);
                  break;
               case 41:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 42:
                  if ((0x2400L & l) != 0L && kind > 5)
                     kind = 5;
                  break;
               case 43:
                  if (curChar == 10 && kind > 5)
                     kind = 5;
                  break;
               case 44:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 43;
                  break;
               case 45:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(46, 47);
                  break;
               case 46:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(46, 47);
                  break;
               case 47:
                  if (curChar == 42)
                     jjCheckNAddStates(31, 33);
                  break;
               case 48:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(49, 47);
                  break;
               case 49:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(49, 47);
                  break;
               case 50:
                  if (curChar == 47 && kind > 6)
                     kind = 6;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 19:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(19);
                  break;
               case 2:
                  if ((0x100000001000L & l) != 0L && kind > 15)
                     kind = 15;
                  break;
               case 5:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(34, 35);
                  break;
               case 8:
                  if ((0x5000000050L & l) != 0L && kind > 19)
                     kind = 19;
                  break;
               case 10:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(12, 14);
                  break;
               case 11:
                  if (curChar == 92)
                     jjAddStates(36, 38);
                  break;
               case 12:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(12, 14);
                  break;
               case 24:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(39, 40);
                  break;
               case 28:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(41, 42);
                  break;
               case 32:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(43, 44);
                  break;
               case 36:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(37);
                  break;
               case 37:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(37, 2);
                  break;
               case 41:
                  jjAddStates(0, 2);
                  break;
               case 46:
                  jjCheckNAddTwoStates(46, 47);
                  break;
               case 48:
               case 49:
                  jjCheckNAddTwoStates(49, 47);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 19:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(19);
                  break;
               case 10:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(12, 14);
                  break;
               case 41:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(0, 2);
                  break;
               case 46:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(46, 47);
                  break;
               case 48:
               case 49:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(49, 47);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 51 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   41, 42, 44, 21, 22, 27, 28, 31, 32, 8, 40, 45, 10, 11, 13, 36, 
   38, 2, 4, 5, 8, 10, 11, 15, 13, 23, 24, 8, 31, 32, 8, 47, 
   48, 50, 6, 7, 12, 14, 16, 25, 26, 29, 30, 33, 34, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec6[i2] & l2) != 0L);
      case 51:
         return ((jjbitVec7[i2] & l2) != 0L);
      case 61:
         return ((jjbitVec8[i2] & l2) != 0L);
      default :
         if ((jjbitVec3[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, "\166\141\162", "\146\165\156\143", 
"\151\146", "\145\154\163\145", "\167\150\151\154\145", "\142\162\145\141\153", 
"\143\157\156\164\151\156\165\145", "\162\145\164\165\162\156", null, null, null, null, null, null, null, null, 
null, null, "\75", "\76", "\74", "\75\75", "\74\75", "\76\75", "\41\75", "\174\174", 
"\46\46", "\53\53", "\55\55", "\53", "\55", "\52", "\57", "\46", "\174", "\136", "\45", 
"\50", "\51", "\173", "\175", "\133", "\135", "\73", "\54", "\56", "\74\74", 
"\76\76", "\76\76\76", "\176", "\41", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3fffffffe68ffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
protected JavaCharStream input_stream;
private final int[] jjrounds = new int[51];
private final int[] jjstateSet = new int[102];
protected char curChar;
/** Constructor. */
public DecoderTokenManager(JavaCharStream stream){
   if (JavaCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public DecoderTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 51; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
