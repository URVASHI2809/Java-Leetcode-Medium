class MaxAbsoluteSum {
    public int maxAbsoluteSum(int[] a) {
        int n=a.length, total=0, sum=0, x=a[0], min=0, max=0;
        if(a[0]<min)min = a[0];
        if(a[0]>max)max = a[0];
        for(int i=1; i<n; i++)
        {
            x = x+a[i];
            if(x > max)max = x;
            if(x < min)min = x;
        }
        return Math.abs(max-min);
    }
}
