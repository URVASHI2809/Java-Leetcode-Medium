package Java;

public class FindChampionII {
        public int findChampion(int n, int[][] edges) {
            int[] inDegree = new int[n];

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                inDegree[v]++;
            }
            int championCount = 0;
            int champion = -1;

            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    championCount++;
                    champion = i;
                }
            }
            if (championCount == 1) {
                return champion;
            }
            return -1;
        }

    public static void main(String[] args) {
        FindChampionII champion = new FindChampionII();

        // Test case 1
        int[][] edges1 = {{0, 1}, {1, 2}};
        System.out.println(champion.findChampion(3, edges1));  // Output: 0

        // Test case 2
        int[][] edges2 = {{0, 2}, {1, 3}, {1, 2}};
        System.out.println(champion.findChampion(4, edges2));  // Output: -1

        // Test case 3
        int[][] edges3 = {{0, 1}, {2, 1}, {3, 1}};
        System.out.println(champion.findChampion(4, edges3));  // Output: 0
    }
}
