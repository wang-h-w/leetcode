class FooBar {
    private int n;
    private Object obj = new Object();
    private volatile boolean fooExec = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(obj) {
                if (!fooExec) obj.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooExec = false;
                obj.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(obj) {
                if (fooExec) obj.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooExec = true;
                obj.notifyAll();
            }
        }
    }
}