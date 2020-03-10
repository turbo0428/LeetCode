time complexity: O(n)
space complexity: o(1)

count表示最多能放多少盆, pre表示前一个位置是不是1

如果当前flowerbed[i] == 1, 如果前面已经放了花, 则count-- 因为出现了连续2个1, 否则pre = true.
如果当前flowerbed[i] == 0, 如果前面没有放花, 则count++, pre = true. 否则, pre = false;
最后判断count是否大于n

public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    boolean pre = false;
    for (int i = 0; i < flowerbed.length; ++i) {
        if (flowerbed[i] == 1) {
            if (pre) count--;
            pre = true;
        } else {
            if (!pre) {
                count++;
                pre = true;
            } else {
                pre = false;
            }
            
        }
    }
    return count >= n;
}



public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    for(int i = 0; i < flowerbed.length && count < n; i++) {
        if(flowerbed[i] == 0) {
     //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0. 
           int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
           int prev = (i == 0) ? 0 : flowerbed[i - 1];
           if(next == 0 && prev == 0) {
               flowerbed[i] = 1;
               count++;
           }
        }
    }
    
    return count == n;
}