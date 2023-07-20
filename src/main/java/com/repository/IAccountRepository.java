package com.repository;

import com.model.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepository extends PagingAndSortingRepository<User,Integer> {
}
