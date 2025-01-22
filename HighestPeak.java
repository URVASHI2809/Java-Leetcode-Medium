class HighestPeak {
    public int[][] highestPeak(int[][] arr) {
        int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};
        int[][]temp=new int[arr.length][arr[0].length];
        for(int[]a:temp){
            Arrays.fill(a,-1);
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    temp[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                int[]curr=q.poll();
                int i=curr[0];
                int j=curr[1];
                for(int[]d:dir){
                    int ni=i+d[0];
                    int nj=j+d[1];
                    if(ni>=0 && ni<arr.length && nj>=0 && nj<arr[0].length && temp[ni][nj]==-1){
                        temp[ni][nj]=temp[i][j]+1;
                        q.add(new int[]{ni,nj});
                    }
                }
            }
        }
        return temp;
    }
}
