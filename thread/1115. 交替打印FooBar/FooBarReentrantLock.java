class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock(true);
    private volatile boolean fooExec = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (fooExec) {
                    printFoo.run();
                    fooExec = false;
                    i++;
                }
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!fooExec) {
                    printBar.run();
                    fooExec = true;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}