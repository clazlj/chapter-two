package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;

import java.util.List;
import java.util.Map;

public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(String keyword) {
        //conn用ThreadLocal中存放的本地线程变量
        //Connection conn = DatabaseHelper.getConnection();

        List<Customer> customerList;
        try {
            String sql = "SELECT * FROM customer";
            customerList = DatabaseHelper.queryEntityList(Customer.class, sql);

            //PreparedStatement stmt = conn.prepareStatement(sql);
            //ResultSet rs = stmt.executeQuery();
            //while (rs.next()) {
            //    Customer customer = new Customer();
            //    customer.setId(rs.getLong("id"));
            //    customer.setName(rs.getString("name"));
            //    customer.setContact(rs.getString("contact"));
            //    customer.setTelephone(rs.getString("telephone"));
            //    customer.setEmail(rs.getString("email"));
            //    customer.setRemark(rs.getString("remark"));
            //    customerList.add(customer);
            //}

        } finally {
            //DatabaseHelper.closeConnection(conn);
        }

        return customerList;
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id=?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
