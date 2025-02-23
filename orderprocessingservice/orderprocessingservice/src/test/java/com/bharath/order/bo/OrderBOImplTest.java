package com.bharath.order.bo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bharath.order.bo.exception.BOException;
import com.bharath.order.dao.OrderDAO;
import com.bharath.order.dto.Order;

@ExtendWith(MockitoExtension.class)
class OrderBOImplTest {

	private static final int ORDER_ID = 123;

	private static final int ZERO = 0;

	private static final int ONE = 1;

	private OrderBOImpl bo;

	@Mock
	private OrderDAO dao;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	@Test
	void placeOrderShouldCreateOrder() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(ONE);
		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao).create(order);
//		verify(dao,times(2)).create(order);
//		verify(dao, atLeast(2)).create(order);

	}

	@Test
	void placeOrderShouldNotCreateOrder() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(order)).thenReturn(ZERO);
		boolean result = bo.placeOrder(order);

		assertFalse(result);
		verify(dao).create(order);

	}

	@Test
	void placeOrderShouldThrowException() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		assertThrows(BOException.class, () -> bo.placeOrder(order));

	}

	@Test
	void shouldCancelOrder() throws BOException, SQLException {

		Order o = new Order();
		when(dao.read(ORDER_ID)).thenReturn(o);
		when(dao.update(o)).thenReturn(ONE);

		boolean result = bo.cancelOrder(ORDER_ID);
		assertTrue(result);

		verify(dao).read(ORDER_ID);
		verify(dao).update(o);

	}

	@Test
	void shouldNotCancelOrder() throws BOException, SQLException {

		Order o = new Order();
		when(dao.read(anyInt())).thenReturn(o);
		when(dao.update(o)).thenReturn(ZERO);

		boolean result = bo.cancelOrder(ORDER_ID);
		assertFalse(result);

		verify(dao).read(ORDER_ID);
		verify(dao).update(o);

	}

	@Test
	void readShouldThrowExceptionForCancelOrder() throws BOException, SQLException {

		when(dao.read(anyInt())).thenThrow(SQLException.class);
		assertThrows(BOException.class, () -> bo.cancelOrder(ORDER_ID));

	}

	@Test
	void updateShouldThrowExceptionForCancelOrder() throws BOException, SQLException {

		Order o = new Order();
		when(dao.read(ORDER_ID)).thenReturn(o);
		when(dao.update(o)).thenThrow(SQLException.class);
		assertThrows(BOException.class, () -> bo.cancelOrder(ORDER_ID));

	}

	@Test
	void shouldDeleteOrder() throws SQLException, BOException {

		when(dao.delete(ORDER_ID)).thenReturn(ONE);

		boolean result = bo.deleteOrder(ORDER_ID);

		assertTrue(result);
		verify(dao).delete(ORDER_ID);

	}

	@Test
	void shouldNotDeleteOrder() throws SQLException, BOException {

		when(dao.delete(ORDER_ID)).thenReturn(ZERO);

		boolean result = bo.deleteOrder(ORDER_ID);

		assertFalse(result);
		verify(dao).delete(ORDER_ID);

	}

	@Test
	void shouldThrowExceptionForDeleteOrder() throws SQLException, BOException {

		when(dao.delete(ORDER_ID)).thenThrow(SQLException.class);

		assertThrows(BOException.class, () -> bo.deleteOrder(ORDER_ID));

	}

}
