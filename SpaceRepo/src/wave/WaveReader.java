package wave;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaveReader {

	public static List<List<String[]>> readWave(int waveNumber) {
		try {
			FileReader read = new FileReader("waves/wave" + waveNumber + ".txt");
			Scanner scan = new Scanner(read);
			
			List<List<String[]>> megaList = new ArrayList<List<String[]>>();
			String tempString;
			String[] splitTemp;
			
			for(int i = 0; i < 5; i++) {
				tempString = scan.nextLine();
				if(tempString.equalsIgnoreCase("switch")) {
					break;
				}
				megaList.get(0).get(0)[0] = tempString;
			}
			
			for(int i = 0; i < 10; i++) {
				tempString = scan.nextLine();
				if(tempString.equalsIgnoreCase("switch")) {
					break;
				}
				megaList.get(1).get(i)[0] = tempString;
			}
			
			for(int i = 0; i < 1000; i++) {
				if(scan.hasNextLine()) {
					tempString = scan.nextLine();
					splitTemp = tempString.split(",");
					megaList.get(2).get(i)[0] = splitTemp[0];
					megaList.get(2).get(i)[1] = splitTemp[1];
				}
			}
			
			scan.close();
			return megaList;
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}