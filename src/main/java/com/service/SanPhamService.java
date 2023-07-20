package com.service;

import com.model.SanPham;
import com.repository.ISanPhamReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SanPhamService implements ICrudService<SanPham>{
    @Autowired
    private ISanPhamReposiroty iSanPhamReposiroty;

    @Override
    public List<SanPham> getAll() {
        return null;
    }

    @Override
    public void save(SanPham sanPham){
        iSanPhamReposiroty.save(sanPham);
    }

    @Override
    public void delete(SanPham sanPham) {

    }

    @Override
    public void edit(SanPham sanPham){
        iSanPhamReposiroty.save(sanPham);
    }

    public void delete(int id){
        iSanPhamReposiroty.deleteById(id);
    }

    public Page<SanPham> getAll(Pageable pageable){
        return iSanPhamReposiroty.findAll(pageable);
    }
    public SanPham findById(int id){
        return iSanPhamReposiroty.findById(id).get();
    }
}
