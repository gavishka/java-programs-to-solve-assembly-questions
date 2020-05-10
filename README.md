﻿# Java-programs-to-solve-assembly-questions

Solving Equations program - Assembly question

To collect an unsigned integer value from a user, you need to first ask a question and then collect the response. To ask a question in assembly, you can use the WriteString library function to print a string by placing the offset of the string in the EDX register and then call the function. Use the ReadDec library function to collect the unsigned integer value. The value is returned in the eax register. To collect a signed integer, the ReadInt library function is used instead.

Write a program which prompts the user to enter five numbers and store the numbers into five double word variables, P, Q, R, S, & T, in the data segment. Each prompt must be different and specific. P R and T are unsigned values whereas Q and S are signed values. Once collected, use the five values to solve and report the results for each of the following equations using only the EBX and EAX registers:
(2P + R) - (Q - S) - 3T
(2P + 4R) -(S + Q) +2T
8R - (S + Q) - (3T + P)
To print a signed integer number, you would make sure the number to print is in the EAX register and then call the WriteInt library function. Your output should look something like: (2P + R) - (Q - S) - 3T = +453 (2P + 4R) - (S + Q) + 2R = +1836 8R - (S + Q) - (3T + P) + R = -49
