package de.spqrinfo.jee.jdbc.backend;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MessageBean {

    @Resource(name = "jdbc/jee")
    private DataSource dataSource;

    public int size() {
        final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM message";
        try {
            final Connection con = this.dataSource.getConnection();
            con.setAutoCommit(false);
            try {
                final Statement stmt = con.createStatement();
                try {
                    final ResultSet rs = stmt.executeQuery(SQL_SELECT_COUNT);
                    rs.next();
                    return rs.getInt(1);
                } finally {
                    stmt.close();
                }
            } finally {
                con.close();
            }
        } catch (final SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addMessage(final String text) {
        if (null == text) {
            throw new IllegalArgumentException("text may not be null");
        }

        final String SQL_INSERT = "INSERT INTO message (msg) VALUES (?)";
        try {
            final Connection con = this.dataSource.getConnection();
            con.setAutoCommit(false);
            try {
                final PreparedStatement pStmt = con.prepareStatement(SQL_INSERT);
                try {
                    pStmt.setString(1, text);
                    pStmt.executeUpdate();
                    con.commit();
                } finally {
                    pStmt.close();
                }
            } catch (final Exception ex) {
                con.rollback();
                throw new RuntimeException(ex);
            } finally {
                con.close();
            }
        } catch (final SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<String> getRecentMessages() {
        final String SQL_SELECT_RECENT = "SELECT msg FROM message ORDER BY id DESC LIMIT ?";
        final int RESULT_SIZE = 15;
        try {
            final Connection con = this.dataSource.getConnection();
            con.setAutoCommit(false);
            try {
                final PreparedStatement pStmt = con.prepareStatement(SQL_SELECT_RECENT);
                try {
                    pStmt.setInt(1, RESULT_SIZE);

                    final List<String> ret = new ArrayList<String>();
                    final ResultSet rs = pStmt.executeQuery();
                    while (rs.next()) {
                        ret.add(rs.getString(1));
                    }
                    return ret;
                } finally {
                    pStmt.close();
                }
            } finally {
                con.close();
            }
        } catch (final SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
