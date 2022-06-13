package sg.ihh.ms.fms.app.repository;

import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository {

    @Autowired
    protected Jdbi jdbi;

    protected Logger log;

    public BaseRepository() {
        // Empty Constructor
    }

    protected Handle getHandle() {
        return jdbi.open();
    }

    protected Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    protected void start(String methodName) {
        log.debug("[{}] Start", methodName);
    }

    protected void completed(String methodName) {
        log.debug("[{}] Completed", methodName);
    }

    protected RowMapper<Map<String, Object>> getResultMapper() {
        return (rs, ctx) -> {
            Map<String, Object> map = new HashMap<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String key = rsmd.getColumnName(i);

                Object obj = rs.getObject(key);

                // Ignore Null Objects
                if (obj != null) {
                    map.put(key, rs.getObject(key));
                }
            }
            return map;

        };
    }
}
