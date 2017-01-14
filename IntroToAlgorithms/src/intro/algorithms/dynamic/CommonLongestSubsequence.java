package intro.algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;

public class CommonLongestSubsequence {
	
	private enum Moved {
		I, J, BOTH, IORJ
	}

	public String[] calculate(String A, String B) {
		int [][] lengths = new int[A.length()+1][B.length()+1];
		Moved [][] movements = new Moved [A.length()+1][B.length()+1];
		
		for(int i=1; i<=A.length(); i++) {
			for(int j=1; j<=B.length(); j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					lengths[i][j] = lengths[i-1][j-1] + 1;
					movements[i][j] = Moved.BOTH;
				} else {
					if(lengths[i-1][j] > lengths[i][j-1]) {
						lengths[i][j] = lengths[i-1][j];
						movements[i][j] = Moved.I;
					} else if(lengths[i-1][j] < lengths[i][j-1]) {
						lengths[i][j] = lengths[i][j-1];
						movements[i][j] = Moved.J;
					} else {
						lengths[i][j] = lengths[i-1][j];
						movements[i][j] = Moved.IORJ;
					}
				}
			}
		}
		
		List<StringBuilder> sbs = new ArrayList<>();
		sbs.add(new StringBuilder());
		
		buildLCS(sbs, 0, movements, A, A.length(), B.length());
		
		String[] result = new String[sbs.size()];
		
		for(int i=0; i<result.length; i++) {
			result[i] = sbs.get(i).toString();
		}
		
		return result;
	}
	
	private void buildLCS(List<StringBuilder> sbs, int builder, Moved [][] movements, String A, int i, int j) {
		if(i==0 || j==0) {
			return;
		}
		
		if(movements[i][j] == Moved.BOTH) {
			sbs.get(builder).insert(0, A.charAt(i-1));
			buildLCS(sbs, builder, movements, A, i-1, j-1);
		} else if(movements[i][j] == Moved.I) {
			buildLCS(sbs, builder, movements, A, i-1, j);
		} else if(movements[i][j] == Moved.J) {
			buildLCS(sbs, builder, movements, A, i, j-1);
		} else {
			sbs.add(new StringBuilder(sbs.get(builder).toString()));
			buildLCS(sbs, sbs.size() - 1, movements, A, i, j-1);
			buildLCS(sbs, builder, movements, A, i-1, j);
		}
	}
}
