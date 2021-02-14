/*
 *  This class executes text-to-integer, integer-to-text conversion methods needed for the assignment.
 *  Each conversion method has Turkish and English versions. 
 *  These methods are implemented regarding the differences in both languages' word structures.
 *  numberToTextENG() and numberToTextTR() methods can translate any integer between 0 and 10 000 000.
 *  textToIntTR() and textToIntENG() methods can translate any input between 0 and 1 000 000.
 *  WARNING! 
 *  The calculator is only functional for positive numbers. 
 *  Because numberToInt functions are only written for positive values.
 *  Actually the calculator computes negative values but the negative integer value is not converted to text in numberToInt()
*/

package converterImpl;

import java.util.ArrayList;
import java.util.Locale;
import java.util.StringJoiner;
import converter.service.Converter;

public class ConverterImpl implements Converter {

	// public static void main(String[] args) {

	// Test
	// System.out.println("Sonuc: " + textToInt("bin yÃ¼z yedi"));
	// int number = 7999919;
	// System.out.println(numberToTextTR(number));
	// System.out.println(numberToTextENG(number));
	// }

	/*
	 * 
	 * The method is written according to Turkish language syntax. This method
	 * converts the entered text to an integer value in order to calculate simple
	 * operations on UIService The text is splitted and every word is analyzed
	 * accordingly. The basamak array stores special digits like a hunndred or a
	 * thousand. The algorithm is; on each word, if you see a basamak[] element,
	 * multiply the number with the basamak. Else, update the number by adding the
	 * corresponding int value.
	 */
	@Override
	public int textToIntTR(String inputText) {

		int value1 = 0;
		Locale.setDefault(new Locale("TR", "tr")); // For special Turkish character recognition
		ArrayList<String> birler = new ArrayList<>();
		birler.add("bir");
		birler.add("iki");
		birler.add("üç");
		birler.add("dört");
		birler.add("beş");
		birler.add("altı");
		birler.add("yedi");
		birler.add("sekiz");
		birler.add("dokuz");
		int[] birlerInt = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		ArrayList<String> onlar = new ArrayList<>();
		onlar.add("on");
		onlar.add("yirmi");
		onlar.add("otuz");
		onlar.add("kırk");
		onlar.add("elli");
		onlar.add("altmış");
		onlar.add("yetmiş");
		onlar.add("seksen");
		onlar.add("doksan");

		ArrayList<String> basamak = new ArrayList<>();
		basamak.add("yüz");
		basamak.add("bin");

		String[] splittedString = inputText.split("\\s+");

		/*
		 * for (int i = 0; i < splittedString.length; i++)
		 * System.out.println(splittedString[i]);
		 */

		for (int i = 0; i < splittedString.length; i++) {

			if (birler.contains(splittedString[i])) {

				// System.out.println("Birlere girdi");

				if (splittedString[i].equals("bir")) {
					value1 += birlerInt[0];
				} else if (splittedString[i].equals("iki")) {
					value1 += birlerInt[1];
				} else if (splittedString[i].equals("üç")) {
					value1 += birlerInt[2];
				} else if (splittedString[i].equals("dört")) {
					value1 += birlerInt[3];
				} else if (splittedString[i].equals("beş")) {
					value1 += birlerInt[4];
				} else if (splittedString[i].equals("altı")) {
					value1 += birlerInt[5];
				} else if (splittedString[i].equals("yedi")) {
					value1 += birlerInt[6];
				} else if (splittedString[i].equals("sekiz")) {
					value1 += birlerInt[7];
				} else if (splittedString[i].equals("dokuz")) {
					value1 += birlerInt[8];
				}

				// System.out.println(value1);
			}

			else if (onlar.contains(splittedString[i])) {

				// System.out.println("Onlara girdi");

				if (splittedString[i].equals("on"))
					value1 += 10;
				else if (splittedString[i].equals("yirmi"))
					value1 += 20;
				else if (splittedString[i].equals("otuz"))
					value1 += 30;
				else if (splittedString[i].equals("kırk"))
					value1 += 40;
				else if (splittedString[i].equals("elli"))
					value1 += 50;
				else if (splittedString[i].equals("altmış"))
					value1 += 60;
				else if (splittedString[i].equals("yetmiş"))
					value1 += 70;
				else if (splittedString[i].equals("seksen"))
					value1 += 80;
				else if (splittedString[i].equals("doksan"))
					value1 += +90;

				// System.out.println(value1);
			}

			else if (basamak.contains(splittedString[i])) {

				// System.out.println("Basamaklara girdi");

				int counter = i + 1;
				int counter2 = i + 2;

				if (value1 == 0) // If the first element of the text is a digit
					value1 = value1 + 1;

				if (splittedString[i].equals("yüz")) {
					value1 = value1 * 100;
				}

				if (splittedString[i].equals("bin")) {

					value1 = value1 * 1000;

					if (counter <= splittedString.length - 1) {
						if (splittedString[counter].equals("yüz")) {
							value1 += 100;
							i++;
						}
					}
					if (counter2 <= splittedString.length - 1 && counter <= splittedString.length) {
						if (birler.contains(splittedString[counter]) && splittedString[counter2].equals("yüz")) {
							if (splittedString[counter].equals("bir")) {
								value1 += 1 * 100;
							} else if (splittedString[counter].equals("iki")) {
								value1 += 2 * 100;
							} else if (splittedString[counter].equals("üç")) {
								value1 += 3 * 100;
							} else if (splittedString[counter].equals("dört")) {
								value1 += 4 * 100;
							} else if (splittedString[counter].equals("beş")) {
								value1 += 5 * 100;
							} else if (splittedString[counter].equals("altı")) {
								value1 += 6 * 100;
							} else if (splittedString[counter].equals("yedi")) {
								value1 += 7 * 100;
							} else if (splittedString[counter].equals("sekiz")) {
								value1 += 8 * 100;
							} else if (splittedString[counter].equals("dokuz")) {
								value1 += 9 * 100;
							}
							i += 2;
						}

					}

				}
				// System.out.println(value1);
			}
		}

		return value1;
	}

