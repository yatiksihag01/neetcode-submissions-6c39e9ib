class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean foundX = false;
        boolean foundY = false;
        boolean foundZ = false;

        int tx = target[0];
        int ty = target[1];
        int tz = target[2];

        for (int i = 0; i < triplets.length; i++) {
            int x = triplets[i][0];
            int y = triplets[i][1];
            int z = triplets[i][2];

            if (x <= tx && y <= ty && z <= tz) {
                if (x == tx) foundX = true;
                if (y == ty) foundY = true;
                if (z == tz) foundZ = true;
            }
        }

        return foundX && foundY && foundZ;
    }
}
