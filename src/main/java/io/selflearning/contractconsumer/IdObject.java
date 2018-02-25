package io.selflearning.contractconsumer;

public class IdObject {

    private long id;

    public IdObject(long id) {
        this.id = id;
    }

    public IdObject(){
        // default constructor for JSON deserialization
    }

    public long getId() {
        return id;
    }

}