	/*
	 * The method is written according to English language syntax. This method
	 * converts the entered text to an integer value in order to calculate simple
	 * operations on UIService The text is splitted and every word is analyzed
	 * accordingly. The basamak array stores special digits like a hunndred or a
	 * thousand. The algorithm is; on each word, if you see a basamak[] element,
	 * multiply the number with the basamak. Else, update the number by adding the
	 * corresponding int value.
	 */
	@Override
	public int textToIntENG(String inputText) {

		int value1 = 0;

		ArrayList<String> birler = new ArrayList<>();
		birler.add("one");
		birler.add("two");
		birler.add("three");
		birler.add("four");
		birler.add("five");
		birler.add("six");
		birler.add("seven");
		birler.add("eight");
		birler.add("nine");
		int[] birlerInt = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		ArrayList<String> special_tens = new ArrayList<>();
		special_tens.add("eleven");
		special_tens.add("twelve");
		special_tens.add("thirteen");
		special_tens.add("fourteen");
		special_tens.add("fifteen");
		special_tens.add("sixteen");
		special_tens.add("seventeen");
		special_tens.add("eighteen");
		special_tens.add("nineteen");

		ArrayList<String> onlar = new ArrayList<>();
		onlar.add("ten");
		onlar.add("twenty");
		onlar.add("thirty");
		onlar.add("forty");
		onlar.add("fifty");
		onlar.add("sixty");
		onlar.add("seventy");
		onlar.add("eighty");
		onlar.add("ninety");

		ArrayList<String> basamak = new ArrayList<>();
		basamak.add("hundred");
		basamak.add("thousand");

		String[] splittedString = inputText.split("\\s+");

		/*
		 * for (int i = 0; i < splittedString.length; i++)
		 * System.out.println(splittedString[i]);
		 */

		for (int i = 0; i < splittedString.length; i++) {

			if (birler.contains(splittedString[i])) {

				// System.out.println("Birlere girdi");

				if (splittedString[i].equals("one")) {
					value1 += birlerInt[0];
				} else if (splittedString[i].equals("two")) {
					value1 += birlerInt[1];
				} else if (splittedString[i].equals("three")) {
					value1 += birlerInt[2];
				} else if (splittedString[i].equals("four")) {
					value1 += birlerInt[3];
				} else if (splittedString[i].equals("five")) {
					value1 += birlerInt[4];
				} else if (splittedString[i].equals("six")) {
					value1 += birlerInt[5];
				} else if (splittedString[i].equals("seven")) {
					value1 += birlerInt[6];
				} else if (splittedString[i].equals("eight")) {
					value1 += birlerInt[7];
				} else if (splittedString[i].equals("nine")) {
					value1 += birlerInt[8];
				}

				// System.out.println(value1);
			}

			else if (special_tens.contains(splittedString[i])) {

				if (splittedString[i].equals("eleven")) {
					value1 += 11;
				} else if (splittedString[i].equals("twelve")) {
					value1 += 12;
				} else if (splittedString[i].equals("thirteen")) {
					value1 += 13;
				} else if (splittedString[i].equals("fourteen")) {
					value1 += 14;
				} else if (splittedString[i].equals("fifteen")) {
					value1 += 15;
				} else if (splittedString[i].equals("sixteen")) {
					value1 += 16;
				} else if (splittedString[i].equals("seventeen")) {
					value1 += 17;
				} else if (splittedString[i].equals("eighteen")) {
					value1 += 18;
				} else if (splittedString[i].equals("nineteen")) {
					value1 += 19;
				}
			}

			else if (onlar.contains(splittedString[i])) {

				// System.out.println("Onlara girdi");

				if (splittedString[i].equals("ten"))
					value1 += 10;
				else if (splittedString[i].equals("twenty"))
					value1 += 20;
				else if (splittedString[i].equals("thirty"))
					value1 += 30;
				else if (splittedString[i].equals("forty"))
					value1 += 40;
				else if (splittedString[i].equals("fifty"))
					value1 += 50;
				else if (splittedString[i].equals("sixty"))
					value1 += 60;
				else if (splittedString[i].equals("seventy"))
					value1 += 70;
				else if (splittedString[i].equals("eighty"))
					value1 += 80;
				else if (splittedString[i].equals("ninety"))
					value1 += +90;

				// System.out.println(value1);
			}

			else if (basamak.contains(splittedString[i])) {

				// System.out.println("Basamaklara girdi");

				int counter = i + 1;
				int counter2 = i + 2;

				if (value1 == 0) // If the first element of the text is a digit
					value1 = value1 + 1;

				if (splittedString[i].equals("hundred")) {
					value1 = value1 * 100;
				}

				if (splittedString[i].equals("thousand")) {

					value1 = value1 * 1000;
					// special case
					if (counter <= splittedString.length - 1) {
						if (splittedString[counter].equals("hundred")) {
							value1 += 100;
							i++;
						}
					}
					// special case
					if (counter2 <= splittedString.length - 1 && counter <= splittedString.length) {
						if (birler.contains(splittedString[counter]) && splittedString[counter2].equals("hundred")) {
							if (splittedString[counter].equals("one")) {
								value1 += 1 * 100;
							} else if (splittedString[counter].equals("two")) {
								value1 += 2 * 100;
							} else if (splittedString[counter].equals("three")) {
								value1 += 3 * 100;
							} else if (splittedString[counter].equals("four")) {
								value1 += 4 * 100;
							} else if (splittedString[counter].equals("five")) {
								value1 += 5 * 100;
							} else if (splittedString[counter].equals("six")) {
								value1 += 6 * 100;
							} else if (splittedString[counter].equals("seven")) {
								value1 += 7 * 100;
							} else if (splittedString[counter].equals("eight")) {
								value1 += 8 * 100;
							} else if (splittedString[counter].equals("nine")) {
								value1 += 9 * 100;
							}
							i += 2;
						}

					}

				}
				// System.out.println(value1);
			}
		}

		return value1;
	}

