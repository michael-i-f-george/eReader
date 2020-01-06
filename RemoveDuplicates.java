package org.ereader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
	
	private static final String SOURCE_DIRECTORY = "/media/bigfoot/ereader/3466 - Science-fiction/";
	private static final String DESTINATION_DIRECTORY = "/media/bigfoot/ereader_/3466 - Science-fiction/";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		listDirectoryContent(new File(SOURCE_DIRECTORY), 0);
		removeDuplicates(new File(SOURCE_DIRECTORY), 0);
		System.out.println();
		System.out.println("DONE");

	}

	public static void listDirectoryContent(File ioDirectory){
		listDirectoryContent(ioDirectory, 0);
	}	
	
	private static void listDirectoryContent(File ioDirectory, int nHierarchicalLevel){

		File[] aioFile = ioDirectory.listFiles();

		if (aioFile!=null) {
			for(int nI=0; nI<aioFile.length; nI++){
				for(int nJ=0; nJ<nHierarchicalLevel; nJ++) {
					System.out.print("\t");
				}
				System.out.print(aioFile[nI]);
				if (aioFile[nI].isDirectory()) {
					System.out.print("/");
					listDirectoryContent(aioFile[nI], nHierarchicalLevel+1);
				}
				else {
					System.out.print("\t" + aioFile[nI].length() + " octets");
				}
				System.out.println();
			}
		}
	}

	public static void removeDuplicates(File ioDirectory){
		removeDuplicates(ioDirectory, 0);
	}	
	
	private static void removeDuplicates(File ioDirectory, int nHierarchicalLevel){

		File[] aioFile = ioDirectory.listFiles();

		if (aioFile!=null) {
			for(int nI=0; nI<aioFile.length; nI++){
				if (aioFile[nI].isDirectory()) {
					removeDuplicates(aioFile[nI], nHierarchicalLevel+1);	// Recursive call.
				}
				else {
					// Determine destination file path.
					File ioDestinationFile = new File(DESTINATION_DIRECTORY + aioFile[nI].getAbsolutePath().substring(SOURCE_DIRECTORY.length()));

					// Check if destination file exists and has the same size as the original.
					if (ioDestinationFile.exists() && ioDestinationFile.length()==aioFile[nI].length()) {
						// Effectively delete destination file.
						ioDestinationFile.delete();
						System.out.println(ioDestinationFile + " deleted");
					}
					
					
				}
			}
		}
	}

	private static void editMedata(File ioDirectory, int nHierarchicalLevel){

		/// vérifier si cette map est la meilleure
		
		Map<String, String> mapOpening = new HashMap<String, String>();
		mapOpening.put("AL", "Alekhine's Defence");
		mapOpening.put("BI", "Benoni Defense");
		mapOpening.put("CA", "Catalan Opening");
		mapOpening.put("CK", "Caro-Kann Defence");
		mapOpening.put("EO", "English Opening");
		mapOpening.put("FR", "French Defence");
		mapOpening.put("GI", "Grünfeld Defence");
		mapOpening.put("HD", "Dutch Defence");
		mapOpening.put("HED", "Hedgehog");
		mapOpening.put("HIP", "Hippopotamus Defence");
		mapOpening.put("IG", "Italian Game");
		mapOpening.put("KF", "King's Fianchetto Opening");
		mapOpening.put("KG", "King's Gambit");
		mapOpening.put("KI", "King's Indian Defence");
		mapOpening.put("KIA", "King's Indian Attack");
		mapOpening.put("KP", "King's Pawn Game");
		mapOpening.put("NI", "Nimzo-Indian Defence");
		mapOpening.put("OI", "Old Indian Defense");
		mapOpening.put("PU", "Pirc Defence");
		mapOpening.put("QG", "Queen's Gambit Accepted, QGA");
		mapOpening.put("QI", "Queen's Indian Defense, QID");
		mapOpening.put("QO", "Queen's Gambit");
		mapOpening.put("QP", "Queen's Pawn Openings");
		mapOpening.put("RE", "Réti Opening");
		mapOpening.put("RG", "Russian Game, Petrov's Defence");
		mapOpening.put("RL", "Ruy Lopez, Spanish Opening");
		mapOpening.put("SD", "Scandinavian Defense, Center Counter Defense");
		mapOpening.put("SI", "Sicilian Defence");
		mapOpening.put("SL", "Slav Defense");
		mapOpening.put("SO", "Scotch Game, Scotch Opening");
		mapOpening.put("TD", "Tarrasch Defense");
		mapOpening.put("VG", "Vienna Game");
		mapOpening.put("VO", "Various Openings");
		System.out.println(mapOpening.get("KIA"));
		
		
		File[] aioFile = ioDirectory.listFiles();

		if (aioFile!=null) {
			for(int nI=0; nI<aioFile.length; nI++){
				if (aioFile[nI].isDirectory()) {
					removeDuplicates(aioFile[nI], nHierarchicalLevel+1);	// Recursive call.
				}
				else {
					// Determine destination file path.
					File ioDestinationFile = new File(DESTINATION_DIRECTORY + aioFile[nI].getAbsolutePath().substring(SOURCE_DIRECTORY.length()));

					// Check if destination file exists and has the same size as the original.
					if (ioDestinationFile.exists() && ioDestinationFile.length()==aioFile[nI].length()) {
						// Effectively delete destination file.
						ioDestinationFile.delete();
						System.out.println(ioDestinationFile + " deleted");
					}
					
					
				}
			}
		}
	}
	
	
}
