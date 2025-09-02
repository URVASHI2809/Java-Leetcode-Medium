class NumberOfPairs {
    public int numberOfPairs(int[][] points) {

        int n = points.length;
    Arrays.sort(points,(a,b) -> {
        if(a[0] == b[0])  return b[1] - a[1];
        return a[0] - b[0];
    });

    int ans = 0;

    for(int i=0;i<n;i++){
        int b = points[i][1];
         int last =-1;
        for(int j=i+1;j<n;j++){
            int a = points[j][1];

            if(a <= b && a > last){
                ans++;
                last = a;
            }
        }
    }
    return ans;
    }
}
