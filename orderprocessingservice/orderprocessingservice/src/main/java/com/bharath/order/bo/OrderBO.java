package com.bharath.order.bo;

import com.bharath.order.bo.exception.BOException;
import com.bharath.order.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;

}
