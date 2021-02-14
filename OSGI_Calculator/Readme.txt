The project consists of 2 OSGI services; Converter Service and UIService.
Converter Service makes text-to-int and int-to-text conversions in Turkish and English seperately.
UIService provides a simple calculator interface and it computes the basic operations. It uses the Converter service for conversions.
The program supports two languages, English and Turkish.
A user should change his local settings if he/she wants to change the language of the program.

Warnings:
The calculator program works only for positive values.
The text inputs can not be entered as negative. Othervise, the result label becomes empty.
So a user can enter any number between 0 and 1 million as inputs, he will be able to see any result whose value is in between 0 and 10 milion.
In other cases, the result section will be empty.
Although the program computes negative integer values, int-to-text conversion for negative values is not supported in the program.
For MacOS, the user can change local language by entering System Preferences -> change language