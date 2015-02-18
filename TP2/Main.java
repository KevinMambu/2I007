public class Main {
	public static void main(String[] args) {
		int X = 40;
		int Y = 40;
		int iter = 1000;
		int i = 0;
        int delay = 50;
		GameOfLife test = new GameOfLife(X,Y);
		test.modifyNode(0,4,true);
        test.modifyNode(0,5,true);
        test.modifyNode(1,4,true);
        test.modifyNode(1,5,true);

        test.modifyNode(10,4,true);
        test.modifyNode(10,5,true);
        test.modifyNode(10,6,true);
        test.modifyNode(11,3,true);
        test.modifyNode(11,7,true);
        test.modifyNode(12,2,true);
        test.modifyNode(13,2,true);
        test.modifyNode(12,8,true);
        test.modifyNode(13,8,true);
        test.modifyNode(14,5,true);
        test.modifyNode(15,3,true);
        test.modifyNode(15,7,true);
        test.modifyNode(16,4,true);
        test.modifyNode(16,5,true);
        test.modifyNode(16,6,true);
        test.modifyNode(17,5,true);

        test.modifyNode(20,2,true);
        test.modifyNode(20,3,true);
        test.modifyNode(20,4,true);
        test.modifyNode(21,2,true);
        test.modifyNode(21,3,true);
        test.modifyNode(21,4,true);
        test.modifyNode(22,1,true);
        test.modifyNode(22,5,true);
        test.modifyNode(24,0,true);
        test.modifyNode(24,1,true);
        test.modifyNode(24,5,true);
        test.modifyNode(24,6,true);

        test.modifyNode(34,2,true);
        test.modifyNode(34,3,true);
        test.modifyNode(33,2,true);
        test.modifyNode(33,3,true);
        while(i < iter) {
			test.upload();
			test.display();
			try {
				Thread.sleep(delay);
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
            i += 1;
		}
	}
}
