import java.io.*;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

public class MNIST {

    public static final int NUM_TEST = 1_000;   // can be up to 10k
    public static final int NUM_TRAIN = 60_000; // can be up to 60k

    public static final int K = 3;
    public static final int NUM_CLASSES = 10;
    public static final int IMG_DIM = 28;

    private static final float[][] TRAIN_IMAGES = new float[NUM_TRAIN][IMG_DIM * IMG_DIM];
    private static final short[] TRAIN_LABELS = new short[NUM_TRAIN];
    public static final float[][] TEST_IMAGES = new float[NUM_TEST][IMG_DIM * IMG_DIM];
    private static final short[] TEST_LABELS = new short[NUM_TEST];

    /**
     * Custom class for storing both labels and
     * priority values in the priority queue
     */
    private static class ImageLabel implements Comparable<ImageLabel> {
        int label;
        float priority;

        /**
         * Constructor that creates a new ImageLabel
         *
         * @param label A number from 0 to 9 that describes the image.
         * @param priority A value that determines how close this image is
         *                 to the current image being tested
         *                 lower priority = better fit
         */
        public ImageLabel(int label, float priority) {
            this.label = label;
            this.priority = priority;
        }


        /**
         * @param imageLabel
         * @return an integer that determines whether priority is lower,
         *         greater, or equal to that of imageLabel
         */
        @Override
        public int compareTo(ImageLabel imageLabel) {
            /* TODO */
            return 0;
        }
    }

    /**
     * TODO: Implement totalDist
     * Calculate Euclidean distance between two vectors (1-D arrays)
     * @param img1 the first array
     * @param img2 the second array
     * @throws IllegalArgumentException if arrays have different length
     * @return the Euclidean distance between img1 and img2
     */
    public static float totalDist(float[] img1, float[] img2) throws IllegalArgumentException {
        /* TODO */
        return 0;
    }

    /**
     * TODO: Implement predict
     * Makes a prediction using the K-NN Classifier
     * You may assume k < n (amount of training data)
     *
     * @param image the array that contains image data
     * @param k the number of nearest neighbors to check
     * @return an integer between 0 and 9 that describes the image
     */
    public static int predict(float[] image, int k) {
        //initialize min priority queue using euclidean distance for priority
        MyPriorityQueue<ImageLabel> pq = new MyPriorityQueue<>(NUM_TRAIN);

        /* TODO */
        return -1;
    }

    /**
     * Loads MNIST data into the specified arrays
     * adapted from https://dilithjay.com/blog/read-mnist-images-in-java/
     *
     * @param imgFile the link to MNIST images
     * @param lblFile the link to MNIST labels
     * @param imgArr the array to store images (dimension nx784)
     * @param lblArr the array to store labels (dimension n)
     */
    public static void loadData(String imgFile, String lblFile, float[][] imgArr, short[] lblArr) throws IOException {

        File data = Paths.get( "src", "data", imgFile).toFile();
        InputStream stream = new FileInputStream(data);
        InputStream imgIn = new GZIPInputStream(stream);

        data = Paths.get( "src", "data", lblFile).toFile();
        stream = new FileInputStream(data);
        InputStream lblIn = new GZIPInputStream(stream);

        // first 16 bytes of image data are metadata
        // first 8 bytes of label data are metadata
        byte[] tempBuffer = new byte[16];
        imgIn.read(tempBuffer, 0, 16);
        lblIn.read(tempBuffer, 0, 8);

        byte[] dataBuffer = new byte[1];

        for (int i = 0; i < lblArr.length; i++){
            lblIn.read(dataBuffer, 0, 1);
            lblArr[i] = (short) (dataBuffer[0] & 0xFF);

            for (int j = 0; j < IMG_DIM * IMG_DIM; j++){
                imgIn.read(dataBuffer, 0, 1);
                float pixelVal = (dataBuffer[0] & 0xFF) / 255.f;
                imgArr[i][j] = pixelVal;
            }
        }
    }

    /**
     * Calls loadData on each MNIST dataset
     */
    public static void downloadMNIST() {
        long startTime = System.currentTimeMillis();

        String trainImagesFile = "train-images-idx3-ubyte.gz";
        String trainLabelsFile = "train-labels-idx1-ubyte.gz";
        String testImagesFile = "t10k-images-idx3-ubyte.gz";
        String testLabelsFile = "t10k-labels-idx1-ubyte.gz";

        // load all training and test data
        try {
            loadData(trainImagesFile, trainLabelsFile, TRAIN_IMAGES, TRAIN_LABELS);
            loadData(testImagesFile, testLabelsFile, TEST_IMAGES, TEST_LABELS);
            System.out.println("MNIST download completed!");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("MNIST download failed!");
            System.exit(1);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime)/1000. + " seconds");
    }

    public static void main(String[] args) {
        downloadMNIST();

        // test the classifier
        long startTime = System.currentTimeMillis();
        int numWrong = 0;
        for (int i = 0; i < NUM_TEST; i++) {
            int guess = predict(TEST_IMAGES[i], K);
            if (guess != TEST_LABELS[i]) {
                numWrong++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Accuracy: " + (1 - numWrong / (float) NUM_TEST));
        System.out.println("Spent " + (endTime - startTime)/1000. + " seconds testing "
            + NUM_TEST + " images with k = " + K);
    }
}
