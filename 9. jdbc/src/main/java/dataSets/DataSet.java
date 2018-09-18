package dataSets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet implements DataSetHandler{
    @Override
    public String toString() {
        return "DataSet{" +
                "id=" + id +
                '}';
    }
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public <T extends DataSet> List<T> handle(ResultSet resultSet) throws SQLException {
        return null;
    }
}
