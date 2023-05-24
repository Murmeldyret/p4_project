<h1 align="center" style="display: block; font-size: 2.5em; font-weight: bold; margin-block-start: 1em; margin-block-end: 1em;">
<a name="logo" href="#"><img align="center" src="https://i.imgur.com/3jCChJ3.png" alt="logo" style="width:35%;height:35%"/></a>
  <br /><br /><strong>Excelibur</strong>
</h1>

## Introduction
The project has been developed as part of P4 at Aalborg University. The main focus of the project was to develop a new programming language. The programming language has been developed with the programming language Java and with the use of SableCC. 

## Build
Building the project requires the ANT build system created by Apache. The build system will take care of everything, since dependencies has already been included.

### Windows
If you are trying to run the project from a Windows platform (In which case, shame on you) you can download the build system [here](https://ant.apache.org/bindownload.cgi).

### macOS
Installing the build system on macOS can be done with Homebrew using the following command.

`brew install ant`

### Fedora
This section will cover how to install it on Fedora using its package manager. However, this process should pretty much apply to all distributions of GNU/Linux, just with the package manager that your system uses.

`sudo dnf install ant`

## Compiling

To compile the project one must run the build system. Your terminal should be inside the `sablecc/grammar` folder. Then you run the following command:

`ant jar`

This will compile the compiler and the jar file will be located inside the `build/jar` folder.

From here you will see a `Excelibur.jar` file and a `compilerdeps` folder. These two element must not be separated, since the compiler requires the `compilerdeps` folder.

## Running the compiler
Now that you have the `Excelibur.jar` file, you can start compiling some code in the Excelibur language.

When you have a source code file, then you should run the following command.

`java -jar Excelibur.jar path/to/the/source/file`

When the compiler has finished then the output of that compiler will be stored in `build/jar` folder which is created next to the compiler.

To run the compiled program use the following:

`java -jar program.jar`