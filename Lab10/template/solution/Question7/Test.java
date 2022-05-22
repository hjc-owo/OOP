public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        NumberPrint np = new NumberPrint(lock);
        CharPrint cp = new CharPrint(lock);
        new Thread(np).start();
        Thread.sleep(100);
        new Thread(cp).start();
    }
}

class NumberPrint implements Runnable {

    Object lock;

    public NumberPrint(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 52) {
            synchronized (lock) {
                System.out.print(i + "" + (i + 1));
                i += 2;
                lock.notify();
                try {
                    if (i > 52) {
                        break;
                    } else {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class CharPrint implements Runnable {

    Object lock;

    public CharPrint(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        char c = 'A';
        while (c <= 'Z') {
            synchronized (lock) {
                System.out.print(c);
                c++;
                lock.notify();
                try {
                    if (c > 'Z') {
                        break;
                    } else {
                        System.out.print(" ");
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
