public class main {
    public static void main(String[] args) throws InterruptedException {
        final int width = 80;
        final int height = 40;
        final double distance = 3.0;

        double[][] vertices = {
            {-1, -1, -1},
            {1, -1, -1},
            {1, 1, -1},
            {-1, 1, -1},
            {-1, -1, 1},
            {1, -1, 1},
            {1, 1, 1},
            {-1, 1, 1}
        };

        int[][] edges = {
            {0, 1}, {1, 2}, {2, 3}, {3, 0},
            {4, 5}, {5, 6}, {6, 7}, {7, 4},
            {0, 4}, {1, 5}, {2, 6}, {3, 7}
        };

        double angleX = 0;
        double angleY = 0;
        double angleZ = 0;

        for (int frame = 0; frame < 200; frame++) {
            char[][] screen = new char[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    screen[y][x] = ' ';
                }
            }

            for (int[] edge : edges) {
                double[] p1 = rotate(vertices[edge[0]], angleX, angleY, angleZ);
                double[] p2 = rotate(vertices[edge[1]], angleX, angleY, angleZ);
                int[] s1 = project(p1, width, height, distance);
                int[] s2 = project(p2, width, height, distance);
                drawLine(screen, s1[0], s1[1], s2[0], s2[1]);
            }

            System.out.print("\u001b[H\u001b[2J");
            for (int y = 0; y < height; y++) {
                System.out.println(new String(screen[y]));
            }
            System.out.println("Simulador 3D: cubo rotacionando");

            angleX += 0.07;
            angleY += 0.05;
            angleZ += 0.03;
            Thread.sleep(100);
        }
    }

    private static double[] rotate(double[] point, double ax, double ay, double az) {
        double x = point[0];
        double y = point[1];
        double z = point[2];

        double cosX = Math.cos(ax);
        double sinX = Math.sin(ax);
        double cosY = Math.cos(ay);
        double sinY = Math.sin(ay);
        double cosZ = Math.cos(az);
        double sinZ = Math.sin(az);

        double y1 = y * cosX - z * sinX;
        double z1 = y * sinX + z * cosX;
        double x2 = x * cosY + z1 * sinY;
        double z2 = -x * sinY + z1 * cosY;
        double x3 = x2 * cosZ - y1 * sinZ;
        double y3 = x2 * sinZ + y1 * cosZ;

        return new double[] {x3, y3, z2};
    }

    private static int[] project(double[] point, int width, int height, double distance) {
        double factor = distance / (distance + point[2]);
        int x = (int) ((point[0] * factor + 1) * width / 2);
        int y = (int) ((point[1] * factor + 1) * height / 2);
        if (x < 0) x = 0;
        if (x >= width) x = width - 1;
        if (y < 0) y = 0;
        if (y >= height) y = height - 1;
        return new int[] {x, y};
    }

    private static void drawLine(char[][] screen, int x0, int y0, int x1, int y1) {
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            if (y0 >= 0 && y0 < screen.length && x0 >= 0 && x0 < screen[0].length) {
                screen[y0][x0] = '*';
            }
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }
}
