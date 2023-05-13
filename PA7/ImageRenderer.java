import java.awt.*;

/**
 * Render MNIST images and display predictions
 *
 * Do not worry about understanding any of the code here
 * Just run the main method :)
 */

public class ImageRenderer {
    private static final int PIXEL_SIZE = 35;
    private int width;
    private int height;
    private int padx;
    private int pady;

    private static class Pixel {
        private Color color;

        public Pixel(Color c) {
            this.color = c;
        }

        public void draw(double x, double y) {
            StdDraw.setPenColor(color);
            StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
        }
    }

    public void init(int w, int h, int padX, int padY, Pixel[][] img) {
        this.width = w;
        this.height = h;
        this.padx = padX;
        this.pady = padY;

        StdDraw.setCanvasSize((width+2*padx) * PIXEL_SIZE, (height+2*pady) * PIXEL_SIZE);

        StdDraw.setXscale(0, width+2*padx);
        StdDraw.setYscale(0, height+2*pady);
        StdDraw.clear(Color.BLACK);

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                img[i][j] = new Pixel(Color.WHITE);
            }
        }

        StdDraw.enableDoubleBuffering();
        StdDraw.show();
    }

    public void render(Pixel[][] img) {
        StdDraw.clear(Color.GRAY);
        StdDraw.setFont(new Font("Courier", Font.PLAIN, PIXEL_SIZE*5/4));
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text( this.width / 2. + 1, this.height + 7, "Q to quit | C to clear");
        StdDraw.text(this.width / 2. + 1, this.height + 5, "G to guess | N to cycle");
        for (int x = 0; x < img.length; x += 1) {
            for (int y = 0; y < img[0].length; y += 1) {
                img[x][y].draw(x + padx, y + pady);
            }
        }
        StdDraw.show();
    }

    public static float[] flatten(Pixel[][] img) {
        float[] ans = new float[28*28];
        for (int i = 0; i < img.length; i ++) {
            for (int j = 0; j < img[0].length; j++) {
                ans[i + j*28] = (img[i][27-j].color == Color.BLACK) ? 1 : 0;
            }
        }
        return ans;
    }

    public void changeColor(int i, int j, Pixel[][] img) {
        boolean changed = false;
        for (int x = i - 1; x < i + 1; x++) {
            for (int y = j - 1; y < j + 1; y++) {
                if (x < 28 && x >= 0 && y < 28 && y >= 0
                        && img[x][y].color.equals(Color.WHITE)) {
                    changed = true;
                    img[x][y].color = Color.BLACK;
                }
            }
        }
        if (changed) {
            this.render(img);
        }
    }

    public void drawGuess(int guess) {
        StdDraw.setFont(new Font("Courier", Font.PLAIN, PIXEL_SIZE*3/2));
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text( this.width / 2. + 1, 2, "Guess: " + guess);
        StdDraw.show();
    }

    public static void main(String[] args) {

        MNIST.downloadMNIST();

        int padX = 2;
        int padY = 4;

        ImageRenderer pr = new ImageRenderer();
        Pixel[][] img = new Pixel[MNIST.IMG_DIM][MNIST.IMG_DIM];
        pr.init(28, 28, padX, padY, img);

        pr.render(img);

        boolean over = false;

        int ctr = 0;
        while(!over) {
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                int tileX = ((int) x) - padX;
                int tileY = ((int) y) - padY;
                pr.changeColor(tileX, tileY, img);
            }

            if (StdDraw.hasNextKeyTyped()) {
                char curr = StdDraw.nextKeyTyped();
                if (curr == 'Q' || curr == 'q') {
                    over = true;
                } else if (curr == 'G' || curr == 'g') {
                    float[] data = flatten(img);
                    int guess = MNIST.predict(data, 1);
                    pr.drawGuess(guess);
                } else if (curr == 'C' || curr == 'c') {
                    for (int i = 0; i < img.length; i++) {
                        for (int j = 0; j < img[0].length; j++) {
                            img[i][j].color = Color.WHITE;
                        }
                    }
                    pr.render(img);
                } else if (curr == 'N' || curr == 'n') {
                    for (int i = 0; i < MNIST.TEST_IMAGES[ctr].length; i++) {
                        int num = Math.round(MNIST.TEST_IMAGES[ctr][i]);
                        img[i % 28][27 - i / 28].color = (num == 1) ? Color.BLACK : Color.WHITE;
                    }
                    float[] data = flatten(img);
                    int guess = MNIST.predict(data, 1);
                    ctr++;
                    pr.render(img);
                    pr.drawGuess(guess);
                }
            }
        }

        StdDraw.pause(100);
        System.exit(0);

    }
}