	/*
	 * The method converts any integer value between 0 and 10 million into Turkish
	 * text. Algorithm: Each time, divide the number with the corresponding digit
	 * and find the int value in that digit. After that decrement the number by (number * digit) 
	 * Example: onBinler = 13000/10000 = 1. 
	 * number -= (onBinler * 10000). 
	 * binler = 30000/1000 = 3, etc.
	 * In the method, there are many corner cases covered.
	 */
	@Override
	public String numberToTextTR(int number) {

		Locale.setDefault(new Locale("TR", "tr")); // For special Turkish character recognition
		String[] birlerBasamagi = new String[] { "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz" };
		String[] ozelBasamak = new String[] { "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen",
				"doksan" };
		String[] yuzlerBasamagi = new String[] { "yüz", "iki yüz", "üç yüz", "dört yüz", "beş yüz", "altı yüz",
				"yedi yüz", "sekiz yüz", "dokuz yüz" };
		String[] binlerBasamagi = new String[] { "bin", "iki bin", "üç bin", "dört bin", "beş bin", "altı bin",
				"yedi bin", "sekiz bin", "dokuz bin" };
		String[] milyonlarBasamagi = new String[] { "bir milyon", "iki milyon", "üç milyon", "dört milyon",
				"beş milyon", "altı milyon", "yedi milyon", "sekiz milyon", "dokuz milyon" };

		String birlerText, onlarText, yuzlerText, binlerText, onBinlerText, yuzBinlerText, milyonlarText;
		int birler, onlar, yuzler, binler, onbinler, yuzbinler, milyonlar;

		StringJoiner outputText = new StringJoiner(" ");

		birler = number % 10;
		onlar = (number - birler) / 10;

		if (number > 0 && number < 10) {
			birler = number % 10;
			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[number - 1];
			}

			outputText.add(birlerText);
		}

