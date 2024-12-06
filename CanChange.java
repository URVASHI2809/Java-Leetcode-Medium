public class CanChange {
    public boolean canChange(String start, String target) {
        if (start.equals(target)) {
            return true;
        }

        int waitL = 0;
        int waitR = 0;
        
        for (int i = 0; i < start.length(); i++) {
            char curr = start.charAt(i); 
            char goal = target.charAt(i); 

            if (curr == 'R') {
                if (waitL > 0) {
                    return false;
                }
                waitR++;
            }
            
            if (goal == 'L') {
                if (waitR > 0) {
                    return false;
                }
                waitL++;
            }

            if (goal == 'R') {
                if (waitR == 0) {
                    return false;
                }
                waitR--;
            }

            if (curr == 'L') {
                if (waitL == 0) {
                    return false;
                }
                waitL--;
            }
        }
        return waitL == 0 && waitR == 0;
    }

    public static void main(String[] args) {
        CanChange solution = new CanChange();

        // Test case 1
        String start = "R_L_";
        String target = "__LR";
        System.out.println("Test case 1: " + solution.canChange(start, target)); // Expected: true

        // Test case 2
        start = "R_L_";
        target = "L_R_";
        System.out.println("Test case 2: " + solution.canChange(start, target)); // Expected: false
    }
}

