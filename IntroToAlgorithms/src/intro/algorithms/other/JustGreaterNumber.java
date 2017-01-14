package intro.algorithms.other;

public class JustGreaterNumber {

	public long findGreaterNumber(long input) {
		String inputAsString = ""+input;
		String result = findGreaterNumber(inputAsString);
		return result != null ? Long.valueOf(result) : -1;
	}
	
	private String findGreaterNumber(String input) {
		if(input.length() <= 1) {
			return null;
		}

		int lastNum = input.charAt(input.length()-1)-48;
		for(int i=input.length()-2; i>=0; i--) {
			int num = input.charAt(i) - 48;
			if(lastNum <= num) {
				lastNum = num;
			} else {
				// Position found where decreasing order of digits is broken
				String restString = input.substring(i+1);
				int substituteNumPosition = findSmallestNumberGreaterThanNumPosition(num, restString);
				int substituteNumber = restString.charAt(substituteNumPosition) - 48;
				restString = restString.substring(0, substituteNumPosition) + num + restString.substring(substituteNumPosition+1);
				String result = input.substring(0,  i)+substituteNumber;
				
				for(int j=restString.length() - 1; j>=0; j--) {
					result += restString.charAt(j);
				}
				return result;
			}
		}
		
		return null;
	}
	
	private int findSmallestNumberGreaterThanNumPosition(int num, String input) {
		for(int i=0; i<input.length(); i++) {
			int currNum = input.charAt(i) - 48;
			if(currNum <= num) {
				return i-1;
			}
		}
		return input.length()-1;
	}
}
