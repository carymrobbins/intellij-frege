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

So far, a preliminary lexer appears to work when adapted from Frege's own lexer.
See the [FregeFlexLexer](src/com/haskforce/frege/lang/FregeFlexLexer.java)
and its [test suite](tests/com/haskforce/frege/lang/FregeLexerTest.java).
The test suite simply lexes files from
[this directory](tests/gold/parser) based on its method names, generating
(and then later comparing) the lexer results
[here](tests/gold/parser/lexer/expected).

IntelliJ lexers should produce values of IElementType.
The [FregeTokenType](src/com/haskforce/frege/lang/FregeTokenType.java) simply wraps Frege's
internal Token into an IElementType, using the TokenID for the IElementType debug name, which
appears in the lexer results.
