import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.util.Arrays;

public class PostgreSqlStringArrayType implements UserType<Object> {

    @Override
    public int getSqlType() {
        return Types.ARRAY;
    }

    @Override
    public Class returnedClass() {
        return String[].class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x instanceof String[] && y instanceof String[]) {
            return Arrays.deepEquals((String[]) x, (String[]) y);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Arrays.hashCode((String[]) x);
    }

    @Override
    public String[] nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session,
                                Object owner) throws SQLException {
        Array array = rs.getArray(position);
        return array != null ? (String[]) array.getArray() : null;
    }


    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if ( value == null ) {
            st.setNull( index, Types.OTHER );
        }
        else {
            st.setObject( index, value );
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        String[] a = (String[]) value;
        return Arrays.copyOf(a, a.length);
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

}