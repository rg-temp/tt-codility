package com.github.rgtemp.task1;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EditedSolution extends Solution {
	/**
d:[0:1, 1, 0, 1, 1, 5:1, 0, 1, 1, 1, 10:0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
l:10
	 */
	private static final Logger logger = LogManager.getLogger(EditedSolution.class.getName());
	
	@Override
    public int solution(int n) {
		logger.error("in n:" + n);
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        logger.error("d:" + Arrays.toString(d));
        logger.error("l:" + l);
        for (p = 1; p <= l / 2; ++p) {
        	logger.error("*********for p");
        	logger.error("for p:" + p);
            int i;
            boolean ok = true;
            for (i = l - 1 - p; i >= p / 2; --i) {
//            	for (i = l - 1 - p; ok && i >= l / 2 ; --i) {
//            for (i = l - 1 ; ok && i >= l / 2; --i) {
            	logger.error("for i:" + i);
                if (d[i] != d[i + p]) {
                    ok = false;
                    logger.error("breaking p:" + p + " i:" + i);
                    break;
                }
                else { logger.error("   Match p:" + p + " i:" + i);}
            }
            if (ok) {
            	logger.error("returning p:" + p + " i:" + i);
                return p;
            }
        }
        return -1;
    }

}
