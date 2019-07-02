package com.dcnutrition.devapps.apirest.models.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dcnutrition.devapps.apirest.models.entity.UserCustom;

public interface IUserCustomService extends JpaRepository<UserCustom, Long> {

	UserCustom findByUsername(String username);
}
