time complexity: O(m + n)
space complexity: O(1)

public void merge(int[] nums1, int m, int[] nums2, int n) {
    int size = m + n - 1;
    while(m > 0 && n > 0) {
        if (nums2[n - 1] > nums1[m - 1]) {
            nums1[size--] = nums2[n - 1];
            n--;
        } else {
            nums1[size--] = nums1[m - 1];
            m--;
        }
    }
    while (n > 0) {
        nums1[size--] = nums2[n-1];
        n--;
    }
}