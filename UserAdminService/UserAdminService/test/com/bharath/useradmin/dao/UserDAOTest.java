package com.bharath.useradmin.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.bharath.useradmin.dto.User;
import com.bharath.useradmin.util.IDGenerator;

class UserDAOTest {

	@Test
	void shouldCreateUserAndReturnUserID() {

//		fail("Not yet implemented");
		UserDAO userDAO = new UserDAO();
		mockStatic(IDGenerator.class);

		when(IDGenerator.generateID()).thenReturn(1);

		int userId = userDAO.create(new User());
		assertEquals(1, userId);

	}

}
