# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 2.8

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list

# Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/wei/Documents/EvolutionaryTestingMethod

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/wei/Documents/EvolutionaryTestingMethod/build

# Include any dependencies generated for this target.
include loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/depend.make

# Include the progress variables for this target.
include loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/progress.make

# Include the compile flags for this target's objects.
include loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/flags.make

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/flags.make
loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o: ../loop_functions/mpga_loop_functions/mpga.cpp
	$(CMAKE_COMMAND) -E cmake_progress_report /home/wei/Documents/EvolutionaryTestingMethod/build/CMakeFiles $(CMAKE_PROGRESS_1)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Building CXX object loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o"
	cd /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions && /usr/bin/c++   $(CXX_DEFINES) $(CXX_FLAGS) -o CMakeFiles/mpga.dir/mpga.cpp.o -c /home/wei/Documents/EvolutionaryTestingMethod/loop_functions/mpga_loop_functions/mpga.cpp

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/mpga.dir/mpga.cpp.i"
	cd /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions && /usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -E /home/wei/Documents/EvolutionaryTestingMethod/loop_functions/mpga_loop_functions/mpga.cpp > CMakeFiles/mpga.dir/mpga.cpp.i

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/mpga.dir/mpga.cpp.s"
	cd /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions && /usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -S /home/wei/Documents/EvolutionaryTestingMethod/loop_functions/mpga_loop_functions/mpga.cpp -o CMakeFiles/mpga.dir/mpga.cpp.s

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o.requires:
.PHONY : loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o.requires

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o.provides: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o.requires
	$(MAKE) -f loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/build.make loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o.provides.build
.PHONY : loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o.provides

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o.provides.build: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/flags.make
loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o: ../loop_functions/mpga_loop_functions/mpga_loop_functions.cpp
	$(CMAKE_COMMAND) -E cmake_progress_report /home/wei/Documents/EvolutionaryTestingMethod/build/CMakeFiles $(CMAKE_PROGRESS_2)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Building CXX object loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o"
	cd /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions && /usr/bin/c++   $(CXX_DEFINES) $(CXX_FLAGS) -o CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o -c /home/wei/Documents/EvolutionaryTestingMethod/loop_functions/mpga_loop_functions/mpga_loop_functions.cpp

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/mpga.dir/mpga_loop_functions.cpp.i"
	cd /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions && /usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -E /home/wei/Documents/EvolutionaryTestingMethod/loop_functions/mpga_loop_functions/mpga_loop_functions.cpp > CMakeFiles/mpga.dir/mpga_loop_functions.cpp.i

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/mpga.dir/mpga_loop_functions.cpp.s"
	cd /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions && /usr/bin/c++  $(CXX_DEFINES) $(CXX_FLAGS) -S /home/wei/Documents/EvolutionaryTestingMethod/loop_functions/mpga_loop_functions/mpga_loop_functions.cpp -o CMakeFiles/mpga.dir/mpga_loop_functions.cpp.s

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o.requires:
.PHONY : loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o.requires

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o.provides: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o.requires
	$(MAKE) -f loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/build.make loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o.provides.build
.PHONY : loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o.provides

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o.provides.build: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o

# Object files for target mpga
mpga_OBJECTS = \
"CMakeFiles/mpga.dir/mpga.cpp.o" \
"CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o"

# External object files for target mpga
mpga_EXTERNAL_OBJECTS =

loop_functions/mpga_loop_functions/libmpga.so: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o
loop_functions/mpga_loop_functions/libmpga.so: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o
loop_functions/mpga_loop_functions/libmpga.so: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/build.make
loop_functions/mpga_loop_functions/libmpga.so: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --red --bold "Linking CXX shared library libmpga.so"
	cd /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/mpga.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/build: loop_functions/mpga_loop_functions/libmpga.so
.PHONY : loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/build

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/requires: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga.cpp.o.requires
loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/requires: loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/mpga_loop_functions.cpp.o.requires
.PHONY : loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/requires

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/clean:
	cd /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions && $(CMAKE_COMMAND) -P CMakeFiles/mpga.dir/cmake_clean.cmake
.PHONY : loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/clean

loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/depend:
	cd /home/wei/Documents/EvolutionaryTestingMethod/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/wei/Documents/EvolutionaryTestingMethod /home/wei/Documents/EvolutionaryTestingMethod/loop_functions/mpga_loop_functions /home/wei/Documents/EvolutionaryTestingMethod/build /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions /home/wei/Documents/EvolutionaryTestingMethod/build/loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : loop_functions/mpga_loop_functions/CMakeFiles/mpga.dir/depend
