package orm;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private static final String SELECT_STAR_FROM = "SELECT * FROM ";
    private static final String INSERT_QUERY = "INSERT INTO %s(%s) VALUE (%s) ";
    private static final String UPDATE_QUERY = "UPDATE %s SET %s WHERE %s ";
    private static final String DELETE_QUERY = "DELETE FROM %s WHERE %s ";
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;

    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primary = getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);
        return (value != null && (int) value > 0) ? doUpdate(entity, primary) : doInsert(entity, primary);
    }

    private boolean doInsert(E entity, Field primary) throws SQLException {
        String tableName = getTableName(entity.getClass());
        String fieldNames = getFieldNames(entity).stream().collect(Collectors.joining(", "));
        String fieldValues = getFieldValues(entity).stream().collect(Collectors.joining(", "));
        String insertQuery = String.format(INSERT_QUERY, tableName, fieldNames, fieldValues);
        return executeQuery(insertQuery);
    }

    private boolean executeQuery(String sql) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.execute();
    }

    private List<String> getFieldValues(E entity) {
        Function<Field, String> getFieldValue = field -> {
            field.setAccessible(true);
            try {
                Object value = field.get(entity);
                return field.getType() == String.class || field.getType() == LocalDate.class ?
                        String.format("'%s'", value.toString()) : value.toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return "";
        };
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> {
                    field.setAccessible(true);
                    return field.getAnnotation(Column.class).name();
                })
                .collect(Collectors.toList());
    }

    private List<String> getFieldNames(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> {
                    field.setAccessible(true);
                    return field.getAnnotation(Column.class).name();
                })
                .collect(Collectors.toList());
    }


    private boolean doUpdate(E entity, Field primary) {
        return false;
    }

    private String getTableName(Class<?> entity) {
        Entity entityAnnotation = entity.getAnnotation(Entity.class);
        if (entityAnnotation != null && entityAnnotation.name().length() > 0) {
            return entityAnnotation.name();
        } else {
            return entity.getSimpleName();
        }
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        return null;
    }

    private Field getId(Class entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have a primary key"));
    }
}
