/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package com.haskforce.frege.lang.lexer;

import java.util.regex.*;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;

import com.haskforce.frege.lang.psi.FregeTokenTypes;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>_FregeParsingLexer.flex</tt>
 */
public class _FregeParsingLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int MAIN = 2;
  public static final int INDENT = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [11, 6, 4]
   * Total runtime size is 13728 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>10]<<6)|((ch>>4)&0x3f)]<<4)|(ch&0xf)];
  }

  /* The ZZ_CMAP_Z table has 1088 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\11\1\12\1\13\6\14\1\15\23\14\1\16"+
    "\1\14\1\17\1\20\12\14\1\21\10\11\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
    "\32\1\11\1\33\1\34\2\11\1\14\1\35\3\11\1\36\10\11\1\37\1\40\20\11\1\41\2\11"+
    "\1\42\5\11\1\43\4\11\1\44\1\45\4\11\51\14\1\46\3\14\1\47\1\50\4\14\1\51\12"+
    "\11\1\52\u0381\11");

  /* The ZZ_CMAP_Y table has 2752 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\1\1\10\1\11\1\12\1\13\1\12\1\13\34\12\1"+
    "\14\1\15\1\16\10\1\1\17\1\20\1\12\1\21\4\12\1\22\10\12\1\23\12\12\1\24\1\12"+
    "\1\25\1\24\1\12\1\26\4\1\1\12\1\27\1\30\2\1\2\12\1\27\1\1\1\31\1\24\5\12\1"+
    "\32\1\33\1\34\1\1\1\35\1\12\1\1\1\36\5\12\1\37\1\40\1\41\1\12\1\27\1\42\1"+
    "\12\1\43\1\44\1\1\1\12\1\45\4\1\1\12\1\46\4\1\1\47\2\12\1\50\1\1\1\51\1\52"+
    "\1\24\1\53\1\54\1\55\1\56\1\57\1\60\1\52\1\15\1\61\1\54\1\55\1\62\1\1\1\63"+
    "\1\64\1\65\1\66\1\21\1\55\1\67\1\1\1\70\1\52\1\71\1\72\1\54\1\55\1\67\1\1"+
    "\1\60\1\52\1\40\1\73\1\74\1\75\1\76\1\1\1\70\1\64\1\1\1\77\1\35\1\55\1\50"+
    "\1\1\1\100\1\52\1\1\1\77\1\35\1\55\1\101\1\1\1\57\1\52\1\102\1\77\1\35\1\12"+
    "\1\103\1\57\1\104\1\52\1\105\1\106\1\107\1\12\1\110\1\111\1\1\1\64\1\1\1\24"+
    "\2\12\1\112\1\111\1\113\2\1\1\114\1\115\1\116\1\117\1\120\1\121\2\1\1\70\1"+
    "\1\1\113\1\1\1\122\1\12\1\123\1\1\1\124\7\1\2\12\1\27\1\104\1\113\1\125\1"+
    "\126\1\127\1\130\1\113\2\12\1\131\2\12\1\132\24\12\1\133\1\134\2\12\1\133"+
    "\2\12\1\135\1\136\1\13\3\12\1\136\3\12\1\27\2\1\1\12\1\1\5\12\1\137\1\24\45"+
    "\12\1\140\1\12\1\24\1\27\4\12\1\27\1\141\1\142\1\15\1\12\1\15\1\12\1\15\1"+
    "\142\1\70\3\12\1\143\1\1\1\144\1\113\2\1\1\113\5\12\1\26\2\12\1\145\4\12\1"+
    "\37\1\12\1\146\2\1\1\64\1\12\1\147\1\46\2\12\1\150\1\12\1\76\1\113\2\1\1\12"+
    "\1\111\3\12\1\46\2\1\2\113\1\151\5\1\1\106\2\12\1\143\1\152\1\113\2\1\1\153"+
    "\1\12\1\154\1\41\2\12\1\37\1\1\2\12\1\143\1\1\1\155\1\41\1\12\1\147\6\1\1"+
    "\156\1\157\14\12\4\1\21\12\1\137\2\12\1\137\1\160\1\12\1\147\3\12\1\161\1"+
    "\162\1\163\1\123\1\162\7\1\1\164\1\1\1\123\6\1\1\165\1\166\1\167\1\170\1\171"+
    "\3\1\1\172\147\1\2\12\1\146\2\12\1\146\10\12\1\173\1\174\2\12\1\131\3\12\1"+
    "\175\1\1\1\12\1\111\4\176\4\1\1\104\35\1\1\177\2\1\1\200\1\24\4\12\1\201\1"+
    "\24\4\12\1\132\1\106\1\12\1\147\1\24\4\12\1\146\1\1\1\12\1\27\3\1\1\12\40"+
    "\1\133\12\1\37\4\1\135\12\1\37\2\1\10\12\1\123\4\1\2\12\1\147\20\12\1\123"+
    "\1\12\1\202\1\1\2\12\1\146\1\104\1\12\1\147\4\12\1\37\2\1\1\203\1\204\5\12"+
    "\1\205\1\12\1\147\1\26\3\1\1\203\1\206\1\12\1\30\1\1\3\12\1\143\1\204\2\12"+
    "\1\143\1\1\1\113\1\1\1\207\1\41\1\12\1\37\1\12\1\111\1\1\1\12\1\123\1\47\2"+
    "\12\1\30\1\104\1\113\1\210\1\211\2\12\1\45\1\1\1\212\1\113\1\12\1\213\3\12"+
    "\1\214\1\215\1\216\1\27\1\65\1\217\1\220\1\176\2\12\1\132\1\37\7\12\1\30\1"+
    "\113\72\12\1\143\1\12\1\221\2\12\1\150\20\1\26\12\1\147\6\12\1\76\2\1\1\111"+
    "\1\222\1\55\1\223\1\224\6\12\1\15\1\1\1\153\25\12\1\147\1\1\4\12\1\204\2\12"+
    "\1\26\2\1\1\150\7\1\1\210\7\12\1\123\1\1\1\113\1\24\1\27\1\24\1\27\1\225\4"+
    "\12\1\146\1\226\1\227\2\1\1\230\1\12\1\13\1\231\2\147\2\1\7\12\1\27\30\1\1"+
    "\12\1\123\3\12\1\70\2\1\2\12\1\1\1\12\1\232\2\12\1\37\1\12\1\147\2\12\1\233"+
    "\3\1\11\12\1\147\1\113\5\1\2\12\1\26\3\12\1\143\11\1\23\12\1\111\1\12\1\37"+
    "\1\26\11\1\1\234\2\12\1\235\1\12\1\37\1\12\1\111\1\12\1\146\4\1\1\12\1\236"+
    "\1\12\1\37\1\12\1\76\4\1\3\12\1\237\4\1\1\70\1\240\1\12\1\143\2\1\1\12\1\123"+
    "\1\12\1\123\2\1\1\122\1\12\1\46\1\1\3\12\1\37\1\12\1\37\1\12\1\30\1\12\1\15"+
    "\6\1\4\12\1\45\3\1\3\12\1\30\3\12\1\30\60\1\1\153\2\12\1\26\2\1\1\64\1\1\1"+
    "\153\2\12\2\1\1\12\1\45\1\113\1\153\1\12\1\111\1\64\1\1\2\12\1\241\1\153\2"+
    "\12\1\30\1\242\1\243\2\1\1\12\1\21\1\150\5\1\1\244\1\245\1\45\2\12\1\146\1"+
    "\1\1\113\1\72\1\54\1\55\1\67\1\1\1\246\1\15\21\1\3\12\1\1\1\247\1\113\12\1"+
    "\2\12\1\146\2\1\1\250\2\1\3\12\1\1\1\251\1\113\2\1\2\12\1\27\1\1\1\113\3\1"+
    "\1\12\1\76\1\1\1\113\26\1\4\12\1\113\1\104\34\1\3\12\1\45\20\1\71\12\1\76"+
    "\16\1\14\12\1\143\53\1\2\12\1\146\75\1\44\12\1\111\33\1\43\12\1\45\1\12\1"+
    "\146\1\113\6\1\1\12\1\147\1\1\3\12\1\1\1\143\1\113\1\153\1\252\1\12\67\1\4"+
    "\12\1\46\1\70\3\1\1\153\6\1\1\15\77\1\6\12\1\27\1\123\1\45\1\76\66\1\5\12"+
    "\1\210\3\12\1\142\1\253\1\254\1\255\3\12\1\256\1\257\1\12\1\260\1\261\1\35"+
    "\24\12\1\262\1\12\1\35\1\132\1\12\1\132\1\12\1\210\1\12\1\210\1\146\1\12\1"+
    "\146\1\12\1\55\1\12\1\55\1\12\1\263\3\264\14\12\1\46\123\1\1\255\1\12\1\265"+
    "\1\266\1\267\1\270\1\271\1\272\1\273\1\150\1\274\1\150\24\1\55\12\1\111\2"+
    "\1\103\12\1\46\15\12\1\147\150\12\1\15\25\1\41\12\1\147\36\1");

  /* The ZZ_CMAP_A table has 3024 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\5\1\12\4\5\1\14\1\53\1\54\2\5\1\56\1"+
    "\4\1\11\1\5\12\10\1\21\1\55\1\5\1\60\3\5\32\16\1\51\1\13\1\52\1\5\1\15\1\57"+
    "\1\24\1\47\1\25\1\33\1\30\1\42\1\27\1\43\1\36\1\16\1\26\1\35\1\31\1\40\1\32"+
    "\1\23\1\16\1\37\1\44\1\22\1\34\1\41\1\45\1\50\1\46\1\16\1\6\1\5\1\7\1\5\13"+
    "\0\1\16\11\0\1\20\1\16\4\0\1\16\5\0\27\16\1\0\12\16\4\0\14\16\16\0\5\16\7"+
    "\0\1\16\1\0\1\16\1\0\5\16\1\0\2\16\2\0\4\16\1\0\1\16\6\0\1\16\1\0\3\16\1\0"+
    "\1\16\1\0\4\16\1\0\23\16\1\0\13\16\10\0\6\16\1\0\26\16\2\0\1\16\6\0\10\16"+
    "\10\0\13\16\5\0\3\16\15\0\12\17\4\0\6\16\1\0\1\16\17\0\2\16\7\0\2\16\12\17"+
    "\3\16\2\0\2\16\1\0\16\16\15\0\11\16\13\0\1\16\16\0\12\17\6\16\4\0\2\16\4\0"+
    "\1\16\5\0\6\16\4\0\1\16\11\0\1\16\3\0\1\16\7\0\11\16\7\0\5\16\17\0\26\16\3"+
    "\0\1\16\2\0\1\16\7\0\12\16\4\0\12\17\1\16\4\0\10\16\2\0\2\16\2\0\26\16\1\0"+
    "\7\16\1\0\1\16\3\0\4\16\3\0\1\16\20\0\1\16\15\0\2\16\1\0\1\16\5\0\6\16\4\0"+
    "\2\16\1\0\2\16\1\0\2\16\1\0\2\16\17\0\4\16\1\0\1\16\7\0\12\17\2\0\3\16\20"+
    "\0\11\16\1\0\2\16\1\0\2\16\1\0\5\16\3\0\1\16\2\0\1\16\30\0\1\16\13\0\10\16"+
    "\2\0\1\16\3\0\1\16\1\0\6\16\3\0\3\16\1\0\4\16\3\0\2\16\1\0\1\16\1\0\2\16\3"+
    "\0\2\16\3\0\3\16\3\0\14\16\13\0\10\16\1\0\2\16\10\0\3\16\5\0\4\16\1\0\5\16"+
    "\3\0\1\16\3\0\2\16\15\0\13\16\2\0\1\16\21\0\1\16\12\0\6\16\5\0\22\16\3\0\10"+
    "\16\1\0\11\16\1\0\1\16\2\0\7\16\11\0\1\16\1\0\2\16\14\0\12\17\7\0\2\16\1\0"+
    "\1\16\2\0\2\16\1\0\1\16\2\0\1\16\6\0\4\16\1\0\7\16\1\0\3\16\1\0\1\16\1\0\1"+
    "\16\2\0\2\16\1\0\4\16\1\0\2\16\11\0\1\16\2\0\5\16\1\0\1\16\11\0\12\17\2\0"+
    "\14\16\1\0\24\16\13\0\5\16\3\0\6\16\4\0\4\16\3\0\1\16\3\0\2\16\7\0\3\16\4"+
    "\0\15\16\14\0\1\16\1\0\6\16\1\0\1\16\5\0\1\16\2\0\13\16\1\0\15\16\1\0\4\16"+
    "\2\0\7\16\1\0\1\16\1\0\4\16\2\0\1\16\1\0\4\16\2\0\7\16\1\0\1\16\1\0\4\16\2"+
    "\0\16\16\2\0\6\16\2\0\15\16\2\0\1\16\1\0\10\16\7\0\15\16\1\0\6\16\23\0\1\16"+
    "\4\0\1\16\3\0\11\16\1\0\1\16\5\0\17\16\1\0\16\16\2\0\14\16\13\0\1\16\15\0"+
    "\7\16\7\0\16\16\15\0\2\16\12\17\3\0\3\16\11\0\4\16\1\0\4\16\3\0\2\16\11\0"+
    "\10\16\1\0\1\16\1\0\1\16\1\0\1\16\1\0\6\16\1\0\7\16\1\0\1\16\3\0\3\16\1\0"+
    "\7\16\3\0\4\16\2\0\6\16\5\0\1\16\15\0\1\16\2\0\1\16\4\0\1\16\2\0\12\16\1\0"+
    "\1\16\3\0\5\16\6\0\1\16\1\0\1\16\1\0\1\16\1\0\4\16\1\0\13\16\2\0\4\16\5\0"+
    "\5\16\4\0\1\16\4\0\2\16\13\0\5\16\6\0\4\16\3\0\2\16\14\0\10\16\7\0\10\16\1"+
    "\0\7\16\6\0\2\16\12\0\5\16\5\0\2\16\3\0\7\16\6\0\3\16\12\17\2\16\13\0\11\16"+
    "\2\0\27\16\2\0\7\16\1\0\3\16\1\0\4\16\1\0\4\16\2\0\6\16\3\0\1\16\1\0\1\16"+
    "\2\0\5\16\1\0\12\16\12\17\5\16\1\0\3\16\1\0\10\16\4\0\7\16\3\0\1\16\3\0\2"+
    "\16\1\0\1\16\3\0\2\16\2\0\5\16\2\0\1\16\1\0\1\16\30\0\3\16\3\0\6\16\2\0\6"+
    "\16\2\0\6\16\11\0\7\16\4\0\5\16\3\0\5\16\5\0\1\16\1\0\10\16\1\0\5\16\1\0\1"+
    "\16\1\0\2\16\1\0\2\16\1\0\12\16\6\0\12\16\2\0\6\16\2\0\6\16\2\0\6\16\2\0\3"+
    "\16\3\0\14\16\1\0\16\16\1\0\2\16\1\0\2\16\1\0\10\16\6\0\4\16\4\0\16\16\2\0"+
    "\1\16\1\0\14\16\1\0\2\16\3\0\1\16\2\0\4\16\1\0\2\16\12\0\10\16\6\0\6\16\1"+
    "\0\3\16\1\0\12\16\3\0\1\16\12\0\4\16\13\0\12\17\1\16\1\0\1\16\3\0\7\16\1\0"+
    "\1\16\1\0\4\16\1\0\17\16\1\0\2\16\14\0\3\16\4\0\2\16\1\0\1\16\20\0\4\16\10"+
    "\0\1\16\13\0\10\16\5\0\3\16\2\0\1\16\2\0\2\16\2\0\4\16\1\0\14\16\1\0\1\16"+
    "\1\0\7\16\1\0\21\16\1\0\4\16\2\0\10\16\1\0\7\16\1\0\14\16\1\0\4\16\1\0\5\16"+
    "\1\0\1\16\3\0\14\16\2\0\13\16\1\0\10\16\2\0\22\17\1\0\2\16\1\0\1\16\2\0\1"+
    "\16\1\0\12\16\1\0\4\16\1\0\1\16\1\0\1\16\6\0\1\16\4\0\1\16\1\0\1\16\1\0\1"+
    "\16\1\0\3\16\1\0\2\16\1\0\1\16\2\0\1\16\1\0\1\16\1\0\1\16\1\0\1\16\1\0\1\16"+
    "\1\0\2\16\1\0\1\16\2\0\4\16\1\0\7\16\1\0\4\16\1\0\4\16\1\0\1\16\1\0\12\16"+
    "\1\0\5\16\1\0\3\16\1\0\5\16\1\0\5\16");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\2\3\1\4\1\2\1\5\1\6"+
    "\1\7\1\10\2\11\1\12\1\13\1\11\15\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\2\25\2\24\4\0\1\26\3\0\14\13\1\27\2\13"+
    "\1\30\2\13\1\31\1\32\4\13\3\33\1\0\1\34"+
    "\1\7\1\26\2\35\21\13\1\36\7\13\2\37\1\34"+
    "\1\40\1\41\1\13\1\42\1\13\1\43\4\13\1\44"+
    "\1\13\1\45\2\13\1\46\16\13\1\47\4\13\1\50"+
    "\2\13\1\51\1\13\1\52\1\53\1\13\1\54\3\13"+
    "\1\55\1\13\1\56\1\57\1\60\1\61\1\13\1\62"+
    "\1\63\1\64\1\13\1\65\1\13\1\66\2\13\1\67"+
    "\1\70\1\71";

  private static int [] zzUnpackAction() {
    int [] result = new int[179];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\223\0\304\0\365\0\u0126"+
    "\0\u0157\0\u0188\0\223\0\u01b9\0\223\0\u01ea\0\u021b\0\u024c"+
    "\0\u024c\0\223\0\u027d\0\u02ae\0\u02df\0\u0310\0\u0341\0\u0372"+
    "\0\u03a3\0\u03d4\0\u0405\0\u0436\0\u0467\0\u0498\0\u04c9\0\223"+
    "\0\223\0\223\0\223\0\223\0\223\0\223\0\223\0\223"+
    "\0\u04fa\0\223\0\u052b\0\u0188\0\u055c\0\u058d\0\u05be\0\u01ea"+
    "\0\223\0\u05ef\0\u0620\0\u0651\0\u0682\0\u06b3\0\u06e4\0\u0715"+
    "\0\u0746\0\u0777\0\u07a8\0\u07d9\0\u080a\0\u083b\0\u086c\0\u089d"+
    "\0\u024c\0\u08ce\0\u08ff\0\u024c\0\u0930\0\u0961\0\u0992\0\u024c"+
    "\0\u09c3\0\u09f4\0\u0a25\0\u0a56\0\u0a87\0\223\0\u0ab8\0\u0ae9"+
    "\0\u058d\0\u05be\0\u01ea\0\223\0\u0620\0\u0b1a\0\u0b4b\0\u0b7c"+
    "\0\u0bad\0\u0bde\0\u0c0f\0\u0c40\0\u0c71\0\u0ca2\0\u0cd3\0\u0d04"+
    "\0\u0d35\0\u0d66\0\u0d97\0\u0dc8\0\u0df9\0\u0e2a\0\u024c\0\u0e5b"+
    "\0\u0e8c\0\u0ebd\0\u0eee\0\u0f1f\0\u0f50\0\u0f81\0\u0fb2\0\223"+
    "\0\223\0\u024c\0\u024c\0\u0fe3\0\u024c\0\u1014\0\u024c\0\u1045"+
    "\0\u1076\0\u10a7\0\u10d8\0\u024c\0\u1109\0\u024c\0\u113a\0\u116b"+
    "\0\u024c\0\u119c\0\u11cd\0\u11fe\0\u122f\0\u1260\0\u1291\0\u12c2"+
    "\0\u12f3\0\u1324\0\u1355\0\u1386\0\u13b7\0\u13e8\0\u1419\0\u024c"+
    "\0\u144a\0\u147b\0\u14ac\0\u14dd\0\u150e\0\u153f\0\u1570\0\u024c"+
    "\0\u15a1\0\u024c\0\u024c\0\u15d2\0\u024c\0\u1603\0\u1634\0\u1665"+
    "\0\u024c\0\u1696\0\u024c\0\u024c\0\u024c\0\u024c\0\u16c7\0\u024c"+
    "\0\u024c\0\u024c\0\u16f8\0\u024c\0\u1729\0\u024c\0\u175a\0\u178b"+
    "\0\u024c\0\u024c\0\u024c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[179];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\61\4\1\5\1\6\1\7\1\10\1\11\1\5\1\12"+
    "\1\13\1\14\1\15\1\16\1\5\1\17\1\20\1\21"+
    "\1\5\2\22\1\23\1\24\1\25\1\26\2\21\1\27"+
    "\1\30\1\31\1\32\1\21\1\33\1\34\1\21\1\35"+
    "\1\21\1\36\2\21\1\37\3\21\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\3\1\53\1\50\1\54\52\50\63\0\2\7\60\0"+
    "\1\7\60\0\1\10\61\0\1\55\3\0\1\14\54\0"+
    "\1\56\64\0\1\14\1\57\47\0\12\60\1\61\1\62"+
    "\45\60\13\63\1\64\1\0\44\63\10\0\1\21\4\0"+
    "\3\21\2\0\27\21\20\0\1\21\4\0\3\21\2\0"+
    "\15\21\1\65\3\21\1\66\2\21\1\67\2\21\20\0"+
    "\1\21\4\0\3\21\2\0\2\21\1\70\7\21\1\71"+
    "\2\21\1\72\11\21\20\0\1\21\4\0\3\21\2\0"+
    "\25\21\1\73\1\21\20\0\1\21\4\0\3\21\2\0"+
    "\2\21\1\74\10\21\1\75\13\21\20\0\1\21\4\0"+
    "\3\21\2\0\13\21\1\76\13\21\20\0\1\21\4\0"+
    "\3\21\2\0\10\21\1\77\1\21\1\100\14\21\20\0"+
    "\1\21\4\0\3\21\2\0\20\21\1\101\6\21\20\0"+
    "\1\21\4\0\3\21\2\0\2\21\1\102\3\21\1\103"+
    "\1\21\1\104\16\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\105\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\7\21\1\106\6\21\1\107\1\21\1\110\6\21\20\0"+
    "\1\21\4\0\3\21\2\0\2\21\1\111\24\21\20\0"+
    "\1\21\4\0\3\21\2\0\2\21\1\112\5\21\1\113"+
    "\16\21\20\0\1\21\4\0\3\21\2\0\21\21\1\114"+
    "\5\21\12\0\1\52\62\0\1\55\54\0\1\115\2\116"+
    "\1\115\1\117\1\0\3\115\1\0\1\115\1\0\5\115"+
    "\1\0\36\115\1\0\4\56\1\120\2\56\1\121\51\56"+
    "\10\0\1\122\50\0\12\60\1\123\1\62\45\60\14\0"+
    "\1\124\60\0\1\125\54\0\1\21\4\0\3\21\2\0"+
    "\12\21\1\126\14\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\127\6\21\1\130\11\21\20\0\1\21\4\0"+
    "\3\21\2\0\1\21\1\131\25\21\20\0\1\21\4\0"+
    "\3\21\2\0\3\21\1\132\23\21\20\0\1\21\4\0"+
    "\3\21\2\0\15\21\1\133\7\21\1\134\1\21\20\0"+
    "\1\21\4\0\3\21\2\0\10\21\1\135\3\21\1\136"+
    "\12\21\20\0\1\21\4\0\3\21\2\0\22\21\1\137"+
    "\4\21\20\0\1\21\4\0\3\21\2\0\22\21\1\140"+
    "\4\21\20\0\1\21\4\0\3\21\2\0\2\21\1\141"+
    "\24\21\20\0\1\21\4\0\3\21\2\0\22\21\1\142"+
    "\4\21\20\0\1\21\4\0\3\21\2\0\11\21\1\143"+
    "\15\21\20\0\1\21\4\0\3\21\2\0\1\144\26\21"+
    "\20\0\1\21\4\0\3\21\2\0\1\145\26\21\20\0"+
    "\1\21\4\0\3\21\2\0\15\21\1\146\11\21\20\0"+
    "\1\21\4\0\3\21\2\0\1\147\26\21\20\0\1\21"+
    "\4\0\3\21\2\0\1\21\1\150\25\21\20\0\1\21"+
    "\4\0\3\21\2\0\20\21\1\151\1\21\1\152\4\21"+
    "\20\0\1\21\4\0\3\21\2\0\1\153\26\21\20\0"+
    "\1\21\4\0\3\21\2\0\13\21\1\154\13\21\20\0"+
    "\1\21\4\0\3\21\2\0\15\21\1\155\11\21\20\0"+
    "\1\21\4\0\3\21\2\0\6\21\1\156\20\21\10\0"+
    "\1\115\1\0\1\116\56\115\1\157\2\160\2\157\1\115"+
    "\3\157\1\115\1\157\1\115\5\157\1\115\36\157\1\115"+
    "\7\56\1\161\51\56\10\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\162\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\16\21\1\163\10\21\20\0\1\21\4\0\3\21\2\0"+
    "\10\21\1\164\16\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\165\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\4\21\1\166\22\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\167\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\13\21\1\170\13\21\20\0\1\21\4\0\3\21\2\0"+
    "\1\171\26\21\20\0\1\21\4\0\3\21\2\0\17\21"+
    "\1\172\7\21\20\0\1\21\4\0\3\21\2\0\1\173"+
    "\26\21\20\0\1\21\4\0\3\21\2\0\6\21\1\174"+
    "\20\21\20\0\1\21\4\0\3\21\2\0\22\21\1\175"+
    "\4\21\20\0\1\21\4\0\3\21\2\0\6\21\1\176"+
    "\20\21\20\0\1\21\4\0\3\21\2\0\12\21\1\177"+
    "\14\21\20\0\1\21\4\0\3\21\2\0\2\21\1\200"+
    "\24\21\20\0\1\21\4\0\3\21\2\0\2\21\1\201"+
    "\24\21\20\0\1\21\4\0\3\21\2\0\14\21\1\202"+
    "\12\21\20\0\1\21\4\0\3\21\2\0\10\21\1\203"+
    "\16\21\20\0\1\21\4\0\3\21\2\0\14\21\1\204"+
    "\12\21\20\0\1\21\4\0\3\21\2\0\1\205\26\21"+
    "\20\0\1\21\4\0\3\21\2\0\14\21\1\206\12\21"+
    "\20\0\1\21\4\0\3\21\2\0\22\21\1\207\4\21"+
    "\20\0\1\21\4\0\3\21\2\0\2\21\1\210\24\21"+
    "\20\0\1\21\4\0\3\21\2\0\15\21\1\211\11\21"+
    "\10\0\1\157\1\0\1\160\56\157\10\0\1\21\4\0"+
    "\3\21\2\0\23\21\1\212\3\21\20\0\1\21\4\0"+
    "\3\21\2\0\2\21\1\213\24\21\20\0\1\21\4\0"+
    "\3\21\2\0\14\21\1\214\12\21\20\0\1\21\4\0"+
    "\3\21\2\0\6\21\1\215\20\21\20\0\1\21\4\0"+
    "\3\21\2\0\2\21\1\216\24\21\20\0\1\21\4\0"+
    "\3\21\2\0\15\21\1\217\11\21\20\0\1\21\4\0"+
    "\3\21\2\0\22\21\1\220\4\21\20\0\1\21\4\0"+
    "\3\21\2\0\13\21\1\221\13\21\20\0\1\21\4\0"+
    "\3\21\2\0\25\21\1\222\1\21\20\0\1\21\4\0"+
    "\3\21\2\0\17\21\1\223\7\21\20\0\1\21\4\0"+
    "\3\21\2\0\15\21\1\224\11\21\20\0\1\21\4\0"+
    "\3\21\2\0\26\21\1\225\20\0\1\21\4\0\3\21"+
    "\2\0\2\21\1\226\24\21\20\0\1\21\4\0\3\21"+
    "\2\0\17\21\1\227\7\21\20\0\1\21\4\0\3\21"+
    "\2\0\6\21\1\230\20\21\20\0\1\21\4\0\3\21"+
    "\2\0\13\21\1\231\13\21\20\0\1\21\4\0\3\21"+
    "\2\0\6\21\1\232\20\21\20\0\1\21\4\0\3\21"+
    "\2\0\22\21\1\233\4\21\20\0\1\21\4\0\3\21"+
    "\2\0\5\21\1\234\21\21\20\0\1\21\4\0\3\21"+
    "\2\0\3\21\1\235\23\21\20\0\1\21\4\0\3\21"+
    "\2\0\3\21\1\236\23\21\20\0\1\21\4\0\3\21"+
    "\2\0\1\237\26\21\20\0\1\21\4\0\3\21\2\0"+
    "\2\21\1\240\24\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\241\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\13\21\1\242\13\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\243\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\1\244\26\21\20\0\1\21\4\0\3\21\2\0\13\21"+
    "\1\245\1\21\1\246\11\21\20\0\1\21\4\0\3\21"+
    "\2\0\16\21\1\247\10\21\20\0\1\21\4\0\3\21"+
    "\2\0\6\21\1\250\20\21\20\0\1\21\4\0\3\21"+
    "\2\0\13\21\1\251\13\21\20\0\1\21\4\0\3\21"+
    "\2\0\6\21\1\252\20\21\20\0\1\21\4\0\3\21"+
    "\2\0\1\253\26\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\254\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\3\21\1\255\23\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\256\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\3\21\1\257\23\21\20\0\1\21\4\0\3\21\2\0"+
    "\6\21\1\260\20\21\20\0\1\21\4\0\3\21\2\0"+
    "\1\261\26\21\20\0\1\21\4\0\3\21\2\0\6\21"+
    "\1\262\20\21\20\0\1\21\4\0\3\21\2\0\11\21"+
    "\1\263\15\21\10\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6076];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\2\11\5\1\1\11\1\1\1\11\4\1\1\11"+
    "\15\1\11\11\1\1\1\11\2\1\4\0\1\11\3\0"+
    "\31\1\1\11\1\1\1\0\3\1\1\11\33\1\2\11"+
    "\102\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[179];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _FregeParsingLexer() { this((java.io.Reader)null); }

  private int yychar;

  /** This should match the newline indent rule defined in our Flex lexer. */
  public static Pattern NEWLINE_INDENT_REGEX = Pattern.compile(
    "(\\r|\\n|\\r\\n)(( |\\t)*)", Pattern.MULTILINE
  );

  protected int currentLineIndent = 0;
  protected int indentLevel = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _FregeParsingLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yypushback(1); yybegin(MAIN);
            }
          case 58: break;
          case 2: 
            { return FregeTokenTypes.OPERATOR;
            }
          case 59: break;
          case 3: 
            { final Matcher m = NEWLINE_INDENT_REGEX.matcher(yytext());
    if (!m.matches()) throw new AssertionError("NEWLINE_INDENT_REGEX did not match!");
    final String indent = m.group(2);
    yypushback(indent.length());
    yybegin(INDENT);
    return FregeTokenTypes.EOL;
            }
          case 60: break;
          case 4: 
            { return FregeTokenTypes.WHITE_SPACE;
            }
          case 61: break;
          case 5: 
            { return FregeTokenTypes.LBRACE;
            }
          case 62: break;
          case 6: 
            { return FregeTokenTypes.RBRACE;
            }
          case 63: break;
          case 7: 
            { return FregeTokenTypes.NUMBER_LITERAL;
            }
          case 64: break;
          case 8: 
            { return FregeTokenTypes.DOT;
            }
          case 65: break;
          case 9: 
            { return FregeTokenTypes.BAD_CHAR;
            }
          case 66: break;
          case 10: 
            { return FregeTokenTypes.UNDERSCORE;
            }
          case 67: break;
          case 11: 
            { return FregeTokenTypes.IDENT;
            }
          case 68: break;
          case 12: 
            { return FregeTokenTypes.LBRACKET;
            }
          case 69: break;
          case 13: 
            { return FregeTokenTypes.RBRACKET;
            }
          case 70: break;
          case 14: 
            { return FregeTokenTypes.LPAREN;
            }
          case 71: break;
          case 15: 
            { return FregeTokenTypes.RPAREN;
            }
          case 72: break;
          case 16: 
            { return FregeTokenTypes.SEMICOLON;
            }
          case 73: break;
          case 17: 
            { return FregeTokenTypes.COMMA;
            }
          case 74: break;
          case 18: 
            { return FregeTokenTypes.BACKTICK;
            }
          case 75: break;
          case 19: 
            { return FregeTokenTypes.EQUALS;
            }
          case 76: break;
          case 20: 
            { final int numWhitespace = yylength() - 1;

    if (currentLineIndent == 0) {
      if (numWhitespace == indentLevel) {
        // Consume all except the non-WHITE_SPACE char
        yypushback(1);
        yybegin(MAIN);
        return FregeTokenTypes.WHITE_SPACE;
      }
      if (numWhitespace > indentLevel) {
        // Consume up to the indentLevel + 1 for the INDENT
        currentLineIndent = indentLevel + 1;
        yypushback(yylength() - (indentLevel + 1));
        return FregeTokenTypes.INDENT;
      }
      if (numWhitespace < indentLevel) {
        --indentLevel;
        yypushback(yylength());
        return FregeTokenTypes.DEDENT;
      }
      // Shouldn't happen since we checked ==, >, and <
      throw new AssertionError(
        "Unexpected case: numWhitespace: " + numWhitespace + "; "
          + "indentLevel: " + indentLevel
      );
    }

    // If no more whitespace, start the line.
    if (numWhitespace == 0) {
      indentLevel = currentLineIndent;
      currentLineIndent = 0;
      yypushback(1);
      yybegin(MAIN);
      return FregeTokenTypes.WHITE_SPACE;
    }

    // If there is whitespace, consume it one char at a time.
    ++currentLineIndent;
    // Consume 1 WHITE_SPACE char.
    yypushback(yylength() - 1);
    return FregeTokenTypes.INDENT;
            }
          case 77: break;
          case 21: 
            { currentLineIndent = 0; return FregeTokenTypes.WHITE_SPACE;
            }
          case 78: break;
          case 22: 
            { return FregeTokenTypes.STRING_LITERAL;
            }
          case 79: break;
          case 23: 
            { return FregeTokenTypes.OF;
            }
          case 80: break;
          case 24: 
            { return FregeTokenTypes.DO;
            }
          case 81: break;
          case 25: 
            { return FregeTokenTypes.IN;
            }
          case 82: break;
          case 26: 
            { return FregeTokenTypes.IF;
            }
          case 83: break;
          case 27: 
            { return FregeTokenTypes.LINE_COMMENT;
            }
          case 84: break;
          case 28: 
            { return FregeTokenTypes.BLOCK_COMMENT;
            }
          case 85: break;
          case 29: 
            { return FregeTokenTypes.CHAR_LITERAL;
            }
          case 86: break;
          case 30: 
            { return FregeTokenTypes.LET;
            }
          case 87: break;
          case 31: 
            { return FregeTokenTypes.DOC_COMMENT;
            }
          case 88: break;
          case 32: 
            { return FregeTokenTypes.TRUE;
            }
          case 89: break;
          case 33: 
            { return FregeTokenTypes.THEN;
            }
          case 90: break;
          case 34: 
            { return FregeTokenTypes.TYPE;
            }
          case 91: break;
          case 35: 
            { return FregeTokenTypes.PURE;
            }
          case 92: break;
          case 36: 
            { return FregeTokenTypes.CASE;
            }
          case 93: break;
          case 37: 
            { return FregeTokenTypes.ELSE;
            }
          case 94: break;
          case 38: 
            { return FregeTokenTypes.DATA;
            }
          case 95: break;
          case 39: 
            { return FregeTokenTypes.CLASS;
            }
          case 96: break;
          case 40: 
            { return FregeTokenTypes.INFIX;
            }
          case 97: break;
          case 41: 
            { return FregeTokenTypes.FALSE;
            }
          case 98: break;
          case 42: 
            { return FregeTokenTypes.WHERE;
            }
          case 99: break;
          case 43: 
            { return FregeTokenTypes.THROWS;
            }
          case 100: break;
          case 44: 
            { return FregeTokenTypes.PUBLIC;
            }
          case 101: break;
          case 45: 
            { return FregeTokenTypes.MODULE;
            }
          case 102: break;
          case 46: 
            { return FregeTokenTypes.DERIVE;
            }
          case 103: break;
          case 47: 
            { return FregeTokenTypes.IMPORT;
            }
          case 104: break;
          case 48: 
            { return FregeTokenTypes.INFIXL;
            }
          case 105: break;
          case 49: 
            { return FregeTokenTypes.INFIXR;
            }
          case 106: break;
          case 50: 
            { return FregeTokenTypes.NATIVE;
            }
          case 107: break;
          case 51: 
            { return FregeTokenTypes.FORALL;
            }
          case 108: break;
          case 52: 
            { return FregeTokenTypes.PACKAGE;
            }
          case 109: break;
          case 53: 
            { return FregeTokenTypes.PRIVATE;
            }
          case 110: break;
          case 54: 
            { return FregeTokenTypes.MUTABLE;
            }
          case 111: break;
          case 55: 
            { return FregeTokenTypes.ABSTRACT;
            }
          case 112: break;
          case 56: 
            { return FregeTokenTypes.INSTANCE;
            }
          case 113: break;
          case 57: 
            { return FregeTokenTypes.PROTECTED;
            }
          case 114: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
