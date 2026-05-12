public class Property {
    public final String key;
    public final Object value;

    public Property(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return key + "=" + value;
    }
}
