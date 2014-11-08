package com.github.rgtemp.task1;

import java.util.function.Function;

public class Solution implements Function<Integer, Integer> {
	
//	Consider a non-empty string S = S[0]S[1]...S[Q-1] consisting of Q 
//	characters. The period of this string is the smallest positive integer P 
//	such that:
//	P <= Q / 2 and
//	S[K] = S[K+P] for every K, where 0 <= K < Q - P.
//
//	For example, 8 is the period of "codilitycodilityco" and 7 is the period of "abracadabracadabra".
//	A positive integer M is the binary period of a positive integer N if M is the period of the binary representation of N.
//	For example, 4 is the binary period of 955, because the binary representation of 955 is "1110111011" and its period is 4.
//	You are given an implementation of a function:
//
//	class Solution { public int solution(int N); }
//	This function, when given a positive integer N, returns the binary period of N. The function returns -1 if N does not have a binary period.
//	For example, given N = 955 the function returns 4, as explained in the example above.
//	Unfortunately, despite the fact that the function may return expected
//	result for the example input, there is a bug in the implementation, which
//	may produce incorrect results for other inputs. Find the bug and correct
//	it. You should modify at most two lines of code.
//	Assume that:
//	N is an integer within the range [1..1,000,000,000].
//	Complexity:
//	expected worst-case time complexity is O(log(N)2);
//	expected worst-case space complexity is O(log(N)).
//
//  Extra custom info:
//  * The first loop stores the more significant bit a d[0].
//  * Problem asks for smallest integer.
//  * asBinary(1,000,000,000) = 11 1011 1001 1010 1100 1010 0000 0000
//	  * length = 30
//	* "You should modify at most two lines of code" Codility restricts adding
//	  or deleting lines, max 2 lines modified.
//	
	
    public int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

	@Override
	public Integer apply(Integer x) {
		return solution(x);
	}
}
