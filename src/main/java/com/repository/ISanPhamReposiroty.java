package com.repository;

import com.model.SanPham;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISanPhamReposiroty extends PagingAndSortingRepository<SanPham,Integer> {

}
