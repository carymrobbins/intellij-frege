# IntelliJ Support for Frege

This is an experiment to see how well Frege works for developing IntelliJ plugins.
The plan is to develop the plugin _in_ Frege and, once it proves feasible, add the
new functionality to [HaskForce](http://caryrobbins.com/intellij-haskforce/), allowing
HaskForce itself to be written in Frege.

Note that there seems to be an
[existing Frege plugin](https://github.com/Dierk/frege-idea-plugin)
in the works.  Hopefully, if this experiment proves a success, we can merge the two
projects together.  Note that as of this writing, the existing Frege plugin appears
to implement its own lexer and parser; ideally, we should be able to reuse Frege's
internal lexer and parser as much as possible, which is one goal of this project.

## Progress

### Lexer

IntelliJ uses two different lexers - one for syntax highlighting and another for parsing.
The distinction is made so that IntelliJ can arbitrarily re-highlight parts of the code
without having to run the lexer over the entire file.

#### Syntax Highlighter Lexer

Frege's internal Lexer won't work for syntax highlighting since IntelliJ wants to be
able to lex only parts of the file to improve performance.  So we define our own
[JFlex lexer](src/com/haskforce/frege/lang/lexer/_FregeSyntaxHighlighterLexer.flex)
which does some very simple highlighting.  You can generate the lexer by opening the file
and pressing <kbd>Ctrl</kbd>+<kbd>Shift</kbd>+<kbd>G</kbd>.  Eventually we'll have this
automated as part of the build script.

#### Parsing Lexer

So far, a preliminary lexer appears to work when adapted from Frege's own lexer.
See the [FregeFlexLexer](src/com/haskforce/frege/lang/FregeFlexParsingLexer.java)
and its [test suite](tests/com/haskforce/frege/lang/FregeParsingLexerTest.java).
The test suite simply lexes files from
[this directory](tests/gold/parser) based on its method names, generating
(and then later comparing) the lexer results
[here](tests/gold/parser/lexer/expected).

IntelliJ lexers should produce values of IElementType.  The lexer token types are generated
from Frege's [TokenID](resources/frege/TokenID.fr) using a [script](tools/gen-token-types).
It also generates a `.fromToken()` method which can create an IElementType from a Frege Token.

### Parser

Currently, the parser naively consumes tokens from the parsing lexer and returns them directly.
You can use the **PsiViewer** plugin to view the parse tree, which is just the sequence of lexer
tokens.

We need to figure out a way to leverage Frege's parser so that we can consume lexer tokens
from the parsing lexer and properly build PsiElement nodes.
