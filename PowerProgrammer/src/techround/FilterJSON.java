package techround;

import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FilterJSON {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String lines = "";
		while(scan.hasNext() && (lines=scan.next()) != ","){
			sb.append(lines);
		}
		String input = new String(sb);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(input);
		String value = (String) jsonObject.get("dataFor");
		
		
		
	}
}
