package DataSet;

import javax.persistence.*;

@MappedSuperclass
public abstract class DataSet {
    @Override
    public String toString() {
        return "DataSet{" +
                "id=" + id +
                '}';
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
