/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

	// preprocess
	String newstr1 = preProcess (str1);
	String newstr2 = preProcess (str2);
	
    // length 
    if (newstr1.length()!= newstr2.length())
	return false; 

// while 1 
    int i = 0;
	while (i < newstr1.length()) {
    char c = newstr1.charAt(i); 

	    if (newstr2.indexOf(c) == -1) {
        return false; 
	    } else {
			int j = newstr2.indexOf(c);
			newstr2 =  newstr2.substring(0, j) + newstr2.substring (j+1);
		}  
		i++;
	 return true;
	  
	}
	return true;
}
	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
	// define results
     String result = "";
	 // for
	   for ( int i=0; i < str.length(); i++ ) {
		char c = str.charAt(i);

		if (Character.isLetter(c)) {
			result = result + c;
		}
          // make lowercase
          result = result.toLowerCase();
		}
		  return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
     String random = "";
	 
     while (str.length() > 0) {

     // random number 
	 int num = (((int) Math.random()) * str.length()); 
	 char a = str.charAt(num);
	 str =  str.substring(0, num) + str.substring (num+1);

    // new string 
    random = random + a; 

	 }

	return random;

	}

	}

