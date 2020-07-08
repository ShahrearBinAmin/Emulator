# Emulator

Write a CPU emulator software that support a basic instruction set (15 instructions) given below. Assume that the</br>
computer has 256 bytes of available memory (M) initially set to zero. Your emulator should load a program code</br>
from a text file. For the simplicity you can store the program code in any data type you like. The use of your</br>
emulatior is like:
</br>
In Java: ./java Midterm_YourStudentId program.txt</br>
In C : ./ Midterm_YourStudentId.exe program.txt</br>
Following example code is an app that can compute the sum of the numbers between 0 and 20. Your emulator</br>
must execute this sample code at minimum. Note that I may test your emulator with any code that supported by</br>
the instruction set. You can implement your code in Java or C. Assuem that initially all flags are set to zero.</br>
%A Hello world app that computes the sum of the numbers between 0 to 20</br>
0 START</br>
1 LOAD 20</br>
2 STORE 200</br>
3 LOAD 0</br>
4 STORE 201</br>
5 STORE 202</br>
6 CMPM 200</br>
7 CJMP 15</br>
8 LOADM 202</br>
9 ADDM 201</br>
10 STORE 202</br>
11 LOADM 201</br>
12 ADD 1</br>
13 STORE 201</br>
14 JMP 6</br>
15 LOADM 202</br>
16 DISP</br>
17 HALT</br>
Instruction Short description Description</br>
START Start execution Starts the program execution</br>
LOAD X Load immediate value Load immediate value X to AC</br>
Ex:</br>
LOAD 25 means</br>
AC=25</br>
LOADM M[X] Load a memory value Load memory value stored at M[X] to AC</br>
STORE X Store a value Store value in AC to memory location M[X]</br>
Ex:</br>
STORE 730 means</br>
M[730]=AC</br>
CMPM M[X] Compare If the value in AC is greater than value in M[X] then set F flag</br>
to 1</br>
If the value in AC is less than value in M[X] then set F flag to -1</br>
If the value in AC is equal to value in M[X] then set F flag to 0</br>
CJMP X Conditional Jump Update the PC with X if the F flag value is positive</br>
JMP X Unconditional Jump Update the PC value with X</br>
Ex:</br>
JMP 114</br>
PC=114</br>
ADD X Immediate Addition Add immediate value of X to AC</br>
Ex:</br>
ADD 67 means</br>
AC=AC+67</br>
ADDM M[X] Addition with memory Add Memory value of M[X] to AC</br>
Ex:</br>
ADDM 180 means</br>
AC=AC+M[180]</br>
SUBM M[X] Subtraction with memory Subtract Memory value of M[X] from AC</br>
Ex:</br>
SUBM 150 means</br>
AC=AC-M[150]</br>
SUB X Immediate Subtraction Subtract immediate value of X from AC</br>
Ex:</br>
SUB 75 means</br>
AC=AC-75</br>
MUL N Immediate Multiplication Multiply AC with immediate value of N</br>
Ex:</br>
MUL 4 means</br>
AC=AC×N</br>
MULM N Multiplication with</br>
memory</br>
Multiply AC with M[N]</br>
Ex:</br>
MULM 4 means</br>
AC=AC×M[4]</br>
DISP Display Display the value in AC on screen</br>
HALT Stop execution Stop</br>
