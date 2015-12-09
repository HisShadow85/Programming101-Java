package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Chiper {
    private ArrayList<Character> mostFrequentLetters = new ArrayList<Character>(Arrays.asList('e','t','a','o','i','n','s','h','r','d','i','c','u','m','w','f','g','y','p','b','v','k','j','x','q','z'));
	public static void main(String[] args) {
		Chiper enigma = new Chiper();
		String encryptText = "Ajb vnf guj luqv akjvojufq  . Sk qkkj egvfs Rkhfwu Lumemu'q akhhfjvq kj vnf ohifjbojc essoxew kg Dofck Ckqve , nfsf'q Ffsjejbk Tkssfq vk qnkr vnf ohifvukuq zkujc dkz nkr ov'q bkjf    Iv'q vnf qehf fxfsz quhhfs . Nk-kjf neq fxfs coxfj hf ejzvnojc kj e iwevf . Tnfz hebf hf akhifvf gks hz iweaf vnf xfsz hkhfjv I ckv ojvk vnf gosqv vfeh;";
		encryptText += "vnev'q rnev vnfz veucnv hf ejb ov'ww df vnev rez ujvow I wfexf . Tnf nocnfs puewovz iwezfsq vnev akhf - ejb Dofck Ckqve oq puewovz - vnf csfevfs vnf akhifvovokj roww df ejb vnf dfvvfs ov'ww df gks vnf vfeh .Ajb gfes jkv ( ks , ewvfsjevoxfwz , bkj'v cfv vkk ftaovfb)  , Tkssfq neq jk iwejq vk vuam veow ejb suj ejb wfexf noq iezanfamq dfnojb .    I bkj'v nexf ejz iwejq vk hkxf erez socnv jkr .    Ig rf woqvfjfb vk eww vnf suhkusq rf'b nexf 50 iwezfsq . Nkr'q jkv vnf socnv vohf vk df vnojmojc edkuv Cnfwqfe .";
		encryptText += " I'h qusf vnf awud oq rksmojc vk ohiskxf vnf vfeh , duv eww vnev hevvfsq socnv jkr oq vnf Wkswb Cui .Om , vnev dov edkuv vnf 50 iwezfsq hebf hf anuamwf .  Noaf kjf , Ffsjejbk .Nkr , oj ej obfew rkswb , rf rkuwb ifsneiq cfv vnfqf rksbq gskh Lumemu , rnkh rf'b womf vk dfakhf wfcfjbesz ev Cnfwqfe .  Buv rf bkj'v woxf oj ej obfew rkswb , ejb ojqvfeb rf cfv vnfqf rksbq gskh Tkssfq , rnkh rf'b womf vk dfakhf e wkjc-gksckvvfj hfhksz ev Cnfwqfe .  Aweq .Tnev dfojc qeob , qojaf ov'q deqoaewwz ej ohikqqodwf vk veqm vk sob kusqfwxfq kg vnf £100h gwki , ev wfeqv nf'q ckv vnf socnv evvovubf .  Hussez?";
		System.out.println(enigma.getDecryptMessege(encryptText));
	}
    /*
     * method produce a map corresponding to the usage of every character in the given string as an argument
     * text -> encrypted message
     * */
	public Map<Character,Integer> getCharacterOccurrances(String text){
		text = getValidString(text);
		//map : key-> the used char :value -> how many times it was encountered
		Map<Character,Integer> letters = new HashMap<Character,Integer>();
		//for every char into the new text
		for (int index = 0; index < text.length(); index++) {
			//if the char exists increase the number of occurrences by one 
			if(letters.containsKey(text.charAt(index))){
				letters.put(text.charAt(index),(letters.get(text.charAt(index))+1));
			}
			else{//else just put it into the map
				letters.put(text.charAt(index), 1);
			}
		}
		
		return letters;		
	}

	/*
	 * sortedSet -> descending sorted set of the most frequently used characters in the encrypted message
	 * sortedMostUsedChars -> descending sorted set of the most frequently used characters in  english language
	 * */
	
	public Map<Character,Character> getDecodingMap(SortedSet<Character> sortedSet,List<Character> sortedMostUsedChars){
		//key -> the character from the encrypted message //value -> corresponding characters from english language
		HashMap<Character,Character> decodingMap = new HashMap<>();
		
		Iterator<Character> sortedSetIt = sortedSet.iterator();
		Iterator<Character> sortedMostUsedCharsIt = sortedMostUsedChars.iterator();
		//merge the two sets into one map
		while(sortedSetIt.hasNext() && sortedMostUsedCharsIt.hasNext()){
			decodingMap.put(sortedSetIt.next(), sortedMostUsedCharsIt.next());
		}
		return decodingMap;
	}
	
	/*
	 * This method replace all characters from the encryptText
	 * whit their corresponding characters in the cipher
	 * Return the decrypted string
	 * */
	public String applyCipher(Map<Character, Character> cipher,String encryptText){
		StringBuilder sb = new StringBuilder();
		//for every char in the encryptText
		for (int index = 0; index < encryptText.length(); index++) {
			//if the char is letter
			if(Character.isLetter(encryptText.charAt(index))){
				char ch = encryptText.charAt(index);
				boolean isCapital =  false;
				
				if(Character.isUpperCase(ch)){
					isCapital = true;
					ch = Character.toLowerCase(ch);
				}
				
				ch = cipher.get(ch);
				
				if(isCapital){
					sb.append(Character.toUpperCase(ch));
				}
				else{
					sb.append(ch);
				}
			}
			else{
				sb.append(encryptText.charAt(index));
			}
		}
		
		return sb.toString();
	}
	
	/*
	 * Decrypts the given encryptMessege 
	 * */
	public String getDecryptMessege(String encryptMessege){		
		SortedSet<Character> sortedChars = sortByOccurrences(getCharacterOccurrances(encryptMessege));
		Map<Character,Character> decodingMap = getDecodingMap(sortedChars,mostFrequentLetters);
		String result = applyCipher(decodingMap,encryptMessege);
		return result;
	}
	
	/*
	 * This method gets a Map<Character,Integer> and produces a sorted set of map's key.
	 * The order is descending.
	 * */
	SortedSet<Character> sortByOccurrences(Map<Character,Integer> letters){
		//make a comparator to compare the Characters from the Map<Character,Integer>
		ValueComparator<Character,Integer> comp = new ValueComparator<Character,Integer>(letters);
		//the result set
		SortedSet<Character> sortedSet = new TreeSet<Character>(comp);
		//sorts the keys from the Map<Character,Integer> (letters)
		for(Entry<Character,Integer> entry : letters.entrySet()){
			sortedSet.add(entry.getKey());
		}
		return sortedSet;
	}
	
	/*
	 * Method compares two key first based on their value, second on their order in alphabet
	 * */
	
	class ValueComparator<K extends Comparable<K>,V extends Comparable<V>> implements Comparator<K> {
	    Map<K ,V> base; //map from which we are going to take the keys

	    public ValueComparator(Map<K,V> base) {
	        this.base = base;
	    }

		@Override
		public int compare(K o1, K o2) {
			V value1 = base.get(o1);
			V value2 = base.get(o2);
			if(value2.compareTo(value1) == 0){
				return o2.compareTo(o1);
			}
			else{
				return value2.compareTo(value1);
			}
		}
	}
	
	String getValidString(String text){
		       //remove everything that is not a char.
				text = text.replaceAll("[^a-zA-z]", " ");
				//Remove single char words.
				text = text.replaceAll("\\b\\w{1,2}\\b\\s?", " ");
				//Replace the sequences of white spaces with empty space
				text = text.replaceAll("() +", "");
				//make everything to lower case
				text = text.toLowerCase();
				return text;
	}
	
}
