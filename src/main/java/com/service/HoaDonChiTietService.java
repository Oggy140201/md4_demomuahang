package com.service;


import com.model.HoaDon;
import com.model.HoaDonChiTiet;
import com.model.SanPham;
import com.repository.IHoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class HoaDonChiTietService implements ICrudService<HoaDonChiTiet>{

    @Autowired
    IHoaDonChiTietRepository iHoaDonChiTietRepository;

    @Override
    public List<HoaDonChiTiet> getAll() {
        return null;
    }

    @Override
    public void save(HoaDonChiTiet hoaDonChiTiet) {
        iHoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public void delete(HoaDonChiTiet hoaDonChiTiet) {
        iHoaDonChiTietRepository.delete(hoaDonChiTiet);
    }

    @Override
    public void edit(HoaDonChiTiet hoaDonChiTiet) {
        iHoaDonChiTietRepository.save(hoaDonChiTiet);
    }
}
