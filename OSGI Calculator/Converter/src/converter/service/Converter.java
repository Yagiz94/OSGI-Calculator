package converter.service;

public interface Converter {
	public String numberToTextENG(int number);
	public String numberToTextTR(int number);
	public int textToIntENG(String inputText);
	public int textToIntTR(String inputText);
}
