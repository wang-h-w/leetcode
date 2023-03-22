class FooBar {
    private int n;
    private BlockingQueue<Integer> fooQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<Integer> barQueue = new LinkedBlockingQueue<>();

    public FooBar(int n) {
        this.n = n;
        fooQueue.add(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooQueue.take();
            printFoo.run();
            barQueue.add(0);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barQueue.take();
            printBar.run();
            fooQueue.add(0);
        }
    }
}