		else if (number >= 10 && number < 100) {
			birler = number % 10;
			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			onlar = (number - birler) / 10;
			onlarText = ozelBasamak[onlar - 1];
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (number >= 100 && number < 1000) {
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;

			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}

			yuzlerText = yuzlerBasamagi[yuzler - 1];
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (1000 <= number && number < 10000) {
			binler = number / 1000;
			number = number - (binler * 1000);
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;
			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}
			if (yuzler == 0) {
				yuzlerText = "";
			} else {
				yuzlerText = yuzlerBasamagi[yuzler - 1];
			}
			binlerText = binlerBasamagi[binler - 1];

			outputText.add(binlerText);
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (10000 <= number && number < 100000) {
			onbinler = number / 10000;
			number = number - (onbinler * 10000);
			binler = number / 1000;
			number = number - (binler * 1000);
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;

			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}
			if (yuzler == 0) {
				yuzlerText = "";
			} else {
				yuzlerText = yuzlerBasamagi[yuzler - 1];
			}
			if (binler == 0) {
				binlerText = "bin";
			} else if (binler == 1) {
				binlerText = "bir bin";
			} else {
				binlerText = binlerBasamagi[binler - 1];
			}
			onBinlerText = ozelBasamak[onbinler - 1];

			outputText.add(onBinlerText);
			outputText.add(binlerText);
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (100000 <= number && number < 1000000) {
			yuzbinler = number / 100000;
			number = number - (yuzbinler * 100000);
			onbinler = number / 10000;
			number = number - (onbinler * 10000);
			binler = number / 1000;
			number = number - (binler * 1000);
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;

			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}
			if (yuzler == 0) {
				yuzlerText = "";
			} else {
				yuzlerText = yuzlerBasamagi[yuzler - 1];
			}
			if (binler == 0) {
				binlerText = "";
			} else if (binler == 1) {
				binlerText = "bir bin";
			} else {
				binlerText = binlerBasamagi[binler - 1];
			}
			if (onbinler == 0) {
				onBinlerText = "";
			} else {
				onBinlerText = ozelBasamak[onbinler - 1];
			}
			if (onbinler == 0 && binler == 0) {
				onBinlerText = "";
				binlerText = "bin";
			} else if (onbinler != 0 && binler == 0) {
				onBinlerText = ozelBasamak[onbinler - 1];
				binlerText = "bin";
			}
			yuzBinlerText = yuzlerBasamagi[yuzbinler - 1];

			outputText.add(yuzBinlerText);
			outputText.add(onBinlerText);
			outputText.add(binlerText);
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (1000000 <= number && number < 10000000) {
			milyonlar = number / 1000000;
			number = number - (milyonlar * 1000000);
			yuzbinler = number / 100000;
			number = number - (yuzbinler * 100000);
			onbinler = number / 10000;
			number = number - (onbinler * 10000);
			binler = number / 1000;
			number = number - (binler * 1000);
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;

			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}
			if (yuzler == 0) {
				yuzlerText = "";
			} else {
				yuzlerText = yuzlerBasamagi[yuzler - 1];
			}
			if (binler == 0) {
				binlerText = "";
			} else if (binler == 1) {
				binlerText = "bin";
			} else {
				binlerText = binlerBasamagi[binler - 1];
			}
			if (onbinler == 0) {
				onBinlerText = "";
			} else {
				onBinlerText = ozelBasamak[onbinler - 1];
			}
			if (onbinler == 0 && binler == 0) {
				onBinlerText = "";
				binlerText = "bin";
				if (yuzbinler == 0) {
					yuzBinlerText = "";
					binlerText = "";
				}
			} else if (onbinler != 0 && binler == 0) {
				onBinlerText = ozelBasamak[onbinler - 1];
				binlerText = "bin";
			}
			if (yuzbinler == 0) {
				yuzBinlerText = "";
			} else {
				yuzBinlerText = yuzlerBasamagi[yuzbinler - 1];
			}
			milyonlarText = milyonlarBasamagi[milyonlar - 1];

			outputText.add(milyonlarText);
			outputText.add(yuzBinlerText);
			outputText.add(onBinlerText);
			outputText.add(binlerText);
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}
		return outputText.toString();
	}
	
	/*
	 * The method converts any integer value between 0 and 10 million into English
	 * text. Algorithm: Each time, divide the number with the corresponding digit
	 * and find the int value in that digit. After that decrement the number by (number * digit) 
	 * Example: onBinler = 13000/10000 = 1. 
	 * number -= (onBinler * 10000). 
	 * binler = 30000/1000 = 3, etc.
	 * In the method, there are many corner cases covered.
	 */
	@Override
	public String numberToTextENG(int number) {

		String[] birlerBasamagi = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight",
				"nine" };
		String[] ozelBasamak = new String[] { "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
				"ninety" };
		String[] onlarBasamagi = new String[] { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
				"seventeen", "eighteen", "nineteen" };
		String[] yuzlerBasamagi = new String[] { "one hundred", "two hundred", "three hundred", "four hundred",
				"five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred" };
		String[] binlerBasamagi = new String[] { "one thousand", "two thousand", "three thousand", "four thousand",
				"five thousand", "six thousand", "seven thousand", "eight thousand", "nine thousand" };
		String[] milyonlarBasamagi = new String[] { "one million", "two million", "three million", "four million",
				"five million", "six million", "seven million", "eight million", "nine million" };

		String birlerText, onlarText, yuzlerText, binlerText, onBinlerText, yuzBinlerText, milyonlarText;
		int birler, onlar, yuzler, binler, onbinler, yuzbinler, milyonlar;

		StringJoiner outputText = new StringJoiner(" ");

		birler = number % 10;
		onlar = (number - birler) / 10;

		if (number > 0 && number < 10) {
			birler = number % 10;
			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[number - 1];
			}

			outputText.add(birlerText);
		}

		else if (number >= 10 && number < 100) {
			birler = number % 10;
			onlar = (number - birler) / 10;
			if (onlar == 1 && birler != 0) {
				outputText.add(onlarBasamagi[birler - 1]);
			} else {
				if (birler == 0) {
					birlerText = "";
				} else {
					birlerText = birlerBasamagi[birler - 1];
				}

				if (onlar == 0) {
					onlarText = "";
				} else {
					onlarText = ozelBasamak[onlar - 1];
					outputText.add(onlarText);
					outputText.add(birlerText);
				}
			}
		}

		else if (number >= 100 && number < 1000) {
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;

			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else if (onlar == 1 && birler != 0) {
				birlerText = "";
				onlarText = onlarBasamagi[birler - 1];
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}

			yuzlerText = yuzlerBasamagi[yuzler - 1];
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (1000 <= number && number < 10000) {
			binler = number / 1000;
			number = number - (binler * 1000);
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;
			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else if (onlar == 1 && birler != 0) {
				birlerText = "";
				onlarText = onlarBasamagi[birler - 1];
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}
			if (yuzler == 0) {
				yuzlerText = "";
			} else {
				yuzlerText = yuzlerBasamagi[yuzler - 1];
			}
			binlerText = binlerBasamagi[binler - 1];

			outputText.add(binlerText);
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (10000 <= number && number < 100000) {
			onbinler = number / 10000;
			number = number - (onbinler * 10000);
			binler = number / 1000;
			number = number - (binler * 1000);
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;

			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else if (onlar == 1 && birler != 0) {
				birlerText = "";
				onlarText = onlarBasamagi[birler - 1];
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}

			if (yuzler == 0) {
				yuzlerText = "";
			} else {
				yuzlerText = yuzlerBasamagi[yuzler - 1];
			}
			if (binler == 0) {
				binlerText = "thousand";
			} else if (binler == 1) {
				binlerText = "one thousand";
			} else {
				binlerText = binlerBasamagi[binler - 1];
			}
			onBinlerText = ozelBasamak[onbinler - 1];

			outputText.add(onBinlerText);
			outputText.add(binlerText);
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (100000 <= number && number < 1000000) {
			yuzbinler = number / 100000;
			number = number - (yuzbinler * 100000);
			onbinler = number / 10000;
			number = number - (onbinler * 10000);
			binler = number / 1000;
			number = number - (binler * 1000);
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;

			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else if (onlar == 1 && birler != 0) {
				birlerText = "";
				onlarText = onlarBasamagi[birler - 1];
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}

			if (yuzler == 0) {
				yuzlerText = "";
			} else {
				yuzlerText = yuzlerBasamagi[yuzler - 1];
			}
			if (binler == 0) {
				binlerText = "";
			} else if (binler == 1) {
				binlerText = "one thousand";
			} else {
				binlerText = binlerBasamagi[binler - 1];
			}
			if (onbinler == 0) {
				onBinlerText = "";
			} else {
				onBinlerText = ozelBasamak[onbinler - 1];
			}
			if (onbinler == 0 && binler == 0) {
				onBinlerText = "";
				binlerText = "thousand";
				if (yuzbinler == 0) {
					yuzBinlerText = "";
					binlerText = "";
				}
			} else if (onbinler != 0 && binler == 0) {
				onBinlerText = ozelBasamak[onbinler - 1];
				binlerText = "thousand";
			}
			yuzBinlerText = yuzlerBasamagi[yuzbinler - 1];

			outputText.add(yuzBinlerText);
			outputText.add(onBinlerText);
			outputText.add(binlerText);
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}

		else if (1000000 <= number && number < 10000000) {
			milyonlar = number / 1000000;
			number = number - (milyonlar * 1000000);
			yuzbinler = number / 100000;
			number = number - (yuzbinler * 100000);
			onbinler = number / 10000;
			number = number - (onbinler * 10000);
			binler = number / 1000;
			number = number - (binler * 1000);
			yuzler = number / 100;
			number = number - (yuzler * 100);
			onlar = number / 10;
			birler = number % 10;

			if (birler == 0) {
				birlerText = "";
			} else {
				birlerText = birlerBasamagi[birler - 1];
			}
			if (onlar == 0) {
				onlarText = "";
			} else if (onlar == 1 && birler != 0) {
				birlerText = "";
				onlarText = onlarBasamagi[birler - 1];
			} else {
				onlarText = ozelBasamak[onlar - 1];
			}

			if (yuzler == 0) {
				yuzlerText = "";
			} else {
				yuzlerText = yuzlerBasamagi[yuzler - 1];
			}
			if (binler == 0) {
				binlerText = "";
			} else if (binler == 1) {
				binlerText = "one thousand";
			} else {
				binlerText = binlerBasamagi[binler - 1];
			}
			if (onbinler == 0) {
				onBinlerText = "";
			} else {
				onBinlerText = ozelBasamak[onbinler - 1];
			}
			if (onbinler == 0 && binler == 0) {
				onBinlerText = "";
				binlerText = "thousand";
				if (yuzbinler == 0) {
					yuzBinlerText = "";
					binlerText = "";
				}
			} else if (onbinler != 0 && binler == 0) {
				onBinlerText = ozelBasamak[onbinler - 1];
				binlerText = "thousand";
			}
			if (yuzbinler == 0) {
				yuzBinlerText = "";
			} else {
				yuzBinlerText = yuzlerBasamagi[yuzbinler - 1];
			}
			milyonlarText = milyonlarBasamagi[milyonlar - 1];

			outputText.add(milyonlarText);
			outputText.add(yuzBinlerText);
			outputText.add(onBinlerText);
			outputText.add(binlerText);
			outputText.add(yuzlerText);
			outputText.add(onlarText);
			outputText.add(birlerText);
		}
		return outputText.toString();
	}
}
