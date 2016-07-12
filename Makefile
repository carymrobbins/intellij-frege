all: build

build:
	tools/gen-tokens
	tools/jflex/generate-sources
	tools/javac jps-lib jps-plugin java-lib
	tools/fregec frege-bindings frege-lib
	tools/javac frege-lib .

clean:
	rm -rf out
