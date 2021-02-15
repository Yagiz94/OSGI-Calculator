The project consists of 2 OSGI services; Converter Service and UIService.
Converter Service makes text-to-int and int-to-text conversions in Turkish and English seperately.
UIService provides a simple calculator interface and it computes the basic operations. It uses the Converter service for conversions.
The program supports two languages, English and Turkish.
A user should change his local settings if he/she wants to change the language of the program.

Warnings:
The user can enter any value between -1 million and 1 million.
However, the result label displays values between -1 million and 1 million
For MacOS, the user can change local language by entering System Preferences -> change language