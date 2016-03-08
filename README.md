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

## Building

1. Configure the Project SDK.
  * Go to **File > Project Structure > Project Settings > Project**
  * Ensure you have an **Intellij IDEA** SDK configured for **Project SDK**.
      If not, choose **New** and create an **Intellij Platform Plugin SDK**
      with **JDK 8**. You might need to create a **JDK 8** if you haven't already.

1. Generate JFlex lexers by running `tools/jflex/generate-sources`

1. Download and copy a [Frege jar](https://github.com/Frege/frege/releases) to the `lib/`
    directory.

1. Compile Frege sources by running `tools/fregec` with the
   following environment variables -
      * **FREGE_JAR** - (optional) path to Frege jar (defaults to `lib/frege*.jar`)
      * **IDEA_HOME** - path to IntelliJ installation (defaults to `~/opt/idea`)
      * **JAVA** - path to `java` executable
      * **JAVAC** - path to `javac` executable

1. Compile Java sources using the IDE (**Build > Make Project**)

## Running the Test Suite

1. Open **FregeTestCase.java**, right-click on the class name, and choose
    **Run 'FregeTestCase'**
