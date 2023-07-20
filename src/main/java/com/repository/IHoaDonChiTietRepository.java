package com.repository;

import com.model.HoaDonChiTiet;
import com.model.SanPham;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IHoaDonChiTietRepository extends PagingAndSortingRepository<HoaDonChiTiet, Integer> {
}
