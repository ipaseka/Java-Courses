package dataSets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DataSetHandler {
    <T extends DataSet> List<T> handle(ResultSet resultSet) throws SQLException;
}
