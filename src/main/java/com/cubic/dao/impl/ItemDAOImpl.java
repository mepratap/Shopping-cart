package com.cubic.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cubic.dao.ItemDAO;
import com.cubic.dao.exception.DBException;
import com.cubic.vo.ItemVO;


public class ItemDAOImpl extends AbstractDAO implements ItemDAO{
	
	//Different SQL queries
	private static final String CREATE_SQL="INSERT INTO PRODUCT(PRODUCT_ID,PRODUCT_NAME,PRODUCT_QUANTITY,PRODUCT_PRICE) VALUES(?,?,?,?)";
	private final static String UPDATE_SQL = "UPDATE PRODUCT SET PRODUCT_NAME=?,PRODUCT_QUANTITY=?,PRODUCT_PRICE WHERE PRODUCT_ID=?";
	private final static String SELECT_SQL = "SELECT * FROM PRODUCT";
	private final static String REMOVE_SQL = "DELETE FROM PRODUCT WHERE PRODUCT_ID=?";
	private final static String SELECT_ID_SQL = "SELECT * FROM PRODUCT WHERE PRODUCT_ID=?";
	
	public ItemVO createItem(ItemVO item) throws DBException {
		Connection connection=null;
		PreparedStatement statement=null;
		if (item == null || StringUtils.isEmpty(item.getItemName())|| item.getQuantity()== 0|| item.getItemPrice()==0|| item.getId()==null)
			throw new IllegalArgumentException("invalid data to create product record");
			
			try{
				connection=this.getConnection();
				long seqId=this.getNextSequence(connection);
				statement=connection.prepareStatement(CREATE_SQL);
				statement.setLong(1, seqId);
				statement.setString(2, item.getItemName());
				statement.setDouble(3, item.getItemPrice());
				statement.setInt(4, item.getQuantity());
				statement.executeUpdate();
				item.setId(seqId);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(connection);
				this.close(statement);
			}
			
		return item;
	}

	public ItemVO modifyItem(ItemVO item) throws DBException {

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(UPDATE_SQL);
			statement.setString(1, item.getItemName());
			statement.setInt(2, item.getQuantity());
			statement.setDouble(3, item.getItemPrice());
			statement.setLong(4, item.getId());
			statement.executeUpdate();
			item=getItem(item.getId());
			//person = getPerson(person.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(statement);
			this.close(connection);
		}
		return item;
	}

	public boolean removeItem(Long pk) throws DBException {

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(REMOVE_SQL);
			statement.setLong(1, pk);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("error in delete person", e);

		} finally {
			this.close(statement);
			this.close(connection);
		}
	}

	public List<ItemVO> getAllItem() throws DBException {
		
		List<ItemVO> results = new ArrayList<ItemVO>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(SELECT_SQL);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(new ItemVO(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("error occured in select all items", e);
		} finally {
			this.close(statement);
			this.close(connection);
		}
		return results;

	}
	
	public ItemVO getItem(Long pk) throws DBException{
		ItemVO item =null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(SELECT_ID_SQL);
			System.out.println("Printing id from daoimpl: " + pk);
			statement.setLong(1, pk);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				//System.out.println("Printing from getPerson: " + resultSet.getLong(1) + resultSet.getString(2));
				item=new ItemVO(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4));
				System.out.println(item);
				//item = new ItemVO(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("error occured in select persons", e);
		} finally {
			this.close(statement);
			this.close(connection);
		}
		return item;
	}
		
	

	public List<ItemVO> searchItem(String name) throws DBException {

		return null;
	}
	
}