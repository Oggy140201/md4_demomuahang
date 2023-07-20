package com.service;

import com.model.HoaDon;
import com.model.HoaDonChiTiet;
import com.model.SanPham;
import com.repository.IHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class HoaDonService implements ICrudService<HoaDon>{

    @Autowired
    IHoaDonRepository iHoaDonRepository;

    @Autowired
    HttpSession httpSession;



    public List<HoaDonChiTiet> addSanPham(SanPham sanPham, HttpSession session){
        List<HoaDonChiTiet> list = (List<HoaDonChiTiet>) session.getAttribute("sanPhams");
        HoaDon hoaDon= (HoaDon) session.getAttribute("hoadon");
        double total = (double) httpSession.getAttribute("total");
        boolean check=false;
        if(list == null && hoaDon==null ){
            list = new ArrayList<>();
            hoaDon=new HoaDon(0,new Date(System.currentTimeMillis()),total);
            session.setAttribute("total",total);
        }
        for (int i = 0; i < list.size();i++){
            if(list.get(i).getId() == sanPham.getId()){
                list.get(i).setQuantity(list.get(i).getQuantity()+1);
                check = true;
                break;
            }
        }
        setPrimekey(sanPham,hoaDon);
        if(!check){
            list.add(new HoaDonChiTiet(0,1,hoaDon,sanPham));
        }
        session.setAttribute("sanPhams",list);
        session.setAttribute("hoadon",hoaDon);
            return list;
    }

    public void setPrimekey(SanPham sanPham,HoaDon hoaDon){
        hoaDon.setTong(hoaDon.getTong() + sanPham.getPrice());
    }

    @Override
    public List<HoaDon> getAll() {
        return null;
    }

    @Override
    public void save(HoaDon hoaDon) {
        iHoaDonRepository.save(hoaDon);
    }

    @Override
    public void delete(HoaDon hoaDon) {
        iHoaDonRepository.delete(hoaDon);
    }

    @Override
    public void edit(HoaDon hoaDon) {
        iHoaDonRepository.save(hoaDon);
    }
}
