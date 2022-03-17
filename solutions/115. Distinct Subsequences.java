            Arrays.fill(m, -1);
        }
        int result = helper(s, t, 0 ,0);
        System.out.println(count);
        int result2 = numDistinct2(s, t);
        System.out.println(count2);
        return result;
    }
    
    private int helper(String s, String t, int i, int j) {
        if(j == t.length()) {
            return 1;
        }
        if(i == s.length()) {
            return 0;
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        int ans = 0;
        count++;
        if(s.charAt(i) == t.charAt(j)) {
            ans = helper(s, t, i + 1, j + 1) + helper(s, t, i + 1, j);
        } else {
            // not choose
            ans = helper(s, t, i + 1, j);
        }
        return memo[i][j] = ans;
    }
    
    public int numDistinct2(String S, String T) {
        // array creation
        int[][] mem = new int[T.length()+1][S.length()+1];
​
        // filling the first row: with 1s
        for(int j = 0; j <= S.length(); j++) {
            mem[0][j] = 1;
        }
​
        // the first column is 0 by default in every other rows but the first, which we need.
​
        for(int i = 0; i < T.length(); i++) {
            for(int j = 0; j < S.length(); j++) {
                count2++;
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }
​
        return mem[T.length()][S.length()];
    }
}
