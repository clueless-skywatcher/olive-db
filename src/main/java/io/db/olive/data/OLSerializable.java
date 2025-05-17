package io.db.olive.data;

public interface OLSerializable<T> {
    public T getValue();
    public byte[] serialize();
    public int getMaxSize();
    public String getDataType();
}
