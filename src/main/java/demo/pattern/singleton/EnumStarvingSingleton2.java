package demo.pattern.singleton;

public enum EnumStarvingSingleton2 {

    //
    INSTANCE {
//        @Override
        protected void read() {
            System.out.println("read");
        }

        protected void write() {
            System.out.println("write");
        }

    };

//    protected abstract void read();

//    protected abstract void write();


    EnumStarvingSingleton2() {
    }
}
