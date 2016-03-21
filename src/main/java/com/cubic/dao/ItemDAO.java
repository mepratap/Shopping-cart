package com.cubic.dao;

import java.util.List;

import com.cubic.dao.exception.DBException;
import com.cubic.vo.ItemVO;


public interface ItemDAO {

	ItemVO createItem(final ItemVO item) throws DBException;

	ItemVO modifyItem(final ItemVO item) throws DBException;

	boolean removeItem(final Long pk) throws DBException;

	List<ItemVO> getAllItem() throws DBException;

	List<ItemVO> searchItem(final String name) throws DBException;

	ItemVO getItem(final Long pk) throws DBException;

}
