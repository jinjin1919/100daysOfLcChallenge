package leetCode;

public class WordAbbreviation {
	
	public static boolean validWordAbbreviation(String word, String abbr) {
        
        int p1 = 0; 
        int p2 = 0; 

        while(p1 < word.length() && p2 < abbr.length()) {
            
            if(Character.isLetter(abbr.charAt(p2)) && abbr.charAt(p2) != word.charAt(p1)){
                return false; 
            }

            if(Character.isDigit(abbr.charAt(p2))){
                if(abbr.charAt(p2) == '0') return false; 
                int num = 0; 
                while(p2 < abbr.length() && Character.isDigit(abbr.charAt(p2))){
                    num = num * 10 + Integer.parseInt(abbr.charAt(p2) + ""); 
                    p2++; 
                }
                p1 += num; 
            }else{
                p1++; 
                p2++; 
            }
        }

        return p1 == word.length() && p2 == abbr.length(); 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
		System.out.println(validWordAbbreviation("apple", "a2e"));
	}

}
